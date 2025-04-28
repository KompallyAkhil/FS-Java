/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
*/

import java.util.HashMap;
import java.util.Scanner;

public class Day26P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split(" ");
        String s = input[0];
        String s1 = input[1];
        boolean result = true;
        if(s1.length() % s.length() != 0){
            System.out.println(false);
            return;
        }
        int subStringLength = s1.length() / s.length();
        HashMap<Character,String> hm = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            String subString = s1.substring(i * subStringLength , (i + 1)  * subStringLength);
            if(!hm.containsKey(c)){
                if(hm.containsValue(subString)){
                    result = false;
                    break;
                }
                hm.put(c,subString);
            }
            else{
                if(!hm.get(c).equals(subString)){
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
}
