class Solution {
    class Pair {
    public:
        int effort;
        int row;
        int col;

        Pair(int effort, int row, int col) {
            this->effort = effort;
            this->row = row;
            this->col = col;
        }
    };

    bool valid(int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) return false;
        return true;
    }

public:
    int minimumEffortPath(vector<vector<int>>& a) {
        int n = a.size();
        int m = a[0].size();

        vector<vector<int>> res(n, vector<int>(m, INT_MAX));

        priority_queue<Pair, vector<Pair>, 
            function<bool(Pair, Pair)>> pq(
                [](Pair ar, Pair b) {
                    return ar.effort > b.effort;
                }
            );

        res[0][0] = 0;
        pq.push(Pair(0, 0, 0));

        int x[] = {1, -1, 0, 0};
        int y[] = {0, 0, 1, -1};

        while (!pq.empty()) {
            Pair curr = pq.top();
            pq.pop();

            int effort = curr.effort;
            int row = curr.row;
            int col = curr.col;

            if (effort > res[row][col]) continue;

            for (int k = 0; k < 4; k++) {
                int r = row + x[k];
                int c = col + y[k];

                if (!valid(r, c, n, m)) continue;

                int absdiff = abs(a[row][col] - a[r][c]);
                int newEff = max(absdiff, effort);

                if (newEff < res[r][c]) {
                    res[r][c] = newEff;
                    pq.push(Pair(newEff, r, c));
                }
            }
        }

        return res[n - 1][m - 1];
    }
};