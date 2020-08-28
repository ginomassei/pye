package com.probabilidad;

import java.lang.reflect.Array;

public class ListFrequences extends GroupDataStatistics {

    // Atributes.
    private double[] absoluteFrequency;
    private double[] relativeFrequency;
    private double variance;
    private double mean;
    private double median;
    private double modalValue;
    private double standardDeviation;
    private double variationCoeficient;

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
    // Setters.
    protected double setMean(double[] arr) {
        // Returns the mean value of a given data series based on the relative frequencies.
        int meanValue = 0;
        int n = Array.getLength(arr);

        for (int i = 0; i < n; i++) {
            meanValue += arr[i] * relativeFrequency[i];
        }
        return meanValue;
    }

    protected double setMedian(double[] arr) {
        return 0;
    }

    protected double setModalValue(double[] arr) {
        return 0;
    }

    private double[] setAbsoluteFrequency(double[] var, double[] data) {
        int n = Array.getLength(var);
        double[] ni = new double[n];
        int j = 0;

        for (double i : var) {
            ni[j] = arrays.linearSearchInstances(data, i);
            j++;
        }
        return ni;
    }

    // Getters.
    double[] getAbsoluteFrequency() {
        return absoluteFrequency;
    }

    double[] getRelativeFrequency() {
        return relativeFrequency;
    }

    double getVariance() {
        return variance;
    }

    double getMean() {
        return mean;
    }

    double getMedian() {
        return median;
    }

    double getModalValue() {
        return modalValue;
    }
}