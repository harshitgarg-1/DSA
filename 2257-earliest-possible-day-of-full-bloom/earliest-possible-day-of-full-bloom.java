class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Pair(plantTime[i], growTime[i]));
        }
        Collections.sort(arr, (p1, p2) -> {
            if(p1.gt==p2.gt) return p1.pt-p2.pt;
            return p2.gt-p1.gt;
        });
        int ans = 0;
        int daysPass = 0;
        for(Pair pair : arr){
            daysPass += pair.pt;
            ans = Math.max(daysPass+pair.gt+1, ans);
        }
        return ans-1;
    }
}

class Pair {
    int pt;
    int gt;
    Pair(int p, int g){
        pt = p;
        gt = g;
    }
}