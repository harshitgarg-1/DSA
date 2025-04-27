class Solution {
    public int minNumberOperations(int[] target) {
        Stack <Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0, prev = 0;

        for (int num: target) {
            if (num > prev) {
                result += num - prev;
            }

            // while (num <= stack.peek()) {
            //     stack.pop();
            // }

            prev = num;
        }

        return result;
    }
}