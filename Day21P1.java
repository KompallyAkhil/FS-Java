/*
A string is called well-weighted string,if and only if
the string has equal number of 'A's and 'B's in it.

You are given a string S, divide S in to the maximum number of 
well-weighted strings. You should not leave any letter/part of the string.
Return the maximum number of well-weighted strings.

Input Format:
-------------
A string contains only A's and B's

Output Format:
--------------
Print an integer, maximum number of well-weighted strings


Sample Input-1:
---------------
ABBBBAAABA

Sample Output-1:
----------------
3

Explanation:
--------------
Well weighted strings, AB, BBBAAA, BA.


Sample Input-2:
---------------
ABAABBABAB

Sample Output-2:
----------------
4

Explanation:
--------------
Well weighted strings, AB, AABB, AB, AB.


Sample Input-3:
---------------
ABAAABBABB

Sample Output-3:
----------------
2

*/
import java.util.Scanner;

public class Day21P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count1 = 0;
        int count2 = 0;
        int countOfString = 0;
        for(char i : s.toCharArray()){
            if(i == 'A'){
                count1++;
            }
            if(i == 'B'){
                count1--;
            }
            if(count1 == 0){
                countOfString++;
            }
        }
        System.out.println(countOfString);
        sc.close();
    }
}
