// You are the chief designer for a futuristic garden trail, where there are n
// consecutive decorative light posts along a path. Each post can be illuminated 
// with one of three distinct colors: Crimson, Azure, or Emerald. The cost to 
// illuminate each post with a particular color depends on the post's location and
// the energy circuit required.

// However, to maintain aesthetic harmony and prevent power circuit overloads, no 
// two adjacent posts can have the same light color.

// The cost of illuminating each post with each color is provided in a 2D array
// costs, where costs[i][0] is the cost of lighting post i with Crimson, 
// costs[i][1] with Azure, and costs[i][2] with Emerald.

// Your goal is to find the minimum total cost to light up all posts in such a way 
// that no two neighboring posts have the same color.

// Input Format:
// -------------
// Line-1: An integer N, number of post.
// Next N lines: 3 space separated integers, cost of illuminating the posts.

// Output Format:
// --------------
// Print an integer, minimum total cost to light up all posts.


// Sample Input:
// ---------------
// 3
// 17 2 17
// 16 4 5
// 14 3 19

// Sample Output:
// ----------------
// 10

// Explanation: 
// ------------
// 1st post is with Azure, 2nd post is with Emerald,
// 3rd post is with Crimson.
// Minimum cost: 2 + 5 + 3 = 10.

// */
import java.util.*;
public class Day54P1 {
    public static int getIndex(int [] grid , int value){
        for(int i = 0 ; i < grid.length ; i++){
            if(grid[i] == value){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] grid = new int [n][3];
        for(int i = 0 ; i < n ; i++){
            grid[i][0] = sc.nextInt();
            grid[i][1] = sc.nextInt();
            grid[i][2] = sc.nextInt();
        }
        for(int i = 1 ; i < n ; i++){
            grid[i][0] += Math.min(grid[i - 1][1],grid[i - 1][2]);
            grid[i][1] += Math.min(grid[i - 1][0],grid[i - 1][2]);
            grid[i][2] += Math.min(grid[i - 1][0],grid[i - 1][1]);
            
        }
        int result = Math.min(grid[n - 1][0], Math.min(grid[n - 1][1],grid[n - 1][2]));
        System.out.println(result);
        sc.close();
    }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int [][] grid = new int [n][3];
    //     for(int i = 0 ; i < n ; i++){
    //         grid[i][0] = sc.nextInt();
    //         grid[i][1] = sc.nextInt();
    //         grid[i][2] = sc.nextInt();
    //     }
    //     int start = Arrays.stream(grid[0]).min().getAsInt();
    //     int index = getIndex(grid[0], start);
    //     int sum = 0;
    //     sum += start;
    //     for(int i = 1 ; i < n ; i++){
    //         int min = Arrays.stream(grid[i]).min().getAsInt();
    //         int minIndex = getIndex(grid[i], min);
    //         if(minIndex != index){
    //             index = minIndex;
    //             sum += min;
    //         }
    //         else{
    //             int less = Integer.MAX_VALUE;
    //             for(int j : grid[i]){
    //                 if(j != min){
    //                     less = Math.min(less, j);
    //                 }
    //             }
    //             int lessIndex = getIndex(grid[i], less);
    //             index = lessIndex;
    //             sum += less;
    //         }
    //     }
    //     System.out.println(sum);
    //     sc.close();
    // }
}
