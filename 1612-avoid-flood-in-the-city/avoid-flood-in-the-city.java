class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        HashMap<Integer, Integer> set = new HashMap<>();
        ArrayList<Integer> zero = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(set.containsKey(rains[i])){
                if(zero.size()==0 || zero.get(zero.size()-1) < set.get(rains[i])) return new int[0];
                else {
                    for(int j=0;j<zero.size();j++){
                        if(zero.get(j)>set.get(rains[i])){
                            ans[zero.get(j)] = rains[i];
                            zero.remove(j);
                            break;
                        }
                    }
                    ans[i] = -1;
                    set.put(rains[i], i);
                }
            } else if (rains[i]==0){
                zero.add(i);
            } else {
                set.put(rains[i], i);
                ans[i] = -1;
            }
        }

        return ans;
    }
}