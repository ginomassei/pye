package com.probabilidad;

import java.lang.reflect.Array;

public class ListFrequences extends GroupDataStatistics {

    // Atributes.
    double[] data;
    double[] variables;
    double[] absoluteFrequency;
    double[] relativeFrequency;
    double variance;
    double mean;
    double median;
    double modalValue;
    double standardDeviation;
    double variationCoeficient;

    // Methods.
    double mean(double[] arr) {
        // Returns the mean value of a given data series based on the relative frequencies.
        int meanValue = 0;
        int n = Array.getLength(arr);

        for (int i = 0; i < n; i++) {
            meanValue += arr[i] * hi[i];
        }
        return meanValue;
    }

    double median(double[] arr) {
        return 0;
    }

    double modalValue(double[] arr) {
        return 0;
    }

    double[] absoluteFrequency(double[] var, double[] data) {
        int n = Array.getLength(var);
        double[] ni = new double[n];
        int j = 0;

        for (double i : var) {
            ni[j] = arrays.linearSearchInstances(data, i);
            j++;
        }
        return ni;
    }
}