package com.example.lesson1hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {


    public static final String NAME_SHARED_PREFERENCE = "LOGIN";
    public static final String appTheme = "APP_THEME";

    public static final int PashaCoolCodeSyle = 0;
    public static final int DarkCodeStyle = 1;
    public static final int OriginCodeSyle = 2;
    public static final String SUM_RESULT_ = "SUM_RESULT ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int currentThemeCode = getCodeStyle();
        int currentThemeResId = codeStyleToStyleId(currentThemeCode);
        setTheme(currentThemeResId);



        setContentView(R.layout.activity_settings);

        initGoToMainActivity();
        initMyRadioButtons();
    }

    private void initGoToMainActivity() {
        findViewById(R.id.buttonGoToCalcunator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
        findViewById(R.id.radioButtonPashaCoolStyleSettings).setOnClickListener(v -> {
            setAppTheme(PashaCoolCodeSyle);
            recreate();
        });
        findViewById(R.id.radioButtonDarcSettings).setOnClickListener(v -> {
            setAppTheme(DarkCodeStyle);
            recreate();
        });
        findViewById(R.id.radioButtonOriginSettings).setOnClickListener(v -> {
            setAppTheme(OriginCodeSyle);
            recreate();
        });

    }
}