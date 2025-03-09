class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        ArrayList<Pair> arr = new ArrayList<>();
        int n = nums1.length;
        for(int i=0;i<n;i++){
            arr.add(new Pair(nums1[i], nums2[i], i));
        }
        Collections.sort(arr, (Pair p1, Pair p2) -> p1.n1-p2.n1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long[] ans = new long[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            Pair p = arr.get(i);
            if(i>0 && p.n1 == arr.get(i-1).n1){
                ans[p.i] = ans[arr.get(i-1).i];
            } else {
                ans[p.i] = sum;
            }
            System.out.println(p.n1 + " " + p.n2 + " " + p.i + " " + sum);
            if(i>=k && pq.peek()<p.n2){
                sum -= pq.poll();
                pq.add(p.n2);
                sum += p.n2;
            } else if (i<k){
                pq.add(p.n2);
                sum += p.n2;
            }
        }
        return ans;
    }
}

class Pair {
    int n1;
    int n2;
    int i;
    Pair(int n1, int n2, int i){
        this.n1 = n1;
        this.n2 = n2;
        this.i = i;
    }
}