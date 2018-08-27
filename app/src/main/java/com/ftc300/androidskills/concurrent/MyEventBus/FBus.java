package com.ftc300.androidskills.concurrent.MyEventBus;


import android.util.Log;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chendong on 2018/8/23.
 */

public class FBus<T> {
    public static Lock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    public static ConcurrentMap<String,Object> concurrentMap = new ConcurrentHashMap<>();
    private String TAG = "@@@@@@@";
    private FBus() {
    }

    public static FBus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final FBus INSTANCE = new FBus();
    }

    public void post(T t){
        try{
            lock.lock();
            Log.d(TAG,t.getClass().getSimpleName());
            Log.d(TAG,t.toString());
            concurrentMap.put(t.getClass().getSimpleName(),t);
            condition.signal();
        }finally {
            lock.unlock();
        }
    }


    public void run(final IBusEvent event,final  T e){
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    condition.await();
                    Log.d(TAG,e.getClass().getSimpleName());
                    Log.d(TAG,concurrentMap.get(e.getClass().getSimpleName()).toString());
                    event.run((T)concurrentMap.get(e.getClass().getSimpleName()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    public interface  IBusEvent<T>{
        void run(T e);
    }

}
