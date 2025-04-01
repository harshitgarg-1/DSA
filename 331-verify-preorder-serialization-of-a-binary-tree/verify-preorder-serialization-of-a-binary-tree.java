class Solution {
    public boolean isValidSerialization(String preorder) {
        int req = 1;
        String[] s = preorder.split(",");
        int n = s.length;
        for(int i=0;i<n;i++){
            String s1 = s[i];
            if(s1.equals("#")) req--;
            else req++;
            if(i != n-1 && req==0) return false;
        }
        return req==0;
    }
}