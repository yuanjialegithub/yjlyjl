package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FocusActivity_login extends AppCompatActivity {
    Button mfbt1,mfbt2,mfbt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focuslogin);
        //mfbt1=findViewById(R.id.btnStop);
        mfbt2=findViewById(R.id.fbt_2);
        mfbt3=findViewById(R.id.fbt_3);//音乐

        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer1);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        //Button btnStop = (Button) findViewById(R.id.fbt_2);
        Button btnRest = (Button) findViewById(R.id.btnReset);//重置
        final Button btnPC=(Button) findViewById(R.id.btnPC);//暂停
        final EditText edtSetTime = (EditText) findViewById(R.id.setTimeEdit);

        RelativeLayout relativeLayout=findViewById(R.id.relativelayout);
        relativeLayout.addView(new MyTree(this));

        mfbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动和停止MusicService
                final Intent i=new Intent(FocusActivity_login.this,MusicService.class);
                if(MusicService.isplay==false){
                    startService(i);//启动Service
                }else{
                    stopService(i);//停止Service
                }

            }
        });

        mfbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickexit(view);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("--开始记时---");
                rangeTime=0;
                String ss = edtSetTime.getText().toString();
                if (!(ss.equals("") && ss != null)) {
                    startTime = Integer.parseInt(edtSetTime.getText().toString())*60;
                    System.out.println(startTime);
                }
// 设置开始计时时间
                chronometer.setBase(SystemClock.elapsedRealtime());
// 开始记时
                chronometer.start();
            }
        });

//暂停或继续计时
        btnPC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
// TODO 自动生成的方法存根
                if(!PAUSE)//暂停计时
                {
                    btnPC.setText("继续");
//从开始计时计时器运行的时间差。。。。。关键
                    FocusActivity_login.this.rangeTime=SystemClock.elapsedRealtime()-chronometer.getBase();
//Toast.makeText(MainActivity.this, "时间："+rangeTime, Toast.LENGTH_SHORT).show();
                    chronometer.stop();
                }
                else //继续计时
                {
                    btnPC.setText("暂停");
//设置计时器的基时间。。。。。关键
                    chronometer.setBase(SystemClock.elapsedRealtime()-rangeTime);
                    chronometer.start();
                }
                PAUSE=!PAUSE;
            }
        });




        /*btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// 停止
                chronometer.stop();
            }
        });*/
// 重置
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
// 如果开始计时到现在超过了startime秒
                if (SystemClock.elapsedRealtime()
                        - chronometer.getBase() > startTime * 1000) {
                    chronometer.stop();
// 给用户提示
                    showDialog();
                }
            }
        });
    }


    protected void showDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setIcon(R.drawable.head2);
        builder.setTitle("警告").setMessage("时间到")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }


    private int startTime = 0;
    private boolean PAUSE=false;
    private long rangeTime;

    public void onclickstop(View view) {//弹出对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_jishi);
        builder.setTitle("专注才能让树苗成长哦！");
        builder.setMessage("你确定要暂停吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FocusActivity_login.this, "已暂停", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(FocusActivity_login.this, "取消暂停", Toast.LENGTH_SHORT).show();
                arg0.dismiss();
            }
        });
        AlertDialog a = builder.create();
        a.show();
    }
    public void onclickexit(View view) {//弹出对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_jishi);
        builder.setTitle("专注才能让树苗成长哦！");
        builder.setMessage("你确定要退出吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog1, int which1) {
                Toast.makeText(FocusActivity_login.this, "退出", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
                Intent intent=new Intent(FocusActivity_login.this,MainActivity_login.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(FocusActivity_login.this, "取消退出", Toast.LENGTH_SHORT).show();
                arg0.dismiss();
            }
        });
        AlertDialog a = builder.create();
        a.show();
    }

}
