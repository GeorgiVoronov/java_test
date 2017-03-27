package com.gosch.sandbox;

// Простые числа - число кот. делится на себя и на 1, никаких других делителей у него нет.
// Поделить на все числа что меньше его, если делитель найдётся значит число не простое.
// int - 32bit, long - 64bit
public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // divide only half of the number
    public static boolean isPrimeFast(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // математика
    public static boolean isPrimeMegaFast(int n) {
        int m = (int) Math.sqrt(n);
        for (int i = 2; i < m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 2;
        while (i < n && n % i != 0) {
            i++;
        }
        return i == n;
    }

    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}