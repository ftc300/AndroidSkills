package com.ftc300.androidskills.autoadaptive;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ftc300.androidskills.R;

public class AutoRecyclerAct extends AppCompatActivity {
	RecyclerView recyclerView;
	MyAdapter adapter;
	String[] datas = {
			"ceshi","Test" ,"窗前明月光，下句是啥"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_auto_recycler);
		AutoUtils.auto(this);
		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setAdapter(adapter = new MyAdapter());
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

		@Override
		public int getItemCount() {
			return datas.length;
		}

		@Override
		public void onBindViewHolder(MyViewHolder holder, int position) {
			holder.tv_item.setText(datas[position]);
		}

		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = View.inflate(AutoRecyclerAct.this, R.layout.item, null);
			MyViewHolder viewHolder = new MyViewHolder(view);
			return viewHolder;
		}

		class MyViewHolder extends RecyclerView.ViewHolder {
			public View view;
			public TextView tv_item;

			public MyViewHolder(View view) {
				super(view);
				this.view = view;
				tv_item = (TextView) view.findViewById(R.id.tv_item);
				AutoUtils.auto(view);
			}
		}

	}

}
