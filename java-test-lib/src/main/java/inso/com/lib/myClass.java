package inso.com.lib;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class myClass {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int s = list.removeFirst();
        System.out.println("" + s);
        long t = 1;
        TimeUnit unit = TimeUnit.SECONDS;
        long t1 = unit.toMillis(t);
        System.out.println("" + t1);

    }
}
