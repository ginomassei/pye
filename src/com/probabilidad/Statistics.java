package com.probabilidad;

import java.lang.reflect.Array;

public class Statistics {
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

    double[] relativeFrequence(double[] ni) {
        int n = Array.getLength(ni);
        double[] hi = new double[n];
        int ac = 0;

        for (int i = 0; i < n; i++) {
            ac += ni[i];
        }

        for (int i = 0; i < n; i++) {
            hi[i] = ni[i] / ac;
        }

        return hi;
    }

    double[] cumulativeFrequence(double[] vec) {
        int n = Array.getLength(vec);
        double[] cf = new double[n];

        for (int i = 0; i < n; i++) cf[i] = vec[i] + cf[i - 1];
        return cf;
    }

    Object[] intervalMaker(double[] yi, int intervalsNumber) {
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

        double[] classMarks = new double[intervalsNumber];  // Marcas de clase.
        for (int i = 0; i < intervalsNumber; i++) {
            classMarks[i] = (intervalsBottom[i] + intervalsTop[i]) / 2;
        }

        double[] classes = new double[intervalsNumber];  // Class number.
        for (int i = 0; i < intervalsNumber; i++) {
            classes[i] = i + 1;
        }
        return new Object[]{intervalsBottom, intervalsTop, classMarks, classes};
    }

    double mean(double[] vec) {
        double sum = 0;
        int n = Array.getLength(vec);

        for (double i : vec) {
            sum += i;
        }
        return sum / n;
    }

    double listFrequenceAverage(double[] vec, double[] hi) {
        int sum = 0;
        int n = Array.getLength(vec);

        for (int i = 0; i < n; i++) {
            sum += vec[i] * hi[i];
        }

        return sum;
    }

    double sampleStandardDeviation(double[] vec) {
        double var = sampleVariance(vec);
        return Math.sqrt(var);
    }

    double populationStandardDeviation(double[] vec) {
        double var = populationVariance(vec);
        return Math.sqrt(var);
    }

    double sampleVariance(double[] vec) {
        int n = Array.getLength(vec);
        double avg = mean(vec); // Obtengo la media de los datos.

        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - avg) * (vec[i] - avg);
        }
        return sqDiff / (n - 1);
    }

    double populationVariance(double[] vec) {
        int n = Array.getLength(vec);
        double avg = mean(vec); // Obtengo la media de los datos.

        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - avg) * (vec[i] - avg);
        }
        return sqDiff / n;
    }

    double sampleVariationCoeficient(double[] vec) {
        double sd = sampleStandardDeviation(vec);
        double avg = mean(vec);
        return sd / avg;
    }

    double populationVariationCoeficient(double[] vec) {
        double sd = populationStandardDeviation(vec);
        double avg = mean(vec);
        return sd / avg;
    }

    double sampleMedian(double[] arr) {
        int n = Array.getLength(arr);
        double medianEven;

        if (!arrays.sorted(arr)) {
            arrays.selectionSort(arr);
        }

        if (n % 2 != 0){
            int median = (n + 1) / 2;
            return arr[median];

        } else {
            double medianIndex = (double) (n + 1) / 2;
            medianEven = (arr[(int) medianIndex - 1] + arr[(int) medianIndex]) / 2;
        }
        return medianEven;
    }

    double sampleModalValue(double[] arr) {
        if (!arrays.sorted(arr)) {
            arrays.selectionSort(arr);
        }
        Object[] max = arrays.getMax(arr);
        int index = (int) max[1];
        return arr[index];
    }
}