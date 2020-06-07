package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Myloginactivity extends AppCompatActivity {
    Button mbt1_login,mbt2_login,mbt3_login,mbt4_login;
    private Button achievement;
    private Button mcreate;
    private Button mjoin;
    private Button mBtMainLogout;
    private Button timebarchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylogin);
        mbt1_login = findViewById(R.id.bt_1_login);
        mbt2_login = findViewById(R.id.bt_2_login);
        mbt3_login = findViewById(R.id.bt_3_login);
        mbt4_login = findViewById(R.id.bt_4_login);
        achievement = findViewById(R.id.achi);
        mBtMainLogout = findViewById(R.id.bt_logout);
        mcreate = findViewById(R.id.create);
        mjoin = findViewById(R.id.join);
        timebarchart = findViewById(R.id.tbc);

        mbt1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面
                Intent i1_login = new Intent(Myloginactivity.this,MainActivity_login.class);
                startActivity(i1_login);
            }
        });
        mbt2_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到待办页面
                Intent i2_login=new Intent(Myloginactivity.this,PlanActivity_login.class);
                startActivity(i2_login);
            }
        });
        mbt3_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到打卡界面
                Intent i3_login=new Intent(Myloginactivity.this,DakaActivity_login.class);
                startActivity(i3_login);
            }
        });
        mBtMainLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到登录界面
                Intent i_logout=new Intent(Myloginactivity.this,MyActivity.class);
                startActivity(i_logout);
            }
        });
        mcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“创建自习室”界面
                Intent i_create=new Intent(Myloginactivity.this,CreateRoom.class);
                startActivity(i_create);
            }
        });
        mjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“加入自习室”界面
                Intent i_join=new Intent(Myloginactivity.this,JoinRoom.class);
                startActivity(i_join);
            }
        });
        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“成就”界面
                Intent i_achi=new Intent(Myloginactivity.this,AchievementMainActivity.class);
                startActivity(i_achi);
            }
        });
        timebarchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“周报”界面
                Intent i_tbc=new Intent(Myloginactivity.this,TimebarchartMainActivity.class);
                startActivity(i_tbc);
            }
        });
    }
}