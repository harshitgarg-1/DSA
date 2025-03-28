class Solution {
    public int totalFruit(int[] fruits) {
        int ans=0,f1=-1,f2=-1,b1=0,b2=0,i=0,j=0,n=fruits.length;
        while(j<n){
            if(b1==0 || fruits[j]==f1){
                b1++;
                f1=fruits[j];
                j++;
                ans = Math.max(ans, b1+b2);
                continue;
            }
            if(b2==0 || fruits[j]==f2){
                b2++;
                f2=fruits[j];
                j++;
                ans = Math.max(ans, b1+b2);
                continue;
            }
            while(b1!=0 && b2!=0){
                if(fruits[i]==f1){
                    b1--;
                }
                if(fruits[i]==f2){
                    b2--;
                }
                i++;
            }
        }
        return ans;
    }
}