package com.ftc300.androidskills.swipeback;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.ftc300.androidskills.R;
import com.ftc300.androidskills.swipeback.lib.SwipeBackActivity;
import com.ftc300.androidskills.swipeback.lib.SwipeBackLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SwipeListViewAct extends SwipeBackActivity {

    private ListView lv;

    private List<HashMap<String, String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_swipe_listview);
        initData();
        initView();
        setDragEdge(SwipeBackLayout.DragEdge.TOP);
    }

    private void initData() {
        data = new ArrayList<>();
        HashMap<String, String> map;
        for (int i = 0; i < 30; i++) {
            map = new HashMap<>();
            map.put("title", "Test" + i);
            data.add(map);
        }
    }

    private void initView() {
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                data, R.layout.item, new String[]{"title"},
                new int[]{R.id.tv_item});
        lv = (ListView) this.findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        data.get(position).get("title"), Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

}
