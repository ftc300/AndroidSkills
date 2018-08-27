package com.ftc300.androidskills.concurrent.MyEventBus;

/**
 * Created by chendong on 2018/8/23.
 */

public class MainBus extends Bus{
    public String name;

    public MainBus() {
    }

    public MainBus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MainBus{" +
                "name='" + name + '\'' +
                '}';
    }
}
