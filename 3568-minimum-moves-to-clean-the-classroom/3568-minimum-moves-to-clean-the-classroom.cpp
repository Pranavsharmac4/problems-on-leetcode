class Solution {
public:
    int minMoves(vector<string>& classroom, int energy) {
        int m = classroom.size();
        int n = classroom[0].size();

        vector<vector<int>> id(m, vector<int>(n, -1));

        int k = 0;
        int sr = 0, sc = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (classroom[r][c] == 'S') {
                    sr = r;
                    sc = c;
                } else if (classroom[r][c] == 'L') {
                    id[r][c] = k++;
                }
            }
        }

        if (k == 0) return 0;

        int totalMask = (1 << k) - 1;

        vector<vector<vector<int>>> best(
            m, vector<vector<int>>(n, vector<int>(1 << k, -1))
        );

        struct State {
            int r, c, mask, e, moves;
        };

        queue<State> q;

        best[sr][sc][0] = energy;
        q.push({sr, sc, 0, energy, 0});

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        while (!q.empty()) {
            State cur = q.front();
            q.pop();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (classroom[nr][nc] == 'X')
                    continue;

                int ne = cur.e - 1;

                if (ne < 0)
                    continue;

                int nmask = cur.mask;

                if (classroom[nr][nc] == 'R') {
                    ne = energy;
                }

                if (classroom[nr][nc] == 'L') {
                    nmask |= (1 << id[nr][nc]);
                }

                if (nmask == totalMask) {
                    return cur.moves + 1;
                }

                if (ne <= best[nr][nc][nmask])
                    continue;

                best[nr][nc][nmask] = ne;

                q.push({nr, nc, nmask, ne, cur.moves + 1});
            }
        }

        return -1;
    }
};