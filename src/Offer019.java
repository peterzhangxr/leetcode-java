public class Offer019 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (;start < s.length() / 2; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }

        return start == s.length() / 2 || isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }

            start++;
            end--;
        }

        return start >= end;
    }
}
