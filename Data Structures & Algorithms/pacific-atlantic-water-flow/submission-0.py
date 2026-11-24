class Solution:
    def pacificAtlantic(self, heights):
        n = len(heights)
        m = len(heights[0])

        pvis = [[False] * m for _ in range(n)]
        avis = [[False] * m for _ in range(n)]

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(i, j, vis, prev):
            if (i < 0 or j < 0 or i >= n or j >= m or
                vis[i][j] or heights[i][j] < prev):
                return

            vis[i][j] = True

            for dx, dy in directions:
                ni = i + dx
                nj = j + dy

                dfs(ni, nj, vis, heights[i][j])

        # Pacific: Top and Left
        for i in range(n):
            dfs(i, 0, pvis, float('-inf'))

        for j in range(m):
            dfs(0, j, pvis, float('-inf'))

        # Atlantic: Bottom and Right
        for i in range(n):
            dfs(i, m - 1, avis, float('-inf'))

        for j in range(m):
            dfs(n - 1, j, avis, float('-inf'))

        res = []

        for i in range(n):
            for j in range(m):
                if pvis[i][j] and avis[i][j]:
                    res.append([i, j])

        return res