public class Offer003 {
    //如果i为偶数，与i/2相同 如果i为奇数，相当于i/2加1
    public int[] countBits(int n) {
        int result[] = new int[n + 1];
        for (int i = 1; i<= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
    // 去掉最右边的1 i & (i - 1)
    public int[] countBits1(int n) {
        int result[] = new int[n + 1];
        for (int i = 1; i<= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }

    public int[] countBits2(int n) {
        int result[] = new int[n + 1];
        for (int i = 1; i<= n; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
