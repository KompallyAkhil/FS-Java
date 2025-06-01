
// Amogh is an Antiquarian, The person who collects antiques.
// He found a rear keyboard which has following keys,
// Keys are 'N', 'S', 'C' and 'P'

// 1st Key - 'N': Print one character 'N' on Console.
// 2nd Key - 'S': Select the whole Console.
// 3rd Key - 'C': Copy selected content to buffer.
// 4th Key - 'P': Print the buffer on Console, and append it after what has 
// already been printed.

// Now, your task is to find out maximum numbers of 'N's you can print
// after K keystrokes . 

// Input Format:
// -------------
// An integer K

// Output Format:
// --------------
// Print an integer, maximum numbers of 'N's you can print.


// Sample Input-1:
// -------------------
// 3

// Sample Output-1:
// -------------------- 
// 3

// Explanation: 
// ---------------
// We can print at most get 3 N's on console by pressing following key sequence:
// N, N, N



// Sample Input-2:
// -------------------
// 7

// Sample Output-2:
// ---------------------
// 9

// Explanation: 
// ---------------
// We can print at most get 9 N's on console by pressing following key sequence:
// N, N, N, S, C, P, P
import java.util.*;
public class Day52P1 {
     private static int maxN(int K) {
        return backtrack(0, 0, false, K);
    }
        private static int backtrack(int currentN, int buffer, boolean selected, int keystrokesLeft) {
        if (keystrokesLeft == 0) {
            return currentN;
        }

        int maxN = 0;

        int pressN = backtrack(currentN + 1, buffer, false, keystrokesLeft - 1);
        maxN = Math.max(maxN, pressN);

        int pressS = backtrack(currentN, buffer, true, keystrokesLeft - 1);
        maxN = Math.max(maxN, pressS);

        if (selected) {
            int pressC = backtrack(currentN, currentN, false, keystrokesLeft - 1);
            maxN = Math.max(maxN, pressC);
        }

        if (buffer > 0) {
            int pressP = backtrack(currentN + buffer, buffer, false, keystrokesLeft - 1);
            maxN = Math.max(maxN, pressP);
        }

        return maxN;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int k = sc.nextInt();
        // int dp [] = new int [k + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 2;
        // int p = 0;
        // for(int i = 3 ; i <= k ; i++){
        //     dp[i] = dp[i - 1] + 1;
        //     for(int j = 1 ; j <= i - 3 ; j++){
        //         dp[i] = Integer.max(dp[i],dp[j] * (i - j - 1));
        //     }
        // }
        // System.out.println(dp[k]);
        // sc.close();
        //  Dynamic Programming (DP) Solution
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        System.out.println(maxN(K));
        sc.close();
    }  
}
