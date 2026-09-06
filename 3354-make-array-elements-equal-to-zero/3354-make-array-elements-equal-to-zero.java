class Solution {
    public int countValidSelections(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int count = 0;
        int leftSum = 0;

        for (int num : nums) {
            if (num == 0) {
                int rightSum = totalSum - leftSum;
                int diff = leftSum - rightSum;

                if (diff == 0) {
                    count += 2; 
                } else if (Math.abs(diff) == 1) {
                    count += 1; 
                }
            } else {
                leftSum += num;
            }
        }

        return count;
    }
}