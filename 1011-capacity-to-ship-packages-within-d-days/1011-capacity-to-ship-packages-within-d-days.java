class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int right = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > low) {
                low = weights[i];
            }
            right += weights[i];
        }
        
        while (low <= right) {
            int mid = low + (right - low) / 2;
            
            if (canShip(weights, days, mid)) {
                right = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        
        return low; 
    }
    
    private boolean canShip(int[] weights, int days, int k) {
        int count = 1;
        int totalw = 0;
        
        for (int i = 0; i < weights.length; i++) {
            if (totalw + weights[i] > k) {
                count++;
                totalw = weights[i];
                if (count > days) return false; 
            } else {
                totalw += weights[i];
            }
        }
        
        return true;
    }
}