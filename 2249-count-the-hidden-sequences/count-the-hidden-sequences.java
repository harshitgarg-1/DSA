class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int l = 0, u = 0;
        int curr = 0;
        for(int diff : differences){
            curr += diff;
            l = Math.min(l, curr);
            u = Math.max(u, curr);
            if(u-l > upper-lower) return 0;

        }
        lower -= l;
        upper -= u;
        int ans = 0;
        if(lower<=upper) ans = upper-lower+1;
        return ans;
    }
}

