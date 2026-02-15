// class Solution {
//     public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
//         // code here
//         boolean[] vis = new boolean[adj.size()];
        
//         ArrayList<Integer> ans = ArrayList<>();
        
//         for(int i = 0; i<vis.length; i++) {
//             if(!vis[i]) {
//                 dfs(i,vis,adj,res);
//             }
//         }
//         return ans ;
        
//     }
//     public void dfs(int node, boolean[] vis, ArrayList<Integer> adj, ArrayList<Integer> ans) {
//         vis[node] = true;
//         res.add(node);
//         for(int neigh : adj.get(node)) {
//             if(!vis[neigh]) {
//                 dfs(neigh,vis,adj,res);
//             }
//         }
//     }
// }




class Solution {
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();              
        int[] vis = new int[V];          
        ArrayList<Integer> ans = new ArrayList<>();

        dfsHelper(0, adj, vis, ans);    
        return ans;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj,
                          int[] vis, ArrayList<Integer> ans) {

        vis[node] = 1;                   
        ans.add(node);                  

        for (int neigh : adj.get(node)) {
            if (vis[neigh] == 0) {
                dfsHelper(neigh, adj, vis, ans);
            }
        }
    }
     
}
