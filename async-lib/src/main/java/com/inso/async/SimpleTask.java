package com.inso.async;

/**
 * Comment:
 * 简单的异步任务，仅仅指定返回结果的类型，不可输入参数
 * Author: ftc300
 * Date: 2018/8/30
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public abstract class SimpleTask<T> extends AsyncTask<Object, Object, T> {

	@Override
	protected T doInBackground(Object... params) {
		return doInBackground();
	}

	protected abstract T doInBackground();
}
