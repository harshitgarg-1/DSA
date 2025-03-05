class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int xc = 0, yc = 0;
        if(!(ax1>bx2 || ax2<bx1)){
            xc = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        }
        if(!(ay1>by2 || ay2<by1)){
            yc = Math.min(ay2, by2) - Math.max(ay1, by1);
        }
        return Math.abs((ax2-ax1)*(ay2-ay1)) + Math.abs((bx2-bx1)*(by2-by1)) - Math.abs(xc*yc);
    }
}