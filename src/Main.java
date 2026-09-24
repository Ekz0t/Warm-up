import java.util.Scanner;
import java.math.BigInteger;

/*
Напишите функцию, которая вычисляет результат двух заданных целых чисел без использования операции умножения.
Постарайтесь сделать это как можно быстрее (O(log(n) или лучше.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int n1 = sc.nextInt();
        System.out.println("Введите второе число: ");
        int n2 = sc.nextInt();
        int res = multiplyFor(n1, n2);
        int res0 = multiplyWhile(n1, n2);
        int res1 = multiplyWithRecursion(n1, n2);
        int res2 = multiplyWithShifts(n1, n2);
        int res3 = multiplyDoWhile(n1, n2);
        BigInteger Bn1 = BigInteger.valueOf(n1);
        BigInteger Bn2 = BigInteger.valueOf(n2);
        int res4 = multiplyBigInt(Bn1, Bn2);
        int res5 = multiplyDivision(n1, n2);
        int res6 = multiplyLog10(n1, n2);
        System.out.println("Итог: " + res);
        System.out.println("Итог0: " + res0);
        System.out.println("Итог1: " + res1);
        System.out.println("Итог2: " + res2);
        System.out.println("Итог3: " + res3);
        System.out.println("Итог4: " + res4);
        System.out.println("Итог5: " + res5);
        System.out.println("Итог6: " + res6);
    }


    public static int multiplyFor(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            int res = 0;
            for (int i = 1; i <= b; i++) {
                res = res + a;
            }
            return res;
        }
    }

    public static int multiplyWhile(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            int res = 0;
            int i = 0;
            while (i < b) {
                res = res + a;
                i++;
            }
            return res;
        }
    }

    public static int multiplyWithRecursion(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b == 1) {
            return a;
        }
        if (b < 0) {
            return multiplyWithRecursion(a, -b);
        }
        return a + multiplyWithRecursion(a, b - 1);
    }

    public static int multiplyWithShifts(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res += a;
            }
            a <<= 1;
            b >>= 1;
        }
        return res;
    }

    public static int multiplyDoWhile(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else {
            int res = 0;
            int i = 0;
            do {
                res = res + a;
                i++;
            }
            while (i < b);
            return res;
        }
    }

    public static int multiplyBigInt(BigInteger a, BigInteger b) {
        BigInteger res = a.multiply(b);
        return res.intValue();
    }

    public static int multiplyDivision(int a, int b) {
        int res = 0;
        while (b > 0) {
            if (b % 2 == 1) {
                res += a;
            }
            a += a;
            b /= 2;
        }
        return res;
    }

    public static int multiplyLog10(int a, int b) {
        if (a == 0 || b == 0){
            return 0;
        }
        int sign = ((a < 0) || (b < 0)) ? -1 : 1;
        double x = Math.abs(a);
        double y = Math.abs(b);
        double logSum = Math.log10(x) + Math.log10(y);
        double result = Math.pow(10, logSum);
        if (sign < 0){
            result = -result;
        }
        return (int) Math.round(result);
    }
}