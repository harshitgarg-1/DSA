class Solution {
        public int shortestSequence(int[] A, int k) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int a : A) {
            s.add(a);
            if (s.size() == k) {
                res++;
                s.clear();
            }
        }
        return res+1;
    }
}