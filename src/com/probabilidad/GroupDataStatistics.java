package com.probabilidad;
import java.lang.reflect.Array;

abstract class GroupDataStatistics extends Statistics {
    double variance(double[] arr) {
        int n = Array.getLength(arr);
        double avg = mean(arr); // Obtengo la media de los datos.
        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (arr[i] - avg) * (arr[i] - avg);
        }
        return sqDiff / n;
    }

    double standardDeviation(double[] arr) {
        double var = variance(arr);
        return Math.sqrt(var);
    }

    double variationCoeficient(double[] arr) {
        double sd = standardDeviation(arr);
        double avg = mean(arr);
        return sd / avg;
    }

    // Abstract methods definition.
    abstract double median(double[] arr);
    abstract double modalValue(double[] arr);
}