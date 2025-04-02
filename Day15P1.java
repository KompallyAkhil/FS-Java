/*
You have been tasked with managing scores in a unique game. 
The game begins with an empty scorecard. You are provided with a list 
of operations represented as a string of characters, denoted as operations[i], 
each corresponding to a specific action. These actions include:

A digit S: This means you should add a new score of S to the scorecard.
'A': This means you should add a new score to the scorecard, 
	which is the addition of the last two scores.
'D': This means you should add a new score to the scorecard, 
	which is double the value of the previous score.
'R': This means you should invalidate the previous score, 
	removing it from the scorecard.
	
Your objective is to calculate the sum of all the scores that remain on
the scorecard after performing all the specified operations.


Input Format:
-------------
A string consists of characters, represents series of operations.

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
526RDAA

Sample Output-1:
----------------
27

Explanation:
-----------
'5' - Add 5 to the scorecard, scorecard is now [5].
'2' - Add 2 to the scorecard, scorecard is now [5, 2].
'6' - Add 6 to the scorecard, scorecard is now [5, 2, 6].
'R' - Invalidate and remove the previous score, scorecard is now [5, 2].
'D' - Add 2 * 2 = 4 to the scorecard, scorecard is now [5, 2, 4].
'A' - Add 2 + 4 = 6 to the scorecard, scorecard is now [5, 2, 4, 6].
'A' - Add 4 + 6 = 10 to the scorecard, scorecard is now [5, 2, 4, 6, 10].
The total sum is 5 + 2+ 4 + 6 + 10 = 27.


Sample Input-2:
---------------
1R

Sample Output-2:
----------------
0
*/
import java.util.*;
public class Day15P1 {
    public static void main(String[] args) {
        String  s = "1R";
        Stack<Integer> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(i != 'A' && i != 'D' && i != 'R'){
                st.add(Integer.parseInt(String.valueOf(i)));
            }
            if(i == 'R'){
                if(!s.isEmpty()){
                    st.pop();
                }
            }
            if(i == 'D'){
                int top = st.peek();
                st.add(top * 2);
            }
            if(i == 'A'){
                if(st.size() > 2){
                    int one = st.pop();
                    int two = st.pop();
                    st.push(two);
                    st.push(one);
                    st.push(one + two);
                }

            }
        }
        int count = 0;
        while (!st.isEmpty()) {
            count += st.pop();
            
        }
        System.out.println(count);
    }
    
}