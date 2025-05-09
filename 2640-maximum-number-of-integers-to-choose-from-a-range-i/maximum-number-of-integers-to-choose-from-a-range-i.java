class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);

        int bannedIdx = 0, count = 0;
        for (int num = 1; num <= n && maxSum >= 0; num++) {
            if (bannedIdx < banned.length && banned[bannedIdx] == num) {
                while (bannedIdx < banned.length && banned[bannedIdx] == num) {
                    bannedIdx++;
                }
            } else {
                maxSum -= num;
                if (maxSum >= 0) {
                    count++;
                }
            }
        }
        return count;
    }
}