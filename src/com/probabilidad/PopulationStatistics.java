package com.probabilidad;

import java.lang.reflect.Array;

class PopulationStatistics extends Statistics {
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
}
