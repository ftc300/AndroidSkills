package inso.com.lib.mutilthread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Comment:
 * Author: ftc300
 * Date: 2018/9/4
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public class Producer_Consumer2 {
    static class Producer implements Runnable{
        private  LinkedBlockingQueue queue;
        private AtomicInteger i = new AtomicInteger(1);
        public Producer(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("produce:" + i.get() );
                    queue.put(i.getAndIncrement());
                }
            } catch (Exception e){

            }
        }
    }

    static class Consumer implements Runnable{
        private  LinkedBlockingQueue queue;

        public Consumer(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Consume" +Thread.currentThread().getId() +":" + queue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        LinkedBlockingQueue q = new LinkedBlockingQueue(4);
        Producer p = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2= new Consumer(q);
        Consumer c3 = new Consumer(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
    }

}
