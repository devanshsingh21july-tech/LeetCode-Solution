class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        // --- Search Pruning Optimizations ---
        if (word.length() > m * n) {
            return false;
        }

        // Frequency check: ensure board has enough occurrences of each letter in word
        int[] boardCounts = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardCounts[board[i][j]]++;
            }
        }

        for (char c : word.toCharArray()) {
            if (--boardCounts[c] < 0) {
                return false;
            }
        }

        // Search direction optimization:
        // Reverse word if ending character frequency is lower than starting character frequency
        if (boardCounts[word.charAt(word.length() - 1)] < boardCounts[word.charAt(0)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // --- Backtracking Search ---
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited in-place
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        board[r][c] = temp;

        return found;
    }
}