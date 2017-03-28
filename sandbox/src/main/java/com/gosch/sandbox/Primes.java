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
    // делителей больше чем n / 2 - не может существовать
    // их не на что умножать чтобы получилось n
    // любой делитель числа гарантированно меньше чем его половина n / 2
    public static boolean isPrimeFast(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Математика:
    // 16 = 2 * 8; 16 = 4 * 4; sqrt(16) = 4;
    // Предположим что число имеет какой-то делитель,
    // это означает, что у него ещё есть второй делитель.
    // n представляется как произведение двух чисел, n = a * b.
    // Меньший из делителей (a или b) не превышает корня из числа n.
    // Оба делителя не могут быть больше чем корень из n (один из них всё равно будет меньше),
    // иначе их произведение будет больше чем n.
    public static boolean isPrimeMegaFast(int n) {
        int m = (int) Math.sqrt(n);
        System.out.println(m);
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

    // long - 64 bit numbers
    // it will take more time than with int - 32 bit numbers
    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}