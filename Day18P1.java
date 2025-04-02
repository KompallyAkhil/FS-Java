/*
In an institution there is a special keyboard.
It contains only one row of 26-keys, keys[]

The order of keys will be given, You need to findout the time taken to type a word.

The rules to find the time is as follows:
Initially you will be at first key .i.e, keys[0].
To type a character, you have to move to a key having desired character, key[j].
Time taken to type the character from key at ith index to key at jth index is |i - j|.

You will be given two strings, Keys and Word W.
Your task is to find how much time it takes to type the Word W 
using the given order of keys

NOTE: You have to use only one finger to type the word.

Input Format:
-------------
Line-1: A String Keys order.
Line-2: A String word W to type.

Output Format:
--------------
An integer T, time to type the word.


Sample Input-1:
---------------
poiuytrewqasdfghjklmnbvcxz
kmit

Sample Output-1:
----------------
39


Sample Output-2:
----------------
abcdefghijklmnopqrstuvwxyz
code

Sample Output-2:
----------------
26

*/
import java.util.*;
public class Day18P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String st = sc.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char i : s.toCharArray()){
            hm.put(i,s.indexOf(i));
        }
        int time = 0;
        int answer = 0;
        for(char i : st.toCharArray()){
            answer += Math.abs(hm.get(s.charAt(time)) - hm.get(i));
            time = hm.get(i);
        }
        System.out.println(answer);
        sc.close();
    }
    
}
