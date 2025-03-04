class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(".")) arr[i] = "";
            if(arr[i].equals("..")){
                arr[i]="";
                int j = i-1;
                while(j>=0){
                    if(arr[j].length()>0){
                        arr[j] = "";
                        break;
                    }
                    j--;
                }
            }
        }
        String ans = "";
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>0){
                ans += "/";
                ans += arr[i];
            }
        }
        return ans.length()==0?"/":ans;
    }
}