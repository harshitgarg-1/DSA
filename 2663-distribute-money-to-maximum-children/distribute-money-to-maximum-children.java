class Solution {
    public int distMoney(int money, int children) {
        money = money - children;
        if(money < 0) return -1;
        int max = money/7;
        max = Math.min(max, children);
        money = money - 7*max;
        if((money == 3 && max == children-1) || (money>0 && max == children)) max--;
        return max<0?0:max;
    }
}