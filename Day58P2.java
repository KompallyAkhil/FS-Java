// /*
// Aruna as a type writer, typing a document in her laptop. Suddently her system got
// hacked and whatever she types as words are displaying in reverse and with simple 
// braces. She types only lowercase letters.

// Inorder to get the actual words, Aruna has to reverse each word starting with the
// word which is in innermost most braces and remove those braces.
// Help Aruna to get actual words.

// Constraints:
// ------------
//   - 0 <= word.length <= 2000
//   - Word only contains lower case English characters and parentheses.
//     It's guaranteed that all braces are balanced.


// Input Format:
// -------------
// Line-1: a string represents an encoded word.

// Output Format:
// --------------
// return the original string.


// Sample Input-1:
// ---------------
// (pqrs)

// Sample Output-1:
// ----------------
// srqp


// Sample Input-2:
// ---------------
// (uoy(are)woh)

// Sample Output-2:
// ----------------
// howareyou

// Explanation
// ------------
// Initially "are" will be revesed as "era".
// Then (uoyerawoh) will be reversed.

import java.util.*;

public class Day58P2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = "(uoy(are)woh)";
        Stack<Character> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(i != ')'){
                st.add(i);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
                for(char ch : sb.toString().toCharArray()){
                    st.add(ch);
                }
                
            }           
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        System.out.println(result.reverse().toString());   
        sc.close();
    }
}
