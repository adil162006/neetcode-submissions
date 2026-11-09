class Solution:
    def numDistinct(self, s: str, t: str) -> int:

        n = len(s)
        m = len(t)

        dp = [[-1] * (m + 1) for _ in range(n + 1)]

        def solve(i, j):

            if j == m:
                return 1

            if i == n:
                return 0

            if dp[i][j] != -1:
                return dp[i][j]

            skip = solve(i + 1, j)

            take = 0
            if s[i] == t[j]:
                take = solve(i + 1, j + 1)

            dp[i][j] = skip + take

            return dp[i][j]

        return solve(0, 0)