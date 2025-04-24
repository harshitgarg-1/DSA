class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y <target ){return false;}
        while(x!=y){
            if(x>y) x = x-y;
            else y = y-x;
        }
        return target%x==0;
    }
}