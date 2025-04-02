/*
In a School, the math teacher has given a number N between 1000 to 9999.
He asked the students to create two numbers N1 and N2 using the digits of N,
where each digit must be used only once and N1 and N2 must be between 0 to 999 
(leading 0's are allowed). The sum of  N1 and N2 should be minimum.

Your task is to help the students to find the mimimum sum of N1 and N2 using N.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7512

Sample Output-1:
----------------
42

Explanation:
------------
The possible numbers of N1 and N2 are,
(125,7), (12,57), (157,2), (17,25) or (15,27),..etc.
Among these 17+25 or 15+27 will give the minimum sum.


Sample Input-2:
---------------
5004

Sample Output-2:
----------------
9

*/

import java.util.Arrays;

public class Day12P3 {
    public static void main(String[] args) {
        int n = 5004;
        String s = String.valueOf(n);
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String sb = String.valueOf(arr);
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        for(int i = 0 ; i < sb.length() ; i++){
            if(i % 2 == 0){
                one.append(String.valueOf(sb.charAt(i)));
            }
            else{
                two.append(String.valueOf(sb.charAt(i)));
            }
        }
        System.out.println(Integer.parseInt(one.toString()) + Integer.parseInt(two.toString()));
        
    }
    
}
