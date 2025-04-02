class Solution {
    public boolean checkPowersOfThree(int n) {
        if(n%3!=0) return find(n-1);
        return find(n);
    }
    public boolean find(int n){
        while(n>0){
            if(n%3!=0) return false;
            while(n%3==0){
                n=n/3;
            }
            n--;
        }
        return true;
    }
}