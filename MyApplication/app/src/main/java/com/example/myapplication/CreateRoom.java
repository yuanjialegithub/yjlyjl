package com.example.myapplication;
/*创建自习室
*每建一个自习室都要在表users中增加一条数据
* 房间号是当前系统时间string输出，这样不会有重复
 */
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateRoom extends AppCompatActivity implements View.OnClickListener {
    private com.example.myapplication.DBOpenHelper mDBOpenHelpers;
    private ImageView mcreateback;
    private LinearLayout mcreateone;
    private EditText mcreatethree;
    private EditText mcreatesix;
    private RelativeLayout mcreatetop;
    private Button mcreatefive;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        initView();
        mDBOpenHelpers = new com.example.myapplication.DBOpenHelper(this);
    }



    public void initView(){
        mcreateback = findViewById(R.id.create_back);
        mcreateone = findViewById(R.id.createone);
        mcreatethree = findViewById(R.id.createthree);
        mcreatesix = findViewById(R.id.cretesix);
        mcreatetop = findViewById(R.id.create_top);
        mcreatefive = findViewById(R.id.createfive);
        //点击事件，箭头返回主页面，创建房间按钮
        mcreateback.setOnClickListener(this);
        mcreatefive.setOnClickListener(this);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.create_back:  //返回主页面
                startActivity(new Intent(this,Myloginactivity.class));
                finish();
                break;
            case R.id.createfive:
                //获取当前time字符串输出作为roomnumber
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");// HH:mm:ss//获取当前时间
                Date date = new Date(System.currentTimeMillis());
                String roomnumberq = simpleDateFormat.format(date);

                String roomnameq = mcreatethree.getText().toString().trim();
                String roomproduceq = mcreatesix.getText().toString().trim();
                if(!TextUtils.isEmpty(roomnameq)&&!TextUtils.isEmpty(roomproduceq)&&!TextUtils.isEmpty(roomnumberq)){
                    mDBOpenHelpers.add(roomnameq,roomnumberq,roomproduceq,'1');
                    Intent intent1 = new Intent(this, com.example.myapplication.CreateSuccess.class);
                    intent1.putExtra("name",mcreatethree.getText().toString().trim());
                    startActivity(intent1);
                    Toast.makeText(this,"创建成功",Toast.LENGTH_SHORT).show();


                    finish();
                }else{
                    Toast.makeText(this,"请完善信息",Toast.LENGTH_SHORT).show();
                }
               break;
        }
    }
}
