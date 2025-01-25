class Solution {
    public boolean isIsomorphic(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        if(n1!=n2) return false;
        HashMap<Character, Character> hm = new HashMap<>();
        for(int i=0;i<n1;i++){
            if(hm.containsKey(str1.charAt(i))){
                if(hm.get(str1.charAt(i))!=str2.charAt(i)) return false;
            }
            else{
                hm.put(str1.charAt(i),str2.charAt(i));
            }
        }
        HashMap<Character, Character> hm1 = new HashMap<>();
        for(int i=0;i<n1;i++){
            if(hm1.containsKey(str2.charAt(i))){
                if(hm1.get(str2.charAt(i))!=str1.charAt(i)) return false;
            }
            else{
                hm1.put(str2.charAt(i),str1.charAt(i));
            }
        }
        return true;
        
    }
}