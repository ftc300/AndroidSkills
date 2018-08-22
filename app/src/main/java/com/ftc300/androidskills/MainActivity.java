package com.ftc300.androidskills;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ftc300.androidskills.autoadaptive.AutoRecyclerAct;
import com.ftc300.androidskills.dagger2.Dagger2Act;
import com.ftc300.androidskills.mvp.MvpAct;
import com.ftc300.androidskills.swipeback.SwipeMainAct;
import com.ftc300.androidskills.swiperefresh.RefreshAct;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_mvp, R.id.btn_dagger2,R.id.btn_swipe,R.id.btn_auto ,R.id.btn_refresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mvp:
                switchTo(MvpAct.class);
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
        }
    }

    private void switchTo(Class<?> cls){
        Intent i = new Intent(MainActivity.this,cls);
        startActivity(i);
    }
}
