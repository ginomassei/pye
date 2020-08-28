package com.probabilidad;

public class Main {
    public static void main(String[] args) {
        double[] obs = {440, 555, 700, 440, 660, 440, 440, 440, 440, 555, 730, 660, 680, 730, 680, 440, 440, 730, 730, 680};

        // Objects definition.
        MyArrays arrays = new MyArrays();
        SimpleDataSeriesStatistics listStatistics = new SimpleDataSeriesStatistics(obs);

        System.out.println(listStatistics.getMean());
        System.out.println(listStatistics.getStandardDeviation());
        System.out.println(listStatistics.getVariance());
        System.out.println(listStatistics.getVariationCoeficient());
    }
}