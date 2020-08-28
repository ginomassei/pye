package com.probabilidad;

import java.lang.reflect.Array;

public class IntervalFrequences extends GroupDataStatistics {

    // Atributes.
    double[] intervalsBottom;
    double[] intervalsTop;
    double[] classMarks;
    double[] absoluteFrequency;
    double[] relativeFrequency;
    double[] classNumber;
    double variance;
    double mean;
    double median;
    double modalValue;
    double standardDeviation;
    double variationCoeficient;

    // Construct.
    IntervalFrequences(double[] data, int intervalNumber) {
        Object[] values = setIntervals(data, intervalNumber);
        this.intervalsBottom = (double[]) values[0];
        this.intervalsTop = (double[]) values[1];
        this.classNumber = (double[]) values[2];
        this.classMarks = setClassMarks(intervalsTop, intervalsBottom);
        this.absoluteFrequency = setAbsoluteFrequency(intervalsBottom, intervalsTop, data);
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
        // Returns the mean value of a given data series based on the class marks.
        int meanValue = 0;
        int n = Array.getLength(arr);

        for (int i = 0; i < n; i++) {
            meanValue += arr[i] * hi[i];
        }
        return meanValue;
    }

    double setMedian(double[] vec) {
        return 0;
    }

    double setModalValue(double[] arr) {
        return 0;
    }

    Object[] setIntervals(double[] yi, int intervalsNumber) {
        int n = Array.getLength(yi);
        double lower = yi[0];
        double higher = yi[n - 1];

        double R = higher - lower;  // Recorrido de la clase.
        double ci = R / intervalsNumber;  // Amplitud del intervalo.

        if ((ci % 2) != 0) {  // Adjusting the class, if not divisible by two.
            ci = (float) Math.ceil(ci);

            double RNew = ci * (double) intervalsNumber;
            double diff = RNew - R;
            lower = lower - (diff / 2);
        }

        double[] intervalsTop = new double[intervalsNumber];  // Vector que contiene los límites superiores de cada clase.
        double[] intervalsBottom = new double[intervalsNumber]; // Vector que contiene los límites inferiores de cada clase.

        for (int i = 0; i < intervalsNumber; i++) {
            intervalsBottom[i] = lower;

            lower = (int) lower + (int) ci;
            intervalsTop[i] = lower;
        }

        double[] classes = new double[intervalsNumber];  // Class number.
        for (int i = 0; i < intervalsNumber; i++) {
            classes[i] = i + 1;
        }
        return new Object[]{intervalsBottom, intervalsTop, classes};
    }

    double[] setClassMarks(double[] intervalsTop, double[] intervalsBottom) {
        int n = Array.getLength(intervalsBottom);
        double[] classMark = new double[n];  // Marcas de clase.

        for (int i = 0; i < n; i++) {
            classMark[i] = (intervalsBottom[i] + intervalsTop[i]) / 2;
        }
        return classMark;
    }

    double[] setAbsoluteFrequency(double[] intervalsBottom, double[] intervalsTop, double[] obs) {
        double[] ni = new double[Array.getLength(intervalsBottom)];

        for (int i = 0; i < Array.getLength(ni); i++) {
            for (double k : obs) {
                if ((k >= intervalsBottom[i]) && (k < intervalsTop[i])) {
                    ni[i]++;
                }
            }
        }
        return ni;
    }
}
