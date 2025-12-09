class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] vis = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(checkCycle(i, adjList, vis, st)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, Stack<Integer> st){
        vis[node] = 2;
        for(int neb : adjList.get(node)){
            if(vis[neb]==2) return true;
            if(vis[neb]==0 && checkCycle(neb, adjList, vis, st)){
                return true;
            }
        }
        vis[node] = 1;
        st.push(node);
        return false;
    }
}