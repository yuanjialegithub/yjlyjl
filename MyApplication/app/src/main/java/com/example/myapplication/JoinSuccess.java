package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Validator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class JoinSuccess extends AppCompatActivity implements View.OnClickListener{
    private  TextView mjoinsuccess2;
    private  TextView mjoinsuccess4;
    private  TextView mjoinsuccess6;
    private TextView mjoinsuccess8;
    private DBOpenHelper mDBOpenHelpersss;
    private ImageView mjoinsuccessback;
    private Button mjoinsuccessbutton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_success);
        mDBOpenHelpersss = new DBOpenHelper(this);
        initView();
    }

        public void initView(){
            mjoinsuccess2 = findViewById(R.id.joinsuccess2);
            mjoinsuccess4 = findViewById(R.id.joinsuccess4);
            mjoinsuccess6 = findViewById(R.id.joinsuccsee6);
            mjoinsuccess8 = findViewById(R.id.joinsuccess8);
            mjoinsuccessback = findViewById(R.id.joinsuccess_back);
            mjoinsuccessbutton = findViewById(R.id.joinsuccessbutton);
            mjoinsuccessbutton.setOnClickListener(this);
            mjoinsuccessback.setOnClickListener(this);
        }


        public void onClick(View view){
            switch (view.getId()){
                case R.id.joinsuccess_back:
                    startActivity(new Intent(this,Myloginactivity.class));
                    finish();
                    break;
                case R.id.joinsuccessbutton:
                    String roomname = getIntent().getStringExtra("joinname");
                    ArrayList<com.example.myapplication.Users> data = mDBOpenHelpersss.getAllData();
                    for (int i=0; i < data.size(); i++) {
                        com.example.myapplication.Users users = data.get(i);
                        if (roomname.equals(users.getName())) {
                            int i1 = users.getNumber();
                            mDBOpenHelpersss.updata(i1+1);
                            mjoinsuccess2.setText(users.getName());
                            mjoinsuccess4.setText(users.getRoomNumber());
                            mjoinsuccess6.setText(users.getProduce());
                            mjoinsuccess8.setText(""+users.getNumber());
                        }

                    }
            }
    }
}
