/*
Mr Saurabh is given a list of words.
Your task is to help Mr Saurabh to find the size of largest group

A group is formed using the following rules:
- Pick one smallest word (in length) and form a group with this word
  (if it is not part of any other group yet)
- Add a letter at any place in the word without changing the relative order 
  of the letters in it, and if it forms a word which is existing in the list[],
  then add the word to the group.
- Repeat the above two steps, till all the words in the list are part of groups.

NOTE:You move form more than one group.

Input Format:
-------------
Space separated words, wordsList[].

Output Format:
--------------
Print an integer result


Sample Input-1:
---------------
many money n an mony any one mone on

Sample Output-1:
----------------
5

Explanation:
------------
the words group is : [n, on, one, mone, money]


Sample Input-2:
---------------
a ab abb babb abab baba bab abbaa

Sample Output-2:
----------------
4
*/
import java.util.*;

public class Day71P3 {
    public static boolean checkSequence(String small, String big) {
        int i = 0;
        int j = 0;
        while (i < small.length() && j < big.length()) {
            if (small.charAt(i) == big.charAt(j)) {
                i++; 
                j++;
            } else {
                j++; 
            }
        }

        return i == small.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Queue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        for(String i : s){
            pq.add(i);
        }
        int count = 1;
        String out = pq.poll();

        while (!pq.isEmpty()) {
            String next = pq.poll();
            if (checkSequence(out, next)) {
                out = next;
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
