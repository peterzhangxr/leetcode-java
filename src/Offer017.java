import java.util.HashMap;

public class Offer017 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> chartToCount = new HashMap<>();
        for(char ch: t.toCharArray()) {
            chartToCount.put(ch, chartToCount.getOrDefault(ch, 0) + 1);
        }

        int count = chartToCount.size();
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        while(end < s.length() || (count == 0 && end == s.length())) {
            if (count > 0) {
                char endCh = s.charAt(end);
                if (chartToCount.containsKey(endCh)) {
                    chartToCount.put(endCh, chartToCount.get(endCh) - 1);
                    if (chartToCount.get(endCh) == 0) {
                        count--;
                    }
                }

                end++;
            } else {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }

                char startCh = s.charAt(start);
                if (chartToCount.containsKey(startCh)) {
                    chartToCount.put(startCh, chartToCount.get(startCh) + 1);
                    if (chartToCount.get(startCh) == 1) {
                        count++;
                    }
                }

                start++;
            }
        }

        return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd): "";

    }
}
