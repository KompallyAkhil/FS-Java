/*
Mr. Chandra has an portrait photo with size M*N pixels, 
where M is the length of the portrait and N is width of the portrait.

You are given an integer S in pixels,
Your task is to help Mr. Chammak Chandra to find the actual values 
[M, N] using the following specifications:
- The size of portrait should be equal to S. i.e., S = M*N.
 - N is always smaller than in M, i.e., N <= M
 - The diffrence between length and width, (M-N) should be minimum.
And print the result as a pair M and N.

NOTE: S is always a positive integer.

Input Format:
-------------
Line-1 -> An integer S, size of the portrait.

Output Format:
--------------
Print the result as a pair of integers.


Sample Input-1:
---------------
24

Sample Output-1:
----------------
6 4


Sample Input-2:
---------------
550

Sample Output-2:
----------------
25 22

*/
import java.util.*;
public class Day13P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int [] pairs = new int[2];
        for(int i = 1 ; i * i <= s ; i++){
            if( s % i == 0 ){
                int n = i;
                int m = s / n;
                int diff = m - n;
                if(diff < min){
                    min = diff;
                    pairs[0] = m;
                    pairs[1] = n;
                }
            }
        }
        int left , right ;
        left = right = (int) Math.sqrt(s);
        while (left * right != s) {
            if(left * right < s){
                right++;
            }
            else{
                left--;
            }
        }
        System.out.println(right + " " + left);
        System.out.println(pairs[0] + " " + pairs[1]);
        sc.close();
    }
}
