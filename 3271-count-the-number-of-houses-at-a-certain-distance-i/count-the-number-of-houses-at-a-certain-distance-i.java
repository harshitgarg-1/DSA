class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int val = Math.min(
                    Math.abs(i - j),
                    Math.min(
                        Math.abs(i - x) + 1 + Math.abs(y - j), 
                        Math.abs(i - y) + 1 + Math.abs(x - j) 
                    )
                );
                result[val - 1] += 2; // from i to j and j to i
            }
        }
        return result;
    }
}