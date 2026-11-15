
class Solution {
    boolean res = true;

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis,
             int[] path, int node) {

        vis[node] = true;
        path[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int neigh = adj.get(node).get(i);

            if (vis[neigh] && path[neigh] == 1) {
                res = false;
                return;
            }

            if (!vis[neigh]) {
                dfs(adj, vis, path, neigh);
            }
        }

        path[node] = 0;
    }

    public boolean canFinish(int v, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        boolean[] vis = new boolean[v];
        int[] path = new int[v];

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int src = edge[1];
            int dest = edge[0];

            adj.get(src).add(dest);
        }

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, vis, path, i);
            }
        }

        return res;
    }
}
