class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);  // sort ascending
        int total = 0, result = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            total += satisfaction[i];
            if (total < 0) break;
            result += total;
        }
        return result;
    }
}


