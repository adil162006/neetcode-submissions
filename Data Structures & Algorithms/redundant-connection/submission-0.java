
class Solution {

    int[] rank;
    int[] parent;

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        rank = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];

            if (find(s) == find(d)) {
                return new int[]{s, d};
            }

            union(s, d);
        }

        return new int[]{-1, -1};
    }
}
