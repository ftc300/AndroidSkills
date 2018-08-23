package com.ftc300.androidskills;

import android.app.Application;
import android.content.Context;
import com.ftc300.androidskills.dagger2.di.ApplicationComponent;
import com.ftc300.androidskills.dagger2.di.ApplicationModule;
import com.ftc300.androidskills.dagger2.di.DaggerApplicationComponent;
import com.ftc300.androidskills.dagger2.provide.DataManager;
import com.ftc300.androidskills.rxjava2.model.Events;
import com.ftc300.androidskills.rxjava2.ui.rxbus.RxBus;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by chendong on 2018/8/20.
 */

public class App extends Application {
    protected ApplicationComponent  applicationComponent;
    private RxBus bus;
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
        bus = new RxBus();
    }

    public RxBus bus() {
        return bus;
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }

    public void sendAutoEvent() {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        bus.send(new Events.AutoEvent());
                    }
                });
    }

}
