class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Preprocess string
        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$");
        char[] arr = t.toString().toCharArray();

        int[] p = new int[arr.length];
        int center = 0, right = 0;

        // Step 2: Expand around center using previously known info
        for (int i = 1; i < arr.length - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Try expanding beyond the current palindrome
            while (arr[i + 1 + p[i]] == arr[i - 1 - p[i]]) {
                p[i]++;
            }

            // If palindrome expanded past right boundary, update center and right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Step 3: Find the longest palindrome
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2; // convert back to original string index
        return s.substring(start, start + maxLen);
    }
}
