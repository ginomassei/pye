package com.probabilidad;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] obs = {};

        // Objects definition.
        MyArrays arrays = new MyArrays();
        Statistics statistics = new Statistics();

        arrays.selectionSort(obs);

        double[] var = arrays.searchOcurrences(obs);
        double[] absFreq = statistics.absoluteFrequence(var, obs);

        System.out.println(Arrays.toString(var));
        System.out.println(Arrays.toString(absFreq));

        double avg = statistics.mean(obs);
        System.out.println("Mean: " + avg);

        double sd = statistics.sampleStandardDeviation(obs);
        System.out.println("DS: " + sd);

        double variance = statistics.sampleVariance(obs);
        System.out.println("Variance: " + variance);

        double coefficient = statistics.sampleVariationCoeficient(obs);
        System.out.println("CV: " + (coefficient * 100));

        Object[] max = arrays.getMax(obs);
        System.out.println("Max: " + max[0]);

        double min = arrays.getMin(obs);
        System.out.println("Min: " + min);

        double median = statistics.sampleMedian(obs);
        System.out.println("Median: " + median);

        double modal = statistics.sampleModalValue(obs);
        System.out.println("Valor modal: " + modal);
    }
}