import java.util.Arrays;

class Solution {
    public int findClosestNumber(int[] nums) {

        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == 0) {
                return 0;
            } else if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        

        if (left >= nums.length) return nums[right];
        if (right < 0) return nums[left];
        
        if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}