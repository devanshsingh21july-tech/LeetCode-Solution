class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (newfunc(nums, threshold, mid)) {
                ans = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }
        
        return ans;
    }
    private boolean newfunc(int[] nums, int threshold, int k) {
        int total = 0;
        for (int num : nums) {
            total += (num + k - 1) / k;
        }
        return total <= threshold;
    }
}