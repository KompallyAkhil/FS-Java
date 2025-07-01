// A merchant has two types of idols, gold and silver.
// He has arranged the idols in the form of m*n grid, 
// 	- the gold idols are represented as 1's 
// 	- the silver idols are represented as 0's.

// Your task is to find the longest consecutive arrangement of gold idols, 
// The arrangement can be either horizontal, vertical, diagonal or 
// antidiagonal, but not the combination of these.


// Input Format:
// -------------
// Line-1: Two space separated integers m and n, grid size.
// Next m lines : n space separated integers, arrangement of idols.

// Output Format:
// --------------
// Print an integer, longest arrangement of gold idols.


// Sample Input:
// ------------
// 4 5
// 1 0 1 1 1
// 0 1 0 1 0
// 1 0 1 0 1
// 1 1 0 1 1

// Sample Output:
// -------------
// 4

// Sample Input:
// -------------
// 5 7
// 1 1 1 1 0 1 0
// 0 1 1 1 0 0 0
// 0 1 1 1 0 1 1
// 1 1 0 0 1 1 1
// 1 0 0 0 0 1 1

// Sample Output
// -------------
// 5

// NOTE:
// Solve this program using DP approach only.
import java.util.*;
public class Day63P2 {
    public static int checkHorizontal(int i , int j , int [][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        return + 1 + checkHorizontal(i ,j + 1 , grid);
    }
    public static int checkVertical(int i , int j , int [][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        return + 1 + checkVertical(i + 1, j, grid);
    }
    public static int checkDiagonal(int i , int j , int [][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        return + 1 + checkDiagonal(i + 1 , j + 1, grid);
    }
    public static int checkAntiDiagonal(int i , int j , int [][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
        return + 1 + checkAntiDiagonal(i + 1 , j - 1, grid);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] grid = new int [m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int maxi = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    maxi = Math.max(maxi,checkHorizontal(i,j,grid));
                    maxi = Math.max(maxi,checkVertical(i,j,grid));
                    maxi = Math.max(maxi,checkDiagonal(i,j,grid));
                    maxi = Math.max(maxi,checkAntiDiagonal(i,j,grid));
                }
            }
        }
        System.out.println(maxi);
        sc.close();
    }
}
