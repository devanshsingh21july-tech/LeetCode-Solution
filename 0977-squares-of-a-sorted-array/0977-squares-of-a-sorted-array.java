class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int leftProd = nums[left] * nums[left];
            int rightProd = nums[right] * nums[right];
            if(leftProd < rightProd) {
                res[i] = rightProd;
                right--;
            } else {
                res[i] = leftProd;
                left++;
            }
        }
        return res;
    }
}