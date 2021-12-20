public class Offer016 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int i = 0;
        int j = -1;
        int longest = 1;
        for (; i < s.length();++i) {
            counts[s.charAt(i)]++;
            while(hasGeaterThan(counts)) {
                ++j;
                counts[s.charAt(j)]--;
            }

            longest = Math.max(i - j, longest);
        }

        return longest;
    }

    private boolean hasGeaterThan(int[] counts) {
        for (int count: counts) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}
