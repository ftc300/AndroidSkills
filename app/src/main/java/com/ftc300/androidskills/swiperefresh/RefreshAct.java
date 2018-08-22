package com.ftc300.androidskills.swiperefresh;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.ftc300.androidskills.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RefreshAct extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_refresh);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_scroll, R.id.btn_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_scroll:
                getFragmentManager().beginTransaction().replace(R.id.framelayout, new RefreshScrollFrg()).commit();
                break;
            case R.id.btn_list:
                getFragmentManager().beginTransaction().replace(R.id.framelayout, new RefreshRecyclerFrg()).commit();
                break;
        }
    }
}
