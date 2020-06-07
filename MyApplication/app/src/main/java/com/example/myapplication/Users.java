package com.example.myapplication;


public class Users {
    private String roomname;            //房间名
    private String roomnumber;          //房间号
    private String roomproduce;         //房间介绍
    private int number;    //房间人数

    public Users(String roomname, String roomnumber, String roomproduce, int number) {
        this.roomname = roomname;
        this.roomnumber = roomnumber;
        this.roomproduce = roomproduce;
        this.number = number;
    }
    public String getName() {
        return roomname;
    }
    public void setName(String roomname) {
        this.roomname = roomname;
    }
    public String getRoomNumber() {
        return roomnumber;
    }
    public void setRoomNumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }
    public String getProduce(){return roomproduce;}
    public void setRoomproduce(String roomproduce){this.roomproduce = roomproduce;}
    public int getNumber(){return number;}
    public void setNumber(int number){this.number = number;}
    @Override
    public String toString() {
        return "Users{" +
                "roomname='" + roomname + '\'' +
                ", roomnumber='" + roomnumber + '\'' +
                ", roomproduce='" + roomproduce + '\'' +
                ",number='"+number+'\''+
                '}';
    }
}

