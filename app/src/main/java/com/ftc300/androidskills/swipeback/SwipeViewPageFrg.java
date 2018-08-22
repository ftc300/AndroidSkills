package com.ftc300.androidskills.swipeback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ftc300.androidskills.R;

public class SwipeViewPageFrg extends Fragment {

    private static final String EXTRA_TITLE = "EXTRA_TITLE";

    public static SwipeViewPageFrg newInstance(String title) {
        SwipeViewPageFrg testFragment = new SwipeViewPageFrg();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TITLE, title);
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_viewpage, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        TextView tvTitle = (TextView) getView().findViewById(R.id.tv_item);

        Bundle bundle = getArguments();
        if (bundle.containsKey(EXTRA_TITLE)) {
            tvTitle.setText(bundle.getString(EXTRA_TITLE));
        }
    }

}
