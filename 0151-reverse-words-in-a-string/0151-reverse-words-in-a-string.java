class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            // Find the start of the current word
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append word to result (separated by space if not first word)
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(i + 1, j + 1));
        }

        return result.toString();
    }
}