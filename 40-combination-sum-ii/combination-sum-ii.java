class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generate(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void generate(int[] candidates, int i, int target, List<Integer> curr, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i==candidates.length) return;
        if(candidates[i]<=target){
            curr.add(candidates[i]);
            generate(candidates, i+1, target-candidates[i], curr, ans);
            curr.remove(curr.size()-1);
        }
        while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
        generate(candidates, i+1, target, curr, ans);
    }
}