package com.probabilidad;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] obs = {153, 134, 138, 137, 128, 123, 148, 138, 146, 127, 129, 125, 122, 138, 146, 132, 139,
                        146, 146, 144, 147, 146, 137, 140, 137, 138, 145, 151, 137, 128, 137, 148, 145, 129,
                        142, 134, 135, 124, 126, 141, 131, 152, 132, 117, 136, 147, 128, 138, 136, 138};

        // Objects definition.
        MyArrays arrays = new MyArrays();
        StatisticsTest statisticsTest = new StatisticsTest();

        arrays.selectionSort(obs);

        Object[] object = statisticsTest.intervalMaker(obs, 5);
        double[] intervalsBottom = (double[]) object[0];
        double[] intervalsTop = (double[]) object[1];
        double[] classMarks = (double[]) object[2];
        double[] classes = (double[]) object[3];

        System.out.println(Arrays.toString(intervalsBottom));
        System.out.println(Arrays.toString(intervalsTop));
        System.out.println(Arrays.toString(classMarks));
        System.out.println(Arrays.toString(classes));

        double[] ni = statisticsTest.populationAbsoluteFrequence(intervalsBottom, intervalsTop, obs);
        System.out.println(Arrays.toString(ni));

        double[] hi = statisticsTest.relativeFrequence(ni);
        System.out.println(Arrays.toString(hi));

        double[] cf = statisticsTest.cumulativeFrequence(ni);
        System.out.println(Arrays.toString(cf));

//        double avg = statistics.mean(obs);
//        System.out.println("Mean: " + avg);
//
//        double sd = statistics.sampleStandardDeviation(obs);
//        System.out.println("DS: " + sd);
//
//        double variance = statistics.sampleVariance(obs);
//        System.out.println("Variance: " + variance);
//
//        double coefficient = statistics.sampleVariationCoeficient(obs);
//        System.out.println("CV: " + (coefficient * 100));
//
//        Object[] max = arrays.getMax(obs);
//        System.out.println("Max: " + max[0]);
//
//        double min = arrays.getMin(obs);
//        System.out.println("Min: " + min);
//
//        double median = statistics.sampleMedian(obs);
//        System.out.println("Median: " + median);
//
//        double modal = statistics.sampleModalValue(obs);
//        System.out.println("Valor modal: " + modal);


//        double[] absoluteFrequency(double[] var, double[] obs) {
//            int n = Array.getLength(var);
//            double[] ni = new double[n];
//            int j = 0;
//
//            for (double i : var) {
//                ni[j] = arrays.linearSearchInstances(obs, i);
//                j++;
//            }
//            return ni;
//        }
    }
}