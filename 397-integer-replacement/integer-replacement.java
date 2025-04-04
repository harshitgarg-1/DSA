class Solution {
    public int integerReplacement(int n) {
        return replacement(n);
    }
    public int replacement(long n) {
        if(n==1) return 0;
        if(n%2==0) return 1 + replacement(n/2);
        return 1 + Math.min(replacement(n-1),replacement(n+1));
    }
}