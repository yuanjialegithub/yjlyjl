package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mbt1,mbt2,mbt3,mbt4,msbt1,msbt2,msbt3,msbt4,msbt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbt1 = findViewById(R.id.bt_1);
        mbt2 = findViewById(R.id.bt_2);
        mbt3 = findViewById(R.id.bt_3);
        mbt4 = findViewById(R.id.bt_4);

        msbt1 = findViewById(R.id.sbt_1);
        msbt2 = findViewById(R.id.sbt_2);
        msbt3 = findViewById(R.id.sbt_3);
        msbt4 = findViewById(R.id.sbt_4);
        msbt5 = findViewById(R.id.sbt_5);


        mbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到待办页面
                Intent i1=new Intent(MainActivity.this,PlanActivity.class);
                startActivity(i1);
            }
        });
        mbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到打卡页面
                Intent i2=new Intent(MainActivity.this,DakaActivity.class);
                startActivity(i2);
            }
        });
        mbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“我的”页面
                Intent i3=new Intent(MainActivity.this,MyActivity.class);
                startActivity(i3);
            }
        });


        msbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到全屏计时页面
                Intent i4=new Intent(MainActivity.this,FocusActivity.class);
                startActivity(i4);
            }
        });
        msbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到全屏计时页面
                Intent i5=new Intent(MainActivity.this,FocusActivity.class);
                startActivity(i5);
            }
        });
        msbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到全屏计时页面
                Intent i6=new Intent(MainActivity.this,FocusActivity.class);
                startActivity(i6);
            }
        });
        msbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到全屏计时页面
                Intent i7=new Intent(MainActivity.this,FocusActivity.class);
                startActivity(i7);
            }
        });
        msbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到全屏计时页面
                Intent i8=new Intent(MainActivity.this,FocusActivity.class);
                startActivity(i8);
            }
        });
    }
}
