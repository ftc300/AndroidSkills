package com.ftc300.androidskills.rxjava2.ui.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ftc300.androidskills.App;
import com.ftc300.androidskills.R;
import com.ftc300.androidskills.rxjava2.model.Events;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amitshekhar on 06/02/17.
 */

public class RxBusActivity extends AppCompatActivity {

    public static final String TAG = RxBusActivity.class.getSimpleName();
    TextView textView;
    Button button;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear(); // do not send event after activity has been destroyed
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxbus);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        disposables.add(((App) getApplication())
                .bus()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Exception {
                        if (object instanceof Events.AutoEvent) {
                            textView.setText("Auto Bus Received");
                        } else if (object instanceof Events.TapEvent) {
                            textView.setText("Tap Bus Received");
                        }
                    }
                }));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App) getApplication())
                        .bus()
                        .send(new Events.TapEvent());
            }
        });
    }



}
