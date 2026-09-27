class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0]; // Sabse kam price jisme stock buy kar sakte hain
        int maxProfit = 0;        // Maximum profit store karne ke liye
        int n = prices.length;

        for (int i = 0; i < n; i++) { // n-1 ki jagah n tak chalega taaki last element cover ho
            // 1. Min Price update karo (Buy price)
            minPrice = Math.min(minPrice, prices[i]);

            // 2. Aaj ke price se sell karke profit check karo
            int currentProfit = prices[i] - minPrice;

            // 3. Max Profit update karo
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}