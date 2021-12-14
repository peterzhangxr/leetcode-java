// https://leetcode-cn.com/problems/xoh6Oh/
public class Offer001 {
    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (a > 0) {
            negative--;
            a = -a;
        }

        if (b > 0) {
            negative--;
            b = -b;
        }

        int result = divided(a, b);
        return negative == 1 ? -result : result;
    }

    public static int divided (int a, int b) {
        int result = 0;
        while (a <= b) {
            int value = b;
            int quotient = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                quotient += quotient;
                value += value;
            }
            a -= value;
            result += quotient;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }
}
