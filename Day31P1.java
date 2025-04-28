// Pranav has a puzzle board filled with square boxes in the form of a grid. Some 
// cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

// The puzzle board has some patterns formed with boxes in it, 
// the patterns may be repeated. The patterns are formed with boxes (1's) only, 
// that are connected horizontally and vertically but not diagonally.

// Pranav wants to find out the number of unique patterns in the board.

// You are given the board in the form of a grid M*N, filled wth 0's and 1's.
// Your task is to help Pranav to find the number of unique patterns in 
// the puzzle board.

// Input Format:
// -------------
// Line-1: Two integers M and N, the number of rows and columns in the grid-land.
// Next M lines: contains N space-separated integers [0, 1].

// Output Format:
// --------------
// Print an integer, the number of unique patterns in the puzzle board.


// Sample Input-1:
// ---------------
// 5 5
// 0 1 0 1 1
// 1 1 1 0 1
// 0 1 0 1 0
// 1 0 1 1 1
// 1 1 0 1 0

// Sample Output-1:
// ----------------
// 3

// Explanation-1:
// ------------
// The unique patterns are as follows:
//   1			1 1	    1 
// 1 1 1		  1 ,	1 1
//   1	   ,	
   
   
// Sample Input-2:
// ---------------
// 6 6
// 1 1 0 0 1 1
// 1 0 1 1 0 1
// 0 1 0 1 0 0
// 1 1 0 0 0 1
// 0 0 1 0 1 1
// 1 1 0 1 0 0

// Sample Output-2:
// ----------------
// 5

// Explanation-2:
// ------------
// The unique patterns are as follows:
// 1 1		1 1		    1		1 1	,	1
// 1   ,     1 ,	    1 1 ,		

import java.util.*;
public class Day31P1 {
    public static void dfs(int i, int j ,int x0, int y0, int [][] grid , boolean [][] visited ,List<String> list){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        list.add((i - x0 )+ ":" + (j - y0));
        dfs(i + 1, j, x0, y0, grid, visited, list);
        dfs(i,j + 1, x0, y0, grid, visited,  list);
        dfs(i - 1, j, x0, y0, grid, visited, list);
        dfs(i, j - 1, x0, y0, grid, visited,list);
        
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] grid = new int [m][n];
        boolean [][] visited = new boolean [m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, grid, visited, shape);
                    set.add(shape.toString());
                }
            }
        }
        System.out.println(set);
        System.out.println(set.size());
        sc.close();
    }

}
