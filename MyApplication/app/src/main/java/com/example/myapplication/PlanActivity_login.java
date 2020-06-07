package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlanActivity_login extends AppCompatActivity {
    Button mpbt1,mpbt2,mpbt3,mpbt4,mpbt5,mbt1_login,mbt2_login,mbt3_login,mbt4_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planlogin);
        mbt1_login =findViewById(R.id.bt_1_login);
        mbt2_login =findViewById(R.id.bt_2_login);
        mbt3_login =findViewById(R.id.bt_3_login);
        mbt4_login =findViewById(R.id.bt_4_login);
        mpbt1 = findViewById(R.id.pbt_1);
        mpbt2 = findViewById(R.id.pbt_2);
        mpbt3 = findViewById(R.id.pbt_3);
        mpbt4 = findViewById(R.id.pbt_4);
        mpbt5 = findViewById(R.id.pbt_5);
        mbt1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面
                Intent i1_login = new Intent(PlanActivity_login.this,MainActivity_login.class);
                startActivity(i1_login);
            }
        });
        mbt3_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到打卡界面
                Intent i2_login=new Intent(PlanActivity_login.this,DakaActivity_login.class);
                startActivity(i2_login);
            }
        });
        mbt4_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“我的”界面
                Intent i3_login=new Intent(PlanActivity_login.this,Myloginactivity.class);
                startActivity(i3_login);
            }
        });
        mpbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1_todo=new Intent(PlanActivity_login.this, TodoMainActivity_login.class);
                startActivity(i1_todo);
            }
        });
        mpbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2_todo=new Intent(PlanActivity_login.this, TodoMainActivity_login.class);
                startActivity(i2_todo);
            }
        });
        mpbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3_todo=new Intent(PlanActivity_login.this, TodoMainActivity_login.class);
                startActivity(i3_todo);
            }
        });
        mpbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4_todo=new Intent(PlanActivity_login.this, TodoMainActivity_login.class);
                startActivity(i4_todo);
            }
        });
        mpbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5_todo=new Intent(PlanActivity_login.this, TodoMainActivity_login.class);
                startActivity(i5_todo);
            }
        });
    }
}


