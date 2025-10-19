import java.util.*;

class Solution {
    Map<String, List<List<Integer>>> memo = new HashMap<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, target, 0);
    }

    private List<List<Integer>> dfs(int[] candidates, int target, int start) {
        String key = start + "," + target;
        if (memo.containsKey(key)) return memo.get(key);
        
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            for (List<Integer> sub : dfs(candidates, target - candidates[i], i)) {
                List<Integer> newList = new ArrayList<>(sub);
                newList.add(0, candidates[i]);
                res.add(newList);
            }
        }

        memo.put(key, res);
        return res;
    }
}

