class Solution {
    public int divide(int dividend, int divisor) {
        int neg = 1;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) neg = -1;
        long ans =0;
        long dvd = dividend, dvs = divisor;
        if(dvd<0)dvd = dvd*-1;
        if(dvs<0)dvs = dvs*-1;

        // while(dvd>=dvs){
        //     int bit=0;
        //     while((dvs<<bit)<=dvd){
        //         bit++;
        //     }
        //     bit--;
        //     ans += (long)1<<bit;
        //     dvd -= dvs<<bit;
        // }
        ans = dvd/dvs;
        if(ans >= Integer.MAX_VALUE && neg==1) return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && neg==-1) return Integer.MIN_VALUE;
        return (int) ans*neg;
    }
}