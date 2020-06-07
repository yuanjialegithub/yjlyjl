package com.example.myapplication;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBOpenHelper extends SQLiteOpenHelper {
    /**
     * 声明一个AndroidSDK自带的数据库变量db
     */
    private SQLiteDatabase db;

    /**
     * 写一个这个类的构造函数，参数为上下文context，所谓上下文就是这个类所在包的路径
     * 指明上下文，数据库名，工厂默认空值，版本号默认从1开始
     * super(context,"db_test",null,1);
     * 把数据库设置成可写入状态，除非内存已满，那时候会自动设置为只读模式
     * db = getReadableDatabase();
     */
    public DBOpenHelper(Context context){
        super(context,"db_test",null,1);
        db = getReadableDatabase();
    }
    /**
     * 重写两个必须要重写的方法，因为class DBOpenHelper extends SQLiteOpenHelper
     * 而这两个方法是 abstract 类 SQLiteOpenHelper 中声明的 abstract 方法
     * 所以必须在子类 DBOpenHelper 中重写 abstract 方法
     * 想想也是，为啥规定这么死必须重写？
     * 因为，一个数据库表，首先是要被创建的，然后免不了是要进行增删改操作的
     * 所以就有onCreate()、onUpgrade()两个方法
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT)");
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS users("+"id INTEGER PRIMARY KEY ,"+
                "roomname varchar,"+"roomnumber varchar,"+"roomproduce vachar,"+"number integer)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
        onOpen(db);
    }
    /**
     * 接下来写自定义的增删改查方法
     * 这些方法，写在这里归写在这里，以后不一定都用
     * add()
     * delete()
     * update()
     * getAllData()
     */
    public void add1(String name,String password){
        db.execSQL("INSERT INTO user (name,password) VALUES(?,?)",new Object[]{name,password});
    }
    public void delete1(String name,String password){
        db.execSQL("DELETE FROM user WHERE name = AND password ="+name+password);
    }
    public void updata1(String password){
        db.execSQL("UPDATE user SET password = ?",new Object[]{password});
    }

    /**查询表user全部内容的方法
     * 我们查询出来的内容，需要有个容器存放，以供使用，
     * 定义了一个ArrayList类的list
     * 接下来就该从表中查询数据了，
     * 这里使用游标Cursor，这就是数据库的功底了，
     * 在Android中我就不细说了，因为我数据库功底也不是很厚，
     * 但我知道，如果需要用Cursor的话，第一个参数："表名"，中间5个：null，
     * 最后是查询出来内容的排序方式："name DESC"
     * 接下来写一个while循环，让游标从表头游到表尾
     * 在游的过程中把游出来的数据存放到list容器中
     */
    public ArrayList<com.example.myapplication.User> getAllData1(){

        ArrayList<com.example.myapplication.User> list = new ArrayList<com.example.myapplication.User>();
        Cursor cursor = db.query("user",null,null,null,null,null,"name DESC");
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new com.example.myapplication.User(name,password));
        }
        return list;
    }
    //增删查改
    public void add(String roomname,String roomnumber,String roomproduce,int number){
        db.execSQL("INSERT INTO users (roomname,roomnumber,roomproduce,number) VALUES(?,?,?,?)",new Object[]{roomname,roomnumber,roomproduce,number});
    }
    public void delete(String roomname,String roomnumber,String roomproduce,int number){
        db.execSQL("DELETE FROM users WHERE roomname = AND roomnumber = AND roomproduce = AND number="+roomname+roomnumber+roomproduce+number);
    }
    public void updata(int number){
        db.execSQL("UPDATE users SET number = ?",new Object[]{number});
    }
    public ArrayList<Users> getAllData(){
        ArrayList<com.example.myapplication.Users> list = new ArrayList<com.example.myapplication.Users>();
        Cursor cursor = db.query("users",null,null,null,null,null,"roomname DESC");
        while (cursor.moveToNext()){
            String roomname = cursor.getString(cursor.getColumnIndex("roomname"));
            String roomnumber = cursor.getString(cursor.getColumnIndex("roomnumber"));
            String roomproduce = cursor.getString(cursor.getColumnIndex("roomproduce"));
            int number = cursor.getInt(cursor.getColumnIndex("number"));
            list.add(new com.example.myapplication.Users(roomname,roomnumber,roomproduce,number));
        }
        return list;
    }
}
