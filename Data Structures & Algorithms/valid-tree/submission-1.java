class Solution {
    boolean cycle = false;
    void solve(ArrayList<ArrayList<Integer>>adj,int node,int parent,boolean[]vis){
        vis[node]=true;
        
        for(int val : adj.get(node)){
            if(vis[val] && val!=parent)cycle = true;
            if(!vis[val]){
                solve(adj,val,node,vis);
            }
        }
    }
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]vis=new boolean[n];
        solve(adj,0,-1,vis);
        for(int i=0;i<n;i++){
            if(!vis[i])return false;
        }
        return cycle?false:true;
    }
}
