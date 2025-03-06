class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        int u,max=0;
        if(x>y){u=x;}else{u=y;}
        if(x+y <target ){return false;}

        //gcd
       for(int i=1;i<=u;i++)
       {
           if(x%i==0&&y%i==0)
           {
               max=Math.max(i,max);
           }
       }
       if(target%max==0){return true;}


        
        return false;
    }
}