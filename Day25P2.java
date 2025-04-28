/*
Arjun wants to build a swimming pool, in the backyard of his farm-house.
The backyard has an empty land of size m*n. 
Some part of the backyard is used to build the swimming pool
You will be given the m*n grid values (0's and 1's). 
where 1 indicates swimming pool, and 0 indiactes empty land.

Your task to find the perimeter of the swimming pool.

Note: There is only one swimming pool.

Input Format:
-------------
Line-1: Two integers M and N, size of the backyard.
Next M lines: N space separated integers, either 0 or 1
0- represents empty land and 1- represents the swimming pool 

Output Format:
--------------
Print an integer, the perimeter of the swimming pool


Sample Input-1:
---------------	
4 4
0 1 0 0
1 1 1 0
0 1 0 0
1 1 0 0
 
Sample Output-1:
----------------
16


Sample Input-2:
---------------
1 2
1 0
 
Sample Output-2:
----------------
4
*/
import java.util.*;
public class Day25P2 {
    public static int backtrack(int[][] grid, boolean[][] visited, int i, int j, int row, int col) {
      
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) {
            return 1;
        }

        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int perimeter = 0;
        perimeter += backtrack(grid, visited, i - 1, j, row, col); 
        perimeter += backtrack(grid, visited, i + 1, j, row, col); 
        perimeter += backtrack(grid, visited, i, j - 1, row, col); 
        perimeter += backtrack(grid, visited, i, j + 1, row, col); 

        return perimeter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int [][] grid = new int [row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean [][] visited = new boolean[row][col];
        int perimeter = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 1){
                    perimeter = backtrack(grid, visited,i, j,row,col);
                    System.out.println(perimeter);
                    return;
                }
            }
        }
        sc.close();
    }
}
