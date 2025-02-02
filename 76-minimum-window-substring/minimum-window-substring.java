class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[256];
        int count = 0;
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i)]++;
            count++;
        }
        int l = 0, size= s.length()+1, start = 0;
        for(int i=0;i<s.length();i++){
            //System.out.println(i + " " + start + " " + size + " " + count);
            char c = s.charAt(i);
            if(arr[c]>0) count--;
            arr[c]--;
            if(count == 0){
                if(size > i-l+1){
                    start = l;
                    size = i-l+1;
                }
                while(count==0){
                    char c1 = s.charAt(l);
                    arr[c1]++;
                    l++;
                    if(arr[c1]>0) count++;
                    else{
                        if(size > i-l+1){
                            start = l;
                            size = i-l+1;
                        }
                    }
                }
            }
        }
        return start+size>s.length()? "" : s.substring(start, start+size);
    }
}