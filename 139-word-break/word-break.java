class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    // memo[i] = whether s[i..end) can be segmented
    Boolean[] memo = new Boolean[s.length()];
    return dfs(s, 0, wordSet, memo);
  }

  private boolean dfs(String s, int start, Set<String> wordSet, Boolean[] memo) {
    if (start == s.length()) return true;
    if (memo[start] != null) return memo[start];

    for (int end = start + 1; end <= s.length(); end++) {
      // check substring s[start..end)
      if (wordSet.contains(s.substring(start, end)) && dfs(s, end, wordSet, memo)) {
        return memo[start] = true;
      }
    }

    return memo[start] = false;
  }
}
