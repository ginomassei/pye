package com.probabilidad;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] obs = {300, 300, 350, 350, 450, 450, 500, 500, 550, 560, 600, 600, 650, 700, 750, 750, 850, 850,
                900, 900, 950, 1000, 1000, 1000,
                1100, 1200, 1200, 1250, 1300, 1400, 1500, 1500, 1600, 1650, 1800, 1900, 2000, 2000, 2500 ,3000  };

        // Objects definition.
        MyArrays arrays = new MyArrays();
        IntervalFrequences Statistics = new IntervalFrequences(obs, 7);

        Object[] data = Statistics.getIntervals();
        System.out.println(Arrays.toString((double[]) data[0]));
        System.out.println(Arrays.toString((double[]) data[1]));
        System.out.println(Arrays.toString((double[]) data[2]));

        System.out.println(Arrays.toString(Statistics.getAbsoluteFrequency()));
        System.out.println(Arrays.toString(Statistics.getRelativeFrequency()));
        System.out.println(Arrays.toString(Statistics.getCumulativeAbsoluteFrequency()));
        System.out.println(Arrays.toString(Statistics.getCumulativeRelativeFrequency()));
    }
}