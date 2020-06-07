package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DakaActivity_login extends Activity implements View.OnClickListener {
    private EditText mEditText,mEditText2,mEditText3,mEditText4,mEditText5;
    private Button mButton,mButton2,mButton3,mButton4,mButton5;
    private TextView mTextView,mTextView2,mTextView3,mTextView4,mTextView5;
    Button mbt1_login,mbt2_login,mbt3_login,mbt4_login, calendar,calendar2,calendar3,calendar4,calendar5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dakalogin);
        setupView();
        setupView2();
        setupView3();
        setupView4();
        setupView5();
        mbt1_login = findViewById(R.id.bt_1_login);
        mbt2_login = findViewById(R.id.bt_2_login);
        mbt3_login = findViewById(R.id.bt_3_login);
        mbt4_login = findViewById(R.id.bt_4_login);
        calendar = findViewById(R.id.bt_cal);
        calendar2 = findViewById(R.id.bt_cal2);
        calendar3 = findViewById(R.id.bt_cal3);
        calendar4 = findViewById(R.id.bt_cal4);
        calendar5 = findViewById(R.id.bt_cal5);

        mbt1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面
                Intent i1_login = new Intent(DakaActivity_login.this, MainActivity_login.class);
                startActivity(i1_login);
            }
        });
        mbt2_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到待办页面
                Intent i2_login = new Intent(DakaActivity_login.this, PlanActivity_login.class);
                startActivity(i2_login);
            }
        });
        mbt4_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“我的”页面
                Intent i3_login = new Intent(DakaActivity_login.this, Myloginactivity.class);
                startActivity(i3_login);
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“日历”页面
                Intent i_cal = new Intent(DakaActivity_login.this, DakaMainActivity.class);
                startActivity(i_cal);
            }
        });
        calendar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“日历”页面
                Intent i_cal2 = new Intent(DakaActivity_login.this, DakaMainActivity.class);
                startActivity(i_cal2);
            }
        });
        calendar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“日历”页面
                Intent i_cal3 = new Intent(DakaActivity_login.this, DakaMainActivity.class);
                startActivity(i_cal3);
            }
        });
        calendar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“日历”页面
                Intent i_cal4 = new Intent(DakaActivity_login.this, DakaMainActivity.class);
                startActivity(i_cal4);
            }
        });
        calendar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“日历”页面
                Intent i_cal5 = new Intent(DakaActivity_login.this, DakaMainActivity.class);
                startActivity(i_cal5);
            }
        });
    }

    public void setupView() {
        mEditText = (EditText) findViewById(R.id.edittext);
        mTextView = (TextView) findViewById(R.id.show_text);
        mButton = (Button) findViewById(R.id.bt_true);
        mButton.setId(0);
        mButton.setOnClickListener(this);
    }

    public void setupView2() {
        mEditText2 = (EditText) findViewById(R.id.edittext2);
        mTextView2 = (TextView) findViewById(R.id.show_text2);
        mButton2 = (Button) findViewById(R.id.bt_true2);
        mButton2.setId(0);
        mButton2.setOnClickListener(this);
    }
    public void setupView3() {
        mEditText3 = (EditText) findViewById(R.id.edittext3);
        mTextView3 = (TextView) findViewById(R.id.show_text3);
        mButton3 = (Button) findViewById(R.id.bt_true3);
        mButton3.setId(0);
        mButton3.setOnClickListener(this);
    }
    public void setupView4() {
        mEditText4 = (EditText) findViewById(R.id.edittext4);
        mTextView4 = (TextView) findViewById(R.id.show_text4);
        mButton4 = (Button) findViewById(R.id.bt_true4);
        mButton4.setId(0);
        mButton4.setOnClickListener(this);
    }
    public void setupView5() {
        mEditText5 = (EditText) findViewById(R.id.edittext5);
        mTextView5 = (TextView) findViewById(R.id.show_text5);
        mButton5 = (Button) findViewById(R.id.bt_true5);
        mButton5.setId(0);
        mButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == 0) {
            String tmp = mEditText.getText().toString();
            mTextView.setText(tmp);
            String tmp2 = mEditText2.getText().toString();
            mTextView2.setText(tmp2);
            String tmp3 = mEditText3.getText().toString();
            mTextView3.setText(tmp3);
            String tmp4 = mEditText4.getText().toString();
            mTextView4.setText(tmp4);
            String tmp5 = mEditText5.getText().toString();
            mTextView5.setText(tmp5);
        }
    }
}
