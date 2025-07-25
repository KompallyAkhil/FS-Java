// /*
// You have given a bulb grid, where the bulb which is turned ON is indicated 
// with 1, and turned OFF is indicated with 0.

// You are allowed to perform an operation:
//     - Select a row/column in the buld grid, and toggle the bulbs,
//     the bulbs which are turned ON will be truned OFF and the bulbs which are 
//     turned OFF will be turned ON.

// Your task is to find the highest possible sum of all the binary equivalents 
// of each row in the bulb grid, after performing the above operation any 
// number of times on the bulb grid.


// Input Format:
// -------------
// Line-1: Two space separated integers, M and N
// Next M lines: N space separated integers, grid[][]

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 3 5
// 0 1 1 1 1 
// 1 0 1 1 1 
// 0 0 0 0 1 

// Sample Output-1:
// ----------------
// 78

// Explanation:
// ------------
// Given grid is 
// 0 1 1 1 1
// 1 0 1 1 1
// 0 0 0 0 1

// Perform operation on row-0 and row-2
// 1 0 0 0 0
// 1 0 1 1 1
// 1 1 1 1 0

// Perform operation on col-1 and col-4
// 1 1 0 0 1 = 25
// 1 1 1 1 0 = 30
// 1 0 1 1 1 = 23
// So, now the total value of Binary Equivalent is 78


// Sample Input-2:
// ---------------
// 2 3
// 0 1 0
// 0 0 1

// Sample Output-2:
// ----------------
// 11

import java.util.*;

public class Day71P1 {
     public static int maxBulbSum(int [][] grid){
        for(int i = 0 ; i < grid.length ; i++){
            if(grid[i][0] == 0){
                for(int j = 0 ; j < grid[0].length ; j++){
                    grid[i][j] ^= 1;
                }
            }
        }
        
        for(int j = 1 ; j < grid[0].length ; j++){
            int countOnes = 0;
            for(int i = 0 ; i < grid.length ; i++){
                if(grid[i][j] == 1){
                    countOnes++;
                }
            }
            
            if(countOnes < grid.length - countOnes){
                for(int i = 0 ; i < grid.length ; i++){
                    grid[i][j] ^= 1;
                }
            }
        }
        
        int totalSum = 0;
        for(int i = 0 ; i < grid.length ; i++){
            int rowValue = 0;
            for(int j = 0 ; j < grid[0].length ; j++){
                rowValue = (rowValue << 1) | grid[i][j];
            }
            totalSum += rowValue;
        }
        
        return totalSum;
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
        int result = maxBulbSum(grid);
        System.out.println(result);
        sc.close();
    }
}
