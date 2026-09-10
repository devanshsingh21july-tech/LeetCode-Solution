class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) return "0";
        
        
        char[] digits = num.toCharArray();
        int top = 0; 
        
        for (int i = 0; i < n; i++) {
       
            while (k > 0 && top > 0 && digits[top - 1] > digits[i]) {
                top--;
                k--;
            }
            digits[top++] = digits[i];
        }
   
        top -= k;
        
        int start = 0;
        while (start < top && digits[start] == '0') {
            start++;
        }
        
        return start == top ? "0" : new String(digits, start, top - start);
    }
}