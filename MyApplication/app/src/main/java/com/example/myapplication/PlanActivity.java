package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlanActivity extends AppCompatActivity {
    Button mpbt1,mpbt2,mpbt3,mpbt4,mpbt5,mbt1,mbt2,mbt3,mbt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        mbt1 =findViewById(R.id.bt_1);
        mbt2 =findViewById(R.id.bt_2);
        mbt3 =findViewById(R.id.bt_3);
        mbt4 =findViewById(R.id.bt_4);
        mpbt1 = findViewById(R.id.pbt_1);
        mpbt2 = findViewById(R.id.pbt_2);
        mpbt3 = findViewById(R.id.pbt_3);
        mpbt4 = findViewById(R.id.pbt_4);
        mpbt5 = findViewById(R.id.pbt_5);
        mbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面
                Intent i1 = new Intent(PlanActivity.this,MainActivity.class);
                startActivity(i1);
            }
        });
        mbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到打卡界面
                Intent i2=new Intent(PlanActivity.this,DakaActivity.class);
                startActivity(i2);
            }
        });
        mbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“我的”界面
                Intent i3=new Intent(PlanActivity.this,MyActivity.class);
                startActivity(i3);
            }
        });
        mpbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1_todo=new Intent(PlanActivity.this, TodoMainActivity_login.class);
                startActivity(i1_todo);
            }
        });
        mpbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2_todo=new Intent(PlanActivity.this, TodoMainActivity_login.class);
                startActivity(i2_todo);
            }
        });
        mpbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3_todo=new Intent(PlanActivity.this, TodoMainActivity_login.class);
                startActivity(i3_todo);
            }
        });
        mpbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4_todo=new Intent(PlanActivity.this, TodoMainActivity_login.class);
                startActivity(i4_todo);
            }
        });
        mpbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5_todo=new Intent(PlanActivity.this, TodoMainActivity_login.class);
                startActivity(i5_todo);
            }
        });
    }
}


