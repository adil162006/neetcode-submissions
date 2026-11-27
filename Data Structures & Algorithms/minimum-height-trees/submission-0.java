
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            res.add(0);
            return res;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            indeg[u]++;
            indeg[v]++;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int s = q.size();
            n -= s;

            while (s-- > 0) {
                int val = q.poll();

                for (int v : adj.get(val)) {
                    indeg[v]--;

                    if (indeg[v] == 1) {
                        q.offer(v);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            res.add(q.poll());
        }

        return res;
    }
}
