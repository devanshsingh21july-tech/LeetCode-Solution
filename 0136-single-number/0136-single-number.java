class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int result=0;
        for(int num=0;num<n;num++){
            result=result^nums[num];
        }
        return result;
    }
}