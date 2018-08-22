package com.ftc300.androidskills.mvp.base;

/**
 * Created by chendong on 2018/8/20.
 */

public class Presenter {
    private MvpView mvpView;
    private MvpModel mvpModel;

    public Presenter(final MvpView mvpView) {
        this.mvpView = mvpView;
        mvpModel = new MvpModel(new ModelCallback() {
            @Override
            public void onResult(Object object) {
                mvpView.updateView(object);
            }
        });
    }

    public void request4Data(){
        mvpModel.request4Data();
    }
}
