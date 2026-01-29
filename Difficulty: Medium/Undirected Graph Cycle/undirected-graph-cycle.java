class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        // Code here
        int[] par = new int[V];
        int[] vis = new int[V];
        for(int i = 0; i<V; i++) {
            par[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        
       
        for(int i = 0; i<V; i++) {
            if(vis[i] == 0) {
                
                 q.add(i);
                 vis[i] = 1;
                 par[i] = -1;
                
               while(!q.isEmpty()) {
                    int node = q.poll();
            
                    for(int neigh :adj.get(node) ) {
                        if(vis[neigh] == 0) {
                        q.add(neigh);
                        vis[neigh] = 1;
                        par[neigh] = node;
                    }
                    // else if(vis[neigh] == 1 && neigh == par[node]) {
                    // //nothing
                    // }
                    else if(neigh != par[node]){
                        return true;
                     }
            }
        } 
            }
        }
        
        
        return false;
    }
}














// class Solution {
//     public boolean isCycle(int V, int[][] edges) {

//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i < V; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for(int[] e : edges) {
//             adj.get(e[0]).add(e[1]);
//             adj.get(e[1]).add(e[0]);
//         }

//         int vis[] = new int[V];
//         int par[] = new int[V];

//         Queue<Integer> q = new LinkedList<>();

//         // Check for every component
//         for(int i = 0; i < V; i++) {

//             if(vis[i] == 0) {   // new component

//                 q.add(i);
//                 vis[i] = 1;
//                 par[i] = -1;

//                 while(!q.isEmpty()) {
//                     int node = q.poll();

//                     for(int neigh : adj.get(node)) {

//                         if(vis[neigh] == 0) {   // not visited
//                             vis[neigh] = 1;
//                             par[neigh] = node;
//                             q.add(neigh);
//                         }
//                         else if(neigh != par[node]) {
//                             // visited but NOT parent → cycle found
//                             return true;
//                         }
//                     }
//                 }
//             }
//         }

//         return false; // no cycle in any component
//     }
// }