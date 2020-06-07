package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    static boolean isplay;//记录当前播放状态
    MediaPlayer player;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        //创建MediaPlayer对象，加载播放的音频文件
        player=MediaPlayer.create(this,R.raw.piano);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!player.isPlaying()){
            player.start();
            isplay=player.isPlaying();
            player.setLooping(true);//背景音乐循环播放
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        isplay=player.isPlaying();
        player.release();
        super.onDestroy();
    }
}
