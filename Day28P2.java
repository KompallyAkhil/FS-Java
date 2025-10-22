// /*
// Vihaar is working with strings. 
// He is given two strings A and B, and another string T,
//  where the length of A and B is same.
 
// You can find the relative groups of letters from A and B,
// using the following rule set:
// 	- Equality rule: 'p' == 'p'
//  	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
//  	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
 	
// Vihaar has to form the relatively smallest string of T,
// using the relative groups of letters.
 
// For example, if A ="pqr" and B = "rst" , 
// then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

// The relatives groups formed using above rule set are as follows: 
// [p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".
 
// You will be given the strings A , B and T.
// Your task is to help Vihaar to find the relatively smallest string of T.
 
// Input Format:
// -------------
// Three space separated strings, A , B and T
 
// Output Format:
// --------------
// Print a string, relatively smallest string of T.
 
 
// Sample Input-1:
// ---------------
// kmit ngit mgit
 
// Sample Output-1:
// ----------------
//  ggit
 
// Explanation: 
// ------------
// The relative groups using A nd B are [k, n], [m, g], [i], [t] and
// the relatively smallest string of T is "ggit"
 
 
// Sample Input-2:
// ---------------
// attitude progress apriori
 
// Sample Output-2:
// ----------------
//  aaogoog
 
//  Explanation: 
//  ------------
//  The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
//  the relatively smallest string of T is "aaogoog"

import java.util.*;

public class Day28P2 {
    static int[] parent = new int[26];

    // Find parent with path compression
    static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // Union operation - always attach larger to smaller (for smallest lexicographical)
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (px < py) parent[py] = px;
        else parent[px] = py;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String T = sc.next();

        // initialize parents
        for (int i = 0; i < 26; i++) parent[i] = i;

        // make unions
        for (int i = 0; i < A.length(); i++) {
            union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }

        // build smallest equivalent string
        StringBuilder res = new StringBuilder();
        for (char c : T.toCharArray()) {
            int root = find(c - 'a');
            res.append((char) (root + 'a'));
        }

        System.out.println(res.toString());
        sc.close();
    }
}
