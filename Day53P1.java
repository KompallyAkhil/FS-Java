/*
You are participating in a futuristic space exploration mission where you must
navigate through a series of planets aligned in a straight line.
The planets are numbered from 0 to n-1, and you start your journey on planet 0.

You are given a 0-indexed array planets, where each element planets[i] 
represents the maximum number of planets you can move forward from planet i. 
In simpler terms, standing on planet i, you can move to any planet from i+1 to
i+planets[i], as long as you don't exceed the last planet.

Your goal is to reach the final planet (planet n-1) in the fewest number of 
moves possible.

It is guaranteed that a path to the final planet always exists.

Return the minimum number of moves needed to reach planet n-1.

Example 1
----------
Input:
2 3 1 0 4
Output:
2

Explanation:
- Move from planet 0 to planet 1.
- Move from planet 1 to planet 4 (last planet).

*/

import java.util.*;

public class Day53P1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        int [] nums = new int [s.length];
        for(int i = 0 ; i < s.length ; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int count = 0;
        int index = 0;
        int end = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            index = Math.max(index , i + nums[i]);
            if(i == end){
                count++;
                end = index;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
