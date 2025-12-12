class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(expression.charAt(i)==')'){
                int t = 0, f = 0;
                while(st.peek()!='('){
                    if(st.pop()=='t') t++;
                    else f++;
                }
                st.pop();
                Character op = st.pop();
                if(op == '&'){
                    if(f>0) st.push('f');
                    else st.push('t');
                } else if(op == '|'){
                    if(t>0) st.push('t');
                    else st.push('f');
                } else {
                    if(t>0) st.push('f');
                    else st.push('t');
                }
            } else if(expression.charAt(i)!=','){
                st.push(expression.charAt(i));
            }
        }
        if(st.peek()=='t') return true;
        return false;
    }
}