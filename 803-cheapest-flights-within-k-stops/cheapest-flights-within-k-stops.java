class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, 10000000);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, src});
        price[src] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[1]>k) continue;
            for(int[] neb : adj.get(curr[2])){
                int des = neb[0];
                int p = neb[1];
                if(price[des]>p+curr[0]){
                    price[des] = p+curr[0];
                    q.add(new int[]{price[des], curr[1]+1, des});
                }
            }
        }
        return price[dst] == 10000000 ? -1 : price[dst];
    }
}