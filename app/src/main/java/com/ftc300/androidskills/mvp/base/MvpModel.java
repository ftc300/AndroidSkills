package com.ftc300.androidskills.mvp.base;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

/**
 * Created by chendong on 2018/8/20.
 */

public class MvpModel {
    private ModelCallback callback;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            callback.onResult(msg.obj);
        }
    };

    public MvpModel(ModelCallback callback) {
        this.callback = callback;
    }

    public void request4Data(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Bean bean = new Bean(1,"hello");
                    Message m = Message.obtain();
                    m.obj = bean;
                    handler.sendMessage(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
