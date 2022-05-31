package Atlassian;

public class Q5 {
    /*
    You are given an integer square grid which can be divided into square sub-grids.
    The sub-grid sum is obtained by adding all elements of the sub-grid.
    Determine the maximum size of a square sub-grid such that all sub-grids of this
    size must have sub-grid sum less than or equal to a given value(maxSum).
    Return the size of that sub-grid (size = number of rows or columns).

    e.g.

    A 3x3 grid is provided.
    grid =
    [[2,2,2],
     [3,3,3],
     [4,4,4]]
    maxSum: sub-grid sum must be less than or equal to this integer value

    Square sub-grids of size 1, the maxSum = 4
    If 4 <= maxSum < 14, answer = 1

    Square sub-grids of size 2, the maxSum = 14
    If 14 <= maxSum < 27, answer = 2

    Square sub-grids of size 3, the maxSum = 27

    If maxSum < 4, no square sub-grid that satisfies the condition.

    ----------------------------------------------------
    Sample Input 0:
    3
    3
    1 1 1
    1 1 1
    1 1 1
    4

    Sample Output 0:
    2

    Since each square sub-grid of size 2 has a sum of 4, and the only square sub-grid of
    size 3 has a sum of 9.
    -------------------------------------------------------

    Sample Input 1
    4
    4
    1 1 1 1
    2 2 2 2
    3 3 3 3
    4 4 4 4
    39

    Sample Output 1
    3

    Since each square sub-grid of size 3 has a sum of 27, and for 4x4 is 40.
    ---------------------------------------------------------

    Sample Input 2
    2
    2
    4 5
    6 7
    2

    Sample Output 2
    0

    All 1x1 sub-grids have a sum > 2, so the answer is 0.
     */
    public static int largestSubgrid(int[][] grid, int maxSum) {
        int n = grid.length;
        int[][] sum = new int[n][n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sum[0][0] = grid[0][0];
                }
                else if (i == 0) {
                    sum[0][j] = sum[0][j - 1] + grid[0][j];
                }
                else if (j == 0) {
                    sum[i][0] = sum[i - 1][0] + grid[i][0];
                }
                else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + grid[i][j] - sum[i - 1][j - 1];
                }
                mx = Math.max(mx, grid[i][j]);
            }
        }
        int ans = 0;
        int l = 0, r = n;
        while (l < r) {
            int x = l + (r - l + 1) / 2;
            int res = 0;
            for (int i = x - 1; i < n; i++) {
                for (int j = x - 1; j < n; j++) {
                    int total = sum[i][j];
                    if (i >= x) total -= sum[i - x][j];
                    if (j >= x) total -= sum[i][j - x];
                    if (i >= x && j >= x) total += sum[i - x][j - x];
                    res = Math.max(res, total);
                }
            }
            if (maxSum >= res) l = x;
            else r = x - 1;
        }
        System.out.println(r);
        return r;
    }
    public static void main(String[] args) {
        /*
        int[][] grid = new int[2][2];
        grid[0][0] = 4;
        grid[0][1] = 5;
        grid[1][0] = 6;
        grid[1][1] = 7;
        */
        int[][] grid = new int[4][4];
        grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[0][3] = 1;
        grid[1][0] = 2;
        grid[1][1] = 2;
        grid[1][2] = 2;
        grid[1][3] = 2;
        grid[2][0] = 3;
        grid[2][1] = 3;
        grid[2][2] = 3;
        grid[2][3] = 3;
        grid[3][0] = 4;
        grid[3][1] = 4;
        grid[3][2] = 4;
        grid[3][3] = 81;
        largestSubgrid(grid, 39);
    }
}
