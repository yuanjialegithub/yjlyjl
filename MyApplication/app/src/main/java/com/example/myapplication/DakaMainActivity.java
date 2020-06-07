package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class DakaMainActivity extends Activity {

    private com.example.myapplication.SignDate signDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dakacal);
        signDate = findViewById(R.id.signDate);
        signDate.setOnSignedSuccess(new com.example.myapplication.OnSignedSuccess() {
            @Override
            public void OnSignedSuccess() {
                Log.e("wqf", "Success");
            }
        });
    }
}