/*
A wall clock is a complete whole circle and cover 360°.
You are given the time as HH:MM.
Your task is to return the angle between the Hours hand and Minutes hand
of the clock and the angle should not be reflex angle.

Input Format:
-------------
A string time, HH:MM

Output Format:
--------------
Print a double result, within 10^-5 of the original value.


Sample Input-1:
---------------
04:30

Sample Output-1:
----------------
45.00000


Sample Input-2:
---------------
06:15

Sample Output-2:
----------------
97.50000
*/

import java.util.*;

public class Day71P2 {
    public static double calculateAngle(int hour , int minute){
        double minuteAngle = minute * 6;
        double hourAngle = (hour * 30) + (minute * 0.5);
        double angleDifference = Math.abs(hourAngle - minuteAngle);
        return Math.min(angleDifference , 360 - angleDifference);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(":");
        System.out.println(calculateAngle(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        sc.close();
    }
}
