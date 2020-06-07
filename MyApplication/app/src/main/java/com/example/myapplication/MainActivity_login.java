package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class MainActivity_login extends AppCompatActivity {

        Button mbt1_login,mbt2_login,mbt3_login,mbt4_login,msbt1_login,msbt2_login,msbt3_login,msbt4_login,msbt5_login;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mainlogin);
            mbt1_login = findViewById(R.id.bt_1_login);
            mbt2_login = findViewById(R.id.bt_2_login);
            mbt3_login = findViewById(R.id.bt_3_login);
            mbt4_login = findViewById(R.id.bt_4_login);

            msbt1_login = findViewById(R.id.sbt_1_login);
            msbt2_login = findViewById(R.id.sbt_2_login);
            msbt3_login = findViewById(R.id.sbt_3_login);
            msbt4_login = findViewById(R.id.sbt_4_login);
            msbt5_login = findViewById(R.id.sbt_5_login);


            mbt2_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到待办页面
                    Intent i1_login=new Intent(com.example.myapplication.MainActivity_login.this,PlanActivity_login.class);
                    startActivity(i1_login);
                }
            });
            mbt3_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到打卡页面
                    Intent i2_login=new Intent(com.example.myapplication.MainActivity_login.this,DakaActivity_login.class);
                    startActivity(i2_login);
                }
            });
            mbt4_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到“我的”页面
                    Intent i3_login=new Intent(com.example.myapplication.MainActivity_login.this,Myloginactivity.class);
                    startActivity(i3_login);
                }
            });


            msbt1_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到全屏计时页面
                    Intent i4_login=new Intent(com.example.myapplication.MainActivity_login.this,FocusActivity_login.class);
                    startActivity(i4_login);
                }
            });
            msbt2_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到全屏计时页面
                    Intent i5_login=new Intent(com.example.myapplication.MainActivity_login.this,FocusActivity_login.class);
                    startActivity(i5_login);
                }
            });
            msbt3_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到全屏计时页面
                    Intent i6_login=new Intent(com.example.myapplication.MainActivity_login.this,FocusActivity_login.class);
                    startActivity(i6_login);
                }
            });
            msbt4_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到全屏计时页面
                    Intent i7_login=new Intent(com.example.myapplication.MainActivity_login.this,FocusActivity_login.class);
                    startActivity(i7_login);
                }
            });
            msbt5_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到全屏计时页面
                    Intent i8_login=new Intent(com.example.myapplication.MainActivity_login.this,FocusActivity_login.class);
                    startActivity(i8_login);
                }
            });
        }
    }
