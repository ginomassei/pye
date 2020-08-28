package com.probabilidad;

import java.lang.reflect.Array;

public class ListFrequences extends GroupDataStatistics {

    // Atributes.
    private double[] absoluteFrequency;
    private double[] relativeFrequency;
    private double[] cumulativeAbsoluteFrequency;
    private double[] cumulativeRelativeFrequency;
    private double variance;
    private double mean;
    private double median;
    private double modalValue;
    private double standardDeviation;
    private double variationCoeficient;

    // Construct.
    ListFrequences(double[] data, double[] variables) {
        arrays.selectionSort(data);
        arrays.selectionSort(variables);
        this.absoluteFrequency = setAbsoluteFrequency(variables, data);
        this.relativeFrequency = setRelativeFrequency(absoluteFrequency);
        this.mean = setMean(data);
        this.variance = setVariance(data);
        this.median = setMedian(data);
        this.modalValue = setModalValue(data);
        this.standardDeviation = setStandardDeviation(variance);
        this.variationCoeficient = setVariationCoeficient(standardDeviation, mean);
        this.cumulativeAbsoluteFrequency = setCumulativeFrequency(absoluteFrequency);
        this.cumulativeRelativeFrequency = setCumulativeFrequency(relativeFrequency);
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
    public double[] getAbsoluteFrequency() {
        return absoluteFrequency;
    }

    public double[] getRelativeFrequency() {
        return relativeFrequency;
    }

    public double getVariance() {
        return variance;
    }

   public double getMean() {
        return mean;
    }

    public double getMedian() {
        return median;
    }

    public double getModalValue() {
        return modalValue;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double getVariationCoeficient() {
        return variationCoeficient;
    }

    public double[] getCumulativeAbsoluteFrequency() {
        return cumulativeAbsoluteFrequency;
    }

    public double[] getCumulativeRelativeFrequency() {
        return cumulativeRelativeFrequency;
    }
}