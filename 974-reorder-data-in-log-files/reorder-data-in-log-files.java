class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<Pair> arr = new ArrayList<>();
        int n = logs.length;
        for(int i=0;i<n;i++){
            String s = logs[i];
            int j=0;
            for(j=0;j<s.length();j++){
                if(s.charAt(j)==' ') break;
            }
            if(s.charAt(j+1)-'a'>=0 && s.charAt(j+1)-'a'<26){
                arr.add(new Pair(s.substring(0, j), s.substring(j+1)));
                logs[i]="";
            }

        }
        Collections.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                int logComparison = p1.log.compareTo(p2.log);
                
                if (logComparison == 0) {
                    return p1.identifier.compareTo(p2.identifier);
                }
                return logComparison;
            }
        });
        String[] ans = new String[n];
        int k=0;
        for(int i=0;i<arr.size();i++){
            ans[k] = arr.get(i).identifier + " " + arr.get(i).log;
            k++;
        }
        for(int i=0;i<n;i++){
            if(logs[i] != ""){
                ans[k] = logs[i];
                k++;
            }
        }
        return ans;
    }
}

class Pair {
    String identifier;
    String log;
    Pair(String i, String l){
        identifier = i;
        log = l;
    }
}