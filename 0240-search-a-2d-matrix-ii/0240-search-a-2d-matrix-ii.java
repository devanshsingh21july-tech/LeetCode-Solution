class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } 
        int rows = matrix.length;
        int cols = matrix[0].length;

int row = rows - 1; // Last row index (matrix.length - 1)
int col = 0;        // First column index

while (row >= 0 && col < cols) {
    if (matrix[row][col] == target) {
        return true;
    } else if (matrix[row][col] > target) {
        row--; // Upar jao (chote elements ki taraf)
    } else {
        col++; // Right jao (bade elements ki taraf)
    }
}

return false;
    }
}