class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0, prev = -1, rem = 0;
        Arrays.sort(answers);
        for(int i=0;i<answers.length;i++){
            if(prev != answers[i] || rem == 0){
                ans += answers[i]+1;
                rem = answers[i];
                prev = answers[i];
                continue;
            }
            rem--;  
        }
        return ans;
    }
}