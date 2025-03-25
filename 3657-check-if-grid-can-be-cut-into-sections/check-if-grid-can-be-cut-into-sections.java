class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        ArrayList<int[]> xAxis = new ArrayList<>();
        ArrayList<int[]> yAxis = new ArrayList<>();
        for(int[] rectangle : rectangles){
            xAxis.add(new int[]{rectangle[0],rectangle[2]});
            yAxis.add(new int[]{rectangle[1],rectangle[3]});
        }
        Collections.sort(xAxis, (int[] x1, int[] x2) -> x1[0]-x2[0]);
        Collections.sort(yAxis, (int[] y1, int[] y2) -> y1[0]-y2[0]);
        return checkValidCuts(n, xAxis) || checkValidCuts(n, yAxis);
    }

    public boolean checkValidCuts(int n, ArrayList<int[]> axis){
        int prev = axis.get(0)[1], count=0;
        for(int i =1;i<axis.size();i++){
            if(axis.get(i)[0]<prev){
                prev = Math.max(prev, axis.get(i)[1]);
            } else {
                prev = axis.get(i)[1];
                count++;
            }
        }
        return count >= 2;

    }
}
// [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]

// 0-2,1-3,2-3,3-4,3-4

// 0-2,0-2, 2-4,2-4,2-4