// Basava is interested in playing with digits.
// He wants to create a set of integers of length N, using the digits[0-9].
// The rules to create the integers are as follows:
// 	- digits in each integer are like d0,d1,d2...dn-1
// 	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

// Basava is given two integers N and D, where N is length of the integer and 
// D is the difference. Can you help Basava, to create such list of integers 
// and print all the possible integers in ascending order

// Note:
// -----
// Integers with leading 0's are not allowed

// Input Format:
// -------------
// Two space separated integers N and K.

// Output Format:
// --------------
// Print all the possible integers in ascending order.

// Sample Input-1:
// ---------------
// 3 5

// Sample Output-1:
// ----------------
// [161, 272, 383, 494, 505, 616, 727, 838, 949]

// Sample Input-2:
// ---------------
// 2 3

// Sample Output-2:
// ----------------
// [14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]

import java.util.*;

public class Day62P1 {
    public static boolean check(int num,  int k) {
        String s = String.valueOf(num);
        for (int i = 1; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            if (Math.abs(curr - prev) != k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            if (check(i, k)) {
                answer.add(i);
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
