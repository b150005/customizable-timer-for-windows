package com.b150005.customizabletimerforwindows;

import java.io.IOException;
import java.net.URL;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.b150005.customizabletimerforwindows.KeyConstants.*;

public class CustomizableTimerApplication extends Application {
  public static void main(String[] args) {
    // Redis Standaloneの起動
    // launchRedis();
    // アプリケーションの起動
    // launch(args);
  }

  /**
   * JavaFXアプリケーション(設定画面)の起動
   */
  @Override
  public void start(Stage stage) {
    try {
      URL url = CustomizableTimerApplication.class.getResource("view/settings.fxml");
      FXMLLoader fxmlLoader = new FXMLLoader(url);
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // 終了時の処理
    stage.showingProperty().addListener((observable, oldValue, newValue) -> {
      if (oldValue == true && newValue == false) {
        System.out.println("hello~");
      }
    });

    stage.setTitle("Settings");
    stage.show();
  }

  private static void launchRedis() {
    // Redisクライアントの作成
    // 事前にRedisのインストールが必要(https://github.com/MicrosoftArchive/redis/releases)
    RedisClient redisClient = RedisClient.create("redis://localhost:6379");
    try (
      // Redis Standaloneサーバへの接続
      // → <Key, Value>型でデータを管理
      StatefulRedisConnection<String, String> connection = redisClient.connect();
    ) {
      // 同期実行のコマンドAPIの取得
      RedisCommands<String, String> syncCommands = connection.sync();
      
      // 保存されたデータが存在しない場合は初期値をセット
      if (syncCommands.get(hasAlreadyExisted)  == null) {
        syncCommands.set(displayOnDigitalMode, "false");
        syncCommands.set(displayAnimationInFront, "false");
        syncCommands.set(frontAnimationIsOn, "false");
        syncCommands.set(frontAnimationDisplayMode, always);
        syncCommands.set(frontAnimationFilePath, fileIsNotSelected);
        syncCommands.set(backAnimationIsOn, "false");
        syncCommands.set(backAnimationDisplayMode, always);
        syncCommands.set(backAnimationFilePath, fileIsNotSelected);

        syncCommands.set(digitalTimerModeIsOn, "false");
        syncCommands.set(changeToDigitalClockAfterTimerDate, "false");

        syncCommands.set(hasAlreadyExisted, "true");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Redisクライアントの終了
      redisClient.shutdown();
    }
  }
}