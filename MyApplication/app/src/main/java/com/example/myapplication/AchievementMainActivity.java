package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.ImageListAdapter;
import com.example.myapplication.ImageListArray;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AchievementMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private List<ImageListArray> achieve = new ArrayList<>();
    int hours=24, contidays=8; //测试数据，需要提供学习的时间/小时，连续学习的天数
    String[] str = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
        addingData();//初始化数据
        ImageListAdapter imageListAdapter = new ImageListAdapter(com.example.myapplication.AchievementMainActivity.this,R.layout.tample, achieve);
        ListView  listView = (ListView)findViewById(R.id.ImageListView);
        listView.setAdapter(imageListAdapter);
        listView.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(com.example.myapplication.AchievementMainActivity.this);
        switch (position) {
            case  0: {
                builder.setTitle("戴上草帽");//设置标题
                builder.setIcon(R.drawable.caomao);
                builder.setMessage(str[position]);
                break;
            }
            case 1: {
                builder.setTitle("拿起铲子");//设置标题
                builder.setIcon(R.drawable.chanzi);
                builder.setMessage(str[position]);
                break;
            }
            case 2: {
                builder.setTitle("种下树苗");//设置标题
                builder.setIcon(R.drawable.penzai);
                builder.setMessage(str[position]);
                break;
            }
            case 3: {
                builder.setTitle("浇浇水");//设置标题
                builder.setIcon(R.drawable.shuidi);
                builder.setMessage(str[position]);
                break;
            }
            case 4: {
                builder.setTitle("植木成林");//设置标题
                builder.setIcon(R.drawable.shulin);
                builder.setMessage(str[position]);
                break;
            }
            case 5:{
                builder.setTitle("坚持七天");//设置标题
                builder.setIcon(R.drawable.rili7);
                builder.setMessage(str[position]);
                break;
            }
            case 6:{
                builder.setTitle("坚持十五天");//设置标题
                builder.setIcon(R.drawable.rili15);
                builder.setMessage(str[position]);
                break;
            }
            case 7:{
                builder.setTitle("坚持三十天");//设置标题
                builder.setIcon(R.drawable.rili15);
                builder.setMessage(str[position]);
                break;
            }
            default:{
                builder.setTitle("");
                builder.setIcon(R.drawable.shulin);
                builder.setMessage("出bug了诶，抱歉！");
            }
        }
        builder.setPositiveButton( "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText( MainActivity.this,"点击了确定按钮", Toast.LENGTH_SHORT).show();
            }
        } );
//        builder.setNegativeButton( "取消",new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText( MainActivity.this,"点击了取消按钮", Toast.LENGTH_SHORT).show();
//            }
//        } );
        AlertDialog dialog = builder.create();
        dialog.show();
//        String text = listView.getItemAtPosition( position )+"";
//        Toast.makeText( this,"posistion="+position+" text="+text,Toast.LENGTH_SHORT ).show();
    }
    public void addingData(){
        if(hours > 4){
            ImageListArray focustime1 = new ImageListArray("戴上草帽", "总专心时间达到4小时", R.drawable.caomao, R.drawable.jt3);
            achieve.add(focustime1);
            str[0] = "任务已完成！";
        }
        else {
            ImageListArray focustime1 = new ImageListArray("戴上草帽", "总专心时间达到4小时", R.drawable.caomao1, R.drawable.jt3);
            achieve.add(focustime1);
            str[0] = "任务还没有完成（"+hours+"/4),继续努力";
        }
        if(hours > 72) {
            ImageListArray focustime2 = new ImageListArray("拿起铲子", "总专心时间达3天", R.drawable.chanzi, R.drawable.jt3);
            achieve.add(focustime2);
            str[1] = "任务已完成！";
        }
        else{
            ImageListArray focustime2 = new ImageListArray("拿起铲子", "总专心时间达3天", R.drawable.chanzi1, R.drawable.jt3);
            achieve.add(focustime2);
            str[1] = "任务还没有完成（"+hours+"/72),继续努力";
        }
        if(hours > 148) {
            ImageListArray focustime3 = new ImageListArray("种下树苗", "总专心时间达7天", R.drawable.penzai, R.drawable.jt3);
            achieve.add(focustime3);
            str[2] = "任务已完成！";
        }
        else{
            ImageListArray focustime3 = new ImageListArray("种下树苗", "总专心时间达7天", R.drawable.penzai1, R.drawable.jt3);
            achieve.add(focustime3);
            str[2] = "任务还没有完成（"+hours+"/148),继续努力";
        }
        if(hours > 360) {
            ImageListArray focustiem4 = new ImageListArray("浇浇水", "总专心时间达15天", R.drawable.shuidi, R.drawable.jt3);
            achieve.add(focustiem4);
            str[3] = "任务已完成";
        }
        else{
            ImageListArray focustiem4 = new ImageListArray("浇浇水", "总专心时间达15天", R.drawable.shuidi1, R.drawable.jt3);
            achieve.add(focustiem4);
            str[3] = "任务还没有完成("+hours+"/360),继续努力";
        }
        if(hours > 720) {
            ImageListArray focustime5 = new ImageListArray("种木成林", "总专心时间达30天", R.drawable.shulin, R.drawable.jt3);
            achieve.add(focustime5);
            str[4] = "任务已完成！";
        }
        else{
            ImageListArray focustime5 = new ImageListArray("种木成林", "总专心时间达30天", R.drawable.shulin1, R.drawable.jt3);
            achieve.add(focustime5);
            str[4] = "任务还没有完成("+hours+"/720),继续努力";
        }
        if(contidays<7){
            ImageListArray cdays = new ImageListArray("坚持七天","连续3天种出健康的树",R.drawable.rili7,R.drawable.jt3);
            achieve.add(cdays);
            str[5] = "任务还没有完成（"+contidays+"/7)，继续努力";
        }
        else{
            ImageListArray cdays = new ImageListArray("坚持七天","连续3天种出健康的树",R.drawable.rili71,R.drawable.jt3);
            achieve.add(cdays);
            str[5] = "任务已完成";
        }
        if(contidays<15){
            ImageListArray cdays15 = new ImageListArray("坚持十五天","连续15天种出健康的树",R.drawable.rili151,R.drawable.jt3);
            achieve.add(cdays15);
            str[6] = "任务还没有完成（"+contidays+"/15)，继续努力";
        }
        else{
            ImageListArray cdays15 = new ImageListArray("坚持十五天","连续15天种出健康的树",R.drawable.rili15,R.drawable.jt3);
            achieve.add(cdays15);
            str[6] = "任务已完成";
        }
        if(contidays<30){
            ImageListArray cdays30 = new ImageListArray("坚持三十天","连续30天种出健康的树",R.drawable.rili301,R.drawable.jt3);
            achieve.add(cdays30);
            str[7] = "任务还没有完成（"+contidays+"/30)，继续努力";
        }
        else{
            ImageListArray cdays30 = new ImageListArray("坚持十五天","连续15天种出健康的树",R.drawable.rili30,R.drawable.jt3);
            achieve.add(cdays30);
            str[7] = "任务已完成";
        }
    }
}
