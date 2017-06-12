package com.agent2.alisaim.sharedpreferencethemeexample;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Button mRedColor;
    Button mGreenColor;
    Button mYellowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar)findViewById(R.id.toolbar);

        mRedColor = (Button)findViewById(R.id.buttonRed);
        mGreenColor = (Button)findViewById(R.id.buttonGreen);
        mYellowColor =  (Button)findViewById(R.id.buttonYello);

        mToolbar.setTitle(getResources().getString(R.string.app_name));

        //check if these is anything choice is already stored in sharedPreference
        if(getColor() != getResources().getColor(R.color.colorPrimary)) {
            mToolbar.setBackgroundColor(getColor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }


        mRedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                }
                setColor(getResources().getColor(R.color.colorRed));

            }
        });



        mGreenColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorGreen));
                }
                setColor(getResources().getColor(R.color.colorGreen));

            }
        });


        mYellowColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorYello));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorYello));
                }
                setColor(getResources().getColor(R.color.colorYello));

            }
        });


    }


    private void setColor(int color) {
        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply();
    }


    private int getColor() {
        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        int selectColor = sharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimary));
        return selectColor;
    }
}
