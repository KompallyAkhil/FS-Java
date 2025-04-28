// /*
// You are provided a chocolate array, represented by the integer array "chocolates," which represents the number of chocolates in different boxes. Every second, you perform the following steps:

// 1. Choose the box with the most number of chocolates.
// 2. If there are multiple boxes with the most chocolates, you may select any one of them.
// 3. Take all the chocolates in that box, except for a square root number of chocolates that you leave behind.
// 4. Repeat the above steps for 'p' seconds.

// You have to calculate how many chocolates left after k seconds.

// Input Format:
// -------------
// Line-1: Two space separated integers, number of boxes N and number of seconds P.
// Line-2: N space seprated integers, chocolates[].

// Output Format:
// --------------
// Print an integer result, the number of chocolates left.


// Sample Input-1:
// ---------------
// 5 4
// 16 100 625 81 9

// Sample Output-1:
// ----------------
// 49

// Explanation: 
// -------------
// - In the first second, the middle box is chosen and 25 chocoloates are left behind.
// - Then the second box is chosen and 10 chocoloates are left behind.
// - After that the fourth box is chosen and 9 chocoloates are left behind.
// - Finally, the middle box is chosen again and 5 chocoloates are left behind.
// The final remaining chocoloates are [16,10,5,9,9], 
// so the total number of chocoloates remaining is 49.

// Sample Input-2:
// ---------------
// 5 8
// 1 1 1 1 1

// Sample Output-2:
// ----------------
// 5

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Day22P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            q.add(i);
        }
        while(k > 0){
            int ele = q.poll();
            q.add((int)Math.sqrt(ele));
            k--;
        }
        int sum = 0;
        while(!q.isEmpty()){
            sum += q.poll();
        }
        System.out.println(sum);
        sc.close();
    }
}
