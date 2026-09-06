class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int rightSum = 0;

        // Calculate total sum (which starts as the initial rightSum)
        for (int num : nums) {
            rightSum += num;
        }

        int[] ans = new int[n];
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
        
            rightSum -= nums[i];


            ans[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return ans;
    }
}