import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();

            // Find how many words fit into the current line
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder sb = new StringBuilder();

            // Case 1: Last line OR line contains only one word -> Left Justified
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                // Pad remaining spaces to the right
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Case 2: Fully Justified (Left and Right)
            else {
                int totalWordLength = 0;
                for (int k = i; k < j; k++) {
                    totalWordLength += words[k].length();
                }

                int totalSpaces = maxWidth - totalWordLength;
                int spacesBetweenSlots = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        // Base spaces between words
                        for (int s = 0; s < spacesBetweenSlots; s++) {
                            sb.append(" ");
                        }
                        // Distribute extra spaces to the leftmost slots
                        if (k - i < extraSpaces) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to next set of words
        }

        return result;
    }
}