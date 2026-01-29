
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
