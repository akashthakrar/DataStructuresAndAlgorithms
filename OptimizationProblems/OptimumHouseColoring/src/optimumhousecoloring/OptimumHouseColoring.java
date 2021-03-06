/*
 *A builder is looking to build a row of N houses that can be of K different colors. 
He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.
Given an N by K matrix where the nth row and kth column represents the cost to build the nthhouse with kth color, 
return the minimum cost which achieves this goal.
======================================================================================================================
Approach:
Dynamic Programming solution:
we can paint the ith house with blue, red or green.
so we have the following equations:
cost[i,r] = min( cost[i-1,b], cost[i-1,g] ) + cost of painting i with r.
cost[i,g] = min( cost[i-1,b], cost[i-1,r] ) + cost of painting i with g.
cost[i,b] = min( cost[i-1,r], cost[i-1,g] ) + cost of painting i with b.


Final Min Cost = min (cost[n,b], cost[n,r], cost[n,g]);


---------------------------
    R      G       B
---------------------------
1   7      5       10 
---------------------------
2   3      6        1
---------------------------
3   8      7       4
--------------------------
4   6      2       9
--------------------------
5   1      4       7
--------------------------
6   2      3       6
--------------------------
 */
package optimumhousecoloring;

/**
 *
 * @author ynagaraj
 */
public class OptimumHouseColoring {

    
    public static void main(String[] args) {
    int [][] costMatrix = {{7, 5, 10},
          {3, 6, 1},
          {8, 7, 4},
          {6, 2, 9},
          {1, 4, 7},
          {2, 3, 6},
         };
        int cost = calcHouseColoringCost(costMatrix);
        System.out.println("Cost of coloring the house is: " + cost);
    }
    public static int calcHouseColoringCost(int [][] M) {
        int finalCost = 0;
        int r = M.length+1;
        int c = M[0].length;
        int [][] C = new int[r][c];

        for (int i=0; i<c; i++) {
         C[0][i] = 0;
        }
   
        for (int i=1; i<r; i++) {
         C[i][0] = Math.min(C[i-1][1], C[i-1][2]) + M[i-1][0];
         C[i][1] = Math.min(C[i-1][2], C[i-1][0]) + M[i-1][1];
         C[i][2] = Math.min(C[i-1][0], C[i-1][1]) + M[i-1][2];
        }
        //System.out.println(C[r-1][0]);
        //System.out.println(C[r-1][1]);
        //System.out.println(C[r-1][2]);
        finalCost = Math.min(Math.min(C[r-1][0], C[r-1][1]), C[r-1][2]);
        //printing the DP matrix.
        System.out.println("Cost matrix leading to the solution: ");
        printMatrix(C);
        return finalCost;
    }
    public static void printMatrix(int [][]M) {
        int r = M.length;
        int c = M[0].length;

        for (int i=0; i<r; i++) {
         for (int j=0; j<c; j++) {
          System.out.print(M[i][j] + " ");
         }
         System.out.println();
        }
 }
    
}
