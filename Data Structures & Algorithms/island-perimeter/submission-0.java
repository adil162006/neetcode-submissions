
class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    int ans;

    boolean valid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    void solve(int i, int j, int n, int m, int[][] a, boolean[][] vis) {
        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int r = x[k] + i;
            int c = y[k] + j;

            if (!valid(r, c, n, m) || a[r][c] == 0) {
                ans++;
            }
            else if (!vis[r][c]) {
                solve(r, c, n, m, a, vis);
            }
        }
    }

    public int islandPerimeter(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        boolean[][] vis = new boolean[n][m];
        ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1 && !vis[i][j]) {
                    solve(i, j, n, m, a, vis);
                }
            }
        }

        return ans;
    }
}
