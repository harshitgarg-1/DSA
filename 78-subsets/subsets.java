class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(nums, 0, new ArrayList<>(), ans);
    return ans;
  }

  private void dfs(int[] nums, int s, List<Integer> path, List<List<Integer>> ans) {
      
   if(s==nums.length){
       ans.add(new ArrayList<>(path));
       return;
   }

    
      path.add(nums[s]);
      dfs(nums, s + 1, path, ans);
      path.remove(path.size() - 1);
      dfs(nums, s + 1, path, ans);  
    
  }
}