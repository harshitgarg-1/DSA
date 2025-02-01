class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = nums2.length;
        for(int i=n-1;i>=0;i--){
            while(st.peek() != -1 && st.peek()<nums2[i]){
                st.pop();
            }
            hm.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = hm.get(nums1[i]);
        }
        return nums1;
    }
}