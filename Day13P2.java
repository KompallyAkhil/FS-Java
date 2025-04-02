/*Mr. Kejriwal purchased a digital clock, it shows the time in "hh:mm" 24 hr format.
Due to technical issue, in the place of some digits of displays '#' symbol.

As Mr Kejriwal is an IIT student also, he got an idea to find the number of 
valid times by replacing '#' with valid digits between 0-9.

You are given the time as a string T.
Your task is to help Mr Kejriwal to find the number of possible valid times.

NOTE:
-----
The valid time is in the range of 00:00 to 23:59.


Input Format:
-------------
A string T, the time in the (24-hr) format as "hh:mm" 

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
#6:00

Sample Output-1:
----------------
2

Explanation:
------------
The valid times after replacing # with 0 or 1, are "06:00", "16:00". 


Sample Input-2:
---------------
0#:0#

Sample Output-2:
----------------
100

Explanation:
------------
To make the given time valid, replace 1st # with 0-9 digits and 2nd with the same.
So, totally we have 100 ways.
*/
import java.util.*;
public class Day13P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 1;
        if(s.charAt(0) == '#'){
            if(s.charAt(1) == '#' ){
                count *= 24;
            }
            else if (s.charAt(1) - '0' <= 3){
                count *= 3;
            }
            else{
                count *= 2;
            }
        }
        if(s.charAt(1) == '#'){
            if(s.charAt(0) == '2'){
                count *= 4;
            }
            else if(s.charAt(0) == '#'){
            }
            else{
                count *= 10;
            }
        }
        if(s.charAt(3) == '#'){
            count *= 6;
        }
        if(s.charAt(4) == '#'){
            count *= 10;
        }
        System.out.println(count);
        sc.close();
    }
}
