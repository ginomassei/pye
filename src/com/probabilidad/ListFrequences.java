package com.probabilidad;

import java.lang.reflect.Array;

public class ListFrequences extends GroupDataStatistics {
    double mean(double[] arr) {
        // Returns the mean value of a given data series based on the relative frequencies.
        int meanValue = 0;
        int n = Array.getLength(arr);

        for (int i = 0; i < n; i++) {
            meanValue += arr[i] * hi[i];
        }
        return meanValue;
    }

    double median(double[] vec) {
        return 0;
    }

    double[] absoluteFrequency(double[] var, double[] obs) {
        int n = Array.getLength(var);
        double[] ni = new double[n];
        int j = 0;

        for (double i : var) {
            ni[j] = arrays.linearSearchInstances(obs, i);
            j++;
        }

        return ni;
    }


}
