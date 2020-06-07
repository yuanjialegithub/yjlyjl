package com.example.myapplication;
//添加页面
import android.content.Intent;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    DBService myDb;
    private Button btnBack;
    private Button btnFinish;
    private EditText titleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();
    }

    private void init() {

        myDb = new DBService(this);
        SQLiteDatabase db = myDb.getReadableDatabase();
        titleEditText = findViewById(R.id.title);
        btnBack = findViewById(R.id.back);
        btnFinish = findViewById(R.id.finish);

        //返回列表页面
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, TodoMainActivity_login.class);
                startActivity(intent);
            }
        });
        //添加待办
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = myDb.getWritableDatabase();
                ContentValues values = new ContentValues();

                String title= titleEditText.getText().toString();

                if("".equals(titleEditText.getText().toString())){
                    Toast.makeText(AddActivity.this,"标题不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                values.put(DBService.TITLE,title);
                db.insert(DBService.TABLE,null,values);
                Toast.makeText(AddActivity.this,"保存成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddActivity.this, TodoMainActivity_login.class);
                startActivity(intent);
                db.close();
            }
        });
    }


}
