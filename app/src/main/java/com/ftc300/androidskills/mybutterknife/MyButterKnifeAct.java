package com.ftc300.androidskills.mybutterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ftc300.androidskills.R;

/**
 * Created by chendong on 2018/8/27.
 */
@ContentView(R.layout.act_my_butterknife)
public class MyButterKnifeAct extends AppCompatActivity {

    @ViewInject(R.id.btn_click)
    private Button btn;

    @OnClick(R.id.btn_click)
    private void onClick(View v){
        btn.setText("have clicked");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtils.inject(this);
    }
}
