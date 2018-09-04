package inso.com.lib.mutilthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Comment:
 * AsyncTask的多线程任务是通过线程池实现的工作线程，在完成任务后利用Future的done回调来通知任务完成，
 * 并通过handler机制通知主线程去执行onPostExecute等回调函数。
 * Author: ftc300
 * Date: 2018/8/30
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public class AsyncTask______FuturetaskExample {
    public static void main(String[] args) {
        Task task = new Task();// 新建异步任务
        FutureTask<Integer> future = new FutureTask<Integer>(task) {
            // 异步任务执行完成，回调
            @Override
            protected void done() {
                try {
                    System.out.println("future.done():" + get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        // 创建线程池（使用了预定义的配置）
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(future);

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
        // 可以取消异步任务
        // future.cancel(true);

        try {
            // 阻塞，等待异步任务执行完毕-获取异步任务的返回值
            System.out.println("future.get():" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    // 异步任务
    static class Task implements Callable<Integer> {
        // 返回异步任务的执行结果
        @Override
        public Integer call() throws Exception {
            int i = 0;
            for (; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "_"
                            + i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
    }
}
