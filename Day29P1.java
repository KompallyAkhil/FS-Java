
/*
In the world of secret codes and cryptography, you are entrusted with deciphering a hidden message. 
You have two encoded keys, key1 and key2, both of equal length. Each character 
in key1 is paired with the corresponding character in key2. 

This relationship follows the standard rules of an equivalence cipher:
• Self-Mapping: Every character inherently maps to itself.  
• Mutual Mapping: If a character from key1 maps to one in key2, then that 
  character in key2 maps back to the one in key1.  
• Chain Mapping: If character A maps to B, and B maps to C, then A, B, and C 
  are all interchangeable in this cipher.

Using this mapping, you must decode a cipherText, by replacing every character 
with the smallest equivalent character from its equivalence group. 
The result should be the relatively smallest possible decoded message.


Input Format:
-------------
Three space separated strings, key1 , key2 and cipherText

Output Format:
--------------
Print a string, decoded message which is relatively smallest string of cipherText.

Example 1: 
input=
attitude progress apriori
output=
aaogoog


Explanation: The mapping pairs form groups: [a, p], [o, r, t], [g, i], [e, u], 
[d, e, s]. By substituting each character in cipherText with the smallest from 
its group, you decode the message to "aaogoog".


Constraints:  
• 1 <= key1.length, key2.length, cipherText.length <= 1000  
• key1.length == key2.length  
• key1, key2, and cipherText consist solely of lowercase English letters.

*/

import java.util.*;

public class Day29P1 {
    static int [] parent = new int[26];
    public static void initialize(){
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void union(int x , int y){
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        String s3 = s[2];
        initialize();
        for(int i = 0 ; i < s1.length() ; i++){
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            union(c1,c2);
        }
        System.out.println(Arrays.toString(parent));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s3.length() ; i++){
            int c3 = s3.charAt(i) - 'a';
            System.err.println(c3);
            int smallestChar = find(c3);
            sb.append((char) (smallestChar + 'a'));
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
