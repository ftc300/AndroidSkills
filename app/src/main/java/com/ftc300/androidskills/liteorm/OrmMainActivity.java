package com.ftc300.androidskills.liteorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ftc300.androidskills.R;

/**
 * 2015-9-4，金锁很紧张，紫薇抢食快，为我的鱼儿赋诗一首：紫非嫣然出清水，薇瞰浮游间其中。
 *
 * @author MaTianyu
 *         2014-2-25下午2:36:30
 */
public class OrmMainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_orm_main);
    }

    public void clickSingle(View view) {
        startActivity(new Intent(this, SingleTestActivity.class));
    }

    public void clickCascade(View view) {
        startActivity(new Intent(this, CascadeTestActivity.class));
    }
}
