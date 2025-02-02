class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0, ans = 0, l=0, r=n-1;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        l=k-1;
        ans = sum;
        while(l>=0){
            sum = sum - cardPoints[l] + cardPoints[r];
            l--;
            r--;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}