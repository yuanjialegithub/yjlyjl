package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WelComeActivity extends AppCompatActivity {
    private RelativeLayout mwelcome;
    private TextView mtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        mwelcome=findViewById(R.id.welcome);
        mtx=findViewById(R.id.tv_focus);

        AlphaAnimation anim=new AlphaAnimation(0.2f,1);
        anim.setDuration(3000);
        mwelcome.startAnimation(anim);

        ScaleAnimation ascale=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ascale.setDuration(3000);
        ascale.setFillAfter(true);

        RotateAnimation arotate=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        arotate.setDuration(3000);
        arotate.setFillAfter(true);

        AnimationSet as=new AnimationSet(true);
        as.addAnimation(arotate);
        as.addAnimation(ascale);
        as.addAnimation(anim);

        mwelcome.startAnimation(as);

        as.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(WelComeActivity.this,MainActivity.class));
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
