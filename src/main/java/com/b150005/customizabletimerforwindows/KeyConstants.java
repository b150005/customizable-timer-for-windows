package com.b150005.customizabletimerforwindows;

/**
 * Redisサーバに追加するキーを定義する定数クラス
 * 静的インポートによって利用性を向上させる
 * 例:) `import static com.b150005.customizabletimerforwindows.KeyConstants`
 */
public class KeyConstants {
  // コンストラクタをprivateで定義することでインスタンス化を避ける
  private KeyConstants(){}

  /**
   * Redisサーバに登録されたデータが存在するかどうかを識別するフラグ
   */
  public static final String hasAlreadyExisted = "hasAlreadyExisted";

  /**
   * デジタルモードで表示するかどうかを識別するフラグのkey
   */
  public static final String displayOnDigitalMode = "displayOnDigitalMode";
  /**
   * アニメーションを前面で表示するかどうかを識別するフラグのkey
   */
  public static final String displayAnimationInFront = "displayAnimationInFront";

  /**
   * アニメーション(前面)を表示するかどうかを識別するフラグのkey
   */
  public static final String frontAnimationIsOn = "frontAnimationIsOn";
  /**
   * アニメーション(前面)の表示タイミングを識別するデータのkey
   */
  public static final String frontAnimationDisplayMode = "frontAnimationDisplayMode";
  /**
   * アニメーション(前面)のファイルパスを表示するラベルのkey
   */
  public static final String frontAnimationFilePath = "frontAnimationFilePath";
  /**
   * アニメーション(背面)を表示するかどうかを識別するフラグのkey
   */
  public static final String backAnimationIsOn = "backAnimationIsOn";
  /**
   * アニメーション(背面)の表示タイミングを識別するデータのkey
   */
  public static final String backAnimationDisplayMode = "backAnimationDisplayMode";
  /**
   * アニメーション(背面)のファイルパスを表示するラベルのkey
   */
  public static final String backAnimationFilePath = "backAnimationFilePath";

  /**
   * アニメーションの表示タイミングの選択肢: 常時
   */
  public static final String always = "常時";
  /**
   * アニメーションの表示タイミングの選択肢: 指定時
   */
  public static final String designated = "指定時";
  /**
   * ファイルが選択されていない場合に表示されるメッセージ
   */
  public static final String fileIsNotSelected = "選択ボタンを押してファイルを選択してください";
  /**
   * 指定時刻に表示するアニメーションの選択肢: 前面
   */
  public static final String front = "前面";
  /**
   * 指定時刻に表示するアニメーションの選択肢: 背面
   */
  public static final String back = "背面";

