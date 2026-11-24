class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    void dfs(int[][] a, boolean[][] vis, int i, int j, int prev) {
        int n = a.length;
        int m = a[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m ||
            vis[i][j] || a[i][j] < prev) {
            return;
        }

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + x[k];
            int nj = j + y[k];

            dfs(a, vis, ni, nj, a[i][j]);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        boolean[][] pvis = new boolean[n][m];
        boolean[][] avis = new boolean[n][m];

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dfs(a, pvis, i, 0, Integer.MIN_VALUE);
            dfs(a, avis, i, m - 1, Integer.MIN_VALUE);
        }

        for (int j = 0; j < m; j++) {
            dfs(a, pvis, 0, j, Integer.MIN_VALUE);
            dfs(a, avis, n - 1, j, Integer.MIN_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pvis[i][j] && avis[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}