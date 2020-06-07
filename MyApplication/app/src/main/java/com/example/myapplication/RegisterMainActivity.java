package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.CreateRoom;
import com.example.myapplication.JoinRoom;
import com.example.myapplication.R;
import com.example.myapplication.loginActivity;


/**
 * 此类 implements View.OnClickListener 之后，
 * 就可以把onClick事件写到onCreate()方法之外
 * 这样，onCreate()方法中的代码就不会显得很冗余
 */
public class RegisterMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mcreate;
    private Button mjoin;
    private Button mBtMainLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zcmain);

        initView();
    }

    private void initView() {
        // 初始化控件对象
        mBtMainLogout = findViewById(R.id.bt_main_logout);
        mcreate = findViewById(R.id.create);
        mjoin = findViewById(R.id.join);
        // 绑定点击监听器
        mBtMainLogout.setOnClickListener(this);
        mcreate.setOnClickListener(this);
        mjoin.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_main_logout:
                startActivity(new Intent(this, loginActivity.class));
                finish();
                break;

            case R.id.create:
                startActivity(new Intent(this, CreateRoom.class));
                finish();
                break;

            case R.id.join:
                startActivity(new Intent(this, JoinRoom.class));
                finish();
                break;
        }

    }
}
