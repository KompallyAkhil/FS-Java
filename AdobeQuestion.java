import java.util.*;
public class AdobeQuestion {
    static boolean[][] visited;
    
    public static int backtrack(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) return Integer.MAX_VALUE;

        if (visited[i][j]) return Integer.MAX_VALUE;

        if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
            return (grid[i][j] == 1) ? 1 : 0;
        }

        visited[i][j] = true;

        int top = backtrack(i - 1, j, grid);
        int down = backtrack(i + 1, j, grid);
        int left = backtrack(i, j - 1, grid);
        int right = backtrack(i, j + 1, grid);

        visited[i][j] = false; 

        int minGuards = Math.min(top, Math.min(down, Math.min(left, right)));

        if (grid[i][j] == 1) minGuards += 1;

        return minGuards;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] grid = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int maxi = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if (grid[i][j] == 0) {
                    visited = new boolean[n][m]; 
                    int guards = backtrack(i, j, grid);
                    if (guards != Integer.MAX_VALUE) {
                        maxi = Math.max(maxi, guards);
                    }
                }
            }
        }
        System.out.println(maxi);
        
        sc.close();
    }
}
