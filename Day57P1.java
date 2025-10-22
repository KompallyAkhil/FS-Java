/*
You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6
*/
import java.util.*;

public class Day57P1 {
    // Compare two version strings
    public static int compareVersions(String v1, String v2) {
        String[] a1 = v1.split("-");
        String[] a2 = v2.split("-");
        int n = Math.max(a1.length, a2.length);

        for (int i = 0; i < n; i++) {
            int num1 = i < a1.length ? Integer.parseInt(a1[i]) : 0;
            int num2 = i < a2.length ? Integer.parseInt(a2[i]) : 0;

            if (num1 != num2)
                return num1 - num2; // positive means v1 > v2
        }
        return 0; // equal
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] versions = sc.nextLine().split(" ");

        String latest = versions[0];
        for (int i = 1; i < versions.length; i++) {
            if (compareVersions(versions[i], latest) > 0)
                latest = versions[i];
        }

        System.out.println(latest);
        sc.close();
    }
}
