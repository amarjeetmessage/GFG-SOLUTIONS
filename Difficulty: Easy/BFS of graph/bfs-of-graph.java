class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[adj.size()];
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int curr = q.peek();
            q.remove();
            ans.add(curr);
            
            for(int neigh : adj.get(curr)) {
                if(!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        
        return ans;
    }
}

