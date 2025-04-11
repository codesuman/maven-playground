package org.example.math.app;

import org.example.math.libs.MathUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int x = 10;
        int y = 5;

        System.out.println("Sum : " + MathUtils.add(x,y));
        System.out.println("Subtract : " + MathUtils.subtract(x,y));
        System.out.println("Product : " + MathUtils.multiply(x,y));
    }
}