class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ls = s.length(), lp = p.length();
        List<Integer> res = new ArrayList<>();
        
        if (lp > ls) return res;
        
        int[] freq = new int[26];
        
        for (int i = 0; i < lp; i++) {
            freq[p.charAt(i) - 'a']--;
            freq[s.charAt(i) - 'a']++;
        }
        
        if (allZero(freq)) res.add(0);
        
        for (int i = lp; i < ls; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[s.charAt(i - lp) - 'a']--;
            if (allZero(freq)) res.add(i - lp + 1);
        }
        
        return res;
    }

    private boolean allZero(int[] freq) {
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }
}