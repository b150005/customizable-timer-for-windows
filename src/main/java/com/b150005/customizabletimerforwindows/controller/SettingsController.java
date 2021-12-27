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
  @FXML
  private CheckBox digitalModeCheckButton;
  /**
   * アニメーションを前面に表示するかどうかを操作するCheckBox
   */
  @FXML
  private CheckBox displayAnimationInFrontCheckBox;
  /**
   * アニメーション(前面)を表示するかどうかを操作するCheckBox
   */
  @FXML
  private CheckBox frontAnimationCheckBox;
  /**
   * アニメーション(前面)の表示タイミングを操作するChoiceBox
   */
  @FXML
  private ChoiceBox<String> frontAnimationDisplayModeChoiceBox;
  /**
   * アニメーション(前面)のファイルパスを表示するLabel
   */
  @FXML
  private Label frontAnimationFilePathLabel;
  /**
   * アニメーション(前面)のファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showFrontFileChooserButton;
  /**
   * アニメーション(背面)を表示するかどうかを操作するCheckBox
   */
  @FXML
  private CheckBox backAnimationCheckBox;
  /**
   * アニメーション(背面)の表示タイミングを操作するChoiceBox
   */
  @FXML
  private ChoiceBox<String> backAnimationDisplayModeChoiceBox;
  /**
   * アニメーション(背面)のファイルパスを表示するLabel
   */
  @FXML
  private Label backAnimationFilePathLabel;
  /**
   * アニメーション(背面)のファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showBackFileChooserButton;
  /**
   * アニメーションの表示タイミング(指定時)の時刻を操作するDatePicker(時刻①)
   */
  @FXML
  private DatePicker displayDatePicker1;
  /**
   * 時刻①(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML
  private ChoiceBox<String> displayTimeChoiceBox1;
  /**
   * アニメーションの表示タイミング(指定時)の時刻を操作するDatePicker(時刻②)
   */
  @FXML
  private DatePicker displayDatePicker2;
  /**
   * 時刻②(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML
  private ChoiceBox<String> displayTimeChoiceBox2;
  /**
   * アニメーションの表示タイミング(指定時)の時刻を操作するDatePicker(時刻③)
   */
  @FXML
  private DatePicker displayDatePicker3;
  /**
   * 時刻③(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML
  private ChoiceBox<String> displayTimeChoiceBox3;
  /**
   * アニメーションの表示タイミング(指定時)の時刻を操作するDatePicker(時刻④)
   */
  @FXML
  private DatePicker displayDatePicker4;
  /**
   * 時刻④(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML
  private ChoiceBox<String> displayTimeChoiceBox4;
  /**
   * アニメーションの表示タイミング(指定時)の時刻を操作するDatePicker(時刻⑤)
   */
  @FXML
  private DatePicker displayDatePicker5;
  /**
   * 時刻⑤(アニメーション指定時表示)のアニメーションを選択するChoiceBox
   */
  @FXML
  private ChoiceBox<String> displayTimeChoiceBox5;

  // Analog
  /**
   * 時計盤のファイルパスを表示するLabel
   */
  @FXML
  private Label faceFilePathLabel;
  /**
   * 時計盤のファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showFaceFileChooserButton;
  /**
   * 短針のファイルパスを表示するLabel
   */
  @FXML
  private Label hourFilePathLabel;
  /**
   * 短針のファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showHourFileChooserButton;
  /**
   * 長針のファイルパスを表示するLabel
   */
  @FXML
  private Label minuteFilePathLabel;
  /**
   * 長針のファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showMinuteFileChooserButton;
  /**
   * 秒針のファイルパスを表示するLabel
   */
  @FXML
  private Label secondFilePathLabel;
  /**
   * 秒針のファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showSecondFileChooserButton;

  // Digital
  /**
   * タイマーとして機能させるかどうかを操作するChoiceBox
   */
  @FXML
  private CheckBox timerModeCheckBox;
  /**
   * フォントを選択するChoiceBox
   */
  @FXML
  private ChoiceBox fontChoiceBox;
  /**
   * フォントのファイル選択ダイアログを表示するButton
   */
  @FXML
  private Button showFontFileChooserButton;
  /**
   * 基本フォント色を選択するColorPicker
   */
  @FXML
  private ColorPicker baseFontColorPicker;
  /**
   * タイマー直前のフォント色を選択するColorPicker
   */
  @FXML
  private ColorPicker beforeFontColorPicker;
  /**
   * タイマー直前の時刻を操作するSpinner
   */
  @FXML
  private Spinner<Integer> beforeTimeSpinner;
  /**
   * フォント色(直後)を選択するColorPicker
   */
  @FXML
  private ColorPicker afterFontColorPicker;
  /**
   * タイマー直後の時刻を操作するSpinner
   */
  @FXML
  private Spinner<Integer> afterTimeSpinner;
  /**
   * フォントの透明度を操作するSlider
   */
  @FXML
  private Slider opacitySlider;
  /**
   * フォントの透明度を操作するSpinner
   */
  @FXML
  private Spinner<Double> opacitySpinner;
  /**
   * タイマーの期限を操作するDatePicker
   */
  @FXML
  private DatePicker timerDatePicker;
  /**
   * タイマーの期限超過時に時計モードに移行するかどうかを操作するCheckBox
   */
  @FXML
  private CheckBox shiftToClockCheckBox;

  /**
   * JavaFXコンポーネントの初期化処理
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    final ObservableList<String> displayMode = FXCollections.observableArrayList(always, designated);
    this.frontAnimationDisplayModeChoiceBox.setItems(displayMode);
    this.backAnimationDisplayModeChoiceBox.setItems(displayMode);
    
    this.frontAnimationDisplayModeChoiceBox.setValue(getValue(frontAnimationDisplayMode));
    this.backAnimationDisplayModeChoiceBox.setValue(getValue(backAnimationDisplayMode));

    this.displayDatePicker1.valueProperty().addListener((observable, oldValue, newValue) -> {

    });
    this.displayDatePicker2.valueProperty().addListener((observable, oldValue, newValue) -> {

    });
    this.displayDatePicker3.valueProperty().addListener((observable, oldValue, newValue) -> {

    });
    this.displayDatePicker4.valueProperty().addListener((observable, oldValue, newValue) -> {

    });
    this.displayDatePicker5.valueProperty().addListener((observable, oldValue, newValue) -> {

    });
    this.opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
      // Spinnerの値を変更
    });
    this.opacitySpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
      // Sliderの値を変更
    });
    this.timerDatePicker.valueProperty().addListener((observable, oldValue, newValue) -> {

    });
  }

  /**
   * チェックボックス押下時のコールバック処理
   * 
   * @param event
   */
  @FXML
  protected void onCheckBoxClick(ActionEvent event) {
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

  @FXML
  protected void onDisplayModeChanged(ActionEvent event) {
    switch (((ChoiceBox) event.getSource()).getId()) {
      case "frontAnimationDisplayModeChoiceBox":
        break;
      case "backAnimationDisplayModeChoiceBox":
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + event.getSource());
    }
  }

  @FXML
  protected void onFontChanged(ActionEvent event) {
    System.out.println("low");
  }

  @FXML
  protected void onFontColorChanged(ActionEvent event) {

  }

  @FXML
  protected void onOpacityChangedWithSlider(MouseEvent event) {
    System.out.println("wow");
  }
}