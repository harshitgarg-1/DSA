class Solution {
    public static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
         List < List < String >> ans = new ArrayList < > ();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            String str1 = strs[i];
            String str2 = sortString(str1);
            if(!hm.containsKey(str2)) hm.put(str2, new ArrayList<>());
            ArrayList<String> arr = hm.get(str2);
            arr.add(str1);
        }
        for (Map.Entry<String,ArrayList<String>> entry : hm.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}