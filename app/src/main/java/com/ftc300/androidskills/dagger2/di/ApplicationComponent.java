package com.ftc300.androidskills.dagger2.di;

import android.app.Application;
import android.content.Context;

import com.ftc300.androidskills.App;
import com.ftc300.androidskills.dagger2.provide.DataManager;
import com.ftc300.androidskills.dagger2.provide.DbHelper;
import com.ftc300.androidskills.dagger2.provide.SharedPrefsHelper;

import javax.inject.Singleton;
import dagger.Component;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject( App demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
