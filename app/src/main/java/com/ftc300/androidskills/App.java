package com.ftc300.androidskills;

import android.app.Application;
import android.content.Context;

import com.ftc300.androidskills.dagger2.di.ApplicationComponent;
import com.ftc300.androidskills.dagger2.di.ApplicationModule;
import com.ftc300.androidskills.dagger2.di.DaggerApplicationComponent;
import com.ftc300.androidskills.dagger2.provide.DataManager;
import com.ftc300.androidskills.dagger2.provide.DbHelper;
import com.ftc300.androidskills.dagger2.provide.SharedPrefsHelper;

import javax.inject.Inject;

/**
 * Created by chendong on 2018/8/20.
 */

public class App extends Application {
    protected ApplicationComponent  applicationComponent;

    @Inject
    DataManager dataManager;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
