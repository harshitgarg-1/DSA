class Solution {
    public int minNumberOperations(int[] target) {
        Stack <Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;

        for (int num: target) {
            if (num > stack.peek()) {
                result += num - stack.peek();
            }

            while (num <= stack.peek()) {
                stack.pop();
            }

            stack.push(num);
        }

        return result;
    }
}