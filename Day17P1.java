// You are provided with an array of integers called 'score,' with 'n' elements, 
// where 'score[i]' represents the performance score of the ith participant 
// in a competitive event. It is guaranteed that all the scores are distinct.

// The participants' final positions are determined solely by their performance scores, 
// with the top performer ( with highest score), securing the 1st position, 
// the second-best performer obtaining the 2nd position, and so forth. 
// Each participant's rank is directly related to their placement:
// 	- The participant in the 1st position is awarded the 'Champion'
// 	- The participant in the 2nd position receives the 'RunnerUp-1'
// 	- The participant in the 3rd position is granted the 'RunnerUp-2'
// 	- For participants ranked from 4th to 'n,' their rank corresponds to 
// 	their position (i.e., the participant in the xth position is assigned the rank 'x').

// Your task is to generate an array named 'answer' of size 'n' 
// Each element 'answer[i]' in this array should represent the rank achieved 
// by the ith participant.

// Input Format:
// -------------
// Line-1: An integer N, number of participants.
// Line-2: N space seprated integers, scores[].

// Output Format:
// --------------
// Print the list of ranks of the participants.


// Sample Input-1:
// ---------------
// 5
// 10 3 9 8 4

// Sample Output-1:
// ----------------
// [Champion, 5, RunnerUp-1, RunnerUp-2, 4]


// Sample Input-2:
// ---------------
// 8
// 10 3 9 4 2 7 6 1

// Sample Output-2:
// ----------------
// [Champion, 6, RunnerUp-1, 5, 7, RunnerUp-2, 4, 8]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day17P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        int [] nums1 = nums.clone();
        Arrays.sort(nums1);
        HashMap<Integer,String> hm = new HashMap<>();
        for(int i = nums1.length - 1; i >= 0 ; i--){
            if(i == nums.length - 1){
                hm.put(nums1[i], "Champaion");
            }
            else if(i == nums.length -2){
                hm.put(nums1[i], "Runner-Up 1");
            }
            else if(i == nums.length -3){
                hm.put(nums1[i], "Runner-Up 2");
            }
            else{
                hm.put(nums1[i], String.valueOf(nums1.length - i));
            }
        }
        List<String> arr = new ArrayList<>();
        for(int i : nums){
            arr.add(hm.get(i));
        }
        System.out.println(arr);
        sc.close();
    }
    
}
