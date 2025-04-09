class Solution {
    public long maxStrength(int[] nums) {
        long ans = -1;
        int maxNeg = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(num<=0) maxNeg = Math.max(maxNeg, num);
            if(num<0) pq.add(num);
            else if(num>0){
                if(ans==-1) ans = 1;
                ans = ans*num;
            }
        }
        if(ans == -1 && pq.size()<2) {
            return maxNeg;
        } 
        long curr = 1;
        while(pq.size()>=2){
            curr = curr*pq.poll()*pq.poll();
        }
        return ans == -1 ? curr : ans*curr;
        
    }
}