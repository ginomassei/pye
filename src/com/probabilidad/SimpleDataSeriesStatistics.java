package com.probabilidad;

import java.lang.reflect.Array;

public class SimpleDataSeriesStatistics extends Statistics {

    // Atributes.
    private double variance;
    private double mean;
    private double median;
    private double modalValue;
    private double standardDeviation;
    private double variationCoeficient;
    private double maxValue;
    private double minValue;

    // Construct.
    SimpleDataSeriesStatistics(double[] data) {
        arrays.selectionSort(data);
        this.mean = setMean(data);
        this.variance = setVariance(data);
        this.median = setMedian(data);
        this.modalValue = setModalValue(data);
        this.standardDeviation = setStandardDeviation(variance);
        this.variationCoeficient = setVariationCoeficient(standardDeviation, mean);
        Object[] max = arrays.getMax(data);
        this.maxValue = (double) max[0];
        this.minValue = arrays.getMin(data);
    }

    // Methods.
    // Setters.
    protected double setMean(double[] vec) {
        // Returns the mean value of a given data series array.
        double sum = 0;
        int n = Array.getLength(vec);

        for (double i : vec) {
            sum += i;
        }
        return sum / n;
    }

    protected double setMedian(double[] vec) {
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

    protected double setVariance(double[] vec) {
        // Returns the variance value of a data series array.
        int n = Array.getLength(vec);
        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - mean) * (vec[i] - mean);
        }
        return sqDiff / (n - 1);
    }

    protected double setModalValue(double[] vec) {
        if (!arrays.sorted(vec)) {
            arrays.selectionSort(vec);
        }
        Object[] max = arrays.getMax(vec);
        int index = (int) max[1];
        return vec[index];
    }

    protected double setStandardDeviation(double variance) {
        return Math.sqrt(variance);
    }

    protected double setVariationCoeficient(double standardDeviation, double mean) {
        return standardDeviation / mean;
    }

    // Getters.
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
        return variationCoeficient * 100;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue;
    }
}
