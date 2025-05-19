// Mr Panda is given two words, word-1 and word-2, both are 1-indexed.
// He want to transform word-1 into word-2 in S number of steps or less.

// Mr Panda is allowed to perfom the opeartion at p-th step ( 1 <= p <= S ):
//     - Choose one character at index-q from word-1, and that character at 
//       index-b has not been chosen previously, and transfer that character 
//       q-steps forward.
//     - Or do nothing.

// In one step, transfer a character to the next character in [a-z],
// circularly, (i.e., after 'z', 'a' will be appeared). 
// Transferring a character by q steps means, repeat the above step, q times.

// Your task is to return "true", if it's possible to transform word-1 into word-2
// in no more than S steps, otherwise return "false".

// NOTE: You can choose the character at an index-p at most once.


// Input Format:
// -------------
// Line-1: A string, Word-1
// Line-2: A string, Word-2
// Line-3: An integer, number of steps S.

// Output Format:
// --------------
// Print a boolean result.


// Sample Input-1:
// ---------------
// kmec
// kmit
// 17

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// In the 4th step, transfer the character 'e' in 4 steps, to get 'i'. 
// And in the 17th step, transfer the character 'c' in 17 steps, to get 't'.
// Now the word-1 is transformed to word-2 completely,so return "true".

// Sample Input-2:
// ---------------
// cock
// coke
// 8

// Sample Output-2:
// ----------------
// false

// Explanation:
// ------------
// In the 8th step, transfer the character 'c' at 3rd index in 8 steps, to get 'k'. 
// There are no more steps left, to transfer 'k' to 'e'. So, return "false".


// Sample Input-3:
// ---------------
// cock
// coke
// 20

// Sample Output-3:
// ----------------
// true

// Explanation:
// ------------
// In the 8th step, transfer the character 'c' at 3rd index in 8 steps, to get 'k'
// In the 20th step, transfer the character 'k' at 4th index in 20 steps, 
// to get 'e', ('k' to 'z' 15 steps, and 'z' to 'e' 5 steps)
// Now the word-1 is transformed to word-2 completely, so return "true".
import java.util.*;
public class Day44P1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int steps = sc.nextInt();
        sc.close();
        if (s1.length() != s2.length()) {
            System.out.println(false);
            return;
        }

        Map<Integer, Integer> shiftCount = new HashMap<>();
        
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            int diff = (ch2 - ch1 + 26) % 26;  
            
            if (diff == 0) continue;  
            
            int used = shiftCount.getOrDefault(diff, 0);
            int requiredStep = diff + 26 * used;
            
            if (requiredStep > steps) {
                System.out.println(false);
                return;
            }
            
            shiftCount.put(diff, used + 1); 
        }
        
        System.out.println(true);
        
       
        // Scanner sc = new Scanner(System.in);
        // String s1 = sc.nextLine();
        // String s2 = sc.nextLine();
        // int steps = sc.nextInt();
        // if(s1.length() != s2.length()){
        //     System.out.println(false);
        //     return;
        // }
        //  for(int i = 0 ; i < s1.length() ; i++){
        //     if(s1.charAt(i) != s2.charAt(i)){
        //         steps -= Math.abs(s1.charAt(i) - s2.charAt(i));
        //     }
        //     if(steps <= 0){
        //         System.out.println(false);
        //         return;
        //     }
        // }
        // System.out.println(true);
        // sc.close();
    }
}
