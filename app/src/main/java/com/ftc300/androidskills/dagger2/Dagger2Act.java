package com.ftc300.androidskills.dagger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ftc300.androidskills.App;
import com.ftc300.androidskills.R;
import com.ftc300.androidskills.dagger2.di.ActivityComponent;
import com.ftc300.androidskills.dagger2.di.ActivityModule;
import com.ftc300.androidskills.dagger2.di.DaggerActivityComponent;
import com.ftc300.androidskills.dagger2.provide.DataManager;
import com.ftc300.androidskills.dagger2.provide.User;

import javax.inject.Inject;

public class Dagger2Act extends AppCompatActivity {

    @Inject
    DataManager mDataManager;

    private ActivityComponent activityComponent;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(App.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dagger);

        getActivityComponent().inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mDataManager.getAccessToken();
        if(token != null){
            mTvAccessToken.setText(token);
        }
    }

    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }
}
