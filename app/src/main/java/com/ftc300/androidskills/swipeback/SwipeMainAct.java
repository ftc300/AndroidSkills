package com.ftc300.androidskills.swipeback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ftc300.androidskills.MainActivity;
import com.ftc300.androidskills.R;
import com.ftc300.androidskills.swipeback.lib.SwipeBackActivity;
import com.ftc300.androidskills.swipeback.lib.SwipeBackLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chendong on 2018/8/21.
 */

public class SwipeMainAct extends SwipeBackActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_swipe_main);
        ButterKnife.bind(this);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }

    @OnClick({R.id.btn_webview, R.id.btn_list, R.id.btn_viewpage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_webview:
                switchTo(SwipeWebViewAct.class);
                break;
            case R.id.btn_list:
                switchTo(SwipeListViewAct.class);
                break;
            case R.id.btn_viewpage:
                switchTo(SwipeViewPagerAct.class);
                break;
        }
    }

    private void switchTo(Class<?> cls){
        Intent i = new Intent(SwipeMainAct.this,cls);
        startActivity(i);
    }
}
