class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long total = (long) n * n;

        // Sum of numbers 1 to total
        long sumExpected = total * (total + 1) / 2;
        
        // Sum of squares of numbers 1 to total
        long sumSqExpected = total * (total + 1) * (2 * total + 1) / 6;

        long sumGrid = 0;
        long sumSqGrid = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                sumGrid += val;
                sumSqGrid += val * val;
            }
        }

        long diffSum = sumGrid - sumExpected;          // a - b
        long diffSqSum = sumSqGrid - sumSqExpected;    // a^2 - b^2

        long sumAdd = diffSqSum / diffSum;             // a + b

        int a = (int) ((diffSum + sumAdd) / 2);        // Repeated
        int b = (int) ((sumAdd - diffSum) / 2);        // Missing

        return new int[]{a, b};
    }
}