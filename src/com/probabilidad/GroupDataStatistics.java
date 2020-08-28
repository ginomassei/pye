package com.probabilidad;
import java.lang.reflect.Array;

abstract class GroupDataStatistics extends Statistics {
    double setVariance(double[] arr) {
        int n = Array.getLength(arr);
        double avg = setMean(arr); // Obtengo la media de los datos.
        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (arr[i] - avg) * (arr[i] - avg);
        }
        return sqDiff / n;
    }

    double setStandardDeviation(double variance) {
        return Math.sqrt(variance);
    }

    double setVariationCoeficient(double standardDeviation, double mean) {
        return standardDeviation / mean;
    }

    // Abstract methods definition.
    abstract double setMedian(double[] arr);
    abstract double setModalValue(double[] arr);
}