class Solution {
    public int find(int parent[], int x) {
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    public boolean union(int parent[], int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        
        if(pu == pv) {
            return true;
        }
        
        parent[pu] = pv;
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        int parent[] = new int[V];
        
        for(int i = 0; i<V; i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if(union(parent, u, v)){
                return true;
            }
        }
        
        return false;
        
    }}