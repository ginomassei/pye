package com.probabilidad;

import java.lang.reflect.Array;

class PopulationStatistics extends Statistics {
    MyArrays arrays = new MyArrays();

    double standardDeviation(double[] vec) {
        double var = variance(vec);
        return Math.sqrt(var);
    }

    double variance(double[] vec) {
        int n = Array.getLength(vec);
        double avg = mean(vec); // Obtengo la media de los datos.

        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - avg) * (vec[i] - avg);
        }
        return sqDiff / n;
    }

    double variationCoeficient(double[] vec) {
        double sd = standardDeviation(vec);
        double avg = mean(vec);
        return sd / avg;
    }

    double median(double[] vec) {
        return 0;
    }

    double modalValue(double[] vec) {
        return 0;
    }

    double[] absoluteFrequence(double[] intervalsBottom, double[] intervalsTop, double[] obs) {
        double[] ni = new double[Array.getLength(intervalsBottom)];

        for (int i = 0; i < Array.getLength(ni); i++){
            for (double k : obs) {
                if ((k >= intervalsBottom[i]) && (k < intervalsTop[i])) {
                    ni[i]++;
                }
            }
        }
        return ni;
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
}
