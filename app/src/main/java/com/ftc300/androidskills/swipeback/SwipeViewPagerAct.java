package com.ftc300.androidskills.swipeback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.ftc300.androidskills.R;
import com.ftc300.androidskills.swipeback.lib.SwipeBackActivity;
import com.ftc300.androidskills.swipeback.lib.SwipeBackLayout;

/**
 * Created by Eric on 15/2/27.
 */
public class SwipeViewPagerAct extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_swipe_viewpage);
        initViews();
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }

    private void initViews() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager_demo);
        FragmentAdp adapter = new FragmentAdp(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    class FragmentAdp extends FragmentPagerAdapter{

        public FragmentAdp(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return SwipeViewPageFrg.newInstance("1");
                case 1:
                    return SwipeViewPageFrg.newInstance("2");
                case 2:
                    return SwipeViewPageFrg.newInstance("3");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
