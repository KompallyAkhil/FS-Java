/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally 
with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5
*/

import java.util.Scanner;

public class Day72P2 {
     public static int backtrack(int i , int j , int [][] grid , boolean [][] visited){
        if(i < 0 || j < 0  ||  i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != 1){
            return 0;
        }
        visited[i][j] = true;
        return 1
        + backtrack(i, j + 1, grid, visited)   
        + backtrack(i + 1, j, grid, visited)   
        + backtrack(i + 1, j + 1, grid, visited) 
        + backtrack(i - 1, j - 1, grid, visited)
        + backtrack(i - 1, j, grid, visited)   
        + backtrack(i, j - 1, grid, visited) 
        + backtrack(i - 1, j + 1, grid, visited) 
        + backtrack(i + 1, j - 1, grid, visited); 
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] grid = new int [n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean [][] visited = new boolean [n][m];
        int maxi = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    // System.out.println(backtrack(i,j,grid,visited));
                    maxi = Math.max(maxi,backtrack(i,j,grid,visited));
                }
            }
        }
        System.out.println(maxi);
        sc.close();
    }
}
