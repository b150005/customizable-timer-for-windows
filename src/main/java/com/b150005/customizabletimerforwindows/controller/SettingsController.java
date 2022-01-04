package com.b150005.customizabletimerforwindows.controller;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import static com.b150005.customizabletimerforwindows.KeyConstants.*;

public class SettingsController implements Initializable {
  // General
  /**
   * デジタルモードで表示するかどうかを操作するCheckBox
   */
  @FXML private CheckBox digitalModeCheckButton;
  /**
   * アニメーションを前面に表示するかどうかを操作するCheckBox
   */
  @FXML private CheckBox displayAnimationInFrontCheckBox;
  /**
   * アニメーション(前面)を表示するかどうかを操作するCheckBox
   */
  @FXML private CheckBox frontAnimationCheckBox;
  /**
   * アニメーション(前面)の表示タイミングを操作するChoiceBox
   */
  @FXML private ChoiceBox<String> frontAnimationDisplayModeChoiceBox;
  /**
   * アニメーション(前面)のファイルパスを表示するLabel
   */
  @FXML private Label frontAnimationFilePathLabel;
  /**
   * アニメーション(前面)のファイル選択ダイアログを表示するButton
   */
  @FXML private Button showFrontFileChooserButton;
  /**
   * アニメーション(背面)を表示するかどうかを操作するCheckBox
   */
  @FXML private CheckBox backAnimationCheckBox;
  /**
   * アニメーション(背面)の表示タイミングを操作するChoiceBox
   */
  @FXML private ChoiceBox<String> backAnimationDisplayModeChoiceBox;
  /**
   * アニメーション(背面)のファイルパスを表示するLabel
   */
  @FXML private Label backAnimationFilePathLabel;
  /**
   * アニメーション(背面)のファイル選択ダイアログを表示するButton
   */
  @FXML private Button showBackFileChooserButton;
  /**
   * 時刻①(アニメーション指定時表示)の年を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> yearChoiceBox1;
  /**
   * 時刻①(アニメーション指定時表示)の月を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> monthChoiceBox1;
  /**
   * 時刻①(アニメーション指定時表示)の日を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> dayChoiceBox1;
  /**
   * 時刻①(アニメーション指定時表示)の時を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> hourChoiceBox1;
  /**
   * 時刻①(アニメーション指定時表示)の分を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> minuteChoiceBox1;
  /**
   * 時刻①(アニメーション指定時表示)の秒を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> secondChoiceBox1;
  /**
   * 時刻①(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML private ChoiceBox<String> displayTimeChoiceBox1;
  /**
   * 時刻②(アニメーション指定時表示)の年を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> yearChoiceBox2;
  /**
   * 時刻②(アニメーション指定時表示)の月を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> monthChoiceBox2;
  /**
   * 時刻②(アニメーション指定時表示)の日を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> dayChoiceBox2;
  /**
   * 時刻②(アニメーション指定時表示)の時を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> hourChoiceBox2;
  /**
   * 時刻②(アニメーション指定時表示)の分を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> minuteChoiceBox2;
  /**
   * 時刻②(アニメーション指定時表示)の秒を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> secondChoiceBox2;
  /**
   * 時刻②(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML private ChoiceBox<String> displayTimeChoiceBox2;
  /**
   * 時刻③(アニメーション指定時表示)の年を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> yearChoiceBox3;
  /**
   * 時刻③(アニメーション指定時表示)の月を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> monthChoiceBox3;
  /**
   * 時刻③(アニメーション指定時表示)の日を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> dayChoiceBox3;
  /**
   * 時刻③(アニメーション指定時表示)の時を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> hourChoiceBox3;
  /**
   * 時刻③(アニメーション指定時表示)の分を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> minuteChoiceBox3;
  /**
   * 時刻③(アニメーション指定時表示)の秒を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> secondChoiceBox3;
  /**
   * 時刻③(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML private ChoiceBox<String> displayTimeChoiceBox3;
  /**
   * 時刻④(アニメーション指定時表示)の年を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> yearChoiceBox4;
  /**
   * 時刻④(アニメーション指定時表示)の月を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> monthChoiceBox4;
  /**
   * 時刻④(アニメーション指定時表示)の日を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> dayChoiceBox4;
  /**
   * 時刻④(アニメーション指定時表示)の時を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> hourChoiceBox4;
  /**
   * 時刻④(アニメーション指定時表示)の分を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> minuteChoiceBox4;
  /**
   * 時刻④(アニメーション指定時表示)の秒を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> secondChoiceBox4;
  /**
   * 時刻④(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML private ChoiceBox<String> displayTimeChoiceBox4;
  /**
   * 時刻⑤(アニメーション指定時表示)の年を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> yearChoiceBox5;
  /**
   * 時刻⑤(アニメーション指定時表示)の月を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> monthChoiceBox5;
  /**
   * 時刻⑤(アニメーション指定時表示)の日を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> dayChoiceBox5;
  /**
   * 時刻⑤(アニメーション指定時表示)の時を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> hourChoiceBox5;
  /**
   * 時刻⑤(アニメーション指定時表示)の分を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> minuteChoiceBox5;
  /**
   * 時刻⑤(アニメーション指定時表示)の秒を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> secondChoiceBox5;
  /**
   * 時刻⑤(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML private ChoiceBox<String> displayTimeChoiceBox5;

  // Analog
  /**
   * 時計盤のファイルパスを表示するLabel
   */
  @FXML private Label faceFilePathLabel;
  /**
   * 時計盤のファイル選択ダイアログを表示するButton
   */
  @FXML private Button showFaceFileChooserButton;
  /**
   * 短針のファイルパスを表示するLabel
   */
  @FXML private Label hourFilePathLabel;
  /**
   * 短針のファイル選択ダイアログを表示するButton
   */
  @FXML private Button showHourFileChooserButton;
  /**
   * 長針のファイルパスを表示するLabel
   */
  @FXML private Label minuteFilePathLabel;
  /**
   * 長針のファイル選択ダイアログを表示するButton
   */
  @FXML private Button showMinuteFileChooserButton;
  /**
   * 秒針のファイルパスを表示するLabel
   */
  @FXML private Label secondFilePathLabel;
  /**
   * 秒針のファイル選択ダイアログを表示するButton
   */
  @FXML private Button showSecondFileChooserButton;

