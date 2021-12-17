public class Offer009 {
    public int numSummaryProductLessThank(int[] nums, int k) {
        long sum = 1;
        int count = 0;
        int left = 0;
        for (int right = 0;right < nums.length; right++) {
            sum *= nums[right];
            while (left <= right && sum >= k) {
                sum /= nums[left++];
            }
            count += right >= right ? right - left + 1 : 0;
        }

        return count;
    }
}
