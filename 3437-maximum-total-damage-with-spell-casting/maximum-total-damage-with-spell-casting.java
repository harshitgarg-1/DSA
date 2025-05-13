class Solution {
    public long maximumTotalDamage(int[] power){
        TreeMap<Integer , Long> dp = new TreeMap<>();
        for(int P : power) dp.put(P , dp.getOrDefault(P , 0L) + P);

        long maxi = 0 , last = 0;

        for(int P : dp.keySet()){
            Map.Entry<Integer , Long> it = dp.floorEntry(P - 3);
            if(it != null) dp.put(P , dp.get(P) + it.getValue());
            dp.put(P, last = Math.max(dp.get(P) , last));
            maxi = Math.max(maxi , last);
        }

        return maxi;
    }
}