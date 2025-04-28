/*
You can call two strings X and Y are friendly strings, 
if you can swap two letters in X, so the result is equal to Y.

The condition to swap the letters is as follows:
	Swapping letters is defined as taking two indices i and j (0-indexed) 
	such that i != j and swapping the characters at A[i] and A[j] . 
	For example, swapping at indices 0 and 2 in "abcd" results in "cbad" .

You are given two strings X and Y of lowercase letters, 
return true if X and Y are friendly strings, otherwise return false.

Input Format:
-------------
Two space separated Strings X and Y

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
abcde bacde

Sample Output-1:
----------------
true

Sample Input-2:
---------------
abcde abcde

Sample Output-2:
----------------
false

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day23P4 {
     public static boolean isFriendly(String s1 , String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            Set<Character> set = new HashSet<>();
            for(char i : s1.toCharArray()){
                if(set.contains(i)){
                    return true;
                }
                else{
                    set.add(i);
                }
            }
        }
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                arr.add(i);
            }
        }
        return arr.size() == 2 && s1.charAt(arr.get(0)) == s2.charAt(arr.get(1)) && s1.charAt(arr.get(1)) == s2.charAt(arr.get(0));
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        System.out.println(isFriendly(s1,s2));
        sc.close();
    }
}
