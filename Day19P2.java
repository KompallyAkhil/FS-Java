/*
In a forest, There are N redwoord trees in a row.
You are given the heights of the trees as heights[],

You are task is to find the longest tree arrangement as follows:
	- Minimum size of the tree arrangement is 3.
	- And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
		- heights[0] < heights[1] < heights[2] <...< heights[i] and
		-  heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1] 

And return the length of the longest tree arrangement.
If there is no such arrangement, return 0.

Input Format:
-------------
Line-1: An integer N, number of elements.
Line-2: N space separated integers, value of the elements.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
8
4 2 5 7 4 2 3 6

Sample Output-1:
----------------
5

Explanation:
------------
The longest tree arrangement is : 2 5 7 4 2


Sample Input-2:
---------------
4
2 4 5 7

Sample Output-2:
----------------
0
*/
import java.util.*;
public class Day19P2 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] arr = new int [size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for(int i = 1 ; i < arr.length - 1 ; i++){
            if(arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                int left = i - 1;
                int right = i + 1;
                while(left > 0 &&  arr[left - 1] < arr[left]){
                    left--;
                }
                while(right < arr.length - 1 && arr[right] > arr[right + 1]){
                    right++;
                }
                ans = Math.max(ans,right - left + 1);   
                i = right;
            }
        
        }
        System.out.println(ans);
        sc.close();
    }
}
