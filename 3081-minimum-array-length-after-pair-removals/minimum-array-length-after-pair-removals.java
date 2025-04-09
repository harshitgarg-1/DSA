class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int ans = nums.size();
        for(int key : hm.keySet()){
            pq.add(hm.get(key));
        }
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            ans -=2;
            if(x-1>0) pq.add(x-1);
            if(y-1>0) pq.add(y-1);
        }
        return ans;
    }
}