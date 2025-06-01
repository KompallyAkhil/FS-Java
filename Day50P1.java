// You are a stealthy archaeologist exploring a circular ring of ancient tombs located deep within a jungle. Each tomb holds a certain number of precious artifacts. However, these tombs are protected by an ancient magical curse: if you disturb two adjacent tombs during the same night, the entire ring activates a trap that seals you in forever.

// The tombs are arranged in a perfect circle, meaning the first tomb is adjacent to the last. You must plan your artifact retrieval carefully to maximize the number of artifacts collected in a single night without triggering the curse.

// Given an integer array  artifacts  representing the number of artifacts in each tomb, return the   maximum   number of artifacts you can collect without disturbing any two adjacent tombs on the same night.

// Example 1:  
// Input:
// 2 4 3
// Output:  
// 4   

// Explanation:   You cannot loot tomb 1 (artifacts = 2) and tomb 3 (artifacts = 3), as they are adjacent in a circular setup.

// Example 2:  
// Input:
// 1 2 3 1
// Output:  
// 4

// Explanation:   You can loot tomb 1 (1 artifact) and tomb 3 (3 artifacts) without breaking the ancient rule.  
// Total = 1 + 3 = 4 artifacts.

// Example 3:  
// Input:
// 1 2 3
// Output:  
// 3 

// Constraints:  
// -  1 <= artifacts.length <= 100 
// -  0 <= artifacts[i] <= 1000 
import java.util.*;
public class Day50P1 {
     // public static int check(int [] nums, int index){
    //     int sum = 0;
    //     while(index < nums.length){
    //         if(sum != 0 && index == nums.length - 1){
    //             break;
    //         }
    //         sum += nums[index];
    //         index += 2;
    //     }
    //     return sum;
    // }
    // public static void main(String [] args){
    //     Scanner sc = new Scanner(System.in);
    //     String [] s = sc.nextLine().split(" ");
    //     int [] nums = new int [s.length];
    //     for(int i = 0 ; i < s.length ; i++){
    //         nums[i] = Integer.parseInt(s[i]);
    //     }
    //     int [] sums = new int [nums.length];
    //     for(int i = 0 ; i < nums.length ; i++){
    //         sums[i] = check(nums,i);
    //     }
    //     int max = Arrays.stream(sums).max().getAsInt();
    //     System.out.println(max);
    //     sc.close();
    // }
    public static int check(int[] nums, int start, int end){
        int prev1 = 0, prev2 = 0;
        for(int i = start; i <= end; i++){
            int temp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        int [] nums = new int [s.length];
        for(int i = 0 ; i < s.length ; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int n = nums.length;
        if(n == 0){
            System.out.println(0);
        } else if(n == 1){
            System.out.println(nums[0]);
        } else {
            int option1 = check(nums, 0, n - 2); 
            int option2 = check(nums, 1, n - 1);
            System.out.println(Math.max(option1, option2));
        }
        sc.close();
    }
}