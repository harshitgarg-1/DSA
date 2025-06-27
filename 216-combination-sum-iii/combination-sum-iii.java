class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(1, k, n, ans, new ArrayList < > ());
        return ans;
    }
    static void findCombinations(int i, int k, int n, List < List < Integer >> ans, List < Integer > ds) {
        if (n == 0 && k==0) {
            ans.add(new ArrayList < > (ds));
            return;
        }
        if(k==0 || n<0 || i>9) return;

        ds.add(i);
        findCombinations(i + 1, k-1, n-i, ans, ds);
        ds.remove(ds.size() - 1);
        findCombinations(i + 1, k, n, ans, ds);
    }
}