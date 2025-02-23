class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuffer sbf = new StringBuffer(s);
        sbf.reverse();
        String s1 = sbf.toString();
        //int[] arr = zFxn(s+"&"+s1);
        int[] arr1 = buildPrefixTable(s+"&"+s1);
        int max = arr1[2*n];
        String ans = "";
        for(int i=n-1;i>=max;i--){
            ans += s.charAt(i);
        }
        ans+=s;
        return ans;


    }
    public int[] zFxn(String s){
        int n = s.length();
        int[] arr = new int[n];
        int l = 0, r = 0;
        for(int i=1;i<n;i++){
            if(i>r){
                l=i;
                r=i;
                while(r<n && s.charAt(r)==s.charAt(r-l)) r++;
                arr[i] = r-l;
                r--;
            } else {
                int k = i-l;
                if(arr[k]<r-i+1){
                    arr[i] = arr[k];
                } else {
                    l=i;
                    while(r<n && s.charAt(r)==s.charAt(r-l)) r++;
                    arr[i] = r-l;
                    r--;
                }
            }
        }
        return arr;
    }

    private int[] buildPrefixTable(String s) {
        int[] prefixTable = new int[s.length()];
        int length = 0;
        for (int i = 1; i < s.length(); i++) {
            while (length > 0 && s.charAt(i) != s.charAt(length)) {
                length = prefixTable[length - 1];
            }
            if (s.charAt(i) == s.charAt(length)) {
                length++;
            }
            prefixTable[i] = length;
        }
        return prefixTable;
    }
}