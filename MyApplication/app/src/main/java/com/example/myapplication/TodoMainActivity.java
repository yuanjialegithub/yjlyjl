package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TodoMainActivity extends AppCompatActivity {

    DBService myDb;
    private Button mBtnAdd;
    private ListView note;
    private Button todoback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        //实例化自己创建的数据库类
        myDb = new DBService(this);
        //初始化函数
        init();

        todoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到主界面
                Intent i_back = new Intent(TodoMainActivity.this,PlanActivity.class);
                startActivity(i_back);
            }
        });
    }

    public void init(){

        mBtnAdd = findViewById(R.id.add);
        note = findViewById(R.id.note);
        //创建Values类型的list保存数据库中的数据
        List<Values> valuesList = new ArrayList<>();
        //获得可读SQLiteDatabase对象
        SQLiteDatabase db = myDb.getReadableDatabase();
        todoback = findViewById(R.id.todo_back);

        //查询数据库中的数据
        Cursor cursor = db.query(DBService.TABLE,null,null,
                null,null,null,null);
        if(cursor.moveToFirst()){
            Values values;
            while (!cursor.isAfterLast()){
                //实例化values对象
                values = new Values();

                //把数据库中的一个表中的数据赋值给values
                values.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex(DBService.ID))));
                values.setTitle(cursor.getString(cursor.getColumnIndex(DBService.TITLE)));

                //将values对象存入list对象数组中
                valuesList.add(values);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        //设置list组件adapter
        Object note_item;
        final MyBaseAdapter myBaseAdapter = new MyBaseAdapter(valuesList,this,R.layout.note_item);
        note.setAdapter(myBaseAdapter);

        //点击跳转到添加界面
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_add = new Intent(TodoMainActivity.this, com.example.myapplication.AddActivity.class);
                startActivity(intent_add);
            }
        });

        //单击查询
        note.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TodoMainActivity.this,ChangeActivity.class);
                Values values = (Values) note.getItemAtPosition(position);
                intent.putExtra(DBService.TITLE,values.getTitle().trim());
                intent.putExtra(DBService.ID,values.getId().toString().trim());
                startActivity(intent);
            }
        });


        //长按删除
        note.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final Values values = (Values) note.getItemAtPosition(position);
                new AlertDialog.Builder(TodoMainActivity.this)
                        .setTitle("提示框")
                        .setMessage("是否删除?")
                        .setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SQLiteDatabase db = myDb.getWritableDatabase();
                                        db.delete(DBService.TABLE,DBService.ID+"=?",new String[]{String.valueOf(values.getId())});
                                        db.close();
                                        myBaseAdapter.removeItem(position);
                                        note.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                myBaseAdapter.notifyDataSetChanged();
                                            }
                                        });

                                    }
                                })
                        .setNegativeButton("no",null).show();
                return true;
            }
        });
    }
    //创建继承自BaseAdapter的实现类进行ListView的展示
    class MyBaseAdapter extends BaseAdapter{

        private List<Values> valuesList;
        private Context context;
        private int layoutId;

        public MyBaseAdapter(List<Values> valuesList, Context context, int layoutId) {
            this.valuesList = valuesList;
            this.layoutId = layoutId;
        }

        @Override
        public int getCount() {
            if (valuesList != null && valuesList.size() > 0)
                return valuesList.size();
            else
                return 0;
        }

        @Override
        public Object getItem(int position) {
            if (valuesList != null && valuesList.size() > 0)
                return valuesList.get(position);
            else
                return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(
                        getApplicationContext()).inflate(R.layout.note_item, parent,
                        false);
                viewHolder = new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            String title = valuesList.get(position).getTitle();
            viewHolder.title.setText(title);
            return convertView;
        }
        public void removeItem(int position){
            this.valuesList.remove(position);
        }

    }
    class ViewHolder{
        TextView title;
    }
}


