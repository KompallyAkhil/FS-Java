/*
You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]

*/
import java.util.*;
public class Day18P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s[] = str.split(" ");
        String a = s[0];
        String s1 = s[1];
        char []b = s1.toCharArray();
        Arrays.sort(b);
        int l = 0;
        int h = b.length;
        ArrayList<Integer> arr = new ArrayList<>();
        while(h < a.length() + 1){
            String t = a.substring(l,h);
            char k[] = t.toCharArray();
            Arrays.sort(k);
            if(Arrays.equals(k,b)) arr.add(l);
            l++;
            h++;
        }
        System.out.println(arr);
        sc.close();
       
    }
}
