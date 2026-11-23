
class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<int[]> edges = new ArrayList<>();

        // Generate all edges
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0])
                         + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{dist, i, j});
            }
        }

        // Sort by weight
        edges.sort((a, b) -> a[0] - b[0]);

        int cost = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {
            int wt = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (find(u) != find(v)) {
                union(u, v);
                cost += wt;
                edgesUsed++;

                if (edgesUsed == n - 1)
                    break;
            }
        }

        return cost;
    }
}