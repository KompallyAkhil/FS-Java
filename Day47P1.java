// Sampoornesh Babu is working with Strings.
// He is trying to form a palindrome using two strings P and Q.
// The rules to form the palindrome are as follows:
// 	- Divide the strings P and Q into two parts, and length of P and Q are same.
// 	- Division of P and Q should be done at same index position.
// 	- After Division P -> P1 + P2 and Q -> Q1 + Q2, where + indicates concatenation.
// 	- Now, check whether P1 + Q2 or Q1 + P2 forms a palindrome or not.
// 	- if palindrome is formed print 'true', otherwise 'false'. 

// For Example: 'job' can be divided in the following ways:
// ""+"job", "j"+"ob",  "jo"+"b", "job"+"".

// Your task is to help Sampoornesh Babu to find whether palindrome can be 
// formed with the strings P and Q.

// Input Format:
// -------------
// Two space separated strings P and Q

// Output Format:
// --------------
// Print a boolean value, whether can you form a palindrome or not.


// Sample Input-1:
// ---------------
// mortal carrom

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// Divide P="mortal" and Q="carrom" at index 3 as follows:
//     P -> "mor" + "tal", P1 = "mor" and P2 = "tal"
//     Q -> "car" + "rom", Q1 = "car" and Q2 = "rom"

// P1 + Q2 = "morrom" is a palindrome,so print true.


// Sample Input-2:
// ---------------
// romans carrom

// Sample Output-2:
// ----------------
// false

import java.util.*;

public class Day47P1 {
   public static boolean checkPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        sc.close();
        if(s1.length() != s2.length()){
            System.out.println(false);
            return;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            String sb1 = s1.substring(0,i);
            String sb2 = s1.substring(i,s1.length());
            String sb3 = s2.substring(0,i);
            String sb4 = s2.substring(i,s2.length());
            String combi1 = sb1 + sb4;
            String combi2 = sb3 + sb2;
            
            if(checkPalindrome(combi1) || checkPalindrome(combi2)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
        
    }
}
