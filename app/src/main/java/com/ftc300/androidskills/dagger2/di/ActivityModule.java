package com.ftc300.androidskills.dagger2.di;

import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 08/12/16.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
