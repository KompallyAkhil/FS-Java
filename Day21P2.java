 /*
There are N laddus placed in a row. Each laddu has an ID printed on it.
IDs are printed in ascending order like as follows: S, S+1, S+2,...,E-2, E-1, E, 
where N = E-S+1.

Chota Bheem ate K number of laddus randomly from the row. You are given 
three integers K, S, E, and the IDs of the laddus eaten given as eaten[] array
in ascending order.

Your task is to find the ranges of IDs on the laddus remained in the row,
and print all the ranges as shown in the samples.

For example:
Given the IDs of the laddus eaten: [ 1, 2, 4, 51, 52, 53, 92, 93, 94, 95]
and S=1 E=100. The ranges of IDs of laddus which are remained in the row: 
[3, 5:50, 54:91, 96:100]

Note: The array eaten[] contains no duplicates.

Input Format:
-------------
Line-1: Three space separated integers, K, S and E.
Line-2: K space separated integers in sorted order, eaten[] IDs of laddus eaten.

Output Format:
--------------
Print the list of ID ranges in the row.


Sample Input-1:
---------------
9 0 20
0 1 2 3 4 5 8 9 10

Sample Output-1:
----------------
[6:7, 11:20]


Sample Input-2:
---------------
14 -50 50
-48 -47 -35 -20 -19 0 21 22 23 25 26 39 43 47

Sample Output-2:
----------------
[-50:-49, -46:-36, -34:-21, -18:-1, 1:20, 24, 27:38, 40:42, 44:46, 48:50]

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day21P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int e = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        List<String> l = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != s){
                int st = s;
                while(s < e && s != arr[i]){
                    s++;
                }
                s--;
                if(s == st){
                    String r = "" + st;
                    l.add(r);
                }
                else{
                    String r = st+":"+s;
                    l.add(r);
                }
                st = s;
                s++;
            }
            s++;
        }
        if(s < e){
            l.add(s+":"+e);
        }
        System.out.println(l);
            // String [] s = sc.nextLine().split(" ");
        // int size = Integer.parseInt(s[0]);
        // int starting = Integer.parseInt(s[1]);
        // int range = Integer.parseInt(s[2]);
        // int [] nums = new int[size];
        // for(int i = 0 ; i < size ; i++){
        //     nums[i] = sc.nextInt();
        // }
        // List<String> result = new ArrayList<>();
        // if(nums[0] != starting){
        //     int remaining = starting - nums[0];
        //     int z = nums[0] + remaining + 1;
        //     String f = String.format("%d:%d",starting,z);
        //     result.add(f);
        // }
        // for(int i = 0 ; i < nums.length - 1; i++){
        //     System.out.println(nums[i] - nums[i+1]);
        //     // if(nums[i] - nums[j] != 1){
        //     //     String e = String.format("%d:%d",)
                
        //     // }
        // }
        // System.out.println(result);
        
        // System.out.println(Arrays.toString(nums) + " " + starting + " " + range);
    }   
}
