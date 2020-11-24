package com.tatytanakutkina.task5;

public class ThreadFactory implements ObjectFactory<Thread> {

    @Override
    public Thread createNew() {
        return new Thread();
    }

}
