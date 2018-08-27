package com.ftc300.androidskills;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ftc300.androidskills.autoadaptive.AutoRecyclerAct;
import com.ftc300.androidskills.concurrent.MyEventBus.FBus;
import com.ftc300.androidskills.concurrent.MyEventBus.MainBus;
import com.ftc300.androidskills.dagger2.Dagger2Act;
import com.ftc300.androidskills.mvp.MvpAct;
import com.ftc300.androidskills.mybutterknife.MyButterKnifeAct;
import com.ftc300.androidskills.rxjava2.ui.SelectionActivity;
import com.ftc300.androidskills.swipeback.SwipeMainAct;
import com.ftc300.androidskills.swiperefresh.RefreshAct;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    public static Lock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    public static ConcurrentMap<String,Object> concurrentMap = new ConcurrentHashMap<>();
    private MainBus mainBus = new MainBus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        Log.d(TAG,Looper.myLooper().toString());
        Boolean b = Looper.myLooper()==Looper.getMainLooper();
        Log.d(TAG, b.toString());
    }

    @OnClick({R.id.btn_mvp, R.id.btn_dagger2,R.id.btn_swipe,R.id.btn_auto ,R.id.btn_refresh,R.id.btn_rxjava2,R.id.btn_mybutterknife})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mvp:
                switchTo(MvpAct.class);
                FBus.getInstance().run(new FBus.IBusEvent() {
                                           @Override
                                           public void run(Object e) {
                                               mainBus = (MainBus) e;
                                               runOnUiThread(new Runnable() {
                                                   @Override
                                                   public void run() {
                                                       Toast.makeText(MainActivity.this, mainBus.name, Toast.LENGTH_LONG).show();
                                                   }
                                               });
                                           }
                                       },mainBus);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        lock.lock();
//                        try {
//                            condition.await();
//                            MainActivity.this.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    String hello = (String)concurrentMap.get("hello");
//                                    Toast.makeText(MainActivity.this, hello, Toast.LENGTH_LONG).show();
//                                }
//                            });
//
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        } finally {
//                            lock.unlock();
//                        }
//                    }
//                }).start();
                break;
            case R.id.btn_dagger2:
                switchTo(Dagger2Act.class);
                break;
            case R.id.btn_swipe:
                switchTo(SwipeMainAct.class);
                break;
            case R.id.btn_auto:
                switchTo(AutoRecyclerAct.class);
                break;
            case R.id.btn_refresh:
                switchTo(RefreshAct.class);
                break;
            case R.id.btn_rxjava2:
                switchTo(SelectionActivity.class);
                break;

            case R.id.btn_mybutterknife:
                switchTo(MyButterKnifeAct.class);
                break;
        }
    }

    private void switchTo(Class<?> cls){
        Intent i = new Intent(MainActivity.this,cls);
        startActivity(i);
    }
}
