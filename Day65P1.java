// Prabhath is working on words.  He used to take out every letter that was repeated 
// in the word. 
// A word W is given to Prabhath. His objective is to eliminate every duplicate 
// letter from W such that the resultant word R contains every unique letter from W
// and did not contain any duplicate letters. 
// And R should be at the top of the dictionary order.

// NOTE:
// -----
// He is not allowed to shuffle the relative order of the letters of the word W to
// create the word R.

// Input Format:
// -------------
// A String, the word W.

// Output Format:
// --------------
// Print a String, resultant word R.


// Sample Input-1:
// ---------------
// cbadccb

// Sample Output-1:
// ----------------
// adcb


// Sample Input-2:
// ---------------
// silicosis

// Sample Output-2:
// ----------------
// ilcos
import java.util.*;
public class Day65P1 {
     public static void main(String [] args){
        // silicosis
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char i : s.toCharArray()){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        Set<Character> set = new HashSet<>();
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.get(ch) - 1);
            if (set.contains(ch)) continue;

            while (!st.isEmpty() && ch < st.peek() && hm.get(st.peek()) > 0) {
                set.remove(st.pop());
            }

            st.push(ch);
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char i : st){
            sb.append(i);
        }
        System.out.println(sb.toString());
        sc.close();
    }
    
}