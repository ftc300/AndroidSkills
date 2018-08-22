package com.ftc300.androidskills.dagger2.di;


import com.ftc300.androidskills.dagger2.Dagger2Act;

import dagger.Component;

/**
 * Created by janisharali on 08/12/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(Dagger2Act mainActivity);
}
