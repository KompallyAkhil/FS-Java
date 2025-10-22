/*
Xavier working on bitwise operations on integer elements.
He is trying to find the maximum XOR value of two elements.
You will be given a list of integers elements list[],
Your task is to findout the maximum XOR value of two elements 
from the given list.

Input Format:
-------------
Line-1: An integer N, number of elements
Line-2: N space separated integers, Arrays of elements.

Output Format:
--------------
Print an integer, max value of XOR value of two elements.


Sample Input-1:
---------------
3
5 9 14

Sample Output-1:
----------------
12

Explanation:
------------
XOR of 5 and 9


Sample Input-2:
---------------
5
34 23 62 73 35

Sample Output-2:
----------------
119


Sample Input-3:
---------------
6
12 23 31 65 76 43

Sample Output-3:
----------------
106*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day77P2 {
    public static int maximum = 0;
    public static void backtrack(int [] nums , int index , List<Integer> arr){
        if(index == 2){
            int xor = arr.get(0) ^ arr.get(1);
            maximum = Math.max(maximum,xor);
            return;
        }
        for(int i = index ; i < nums.length ; i++){
            arr.add(nums[i]);
            backtrack(nums,index + 1,arr);
            arr.remove(arr.size() - 1);
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        backtrack(nums,0,new ArrayList<>());
        System.out.println(maximum);
        sc.close();
    }
}
