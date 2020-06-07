package com.example.myapplication;
//修改页面
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class ChangeActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnCancel;
    private EditText ChangeTitle;

    private Values value;
    DBService myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        init();
    }

    public void init() {
        myDb = new DBService(this);
        btnCancel = findViewById(R.id.change_cancel);
        btnSave = findViewById(R.id.change_save);
        ChangeTitle = findViewById(R.id.change_title);

        Intent intent = this.getIntent();
        if (intent != null) {
            value = new Values();

            value.setTitle(intent.getStringExtra(DBService.TITLE));
            value.setId(Integer.valueOf(intent.getStringExtra(DBService.ID)));

            ChangeTitle.setText(value.getTitle());
        }

        //按钮点击
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDb.getWritableDatabase();
                ContentValues values = new ContentValues();
                String title = ChangeTitle.getText().toString();


                values.put(DBService.TITLE,title);

                db.update(DBService.TABLE,values,DBService.ID+"=?",new String[]{value.getId().toString()});
                Toast.makeText(ChangeActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                db.close();
                Intent intent = new Intent(ChangeActivity.this, TodoMainActivity_login.class);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = ChangeTitle.getText().toString();
                new AlertDialog.Builder(ChangeActivity.this)
                        .setTitle("提示框")
                        .setMessage("是否保存当前内容?")
                        .setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SQLiteDatabase db = myDb.getWritableDatabase();
                                        ContentValues values = new ContentValues();
                                        values.put(DBService.TITLE,title);
                                        db.update(DBService.TABLE,values,DBService.ID+"=?",new String[]{value.getId().toString()});
                                        Toast.makeText(ChangeActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                                        db.close();
                                        Intent intent = new Intent(ChangeActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                })
                        .setNegativeButton("no",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(ChangeActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                }).show();
            }
        });
    }


}
