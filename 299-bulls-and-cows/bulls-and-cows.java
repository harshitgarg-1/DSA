class Solution {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        for(char c : secret.toCharArray()){
            arr[c-'0']++;
        }
        int bull = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                arr[secret.charAt(i)-'0']--;
                bull++;
            }
        }
        int cow=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                if(arr[guess.charAt(i)-'0']>0){
                arr[guess.charAt(i)-'0']--;
                cow++;}
            }
        }
        return "" + bull+"A"+cow+"B";
    }
}