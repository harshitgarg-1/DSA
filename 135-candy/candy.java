class Solution {
    public int candy(int[] ratings) {
        int sum = 1, max = 1, n = ratings.length, i=1, prev = 1;
        while(i<n){
            if(ratings[i]>ratings[i-1]){
                max = prev+1;
                sum+=max;
                prev = max;
                i++;
            } else if(ratings[i]==ratings[i-1]){
                max = 1;
                sum++;
                prev = 1;
                i++;
            } else {
                prev = 0;
                while(i<n && ratings[i]<ratings[i-1]){
                    prev++;
                    sum+=prev;
                    i++;
                }
                sum -= max;
                sum += Math.max(max, prev+1);
                prev = 1;
            }
        }
        return sum;
    }
}