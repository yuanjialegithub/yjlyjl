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

import com.example.myapplication.R;
import com.example.myapplication.CreateRoom;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreateSuccess extends AppCompatActivity implements View.OnClickListener{
    private  TextView msuccessroomname ;
    private  TextView msuccessroomnumber ;
    private  TextView msuccessroomproduce ;
    private com.example.myapplication.DBOpenHelper mDBOpenHelperss;
    private ImageView mcreatesuccessback;
    private Button mcreatesuccessbutton;
    private TextView msuccessnumber2;
    //private int count = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_success);
        mDBOpenHelperss = new com.example.myapplication.DBOpenHelper(this);

        initView();
    }
        public void initView(){
            msuccessroomname = findViewById(R.id.successroomname2);
            msuccessroomnumber = findViewById(R.id.successroomnumber2);
            msuccessroomproduce = findViewById(R.id.successroomproduce2);
            mcreatesuccessback = findViewById(R.id.createsuccess_back);
            mcreatesuccessbutton = findViewById(R.id.createsucccessbutton);
            msuccessnumber2 = findViewById(R.id.successnumber2);
            mcreatesuccessback.setOnClickListener(this);
            mcreatesuccessbutton.setOnClickListener(this);
        }


        public void onClick(View view){
            switch (view.getId()){
                case R.id.createsuccess_back:
                    startActivity(new Intent(this,Myloginactivity.class));
                    finish();
                    break;
                case R.id.createsucccessbutton:
                    String roomname = getIntent().getStringExtra("name");
                    ArrayList<com.example.myapplication.Users> data = mDBOpenHelperss.getAllData();
                    for (int i=0; i < data.size(); i++) {
                        com.example.myapplication.Users users = data.get(i);
                        if (roomname.equals(users.getName())) {
                            msuccessroomname.setText(users.getName());
                            msuccessroomnumber.setText(users.getRoomNumber());
                            msuccessroomproduce.setText(users.getProduce());
                            msuccessnumber2.setText("1");

                        }
                    }

        }

    }
}
