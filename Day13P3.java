/*
Pascal's Triangle looks like below:
			1
		  1  1
		1  2  1
	  1  3  3  1
ans so on... You can create N number of rows, rows are indexed from 0 onwards.

You are given an integer N,
Your task is to print N-th index Row of the Pascal's Triangle.

Input Format:
-------------
An integer N, index number.

Output Format:
--------------
Print the n-th index row of Pascal's Triangle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1 1


Sample Input-2:
---------------
3

Sample Output-2:
----------------
1 3 3 1

*/
import java.util.*;
public class Day13P3 {
    public static void main(String[] args) {
        int n = 1;
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        arr.add(nums);
        for(int i = 1 ; i <= n ; i++){
            List<Integer> pre = arr.get(i-1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0 ; j < i - 1; j++){
                row.add(pre.get(j) + pre.get(j+1));
            }
            row.add(1);
            arr.add(row);
        }
        System.out.println(arr.get(n));
    }
}
