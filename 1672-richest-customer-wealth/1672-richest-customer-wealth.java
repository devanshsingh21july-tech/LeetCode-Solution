class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        // Har customer (row) par iterate karo
        for (int[] customer : accounts) {
            int currentWealth = 0;
            
            // Customer ke saare bank accounts (columns) ka sum nikalo
            for (int bank : customer) {
                currentWealth += bank;
            }
            
            // Agar yeh wealth pichli max wealth se badi hai, toh update kar do
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        
        return maxWealth;
    }
}