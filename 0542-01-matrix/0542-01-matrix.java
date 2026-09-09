class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int INF = m + n; 
        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    int top = (i > 0) ? mat[i - 1][j] : INF;
                    int left = (j > 0) ? mat[i][j - 1] : INF;
                    mat[i][j] = Math.min(top, left) + 1;
                }
            }
        }
        

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int bottom = (i < m - 1) ? mat[i + 1][j] : INF;
                    int right = (j < n - 1) ? mat[i][j + 1] : INF;
                    mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
                }
            }
        }
        
        return mat;
    }
}