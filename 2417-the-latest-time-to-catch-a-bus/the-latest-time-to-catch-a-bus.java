class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int last = -1;
        int ans=0,j=0;
        for(int i=0;i<buses.length;i++){
            int c = 0;
            while(j<passengers.length && c<capacity && passengers[j]<=buses[i]){
                if(last != passengers[j]-1){
                    ans=passengers[j]-1;
                }
                last = passengers[j];
                j++; c++;
            }
            if(c<capacity && last != buses[i]){
                ans = buses[i];
            }
        }
        return ans;
    }
}