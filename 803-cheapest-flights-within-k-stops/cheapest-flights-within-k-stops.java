import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, src});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currCost = curr[0];
            int currStops = curr[1];
            int currNode = curr[2];
            if (currStops > k) continue;
            for (int[] neighbor : adj.get(currNode)) {
                int nextNode = neighbor[0];
                int flightCost = neighbor[1];
                if (currCost + flightCost < price[nextNode]) {
                    price[nextNode] = currCost + flightCost;
                    q.add(new int[]{price[nextNode], currStops + 1, nextNode});
                }
            }
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}
