class Solution {
    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length, low = 1, high = arr[0], ans = 0;
        if(n > limit) return -1;
        high = arr[0];
        for (int i = 0; i < n; i++) {
            high = Math.max(high, arr[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
                ans=mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int sumByD(int[] arr, int div) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }
}