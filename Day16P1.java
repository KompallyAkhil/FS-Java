/*
In the context of linguistic harmony, we define a "harmonious string" as a string where 
every alphabet it contains appears both in uppercase and lowercase forms. For instance, 
a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'. 
Conversely, a string like "pqP" is not harmonious as it fails to meet this condition, 
with 'q' present while 'Q' is absent.

Your are given a string S, your task is  to return the longest harmonious substring in S. 
If there are multiple answers meeting this criterion, you should return the one that appears 
earliest in the string. If there is no harmonious substring, you should return an empty string.

Input Format:
-------------------
A string S

Output Format:
-------------------
Prin the longest harmonious string.


Sample Input:
--------------
QcvcCcq

Sample Output:
---------------
cCc


Sample Input:
--------------
pqrs

Sample Output:
--------------
""
*/
import java.util.*;
public class Day16P1 {
    public static boolean isHarmonious(String sub){
        Set<Character> set = new HashSet<>();
        for (char c : sub.toCharArray()) {
            set.add(c);
        }
        for (char c : set) {
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
                return false;
            }
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "QcvcCcq";
        int maxLength = 0;
        String longestSubString = "";
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i + 1 ; j <= s.length() ; j++){
                String sub = s.substring(i, j);
                if(isHarmonious(sub)){
                    if(sub.length() > maxLength){
                        maxLength = sub.length();
                        longestSubString = sub;
                    }
                }
            }
        }
        System.out.println(longestSubString);
    }
    
}
