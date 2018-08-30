package com.inso.async;

/**
 * Comment:
 * 简单的安全异步任务，仅仅指定返回结果的类型，不可输入参数
 * Author: ftc300
 * Date: 2018/8/30
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public abstract class SimpleSafeTask<T> extends SafeTask<Object, Object, T> {
    protected abstract T doInBackgroundSafely() throws Exception;

    //@Override
    //protected void onPreExecuteSafely() throws Exception {}

    @Override
    protected final T doInBackgroundSafely(Object... params) throws Exception {
        return doInBackgroundSafely();
    }

    //@Override
    //protected void onPostExecuteSafely(T result, Exception e) throws Exception {}
}
