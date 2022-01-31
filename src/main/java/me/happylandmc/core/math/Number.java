package me.happylandmc.core.math;

public class Number {
    public static int getRandom(int start, int end) {
        return (int)(Math.random() * (end - start + 1) + start);
    }
}
