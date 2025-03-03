class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int req = 0, index = -1, giving = 0;
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i] && index == -1){
                index = i;
            }
            if(index != -1) giving += gas[i] - cost[i];
            req += gas[i] - cost[i];
            if(giving<0){
                index = -1;
                giving=0;
            }
        }
        if(req<0) return -1;
        return index;
    }
}