package com.example.lesson1hw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_SHARED_PREFERENCE = "LOGIN";
    public static final String appTheme = "APP_THEME";

    public static final int PashaCoolCodeSyle = 0;
    public static final int DarkCodeStyle = 1;
    public static final int OriginCodeSyle = 2;


    private int counter1 = 0;
    public static final String DEFAULT_VALUE_NUMBERS_AND_ANSWER = "0";
    private boolean changeToSecondNumber = false;
    public static final String KEY_CONSTANT_first_Number = "KEY_CONSTANT_first_Number";
    public static final String KEY_CONSTANT_second_Number = "KEY_CONSTANT_second_Number";
    public static final String KEY_CONSTANT_current_math_action = "KEY_CONSTANT_current_math_action";
    public static final String KEY_CONSTANT_answer_Number = "KEY_CONSTANT_answer_Number";

    String firstNumberString = new String();
    String secondNumberString = new String();
    String finalAnswerString = new String();
    String current_math_action = new String();

    private TextView first_Number;
    private TextView second_Number;
    private TextView math_Action;
    private TextView math_Answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int currentThemeCode = getCodeStyle();
        int currentThemeResId = codeStyleToStyleId(currentThemeCode);
        setTheme(currentThemeResId);


        setContentView(R.layout.activity_main);


        Typeface typefaceTokyoZoo = Typeface.createFromAsset(getAssets(), "font/ZenTokyoZoo-Regular.ttf");
        TextView textViewHeadline = findViewById(R.id.textViewHeadline2);
        textViewHeadline.setTypeface(typefaceTokyoZoo);


        first_Number = findViewById(R.id.first_Number);
        second_Number = findViewById(R.id.second_Number);


        math_Action = findViewById(R.id.current_math_action);
        math_Answer = findViewById(R.id.textViewAnser);


        findViewById(R.id.buttonCalculatorNumer0).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "0";
            } else {
                secondNumberString = secondNumberString + "0";
                ;
            }
            updateCounters();
        });

        findViewById(R.id.buttonCalculatorNumer1).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "1";
            } else {
                secondNumberString = secondNumberString + "1";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer2).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "2";
            } else {
                secondNumberString = secondNumberString + "2";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer3).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "3";
            } else {
                secondNumberString = secondNumberString + "3";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer4).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "4";
            } else {
                secondNumberString = secondNumberString + "4";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer5).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "5";
            } else {
                secondNumberString = secondNumberString + "5";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer6).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "6";
            } else {
                secondNumberString = secondNumberString + "6";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer7).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "7";
            } else {
                secondNumberString = secondNumberString + "7";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer8).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "8";
            } else {
                secondNumberString = secondNumberString + "8";
                ;
            }
            updateCounters();
        });
        findViewById(R.id.buttonCalculatorNumer9).setOnClickListener(v -> {
            if (changeToSecondNumber == false) {
                firstNumberString = firstNumberString + "9";
            } else {
                secondNumberString = secondNumberString + "9";
                ;
            }
            updateCounters();
        });

        findViewById(R.id.buttonCalculatorNumerPlus).setOnClickListener(v -> {
            current_math_action = "+";
            changeToSecondNumber = true;
            updateMathAction();
        });
        findViewById(R.id.buttonCalculatorNumerMin).setOnClickListener(v -> {
            current_math_action = "-";
            changeToSecondNumber = true;
            updateMathAction();
        });
        findViewById(R.id.buttonCalculatorNumerX).setOnClickListener(v -> {
            current_math_action = "x";
            changeToSecondNumber = true;
            updateMathAction();
        });
        findViewById(R.id.buttonCalculatorNumerDiv).setOnClickListener(v -> {
            current_math_action = "/";
            changeToSecondNumber = true;
            updateMathAction();
        });

        findViewById(R.id.buttonCalculatorNumerEqulse).setOnClickListener(v -> {

            Double firstNumberDouble = Double.valueOf(firstNumberString);
            Double secondNumberDouble = Double.valueOf(secondNumberString);

            if (current_math_action == "+") {
                Double finalAnswer = firstNumberDouble + secondNumberDouble;

                finalAnswerString = String.format("%.0f", finalAnswer);
                updateMathAnswer();
            } else if (current_math_action == "-") {
                Double finalAnswer = firstNumberDouble - secondNumberDouble;

                finalAnswerString = String.format("%.0f", finalAnswer);
                updateMathAnswer();
            } else if (current_math_action == "x") {
                Double finalAnswer = firstNumberDouble * secondNumberDouble;

                finalAnswerString = String.format("%.0f", finalAnswer);
                updateMathAnswer();
            } else if (current_math_action == "/") {

                if (secondNumberDouble != 0) {
                    Double finalAnswer = firstNumberDouble / secondNumberDouble;
                    finalAnswerString = String.format("%.7f", finalAnswer);
                } else if (secondNumberDouble == 0) {
                    finalAnswerString = "деление на ноль";
                }
            }

            updateMathAnswer();

        });

        findViewById(R.id.buttonCalculatorNumerAC).setOnClickListener(v -> {
            firstNumberString = "0";
            secondNumberString = "0";
            finalAnswerString = "0";

            updateCounters();
            changeToSecondNumber = false;
            updateCounters();
            updateMathAnswer();

        });

        //
        initMyRadioButtons();
    }

    private void initRadioButtons() {
    }


    private int getCodeStyle() {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        return preferences.getInt(appTheme, R.style.PashasCoolStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        preferences.edit()
                .putInt(appTheme, codeStyle)
                .apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case PashaCoolCodeSyle:
                return R.style.PashasCoolStyle;
            case DarkCodeStyle:
                return R.style.ThemeOverlay_AppCompat_Dark;
            case OriginCodeSyle:
                return R.style.Theme_Lesson1HW;
            default:
                return R.style.ThemeOverlay_AppCompat_Dark;
        }
    }


    private void initMyRadioButtons() {
        findViewById(R.id.radioButtonPashaCoolStyle).setOnClickListener(v -> {
            setAppTheme(PashaCoolCodeSyle);
            recreate();
        });
        findViewById(R.id.radioButtonDarc).setOnClickListener(v -> {
            setAppTheme(DarkCodeStyle);
            recreate();
        });
        findViewById(R.id.radioButtonOrigin).setOnClickListener(v -> {
            setAppTheme(OriginCodeSyle);
            recreate();
        });

    }


    private void updateCounters() {

        if (changeToSecondNumber == false) {
            first_Number.setText(String.valueOf(firstNumberString));
        } else {
            second_Number.setText(String.valueOf(secondNumberString));
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY_CONSTANT_first_Number", firstNumberString);
        outState.putString("KEY_CONSTANT_second_Number", secondNumberString);
        outState.putString("KEY_CONSTANT_current_math_action", current_math_action);
        outState.putString("KEY_CONSTANT_answer_Number", finalAnswerString);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstNumberString = savedInstanceState.getString("KEY_CONSTANT_first_Number", DEFAULT_VALUE_NUMBERS_AND_ANSWER);
        secondNumberString = savedInstanceState.getString("KEY_CONSTANT_second_Number", DEFAULT_VALUE_NUMBERS_AND_ANSWER);
        current_math_action = savedInstanceState.getString("KEY_CONSTANT_current_math_action", "math_action");
        finalAnswerString = savedInstanceState.getString("KEY_CONSTANT_answer_Number", DEFAULT_VALUE_NUMBERS_AND_ANSWER);

    }

    private void updateMathAction() {
        math_Action.setText(String.valueOf(current_math_action));
        //first_Number.setText(String.valueOf(firstNumberString));
    }

    private void updateMathAnswer() {

        math_Answer.setText(String.valueOf(finalAnswerString));

    }
}

