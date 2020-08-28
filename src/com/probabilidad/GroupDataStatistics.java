package com.probabilidad;
import java.lang.reflect.Array;

abstract class GroupDataStatistics extends Statistics {
    double variance(double[] vec) {
        int n = Array.getLength(vec);
        double avg = mean(vec); // Obtengo la media de los datos.

        double sqDiff = 0;

        for (int i = 0; i < n; i++) {
            sqDiff += (vec[i] - avg) * (vec[i] - avg);
        }
        return sqDiff / n;
    }

    double[] modalValue(double[] classMarks) {
        // TODO: 27/08/2020  Review return type
        return classMarks;
    }

    double standardDeviation(double[] vec) {
        double var = variance(vec);
        return Math.sqrt(var);
    }

    double variationCoeficient(double[] vec) {
        double sd = standardDeviation(vec);
        double avg = mean(vec);
        return sd / avg;
    }

    // Abstract methods definition.
    abstract double median(double[] vec);
}