// Mr Robert is working with strings.
// He selected two strings S1 and S2, may differ in length,
// consists of lowercase alphabets only.

// Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
// 	- All the alphabets in S1 should be less than all the alphabets in S2.
// 	- All the alphabets in S2 should be less than all the alphabets in S1.
// 	- Both S1 and S2 should have only one distinct alphabet in it.
// To Achieve, one of the criteria, you are allowed to replace any one letter in 
// the string with any other lowercase alphabet.

// Your task is to help Mr Robert, to find the minimum replacements to be done to 
// update the strings S1 and S2 to meet one of the criteria mentioned above.


// Input Format:
// -------------
// Two space separated strings S1 and S2.

// Output Format:
// --------------
// Print an integer, minimum number of replacements.


// Sample Input-1:
// ---------------
// apple ball

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Consider the best way to make the criteria true:
// - Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
// then every alphabet in S2 is less than every alphabet in S1.
//         (OR)
// - Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less 
// than every alphabet in S1.


// Sample Input-2:
// ---------------
// kmit kmec

// Sample Output-2:
// ----------------
// 2

import java.util.*;

public class Day47P2 {
    
    public static int minReplacements(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // Build frequency arrays from HashMap for prefix use
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            freq1[i] = map1.getOrDefault(ch, 0);
            freq2[i] = map2.getOrDefault(ch, 0);
        }
        System.out.println(Arrays.toString(freq1));
        System.out.println(Arrays.toString(freq2));

        // Compute prefix sums
        int[] prefix1 = new int[26];
        int[] prefix2 = new int[26];
        prefix1[0] = freq1[0];
        prefix2[0] = freq2[0];
        for (int i = 1; i < 26; i++) {
            prefix1[i] = prefix1[i - 1] + freq1[i];
            prefix2[i] = prefix2[i - 1] + freq2[i];
        }
        System.out.println(Arrays.toString(prefix1));
        System.out.println(Arrays.toString(prefix2));
        int len1 = s1.length();
        int len2 = s2.length();
        int res = Integer.MAX_VALUE;

        // Case 1: All chars in s1 < all chars in s2
        for (int i = 0; i < 25; i++) {
            int cost1 = len1 - prefix1[i];
            int cost2 = prefix2[i];
            res = Math.min(res, cost1 + cost2);
        }

        // Case 2: All chars in s2 < all chars in s1
        for (int i = 0; i < 25; i++) {
            int cost1 = prefix1[i];
            int cost2 = len2 - prefix2[i];
            res = Math.min(res, cost1 + cost2);
        }

        // Case 3: Make both strings consist of same character
        for (int i = 0; i < 26; i++) {
            int cost1 = len1 - freq1[i];
            int cost2 = len2 - freq2[i];
            res = Math.min(res, cost1 + cost2);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();

        int result = minReplacements(s1, s2);
        System.out.println(result);
    }
}
