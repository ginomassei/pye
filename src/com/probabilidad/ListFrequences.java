package com.probabilidad;

import java.lang.reflect.Array;

public class ListFrequences extends GroupDataStatistics {

    // Atributes.
    double[] absoluteFrequency;
    double[] relativeFrequency;
    double variance;
    double mean;
    double median;
    double modalValue;
    double standardDeviation;
    double variationCoeficient;

    // Construct.
    ListFrequences(double[] data, double[] variables) {
        this.absoluteFrequency = setAbsoluteFrequency(variables, data);
        this.relativeFrequency = setRelativeFrequency(absoluteFrequency);
        this.variance = setVariance(data);
        this.mean = setMean(data);
        this.median = setMedian(data);
        this.modalValue = setModalValue(data);
        this.standardDeviation = setStandardDeviation(variance);
        this.variationCoeficient = setVariationCoeficient(standardDeviation, mean);
    }

    // Methods.
    double setMean(double[] arr) {
        // Returns the mean value of a given data series based on the relative frequencies.
        int meanValue = 0;
        int n = Array.getLength(arr);

        for (int i = 0; i < n; i++) {
            meanValue += arr[i] * relativeFrequency[i];
        }
        return meanValue;
    }

    double setMedian(double[] arr) {
        return 0;
    }

    double setModalValue(double[] arr) {
        return 0;
    }

    double[] setAbsoluteFrequency(double[] var, double[] data) {
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