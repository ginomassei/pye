package com.probabilidad;


import java.lang.reflect.Array;

public class MyArrays {
    void selectionSort(double[] vec) {
        int n = Array.getLength(vec);
        double temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (vec[j - 1] > vec[j]) {
                    temp = vec[j-1];
                    vec[j - 1] = vec[j];
                    vec[j] = temp;
                }
            }
        }
    }

    boolean linearSearchBoolean(double[] vec, double x) {
        int n = Array.getLength(vec);

        for (int i = 0; i < n; i++) {
            if (vec[i] == x) {
                return true;
            }
        }
        return false;
    }

    int linearSearchInstances(double[] obs, double x) {
        int n = Array.getLength(obs);
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (obs[i] == x) {
                j ++;
            }
        }
        return j;
    }

    double[] searchOcurrences(double[] listObs) {
        int c = 0;
        double ocurrence = 0;
        int n =  Array.getLength(listObs);

        for (int i = 0; i < n; i++) {
            try {
                if (listObs[i] > listObs[i + 1]) {
                    selectionSort(listObs);
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }

        }

        for (double i : listObs) {
            if (i != ocurrence) {
                ocurrence = i;
                c ++;
            }
        }

        double[] v = new double[c];

        c = 0;
        for (double i : listObs) {
            if (i != ocurrence) {
                ocurrence = i;
                v[c] = ocurrence;
                c ++;
            }
        }

        return v;
    }

    double getMin(double[] arr) {
        double min = 0;
        int j = 0;

        for (double i : arr) {
            if (j == 0) {
                min = i;
                j = 1;
            }
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    Object[] getMax(double[] arr) {
        double max = 0;
        int index = 0;
        int maxIndex = 0;

        for (double i : arr) {
            if (i > max) {
                max = i;
                maxIndex = index;
            }
            index ++;
        }
        return new Object[] {max, maxIndex};
    }

    boolean sorted(double[] arr) {
        int n = Array.getLength(arr);

        for (int i = 0; i < n; i++) {
            try {
                if (arr[i] > arr[i + 1]) {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }
        return false;
    }
}