class Solution {
    int n;
    int []dp;
    int solve(int i, int[] a) {
        if (i >= n) return 0;

        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];

        dp[i] = a[i] - solve(i + 1, a);

        if (i + 1 < n)
            dp[i] = Math.max(dp[i],
                    a[i] + a[i + 1] - solve(i + 2, a));

        if (i + 2 < n)
            dp[i] = Math.max(dp[i],
                    a[i] + a[i + 1] + a[i + 2] - solve(i + 3, a));

        return dp[i];
    }
    public String stoneGameIII(int[] a) {
        n= a.length;
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int diff = solve(0, a);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
}