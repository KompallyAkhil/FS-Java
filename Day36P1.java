// Due to side effects of vaccination in Europe, Few people turned as zombies.
// And other people fight againest zombies called as warriors to save their lives.

// You are given a list of integers strength[], represent the strength of the people.
// all the people running in same line with same speed.
// If the strength value is negative the person is a zombie running towards left,
// If the strength value is positive the person is a warrior running towards right.
// and the absolute value represents their strength.

// If a zombie and a warrior meet, the person with smallest strength will die. 
// If both have the same strength, both will die. 
// Two persons moving in the same direction will never meet.

// Your task is to find out the list of strengths of people who will be alive. 

// Input Format:
// -------------
// space separated integers, list of strength[].

// Output Format:
// --------------
// Print the list of strengths people who will be alive.


// Sample Input-1:
// ---------------
// 4 9 -5

// Sample Output-1:
// ----------------
// 4 9

// Explanation:
// ------------
// The 9 and -5 meet resulting in 9. The 4 and 9 never meet.


// Sample Input-2:
// ---------------
// -3 -2 2 3

// Sample Output-2:
// ----------------
// -3 -2 2 3

// Explanation:
// ------------
// The people with the strengths,
// -3 and -2 moving left, 3 and 2 moving right. No one will die.


// Sample Input-3:
// ---------------
// 8 3 -6

// Sample Output-3:
// ----------------
// 8

// Explanation:
// ------------
// The people with the strengths,
// 3 and -6 meet, 3 will die, -6 is alive.
// And 8 and -6 meet, -6 will die, 8 is alive.

import java.util.*;

public class Day36P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        int [] nums = new int [s.length];
        for(int i = 0 ; i < s.length ; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i : nums){
            boolean alive = true;
            while (!stack.isEmpty() && stack.peek() > 0 && i < 0) {
                int last = stack.pop();
                if(Math.abs(last) > Math.abs(i)){
                    stack.push(last);
                    alive = false;
                    break;
                }
                else if(Math.abs(last) == Math.abs(i)){
                    alive = false;
                    break;
                }
            }
            if(alive){
                stack.push(i);
            }
        }
        System.out.println(stack);
        sc.close();
    }
}
