class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int right=1;
        for(int weight:weights){
            low=Math.max(low,weight);
            right+=weight;
        }
        int ans=right;
        while(low<=right){
            int mid=low+(right-low)/2;
            if(newfunc(weights,days,mid)){
                ans=mid;
                right=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean newfunc(int[] weights,int days,int k){
        int count=1;
        int totalw=0;
        for(int weight:weights){
            if(totalw+weight>k){
                count++;
                totalw=weight;
            }else{
                totalw+=weight;
            }
        }
        return count<=days;
    }
}