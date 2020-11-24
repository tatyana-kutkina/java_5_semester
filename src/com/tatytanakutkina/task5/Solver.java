package com.tatytanakutkina.task5;

import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Solver implements Runnable {
    double[] a, b, c;
    ResourcePool<FileWriter> filePool;

    Solver(double[] a, double[] b, double[] c, ResourcePool<FileWriter> filePool) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.filePool = filePool;
    }

    @Override
    public void run() {

        try (FileWriter writer = filePool.getObject()) {
            for (int i = 0; i < a.length; i++) {
                String res = findRoots(a[i], b[i], c[i]);
                writer.write(res);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    static String findRoots(double a, double b, double c) {
        if (a == 0) {
            double x1 = -c / b;
            return String.format("%f" + '\n', x1);
        }

        double d = b * b - 4 * a * c;
        double sqrt_val = sqrt(abs(d));

        if (d > 0) {
            double x1 = (-b + sqrt_val) / (2 * a);
            double x2 = (-b - sqrt_val) / (2 * a);
            return String.format("%f, %f" + '\n', x1, x2);
        } else if (d == 0) {
            double x1 = -(double) b / (2 * a);
            return String.format("%f" + '\n', x1);
        } else {
            return "D<0" + '\n';
        }
    }
}
