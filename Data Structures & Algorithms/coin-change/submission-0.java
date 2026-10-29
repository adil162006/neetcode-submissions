
class Solution {
    int[][] t;

    int solve(int idx, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (idx == 0) return Integer.MAX_VALUE - 1;

        if (t[idx][amount] != -1) {
            return t[idx][amount];
        }

        int skip = solve(idx - 1, coins, amount);

        int take = Integer.MAX_VALUE - 1;

        if (coins[idx - 1] <= amount) {
            take = 1 + solve(idx, coins, amount - coins[idx - 1]);
        }

        return t[idx][amount] = Math.min(skip, take);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        if (amount == 0) return 0;

        t = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], -1);
        }

        int ans = solve(n, coins, amount);

        return ans >= Integer.MAX_VALUE - 1 ? -1 : ans;
    }
}