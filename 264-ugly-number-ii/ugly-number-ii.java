class Solution {
    public int nthUglyNumber(int n) {
        int i=0, j=0, k=0;
        ArrayList<Integer> arr = new ArrayList<>();
        int ans = 1;
        arr.add(1);
        while(n>1){
            int x = arr.get(i)*2;
            int y = arr.get(j)*3;
            int z = arr.get(k)*5;
            arr.add(Math.min(x, Math.min(y,z)));
            if(x==arr.get(arr.size()-1)){
                i++;
            } 
            if(y==arr.get(arr.size()-1)){
                j++;
            } 
            if (z==arr.get(arr.size()-1)){
                k++;
            }
            n--;
        }
        return arr.get(arr.size()-1);
    }
}