package com.probabilidad;

import java.lang.reflect.Array;

public class SimpleDataSeriesStatistics extends Statistics {
    double mean(double[] vec) {
        // Returns the mean value of a given data series array.
        double sum = 0;
        int n = Array.getLength(vec);

        for (double i : vec) {
            sum += i;
        }
        return sum / n;
    }

    double median(double[] vec) {
        // Returns the median value of a data series array.
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

    double variance(double[] vec) {
        // Returns the variance value of a data series array.
        int n = Array.getLength(vec);
        double avg = mean(vec);

        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - avg) * (vec[i] - avg);
        }
        return sqDiff / (n - 1);
    }

    double modalValue(double[] vec) {
        if (!arrays.sorted(vec)) {
            arrays.selectionSort(vec);
        }
        Object[] max = arrays.getMax(vec);
        int index = (int) max[1];
        return vec[index];
    }

    double standardDeviation(double[] vec) {
        double var = variance(vec);
        return Math.sqrt(var);
    }

    double variationCoeficient(double[] vec) {
        double sd = standardDeviation(vec);
        double avg = mean(vec);
        return sd / avg;
    }
}
