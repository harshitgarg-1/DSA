class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        for (int i = 0; i <= target; i++) dp.add(new ArrayList<>());

        dp.get(0).add(new ArrayList<>());

        for (int c : candidates) {
            for (int t = c; t <= target; t++) {
                for (List<Integer> prev : dp.get(t - c)) {
                    List<Integer> newList = new ArrayList<>(prev);
                    newList.add(c);
                    dp.get(t).add(newList);
                }
            }
        }

        return dp.get(target);
    }
}
