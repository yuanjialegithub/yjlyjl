package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SignDate extends LinearLayout {

    private TextView tvYear;//显示年月
    private com.example.myapplication.InnerGridView gvWeek;//显示星期几
    private com.example.myapplication.InnerGridView gvDate;//显示日历
    private AdapterDate adapterDate;

    public SignDate(Context context) {
        super(context);
        init();
    }

    public SignDate(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SignDate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        View view = View.inflate(getContext(),R.layout.layout_signdate,this);
        tvYear = view.findViewById(R.id.tvYear);
        gvWeek = view.findViewById(R.id.gvWeek);
        gvDate = view.findViewById(R.id.gvDate);
        tvYear.setText(DateUtil.getCurrentYearAndMonth());
        gvWeek.setAdapter(new com.example.myapplication.AdapterWeek(getContext()));
        adapterDate = new AdapterDate(getContext());
        gvDate.setAdapter(adapterDate);
    }

    /**
     * 签到成功的回调
     * @param onSignedSuccess
     */
    public void setOnSignedSuccess(com.example.myapplication.OnSignedSuccess onSignedSuccess){
        adapterDate.setOnSignedSuccess(onSignedSuccess);
    }
}