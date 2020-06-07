package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class TimebarchartMainActivity extends AppCompatActivity implements View.OnClickListener{
    //测试数据
    private String[] types1 = {"周一","周二","周三","周四","周五","周六","周日"};
    private  String[] types = types1;
    private  float[] values = {9.6f,6.4f,5.4f,7.5f,6.8f,7.5f,8.6f};//test用的数据。若要整合，得同步values的值
    private  int sumCount = 10,sumCountMonth = 500,sumCountYear = 1500;
    private  float[] monthTime = {9.6f,6.4f,5.4f,7.5f,6.8f,7.5f,8.6f,9.6f,6.4f,5.4f,7.5f,6.8f,7.5f,8.6f,9.6f,6.4f,5.4f,7.5f,6.8f,7.5f,8.6f,
            9.6f,6.4f,5.4f,7.5f,6.8f,7.5f,8.6f,5.6f,7.8f};
    private String[] monthTypes = {"6月1日","6月2日","6月3日","6月4日","6月5日","6月6日","6月7日","6月8日","6月9日","6月10日",
            "6月11日","6月12日","6月13日","6月14日","6月15日","6月16日","6月17日","6月18日","6月19日","6月20日",
            "6月21日","6月22日","6月23日","6月24日","6月25日","6月26日","6月27日","6月28日","6月29日","6月30日"};
    private float[] yearTime = {45f,57f,89f,99f,56.7f,58.6f,55.4f,150f,566f,589.4f,213.5f,211.8f};
    private String[] yearTypes = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timebarchart);
        float sum = 0f;
        for (float value : values) {
            sum += value;
        }
        weekTimeBar(sum,types1,values,sumCount);
        Button week = findViewById(R.id.button);
        week.setBackgroundResource(R.drawable.left_shape_press);
        Button month = findViewById(R.id.button2);
        Button year = findViewById(R.id.button3);
        week.setOnClickListener(this);
        month.setOnClickListener(this);
        year.setOnClickListener(this);
    }

    private  void weekTimeBar(float sum,String[] typeS,float[] yValues,int sumcount){

            TextView text1 = findViewById(R.id.sumTime);
            int minute = (int)(60 * (sum-(int)sum));
            String text = "总时长："+(int)sum+"时"+minute+"分";
            text1.setText(text);
            String count = sumcount+"个";
            TextView text2 = findViewById(R.id.sumCount);
            text2.setText(count);
            BarChart mChart = findViewById(R.id.bar_chart);
            initBarChart(mChart);
            setBarChartData(typeS.length,mChart,yValues);
        }

    private void initBarChart(BarChart mBarChart){
        mBarChart.setBackgroundColor(Color.WHITE);
        mBarChart.setDrawGridBackground(false);//是否需要有网格
        mBarChart.getDescription().setEnabled(false);//描述
        mBarChart.setDrawBarShadow(false);//背景阴影
        mBarChart.setDrawBorders(false);//是否显示边界
        //设置动画效果
        mBarChart.animateY(1000, Easing.EasingOption.Linear);
        mBarChart.animateX(1000,Easing.EasingOption.Linear);

        //折线图例 标签 设置
        Legend l = mBarChart.getLegend();
        l.setEnabled(false);

        YAxis leftAxis = mBarChart.getAxisLeft();
        YAxis rightAxis = mBarChart.getAxisRight();
        leftAxis.setAxisMinimum(0f);//设置x,y的最小值
        rightAxis.setAxisMinimum(0f);
        leftAxis.setEnabled(false);
        rightAxis.setEnabled(false);

        XAxis xAxis = mBarChart.getXAxis();

        //XY轴设置
        //X轴设置显示位置在底部
        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(0xffe0e0e0);

        xAxis.setValueFormatter(new IAxisValueFormatter(){
           @Override
           public String getFormattedValue(float value, AxisBase axis){
               int idx = (int) value;
               return types[idx];
           }
        });
    }
    private void setBarChartData(int count, BarChart mChart, final float[] value){
        ArrayList<BarEntry> yVals = new ArrayList<>();
        final float[] Value = value;
        int[] colors = new int[count];

        for (int i = 0;i<count;i++){
            float val = value[i];

            if(val > 0){
                colors[i] = 0xffF04933;
            }

            if(val < 0){
                colors[i] = 0xff2BBE53;
            }

            yVals.add(new BarEntry(i, Math.abs(val)));
        }

        BarDataSet mBarDataSet = new BarDataSet(yVals,"本周学习记录");
        mBarDataSet.setDrawIcons(false);
        mBarDataSet.setColors(colors);
        mBarDataSet.setValueTextColor(0xff74828F);
        mBarDataSet.setValueTextSize(12f);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(mBarDataSet);

        BarData mBarData = new BarData(dataSets);
        mBarData.setBarWidth(0.6f);

        mBarData.setValueFormatter(new IValueFormatter(){
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler){
                int idx = (int) entry.getX();
                return String.valueOf(Value[idx]);
            }
        });

        mChart.setData(mBarData);
    }

    @Override
    public void onClick(View v) {
        Button temp = findViewById(R.id.button);
        Button temp1 = findViewById(R.id.button2);
        Button temp2 = findViewById(R.id.button3);
        switch (v.getId()) {
            case R.id.button:{
                float sum = 0f;
                for (float value : values) {
                    sum += value;
                }
                temp.setBackgroundResource(R.drawable.left_shape_press);
                temp1.setBackgroundResource(R.drawable.middle_shape);
                temp2.setBackgroundResource(R.drawable.right_shape);
                weekTimeBar(sum,types1,values,sumCount);
                break;
            }
            case R.id.button2:{
                float sum = 0f;
                for (float value : monthTime) {
                    sum += value;
                }
                types = monthTypes;
                weekTimeBar(sum,monthTypes,monthTime,sumCountMonth);
                temp.setBackgroundResource(R.drawable.left_shape);
                temp1.setBackgroundResource(R.drawable.middle_shape_press);
                temp2.setBackgroundResource(R.drawable.right_shape);
                break;
            }
            case R.id.button3:{
                float sum = 0f;
                for (float value : yearTime) {
                    sum += value;
                }
                types  = yearTypes;
                weekTimeBar(sum,yearTypes,yearTime,sumCountYear);
                temp.setBackgroundResource(R.drawable.left_shape);
                temp1.setBackgroundResource(R.drawable.middle_shape);
                temp2.setBackgroundResource(R.drawable.right_shape_press);
                break;
            }
            default:break;
        }
    }
}
