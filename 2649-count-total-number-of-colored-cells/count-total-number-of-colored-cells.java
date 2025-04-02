class Solution {
    public long coloredCells(int n) {
        return 1 + 4L * n * (n - 1) / 2;
    }
}
// 1  1
// 2  1 + 4
// 3  1 + 4 + 8
// 4  1 + 4 + 8 + 12
