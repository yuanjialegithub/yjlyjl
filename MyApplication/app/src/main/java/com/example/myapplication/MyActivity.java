package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    Button mbt1,mbt2,mbt3,mbt4,msbt6,msbt7;
    TextView mtv1,mtv2,mtv3,mtv4,mtv5,mtv6,mtv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mbt1 = findViewById(R.id.bt_1);
        mbt2 = findViewById(R.id.bt_2);
        mbt3 = findViewById(R.id.bt_3);
        mbt4 = findViewById(R.id.bt_4);
        mtv1 =findViewById(R.id.tv_1);
        mtv2 =findViewById(R.id.tv_2);
        mtv3 =findViewById(R.id.tv_3);
        mtv4 =findViewById(R.id.tv_4);
        mtv5 =findViewById(R.id.tv_5);
        mtv6 =findViewById(R.id.tv_6);
        mtv7=findViewById(R.id.user_name);


        msbt6 = findViewById(R.id.sbt_6);
        msbt7 = findViewById(R.id.sbt_7);
        mbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面
                Intent i1 = new Intent(MyActivity.this,MainActivity.class);
                startActivity(i1);
            }
        });
        mbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到待办页面
                Intent i2=new Intent(MyActivity.this,PlanActivity.class);
                startActivity(i2);
            }
        });
        mbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到打卡界面
                Intent i3=new Intent(MyActivity.this,DakaActivity.class);
                startActivity(i3);
            }
        });
        msbt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到登录页面
                Intent i9=new Intent();
                i9.setClass(MyActivity.this,loginActivity.class);
                startActivity(i9);
            }
        });
        msbt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册页面
                Intent i10=new Intent(MyActivity.this,RegisterActivity.class);
                startActivity(i10);
            }
        });
    }
}
