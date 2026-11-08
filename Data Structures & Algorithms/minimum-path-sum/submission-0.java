
class Solution {
    int dp[][];

    int solve(int i, int j, int n, int m, int[][] a) {

        if(i >= n || j >= m)
            return Integer.MAX_VALUE;

        if(i == n-1 && j == m-1)
            return a[i][j];

        if(dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i, j+1, n, m, a);
        int down = solve(i+1, j, n, m, a);

        return dp[i][j] = a[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, n, m, a);
    }
}
