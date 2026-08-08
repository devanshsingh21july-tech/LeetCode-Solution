class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Make sure `mid` is even
            if (mid % 2 == 1) {
                mid--;
            }

            // If mid and mid+1 are same, single element is on the right half
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // Single element is on the left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }
}