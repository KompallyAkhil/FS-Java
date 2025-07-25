// Rancho, Farhan and Raju also known as '3 Idiots' are good friends. 
// They found a treasure, which has 3N boxes and each box has some gold biscuits.

// They have decided to share the treasure as follows:
//     - Rancho selects 3 boxes each time, Among the boxes, he gives the box with 
//       more gold biscuits to Farhan and the onw with less gold biscuits given 
//       to Raju and the remaining box will be retained for himself.
//     - This will be repeated until all boxes are completed.

// You are given an array of integers as boxes[], where box[i] is the number of 
// gold bisucits in the ith box. Your mission is to assist Rancho in obtaining 
// the greatest number of gold biscuits possible before the treasure is shared.


// Input Format:
// -------------
// Line-1: an integer N represents the number of boxes.
// Line-2: N space seperated integers, the amount of gold biscuits in each box

// Output Format:
// --------------
// Print an integer, maximum amount of gold he can obtain.


// Sample Input-1:
// ---------------
// 6
// 3 5 1 2 4 7


// Sample Output-1:
// ----------------
// 8

// Explanation:
// ------------
// Step-1:selection will be (7,5,2) so Srikanth takes 5.
// Step-2: Selection will be (4,3,1) so srikanth takes 3.
// Total = 5+3=8


// Sample Input-2:
// ---------------
// 9
// 3 1 5 4 2 8 10 12 15

// Sample Output-2:
// ----------------
// 24

// Explanation:
// -------------
// Step-1:selection will be (15,12,2) so Srikanth takes 12.
// Step-2: Selection will be (10,8,1) so srikanth takes 8.
// Step-3: Selection will be (5,4,3) so srikanth takes 4.
// Total = 12+8+4=24

import java.util.*;
public class Day45P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int i = 0 ; 
        int j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j - 1];
            i++;
            j -= 2;
        }
        System.out.println(count);
        sc.close();
    }
}
