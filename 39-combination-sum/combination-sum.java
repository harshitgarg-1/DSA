class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void generate(int[] candidates, int i, int target, List<Integer> curr, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i==candidates.length) return;
        generate(candidates, i+1, target, curr, ans);
        if(candidates[i]<=target){
            curr.add(candidates[i]);
            generate(candidates, i, target-candidates[i], curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}