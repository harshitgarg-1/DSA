class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i = 1; i <= n; i++){
            int val = (int)Math.pow(2,i-1);
            int j = list.size();
            for(int k=j-1;k>=0;k--){
                list.add(val+list.get(k));
            }
        }
        
        return list;
    }
}