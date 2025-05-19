// Arjun wants to build some homes in a land of size R*C.
// He wanted to construct homes in rectangular shape.
// The place which is remained will be used for gradening.
// Accordingly he has prepared the plan and given as
// an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

// A home is set of cells with value 1 in rectangular shape.
// He wants to findout all the homes in the plan and store their co-ordinates in 
// the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
// co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
// (bottom right corner) of i-th home.

// Your task is to help Arjun to find all the homes and return the coords[][] of 
// all the homes from top left corner to bottom right corner.

// NOTE: No two homes are adjacent to each other in 4 directions,
// (left, right, top, bottom).

// Input Format:
// -------------
// Line-1: Two integers R and C, size of the land.
// Next R lines: C space separated integers, either 0 or 1
// 0- represents garden area land and 1- represents the home.

// Output Format:
// --------------
// Print 2d array, the co-ordinates of all homes.


// Sample Input-1:
// ---------------
// 2 3
// 1 0 0
// 0 1 1
 
// Sample Output-1:
// ----------------
// [0, 0, 0, 0][1, 1, 1, 2]


// Sample Input-2:
// ---------------
// 4 4
// 1 1 0 1
// 0 0 0 0
// 1 1 0 1
// 1 1 0 1
 
// Sample Output-2:
// ----------------
// [0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]

import java.util.*;
public class Day44P2 {
    public static void backtrack(int i, int j, int[][] grid, boolean[][] visited, int[] bounds) {
      

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;

        bounds[0] = Math.min(bounds[0], i);
        bounds[1] = Math.min(bounds[1], j);
        bounds[2] = Math.max(bounds[2], i); 
        bounds[3] = Math.max(bounds[3], j); 

        backtrack(i + 1, j, grid, visited, bounds);
        backtrack(i - 1, j, grid, visited, bounds);
        backtrack(i, j + 1, grid, visited, bounds);
        backtrack(i, j - 1, grid, visited, bounds);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int [][] grid = new int[r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean [][] visited = new boolean[r][c];
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int[] bounds = {i, j, i, j}; 
                    backtrack(i, j, grid, visited, bounds);
                    List<Integer> cords = new ArrayList<>();
                    for (int val : bounds) cords.add(val);
                    arr.add(cords);
                }
            }
        }
        System.out.println(arr);
        sc.close();
    }
}
