// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i<V; i++) {
            adjList.add(new ArrayList<Integer>());//create new ArrayList for each Node
        }
        
        //to change matrix to AdjList form 
        
        for(int i= 0; i<V; i++) {
            for(int j = 0; j<V; j++) {
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        //create visited array 
        int[] vis = new int[V+1];
        int count = 0;
        
        for(int i = 0; i<V; i++) {
            
            if(vis[i] == 0) {
                
                //increase count
                count++;
            
                dfs(i, adjList, vis);
            }
        }
        return count ;
    }
    
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int vis[]) {
        
        vis[node] = 1;
        
        for(int neigh : adjList.get(node)) {
            if(vis[neigh] == 0) {
                dfs( neigh, adjList, vis);
            }
        }
        
    }
}









