package com.example.myapplication;
/*
*加入房间，在数据库表users中寻找对应的房间名
* 显示加入成功，并跳转到房间信息查看界面
 */
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DBOpenHelper;
import com.example.myapplication.R;

import java.util.ArrayList;

public class JoinRoom extends AppCompatActivity implements View.OnClickListener {
    private DBOpenHelper mDBOpenHelpers;
    private ImageView mjoinback;
    private EditText mjointhree;
    private Button mjoinfour;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        initView();
        mDBOpenHelpers = new DBOpenHelper(this);
    }
    public void initView(){
        mjoinback = findViewById(R.id.join_back);
        mjointhree = findViewById(R.id.jointhree);
        mjoinfour = findViewById(R.id.joinfour);
        mjoinback.setOnClickListener(this);
        mjoinfour.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.join_back:
                startActivity(new Intent(this,Myloginactivity.class));
                finish();
                break;
            case R.id.joinfour:
                String roomname = mjointhree.getText().toString().trim();
                if(!TextUtils.isEmpty(roomname)){
                    ArrayList<com.example.myapplication.Users> data = mDBOpenHelpers.getAllData();
                    boolean matchs = false;
                    for(int i=0;i<data.size();i++){
                        com.example.myapplication.Users users = data.get(i);
                        if(roomname.equals(users.getName())){
                            matchs = true;
                            break;
                        }else{
                            matchs = false;
                        }
                    }
                    if(matchs){
                        Toast.makeText(this,"加入成功",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, com.example.myapplication.JoinSuccess.class);
                        intent .putExtra("joinname",mjointhree.getText().toString().trim());
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(this,"该房间不存在",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"请先输入房间名",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
