package com.ftc300.androidskills.rxjava2.ui.compose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ftc300.androidskills.R;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class ComposeOperatorExampleActivity extends AppCompatActivity {

    private RxSchedulers schedulers = new RxSchedulers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_operator_example);

        /*
            Compose for reusable code.
         */
        Observable.just(1, 2, 3, 4, 5)
                .compose(schedulers.<Integer>applyObservableAsync())
                .subscribe(/* */);

        Flowable.just(1, 2, 3, 4, 5)
                .compose(schedulers.<Integer>applyFlowableAsysnc())
                .subscribe(/* */);

    }
}
