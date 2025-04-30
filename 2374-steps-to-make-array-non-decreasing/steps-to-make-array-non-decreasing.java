class Solution {
    public int totalSteps(int[] nums) {
    LinkedList<int[]> stack = new LinkedList<>();
    int max = 0;
    
    for(int num : nums) {
        int score = 0;

        // Pop elements from stack while current num is >= top of stack
        while(stack.size() > 0 && stack.getLast()[0] <= num) {
            score = Math.max(score, stack.removeLast()[1]);
        }

        // Push current element with updated score
        stack.add(new int[]{num, stack.size() == 0 ? 0 : score + 1});

        // Track the maximum score across all elements
        max = Math.max(max, stack.getLast()[1]);
    }

    return max;
}

}