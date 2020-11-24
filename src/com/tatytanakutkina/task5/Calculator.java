package com.tatytanakutkina.task5;

import java.io.FileWriter;
import java.util.Arrays;


public class Calculator {

    public static void main(String[] args) {
        long timeMillis = 1000000;
        int size = 4;
        ThreadFactory factory = new ThreadFactory();
        ResourcePool<Thread> threadPool = new ResourcePool<>(size, factory, timeMillis);
        ResourcePool<FileWriter> filePool = new ResourcePool<>(size, new FileFactory(), timeMillis);

        double[] a = new double[10000];
        double[] b = new double[10000];
        double[] c = new double[10000];


        for (int i = 0; i < 10000; i++) {
            a[i] = Math.random() * 1000;
            b[i] = Math.random() * 1000;
            c[i] = Math.random() * 1000;
        }

        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {

            double[] aNew = Arrays.copyOfRange(a, i * 10000 / size, (i + 1) * 10000 / size);
            double[] bNew = Arrays.copyOfRange(b, i * 10000 / size, (i + 1) * 10000 / size);
            double[] cNew = Arrays.copyOfRange(c, i * 10000 / size, (i + 1) * 10000 / size);

            Solver solver = new Solver(aNew, bNew, cNew, filePool);
            threads[i] = new Thread(solver);
            threads[i].start();
        }

    }

}
