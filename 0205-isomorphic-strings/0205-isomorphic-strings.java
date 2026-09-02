class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Agar dono characters ka pichla index match nahi karta
            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            // Store (i + 1) so default 0 represents "not seen yet"
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        return true;
    }
}