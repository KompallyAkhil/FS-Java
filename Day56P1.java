// Alex and his twin brother Jordan often create secret messages. One day, Jordan 
// gives Alex two encrypted messages and challenges him to find the longest common 
// palindromic pattern hidden within both messages.

// Alex wants your help to decode the longest common palindromic subsequence that 
// exists in both strings.

// Your task is to determine the length of the longest subsequence that:
// - Appears in both messages
// - Is a palindrome

// Input Format:
// -------------
// input1: A string representing the first encrypted message.
// input2: A string representing the second encrypted message.

// Output Fromat:
// --------------
// Return an integer representing the length of the longest common palindromic 
// subsequence shared by both messages.


// Sample Input: 
// -------------
// adfa
// aagh

// Sample Output:
// --------------
// 2


// Sample Input-2:
// ---------------
// abcda
// fxaaba

// Sample Output:
// --------------
// 3

// Explanation:
// ------------
// The longest palindromic subsequence common to both is "aba" with length 3.

import java.util.*; 

public class Day56P1 {
    // static String longest = "";
    // public static String longestPalindromicSubsequence(String s){
    //     longest = "";
    //     backtrack(s,0,new StringBuilder());
    //     return longest;
    // }
    // public static void backtrack(String s , int index , StringBuilder sb){
    //     if(index == s.length()){
    //         String candidate = sb.toString();
    //         if(isPalindrome(candidate) && candidate.length() > longest.length()){
    //             longest = candidate;
    //         }
    //         return;
    //     }
    //     sb.append(s.charAt(index));
    //     backtrack(s, index + 1, sb);
    //     sb.deleteCharAt(sb.length() - 1);
    //     backtrack(s, index + 1, sb);
    // }
    // public static boolean isPalindrome(String s){
    //     int left = 0;
    //     int right = s.length() - 1;
    //     while (left <= right) {
    //         if(s.charAt(left) != s.charAt(right)){
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
    // public static boolean isSequence(String s , String sub){
    //     int i = 0;
    //     int j = 0;
    //     while (i < s.length() && j < sub.length()) {
    //         if(s.charAt(i) != sub.charAt(j)){
    //             i++;
    //             j++;
    //         }
    //         else{
    //             j++;
    //         }
    //     }
    //     return i == s.length();
    // }
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String s1 = sc.nextLine();
    //     String s2 = sc.nextLine();
    //     String l1 = longestPalindromicSubsequence(s1);
    //     String l2 = longestPalindromicSubsequence(s2);
    //     Boolean b1 = isSequence(l1,s2);
    //     Boolean b2 = isSequence(l2,s1);
    //     int maxi = 0;
    //     if(b1 && b2){
    //         maxi = Math.max(l1.length(), l2.length());
    //     }
    //     if(b1){
    //         maxi = Math.max(maxi,l1.length());
    //     }
    //     if(b2){
    //         maxi = Math.max(maxi, l2.length());
    //     }
    //     System.out.println(maxi);
    //     // System.out.println(l1 + " " + l2);
    //     // System.out.println(b1);
    //     // System.out.println(b2);
    //     // System.out.println(longestPalindromicSubsequence(s1));
    //     // System.out.println(longestPalindromicSubsequence(s2));
    //     sc.close();   
    // }
    static int maxLen = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        backtrack(s1, s2, 0, 0, new StringBuilder());
        System.out.println(maxLen);
        sc.close();
    }

    // Generate all common subsequences using two pointers (i, j)
    public static void backtrack(String s1, String s2, int i, int j, StringBuilder sb) {
        if (i == s1.length() || j == s2.length()) {
            String sub = sb.toString();
            if (isPalindrome(sub)) {
                maxLen = Math.max(maxLen, sub.length());
            }
            return;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // Include this character in the result
            sb.append(s1.charAt(i));
            backtrack(s1, s2, i + 1, j + 1, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // Explore other options
        backtrack(s1, s2, i + 1, j, sb);
        backtrack(s1, s2, i, j + 1, sb);
    }

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