  // Digital
  /**
   * タイマーとして機能させるかどうかを操作するChoiceBox
   */
  @FXML private CheckBox timerModeCheckBox;
  /**
   * フォントを選択するChoiceBox
   */
  @FXML private ChoiceBox fontChoiceBox;
  /**
   * フォントのファイル選択ダイアログを表示するButton
   */
  @FXML private Button showFontFileChooserButton;
  /**
   * 基本フォント色を選択するColorPicker
   */
  @FXML private ColorPicker baseFontColorPicker;
  /**
   * タイマー直前のフォント色を選択するColorPicker
   */
  @FXML private ColorPicker beforeFontColorPicker;
  /**
   * タイマー直前の時刻を操作するSpinner
   */
  @FXML private Spinner<Integer> beforeTimeSpinner;
  /**
   * フォント色(直後)を選択するColorPicker
   */
  @FXML private ColorPicker afterFontColorPicker;
  /**
   * タイマー直後の時刻を操作するSpinner
   */
  @FXML private Spinner<Integer> afterTimeSpinner;
  /**
   * フォントの透明度を操作するSlider
   */
  @FXML private Slider opacitySlider;
  /**
   * フォントの透明度を操作するSpinner
   */
  @FXML private Spinner<Double> opacitySpinner;
  /**
   * タイマー期限の年を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> yearTimerChoiceBox;
  /**
   * タイマー期限の月を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> monthTimerChoiceBox;
  /**
   * タイマー期限の日を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> dayTimerChoiceBox;
  /**
   * タイマー期限の時を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> hourTimerChoiceBox;
  /**
   * タイマー期限の分を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> minuteTimerChoiceBox;
  /**
   * タイマー期限の秒を表すChoiceBox
   */
  @FXML private ChoiceBox<Integer> secondTimerChoiceBox;
  /**
   * タイマーの期限超過時に時計モードに移行するかどうかを操作するCheckBox
   */
  @FXML private CheckBox shiftToClockCheckBox;

