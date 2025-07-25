// An valid bracket arrangement is either "", "[" + A + "]", 
// or A + B, where A and B are valid bracket arrangements 
// and + represents string concatenation.

// For example, "", "[]", "[[]]", and "[[][[]]]" are all valid bracket combinations.
// A non-empty valid bracket arrangement is called authentic bracket string.
// If an authentic bracket string s can be divided into s = A + B, where A and B 
// are valid bracket strings and non-empty.

// Consider the following basic partitioning of an authentic bracket string S, 
// S = P1 + P2 +... + Pk, where Pi are basic authentic bracket string.

// Return S after deleting the outermost brackets of each authentic string in S's partitioning.


// INPUT FORMAT:
// -------------
// A String S, consists of '[' and ']' brackets only.

// OUTPUT FORMAT:
// --------------
// Print S after deleting the outermost brackets.


// SAMPLE INPUT-1:
// ---------------
// [[]][[][]][]

// SAMPLE OUTPUT-1:
// ----------------
// [][][]


// SAMPLE INPUT-2:
// ---------------
// [[][]][[]][[][[]]]


// SAMPLE OUTPUT-2:
// ----------------
// [][][][][[]]

import java.util.*;

public class Day26P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "[[]][[][]][]";
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(i == '['){
                if(!st.isEmpty()){
                    sb.append(i);
                }
                st.push(i);
            }
            else if(i == ']'){
                st.pop();
                if(!st.isEmpty()){
                    sb.append(i);
                }
            }    
        }
        System.out.println(sb.toString());
    }
}
