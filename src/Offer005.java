public class Offer005 {
    public int maxProduct (String[] words) {
        int max = 0;
        int[] flags = new int[words.length];
        for (int i= 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                flags[i] |= 1 << (c - 'a');
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {

                if ((flags[i] & flags[i]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
    public int maxProduct2 (String[] words) {
        int max = 0;
        boolean[][] flags = new boolean[words.length][26];
        for (int i= 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (;k < 26;k++) {
                    if (flags[i][k] && flags[j][k]){
                        break;
                    }
                }

                if (k == 26) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
    //暴力解法 时间复杂度太大O(n^2 * pq)
    public int maxProduct3(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                boolean flag = false;
                for (int k = 0; k < str1.length(); k++) {
                    if (words[j].indexOf(str1.charAt(k)) != -1) {
                        flag = true;
                    }
                }
                if (!flag) {
                    max = Math.max(max, words[j].length() * str1.length());
                }

            }
        }
        return max;
    }
}
