class Solution {
public:
    int x[4] = {-1, 1, 0, 0};
    int y[4] = {0, 0, -1, 1};

    void dfs(vector<vector<int>>& a, vector<vector<bool>>& vis,
             int i, int j, int prev) {

        int n = a.size();
        int m = a[0].size();

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

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& a) {
        int n = a.size();
        int m = a[0].size();

        vector<vector<bool>> pvis(n, vector<bool>(m, false));
        vector<vector<bool>> avis(n, vector<bool>(m, false));

        vector<vector<int>> res;

        for (int i = 0; i < n; i++) {
            dfs(a, pvis, i, 0, INT_MIN);
            dfs(a, avis, i, m - 1, INT_MIN);
        }

        for (int j = 0; j < m; j++) {
            dfs(a, pvis, 0, j, INT_MIN);
            dfs(a, avis, n - 1, j, INT_MIN);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pvis[i][j] && avis[i][j]) {
                    res.push_back({i, j});
                }
            }
        }

        return res;
    }
};