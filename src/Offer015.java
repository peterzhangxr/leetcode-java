import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer015 {
    public List<Integer> findAnagrams (String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] counts = new int[26];
        int i = 0;
        for (; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']++;
            counts[s.charAt(i) - 'a']--;
        }

        if (isAllZero(counts)) {
            result.add(0);
        }
        for (; i < s.length();i++) {
            counts[s.charAt(i) - 'a']--;
            counts[s.charAt(i) - p.length() - 'a']++;
            if (isAllZero(counts)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    private boolean isAllZero (int[] counts) {
        for (int count: counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