  /**
   * 時刻①の年データのkey
   */
  public static final String displayYear1 = "displayYear1";
  /**
   * 時刻①の月データのkey
   */
  public static final String displayMonth1 = "displayMonth1";
  /**
   * 時刻①の日データのkey
   */
  public static final String displayDay1 = "displayDay1";
  /**
   * 時刻①の時データのkey
   */
  public static final String displayHour1 = "displayHour1";
  /**
   * 時刻①の分データのkey
   */
  public static final String displayMinute1 = "displayMinute1";
  /**
   * 時刻①の秒データのkey
   */
  public static final String displaySecond1 = "displaySecond1";
  /**
   * 時刻②の年データのkey
   */
  public static final String displayYear2 = "displayYear2";
  /**
   * 時刻②の月データのkey
   */
  public static final String displayMonth2 = "displayMonth2";
  /**
   * 時刻②の日データのkey
   */
  public static final String displayDay2 = "displayDay2";
  /**
   * 時刻②の時データのkey
   */
  public static final String displayHour2 = "displayHour2";
  /**
   * 時刻②の分データのkey
   */
  public static final String displayMinute2 = "displayMinute2";
  /**
   * 時刻②の秒データのkey
   */
  public static final String displaySecond2 = "displaySecond2";
  /**
   * 時刻③の年データのkey
   */
  public static final String displayYear3 = "displayYear3";
  /**
   * 時刻③の月データのkey
   */
  public static final String displayMonth3 = "displayMonth3";
  /**
   * 時刻③の日データのkey
   */
  public static final String displayDay3 = "displayDay3";
  /**
   * 時刻③の時データのkey
   */
  public static final String displayHour3 = "displayHour3";
  /**
   * 時刻③の分データのkey
   */
  public static final String displayMinute3 = "displayMinute3";
  /**
   * 時刻③の秒データのkey
   */
  public static final String displaySecond3 = "displaySecond3";
  /**
   * 時刻④の年データのkey
   */
  public static final String displayYear4 = "displayYear4";
  /**
   * 時刻④の月データのkey
   */
  public static final String displayMonth4 = "displayMonth4";
  /**
   * 時刻④の日データのkey
   */
  public static final String displayDay4 = "displayDay4";
  /**
   * 時刻④の時データのkey
   */
  public static final String displayHour4 = "displayHour4";
  /**
   * 時刻④の分データのkey
   */
  public static final String displayMinute4 = "displayMinute4";
  /**
   * 時刻④の秒データのkey
   */
  public static final String displaySecond4 = "displaySecond4";
  /**
   * 時刻⑤の年データのkey
   */
  public static final String displayYear5 = "displayYear5";
  /**
   * 時刻⑤の月データのkey
   */
  public static final String displayMonth5 = "displayMonth5";
  /**
   * 時刻⑤の日データのkey
   */
  public static final String displayDay5 = "displayDay5";
  /**
   * 時刻⑤の時データのkey
   */
  public static final String displayHour5 = "displayHour5";
  /**
   * 時刻⑤の分データのkey
   */
  public static final String displayMinute5 = "displayMinute5";
  /**
   * 時刻⑤の秒データのkey
   */
  public static final String displaySecond5 = "displaySecond5";

  /**
   * 時計盤のファイルパスのkey
   */
  public static final String faceFilePath = "faceFilePath";
  /**
   * 短針のファイルパスのkey
   */
  public static final String hourFilePath = "hourFilePath";
  /**
   * 長針のファイルパスのkey
   */
  public static final String minuteFilePath = "minuteFilePath";
  /**
   * 秒針のファイルパスのkey
   */
  public static final String secondFilePath = "secondFilePath";
  
  /**
   * タイマーとして表示するかどうかを識別するフラグのkey
   */
  public static final String digitalTimerModeIsOn = "digitalTimerModeIsOn";

  /**
   * 選択されたフォントのkey
   */
  public static final String selectedFont = "selectedFont";
  /**
   * フォントカラー(基本)のkey
   */
  public static final String baseFontColor = "baseFontColor";
  /**
   * フォントカラー(直前)のkey
   */
  public static final String beforeFontColor = "beforeFontColor";
  /**
   * タイマーのフォント色(直前)を変更する分データのkey
   */
  public static final String beforeMinute = "beforeMinute";
  /**
   * フォントカラー(直後)のkey
   */
  public static final String afterFontColor = "afterFontColor";
  /**
   * タイマーのフォント色(直後)を変更する分データのkey
   */
  public static final String afterMinute = "afterMinute";
  /**
   * 透明度のkey
   */
  public static final String opacity = "opacity";

  /**
   * タイマーの期限(年)データのkey
   */
  public static final String timerYear = "timerYear";
  /**
   * タイマーの期限(月)データのkey
   */
  public static final String timerMonth = "timerMonth";
  /**
   * タイマーの期限(日)データのkey
   */
  public static final String timerDay = "timerDay";
  /**
   * タイマーの期限(時)データのkey
   */
  public static final String timerHour = "timerHour";
  /**
   * タイマーの期限(分)データのkey
   */
  public static final String timerMinute = "timerMinute";
  /**
   * タイマーの期限(秒)データのkey
   */
  public static final String timerSecond = "timerSecond";
  /**
   * タイマーモードの期限超過時に時計モードに移行するかどうかを識別するフラグのkey
   */
  public static final String changeToDigitalClockAfterTimerDate = "changeToDigitalClockAfterTimerDate";
}