  /**
   * JavaFXコンポーネントの初期化処理
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // 「デジタルモードで表示」のCheckBoxに反映
    this.digitalModeCheckButton.setSelected(Boolean.valueOf(getValue(displayOnDigitalMode)));
    this.displayAnimationInFrontCheckBox.setSelected(Boolean.valueOf(getValue(displayOnDigitalMode)));

    final ObservableList<String> displayMode = FXCollections.observableArrayList(always, designated);
    this.frontAnimationDisplayModeChoiceBox.setItems(displayMode);
    this.backAnimationDisplayModeChoiceBox.setItems(displayMode);
    
    this.frontAnimationDisplayModeChoiceBox.setValue(getValue(frontAnimationDisplayMode));
    this.backAnimationDisplayModeChoiceBox.setValue(getValue(backAnimationDisplayMode));

    this.opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
      // Spinnerの値を変更
    });
    this.opacitySpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
      // Sliderの値を変更
    });
  }

  /**
   * チェックボックス押下時のコールバック処理
   * @param event
   */
  @FXML protected void onCheckBoxClick(ActionEvent event) {
    switch (((CheckBox) event.getSource()).getId()) {
      case "digitalModeCheckButton":
        toggle(displayOnDigitalMode);
        break;
      case "displayAnimationInFrontCheckBox":
        toggle(displayAnimationInFront);
        break;
      case "frontAnimationCheckBox":
        toggle(frontAnimationIsOn);
        break;
      case "backAnimationCheckBox":
        toggle(backAnimationIsOn);
        break;
      case "timerModeCheckBox":
        toggle(digitalTimerModeIsOn);
        break;
      case "shiftToClockCheckBox":
        toggle(changeToDigitalClockAfterTimerDate);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + event.getSource());
    }
  }

  /**
   * Redisサーバに登録されている引数keyに紐づくvalueを取得し返却する
   * @param key Redisサーバに登録されているkey
   * @return 引数keyに紐づくString型value
   */
  private static String getValue(String key) {
    // Redisクライアントの作成
    RedisClient redisClient = RedisClient.create("redis://localhost:6379");
    try (
      // Redis Standaloneサーバへの接続
      StatefulRedisConnection<String, String> connection = redisClient.connect();
    ) {
      // 同期実行のコマンドAPIの取得
      RedisCommands<String, String> syncCommands = connection.sync();
      
      // キーが存在しない場合は空文字を返却
      if (syncCommands.get(key) == null) {
        return "";
      }
      else {
        // Redisサーバからキーを指定して値を取得
        return syncCommands.get(key);
      }
    } catch (Exception e) {
      e.printStackTrace();
      // エラーが生じた場合も空文字を返却
      return "";
    } finally {
      // Redisクライアントの終了
      redisClient.shutdown();
    }
  }

  /**
   * Redisサーバに第一引数key, 第二引数valueのデータを追加
   * @param key paramに紐づくkey
   * @param value keyに紐づくvalue
   */
  private static void setValue(String key, String value) {
    // Redisクライアントの作成
    RedisClient redisClient = RedisClient.create("redis://localhost:6379");
    try (
      // Redis Standaloneサーバへの接続
      StatefulRedisConnection<String, String> connection = redisClient.connect();
    ) {
      // 同期実行のコマンドAPIの取得
      RedisCommands<String, String> syncCommands = connection.sync();
      
      // Redisサーバにキーと値を送信
      syncCommands.set(key, value);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Redisクライアントの終了
      redisClient.shutdown();
    }
  }

  /**
   * Redisサーバに登録されているBoolean型の値をtoggleする
   * @param key Redisサーバに登録されたBoolean値をもつkey
   */
  private static void toggle(String key) {
    // Redisクライアントの作成
    RedisClient redisClient = RedisClient.create("redis://localhost:6379");
    try (
      // Redis Standaloneサーバへの接続
      StatefulRedisConnection<String, String> connection = redisClient.connect();
    ) {
      // 同期実行のコマンドAPIの取得
      RedisCommands<String, String> syncCommands = connection.sync();
      
      // キーの存在チェックを行い、Boolean値である場合のみ更新
      if (syncCommands.get(key)  == null) {
        System.out.println("a designated key does not exist.");
      }
      else {
        switch(syncCommands.get(key)) {
          case "true":
            syncCommands.set(key, "false");
            break;
          case "false":
            syncCommands.set(key, "true");
            break;
          default:
            System.out.println("a designated key does not have Boolean value.");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Redisクライアントの終了
      redisClient.shutdown();
    }
  }

  @FXML protected void onDisplayModeChanged(ActionEvent event) {
    switch (((ChoiceBox) event.getSource()).getId()) {
      case "frontAnimationDisplayModeChoiceBox":
        break;
      case "backAnimationDisplayModeChoiceBox":
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + event.getSource());
    }
  }

  @FXML protected void onFontChanged(ActionEvent event) {
    System.out.println("low");
  }

  @FXML protected void onFontColorChanged(ActionEvent event) {

  }

  @FXML protected void onOpacityChangedWithSlider(MouseEvent event) {
    System.out.println("wow");
  }
}