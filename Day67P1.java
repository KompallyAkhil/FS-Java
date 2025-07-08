// Sampoornesh Babu is learning arithmatics.
// His teacher given him a task to find the minimum number of operations
// required to convert a given integer I to 1.

// Sampoornesh is allowed to perform the following operations:
// 	- If I is even, convert I with I/2 .
// 	- In I is odd, convert I with either I+1 or I-1.

// Now it's your task to help Sampoornesh Babu to find and print
// the minimum number of operations required.

// Input Format:
// -------------
// An integer I.

// Output Format:
// --------------
// Print an integer, the minimum number of operations required.


// Sample Input-1:
// ---------------
// 10

// Sample Output-1:
// ----------------
// 4

// Explanation:
// ------------
// 10 -> 5 -> 4-> 2 -> 1.


// Sample Input-2:
// ---------------
// 15

// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// 15 -> 16 -> 8 -> 4 -> 2 -> 1.Sampoornesh Babu is learning arithmatics.
// His teacher given him a task to find the minimum number of operations
// required to convert a given integer I to 1.

// Sampoornesh is allowed to perform the following operations:
// 	- If I is even, convert I with I/2 .
// 	- In I is odd, convert I with either I+1 or I-1.

// Now it's your task to help Sampoornesh Babu to find and print
// the minimum number of operations required.

// Input Format:
// -------------
// An integer I.

// Output Format:
// --------------
// Print an integer, the minimum number of operations required.


// Sample Input-1:
// ---------------
// 10

// Sample Output-1:
// ----------------
// 4

// Explanation:
// ------------
// 10 -> 5 -> 4-> 2 -> 1.


// Sample Input-2:
// ---------------
// 15

// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// 15 -> 16 -> 8 -> 4 -> 2 -> 1.
import java.util.*;
public class Day67P1 {
    public static int backtrack(int n, int target){
        if(n == target){
            return 0;
        }
        if(n % 2 == 0){
            return 1 + backtrack(n / 2 , target);
        }
        int withPlus = 1 + backtrack(n + 1 , target);
        int withMinus = 1 + backtrack(n - 1, target);
        return Math.min(withPlus,withMinus);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int operations = backtrack(n,1);
        System.out.println(operations);
        sc.close();
    }
}
