class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[0]-b[0]);
        int max = -1000000, rangeDiff = Integer.MAX_VALUE;
        int[] range = new int[2];
        for(int i=0;i<nums.size();i++){
            pq.add(new int[]{nums.get(i).get(0),i,0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while(true){
            int[] curr = pq.poll();
            if(max-curr[0]<rangeDiff) {
                range[0] = curr[0];
                range[1] = max;
                rangeDiff = max-curr[0];
            }
            if(nums.get(curr[1]).size()==curr[2]+1) break;
            pq.add(new int[]{nums.get(curr[1]).get(curr[2]+1),curr[1],curr[2]+1});
            max = Math.max(max, nums.get(curr[1]).get(curr[2]+1));
        }
        return range;
    }
}