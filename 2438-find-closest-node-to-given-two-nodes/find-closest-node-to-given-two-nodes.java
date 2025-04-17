class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int t = 0;
        while(node1 != -1 && !hm.containsKey(node1)){
            hm.put(node1, t);
            t++;
            node1 = edges[node1];
        }
        int dis = Integer.MAX_VALUE;
        int ans = -1;
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        t=0;
        while(node2 != -1 && !hm1.containsKey(node2)){
            if(hm.containsKey(node2)){
                int curr = Math.max(t, hm.get(node2));
                if(dis>curr){
                    dis = curr;
                    ans = node2;
                }
                if(dis==curr && ans > node2) ans = node2;
            }
            hm1.put(node2, t);
            t++;
            node2 = edges[node2];
        }
        return ans;

    }
}