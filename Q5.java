// This is the last question in 2020 OA from Atlassian


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
        
    }
    public static void main(String[] args) {

    }
}
