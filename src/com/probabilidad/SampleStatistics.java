package com.probabilidad;

import java.lang.reflect.Array;

class SampleStatistics extends Statistics {
    MyArrays arrays = new MyArrays();

    double[] absoluteFrequence(double[] var, double[] obs) {
        int n = Array.getLength(var);
        double[] ni = new double[n];
        int j = 0;

        for (double i : var) {
            ni[j] = arrays.linearSearchInstances(obs, i);
            j++;
        }
        return ni;
    }

    double standardDeviation(double[] vec) {
        double var = variance(vec);
        return Math.sqrt(var);
    }

    double variance(double[] vec) {
        int n = Array.getLength(vec);
        double avg = mean(vec); // Obtengo la media de los datos.

        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - avg) * (vec[i] - avg);
        }
        return sqDiff / (n - 1);
    }

    double variationCoeficient(double[] vec) {
        double sd = standardDeviation(vec);
        double avg = mean(vec);
        return sd / avg;
    }

    double median(double[] vec) {
        int n = Array.getLength(vec);
        double medianEven;

        if (!arrays.sorted(vec)) {
            arrays.selectionSort(vec);
        }

        if (n % 2 != 0){
            int median = (n + 1) / 2;
            return vec[median];

        } else {
            double medianIndex = (double) (n + 1) / 2;
            medianEven = (vec[(int) medianIndex - 1] + vec[(int) medianIndex]) / 2;
        }
        return medianEven;
    }

    double modalValue(double[] vec) {
        if (!arrays.sorted(vec)) {
            arrays.selectionSort(vec);
        }
        Object[] max = arrays.getMax(vec);
        int index = (int) max[1];
        return vec[index];
    }
}