class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> degree = new ArrayList<>();
        int x = location.get(0);
        int y = location.get(1);
        int origin = 0;
        for(List<Integer> point : points){
            if(point.get(0)==x && point.get(1)==y) {
                origin++;
                continue;
            }
            degree.add(Math.toDegrees(Math.atan2(point.get(1)-y, point.get(0)-x)));
        }
        Collections.sort(degree);
        int n = degree.size();
        for(int i=0;i<n;i++){
            degree.add(360+degree.get(i));
        }
        int ans = 1;
        if(degree.size()==0) ans=0;
        int i=0,j=1;
        while(j<degree.size()){
            while(degree.get(j)-degree.get(i)>angle) i++;
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans+origin;

    }
}