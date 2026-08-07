class Solution {
    public int singleNumber(int[] nums) {
        for(int i=0;i<=nums.length-1;i++){
            int n=0;
            for(int j=0;j<=nums.length-1;j++){
                if(nums[i]==nums[j]){
                    n=n+1;
                }
            }
        if(n==1){
            return nums[i];
        }
        }
        return -1;
    }
}
