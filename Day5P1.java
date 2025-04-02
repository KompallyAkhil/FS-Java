// You are given an integer array nums and two integers l and r. Your task is to 
// analyze the volatility of a sequence of values. The volatility of a sequence is 
// defined as the difference between the maximum and minimum values in that sequence.

// You need to determine the sequence with the highest volatility among all 
// sequences of length between l and r (inclusive).

// Return the highest volatility. If no such sequence exists, return -1.

// Input Format:
// -------------
// Line-1: 3 space separated integers, n, l, r
// Line-2: n space separated integers, nums[].

// Output Format:
// -------------
// An integer, the highest volatility.


// Sample Input-1:
// ---------------
// 5 2 3
// 8 3 1 6 2

// Sample Output-1:
// ----------------
// 7

// Explanation:
// ------------
// The possible sequences of length between l = 2 and r = 3 are:

// [8, 3] with a volatility of 8−3=5
// [3, 1] with a volatility of 3−1=2
// [1, 6] with a volatility of 6−1=5
// [8, 3, 1] with a volatility of 8−1=7
// The sequence [8, 3, 1] has the highest volatility of 7.

// Sample Input-2:
// ---------------
// 4 2 4
// 5 5 5 5

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// All possible sequences have no volatility as the maximum and minimum values 
// are the same, resulting in a difference of 0.

import java.util.*;
public class Day5P1 {
    public static int difference (List<Integer> arr ){
        return Math.abs(Collections.max(arr) - Collections.min(arr));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        int l = sc.nextInt();
        int r = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : nums) arr.add(i);
        int i = 0 ;
        int size = l;
        int s = r;
        int maxi = 0;
        while (size <= nums.length && s <= nums.length){
            int size1 = difference(arr.subList(i, size));
            int size2 = difference(arr.subList(i, s));
            maxi = Math.max(maxi,size1);
            maxi = Math.max(maxi, size2);
            i++;
            s++;
            size++;
        }
        System.out.println(maxi);
        sc.close();

    }
}
