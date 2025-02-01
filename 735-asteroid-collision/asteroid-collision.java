class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]==0) continue;
            if(st.isEmpty()|| asteroids[i]>=0 || (asteroids[i]<0 && st.peek()<0)) st.push(asteroids[i]);
            else{

                while(!st.isEmpty() && st.peek()>=0){
                    int x = -1*asteroids[i];
                    int e = st.pop();
                    if(e > x){
                        st.push(e);
                        break;
                    }
                    else if(e==x) break;
                    else if(st.isEmpty() || st.peek()<0){
                        st.push(asteroids[i]);
                        break;
                    }
                }
            }
        }
        int n = st.size();
        int[] ans = new int[n];
        n--;
        while(!st.isEmpty()){
            ans[n]=st.pop();
            n--;
        }
        return ans;
    }
}