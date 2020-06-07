package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class MyTree extends View {
    public MyTree(Context context) {
        super(context);
    }
    public MyTree(Context context, AttributeSet attrs){
       super(context,attrs);
    }
    public MyTree(Context context,AttributeSet attrs,int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        paint.setAntiAlias(true);//采用抗锯齿功能
        paint.setColor(0xFFA4C739);//设置画笔颜色为绿色
        //绘制树苗顶端的三角形
        Path path=new Path();
        path.moveTo(120,150);
        path.lineTo(60,200);
        path.lineTo(180,200);
        path.close();
        canvas.drawPath(path,paint);
        //绘制第二层三角形
        Path path1=new Path();
        path1.moveTo(100,200);
        path1.lineTo(40,250);
        path1.lineTo(200,250);
        path1.lineTo(140,200);
        path1.close();
        canvas.drawPath(path1,paint);
        //绘制第三层三角形
        Path path2=new Path();
        path2.moveTo(100,250);
        path2.lineTo(20,300);
        path2.lineTo(220,300);
        path2.lineTo(140,250);
        path2.close();
        canvas.drawPath(path2,paint);
        //绘制树干
        paint.setColor(0xFF8F695F);
        paint.setStrokeWidth(10);
        canvas.drawLine(120,300,120,350,paint);
        //绘制文字
        paint.setTextSize(50);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("小树正在成长呦！",200,250,paint);
        super.onDraw(canvas);
    }
}
