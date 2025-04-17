class Solution {
    public int minOperations(int n, int m) {
         if(!notPrime(n) || !notPrime(m) ){
            return -1;
        } 
        if(n==m){
            return n;
        }
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        Set<Integer> set = new HashSet<>();
        pq.add(new int[] { n, n });
        set.add(n);
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int temp = curr[0];
            int idx = 0;
            while (temp != 0) {
                int dig = temp % 10;
                if (dig != 0) { // reduce
                    int n1 = curr[0] - (int) Math.pow(10, idx);
                    if (n1 == m) {
                        return curr[1] + n1;
                    }
                    if (!set.contains(n1) && notPrime(n1)) {
                        set.add(n1);
                        pq.add(new int[] { n1, curr[1] + n1 });
                    }
                }
                if (dig != 9) { //increase
                    int n1 = curr[0] + (int) Math.pow(10, idx);
                    if (n1 == m) {
                        return curr[1] + n1;
                    }
                    if (!set.contains(n1) && notPrime(n1)) {
                        set.add(n1);
                        pq.add(new int[] { n1, curr[1] + n1 });
                    }
                }
                idx++;
                temp /= 10;
            }
        }
        return -1;

    }

    private boolean notPrime(int n) {
        if ( n == 2 || n == 3 || n == 5) {
            return false;
        }
        if (n==1 || n % 2 == 0 || n % 3 == 0 || n % 5 == 0) {
            return true;
        }
        for (int i = 7; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}