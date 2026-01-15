class Solution {

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        
        for(int i = 0; i<V; i++) {
            if(!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                
                q.add(i);
                visited[i] = true;
                
                while(!q.isEmpty()) {
                    int node = q.poll();
                    component.add(node);
                    
                    for(int neighbour : adj.get(node)) {
                        if(!visited[neighbour]) {
                            visited[neighbour] = true;
                            q.add(neighbour);
                        }
                    }
                }
                ans.add(component);
            }
        }
        return ans;
    }
}
