// Venkatadri is a maths teacher.
// He is teaching matrices to his students.
// He is given a matrix of size m*n, and it contains only positive numbers.
// He has given a task to his students to find the special matrix, 
// in the iven matrix A[m][n].
// A special matrix has following property:
// 	- The sum of elements in each row, each column and the two diagonals are equal.
// 	- Every 1*1 matrix is called as a special matrix.
// 	- The size of the special matrix should be a square, i.e., P*P.

// Your task is to help the students to find the speical matrix  with max size P.


// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the matrix.
// Next M lines: N space separated integers m and n.

// Output Format:
// --------------
// Print an integer, maximum size P of the special matrix.


// Sample Input-1:
// ---------------
// 5 5
// 7 8 3 5 6
// 3 5 1 6 7
// 3 5 4 3 1
// 6 2 7 3 2
// 5 4 7 6 2

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// The special square is:
// 5 1 6
// 5 4 3
// 2 7 3


// Sample Input-2:
// ---------------
// 4 4
// 7 8 3 5
// 3 2 1 6
// 3 2 3 3
// 6 2 3 3

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// The special square is:
// 3 3
// 3 3

import java.util.*;


public class Day41P2 {
      public static boolean isSpecial(int[][] matrix, int row, int col, int p) {
        // Calculate the sum of the first row to compare with others
        int sum = 0;
        for (int j = col; j < col + p; j++) {
            sum += matrix[row][j];
        }
        
        // Check subsequent rows
        for (int i = row + 1; i < row + p; i++) {
            int rowSum = 0;
            for (int j = col; j < col + p; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }
        
        // Check columns
        for (int j = col; j < col + p; j++) {
            int colSum = 0;
            for (int i = row; i < row + p; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != sum) {
                return false;
            }
        }
        
        // Check main diagonal
        int diag1Sum = 0;
        for (int i = 0; i < p; i++) {
            diag1Sum += matrix[row + i][col + i];
        }
        if (diag1Sum != sum) {
            return false;
        }
        
        // Check anti-diagonal
        int diag2Sum = 0;
        for (int i = 0; i < p; i++) {
            diag2Sum += matrix[row + i][col + p - 1 - i];
        }
        if (diag2Sum != sum) {
            return false;
        }
        
        return true;
    }
    public static boolean hasSpecialMatrix(int[][] matrix, int m, int n, int p) {
        // Check all possible p x p submatrices
        for (int i = 0; i <= m - p; i++) {
            for (int j = 0; j <= n - p; j++) {
                if (isSpecial(matrix, i, j, p)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] matrix = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int maxP = 1; // since every 1x1 matrix is special
        
        // Start checking from the largest possible square size
        for (int p = Math.min(m, n); p >= 2; p--) {
            if (hasSpecialMatrix(matrix, m, n, p)) {
                maxP = p;
                break;
            }
        }
        
        System.out.println(maxP);
        sc.close();

    }
}
