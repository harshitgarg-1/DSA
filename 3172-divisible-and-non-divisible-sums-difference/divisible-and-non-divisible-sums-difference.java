class Solution {
    public int differenceOfSums(int n, int m) {
        int x = (n*(n+1))/2;
        int a = n/m;
        int y = m*((a*(a+1))/2);
        return x - 2*y;
    }
}
