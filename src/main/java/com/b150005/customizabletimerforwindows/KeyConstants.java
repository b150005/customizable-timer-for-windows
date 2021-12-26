package com.b150005.customizabletimerforwindows;

/**
 * Redisサーバに追加するキーを定義する定数クラス
 * 静的インポートによって利用性を向上させる
 * 例:) `import static com.b150005.customizabletimerforwindows.KeyConstants`
 */
public class KeyConstants {
  // コンストラクタをprivateで定義することでインスタンス化を避ける
  private KeyConstants(){}

  public static final String hasAlreadyExisted = "hasAlreadyExisted";

  public static final String displayOnDigitalMode = "displayOnDigitalMode";
  public static final String displayAnimationInFront = "displayAnimationInFront";

  public static final String frontAnimationIsOn = "frontAnimationIsOn";
  public static final String frontAnimationDisplayMode = "frontAnimationDisplayMode";
  public static final String frontAnimationFilePath = "frontAnimationFilePath";
  public static final String backAnimationIsOn = "backAnimationIsOn";
  public static final String backAnimationDisplayMode = "backAnimationDisplayMode";
  public static final String backAnimationFilePath = "backAnimationFilePath";

  public static final String always = "常時";
  public static final String designated = "指定時";
  public static final String fileIsNotSelected = "選択ボタンを押してファイルを選択してください";
  public static final String front = "前面";
  public static final String back = "背面";

  public static final String displayDate1 = "displayDate1";
  public static final String displayDate2 = "displayDate2";
  public static final String displayDate3 = "displayDate3";
  public static final String displayDate4 = "displayDate4";
  public static final String displayDate5 = "displayDate5";

  public static final String faceFilePath = "faceFilePath";
  public static final String hourFilePath = "hourFilePath";
  public static final String minuteFilePath = "minuteFilePath";
  public static final String secondFilePath = "secondFilePath";
  
  public static final String digitalTimerModeIsOn = "digitalTimerModeIsOn";

  public static final String selectedFont = "selectedFont";
  public static final String baseFontColor = "baseFontColor";
  public static final String beforeFontColor = "beforeFontColor";
  public static final String beforeMinute = "beforeMinute";
  public static final String afterFontColor = "afterFontColor";
  public static final String afterMinute = "afterMinute";

  public static final String opacity = "opacity";
  public static final String timerDate = "timerDate";
  public static final String changeToDigitalClockAfterTimerDate = "changeToDigitalClockAfterTimerDate";
}
