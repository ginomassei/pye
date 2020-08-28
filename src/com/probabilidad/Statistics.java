package com.probabilidad;
import java.lang.reflect.Array;

/**
 * This class implements statisticals operations
 * */

abstract class Statistics {
    // Implements the array class.
    MyArrays arrays = new MyArrays();
    // Method definitions.
    double[] relativeFrequency(double[] ni) {
        // Calculates the relative frequency of a given absolute frequency array.
        // Retunrs an array with the relative frequency.
        int n = Array.getLength(ni);
        double[] hi = new double[n];
        int ac = 0;

        for (int i = 0; i < n; i++) {
            ac += ni[i];
        }
        for (int i = 0; i < n; i++) {
            hi[i] = ni[i] / ac;
        }
        return hi;
    }

    double[] cumulativeFrequency(double[] vec) {
        // Returns the cumulative frequency of a given array.
        int n = Array.getLength(vec);
        double[] cf = new double[n];

        for (int i = 0; i < n; i++) {
            if (i == 0){
                cf[i] = vec[i] + cf[i];
            } else {
                cf[i] = vec[i] + cf[i - 1];
            }
        }
        return cf;
    }

    // Abstract methods definitions.
    abstract double mean(double[] arr);
    abstract double median(double[] arr);
    abstract double variance(double[] vec);
    abstract double modalValue(double[] vec);
    abstract double standardDeviation(double[] vec);
    abstract double variationCoeficient(double[] vec);
}
