class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n > connections.length + 1) return -1;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<connections.length;i++){
            ds.union(connections[i][0], connections[i][1]);
        }
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(ds.findPar(i));
        }
        return s.size()-1;
    }
}

class DisjointSet {
    int[] par, size;
    DisjointSet(int n){
        par = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i] = 1;
        }
    }
    int findPar(int i){
        if(par[i]==i) return i;
        return par[i] = findPar(par[i]);
    }
    void union(int x, int y){
        int par_x = findPar(x);
        int par_y = findPar(y);
        if(par_x==par_y) return;
        if(size[par_x]>size[par_y]){
            par[par_y] = par_x;
            size[par_x] += size[par_y];
        }
        else{
            par[par_x] = par_y;
            size[par_y] += size[par_x];
        }
    }
}