package com.probabilidad;

import java.lang.reflect.Array;

abstract class Statistics {
    // None abstract methods.
    double[] relativeFrequence(double[] ni) {
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

    double[] cumulativeFrequence(double[] vec) {
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

    double mean(double[] vec) {
        double sum = 0;
        int n = Array.getLength(vec);

        for (double i : vec) {
            sum += i;
        }
        return sum / n;
    }

    // Abstract methods.
    abstract double standardDeviation(double[] vec);
    abstract double variance(double[] vec);
    abstract double variationCoeficient(double[] vec);
    abstract double median(double[] vec);
}
