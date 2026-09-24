class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);

            // Check if the end of the current string matches 'part'
            if (sb.length() >= n) {
                if (sb.substring(sb.length() - n).equals(part)) {
                    sb.delete(sb.length() - n, sb.length());
                }
            }
        }

        return sb.toString();
    }
}