package com.ftc300.androidskills.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.ftc300.androidskills.R;
import com.ftc300.androidskills.mvp.base.Bean;
import com.ftc300.androidskills.mvp.base.MvpView;
import com.ftc300.androidskills.mvp.base.Presenter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chendong on 2018/8/20.
 */

public class MvpAct extends AppCompatActivity implements MvpView {
    @BindView(R.id.tv_int)
    TextView tvInt;
    @BindView(R.id.tv_string)
    TextView tvString;
    private Presenter presenter;
    private Bean bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_mvp);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        presenter.request4Data();
    }

    @Override
    public void updateView(Object object) {
        bean = (Bean) object;
        tvInt.setText("" + bean.arg1);
        tvString.setText("" + bean.arg2);
    }
}
