public class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> elementFrequency = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.size(); right++) {
            int currentElement = nums.get(right);

            elementFrequency.put(currentElement, elementFrequency.getOrDefault(currentElement, 0) + 1);
            currentSum += currentElement;

            while (right - left + 1 > k) {
                int leftElement = nums.get(left);

                elementFrequency.put(leftElement, elementFrequency.get(leftElement) - 1);
                if (elementFrequency.get(leftElement) == 0) {
                    elementFrequency.remove(leftElement);
                }
                currentSum -= leftElement;

                left++;
            }

            if (elementFrequency.size() >= m) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}