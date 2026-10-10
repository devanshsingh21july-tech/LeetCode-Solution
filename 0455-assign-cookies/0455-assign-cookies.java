import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0; // Pointer for children (g)
        int j = 0; // Pointer for cookies (s)
        
        // Match smallest possible cookie to smallest possible greed
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // Child is content, move to the next child
            }
            j++; // Move to the next cookie
        }
        
        return i; // Number of satisfied children
    }
}