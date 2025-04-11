class Solution {
        public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,new Comparator<int[]>(){
                    public int compare(int[] a,int[] b){
                        if((a[1] - a[0]) > (b[1] - b[0]))
                            return -1;
                        else return 1;
                    }
                    });
        int initial = tasks[0][1];
        int cur = initial;
        for(int i[] : tasks){
            if(cur >= i[1]){
                cur -= i[0];
            }
            else{
                initial = initial + i[1] - cur;
                cur = i[1]-i[0];
            }
        } 
        return initial;
        
    }
}

