// /*
// Gunith is interested in series and sequence problems in Maths.
// Gunith is given an array A of integers, he wants to find out 
// a Sequence, which is long and subsequence of given array.

// Subsequence AS is the list AS[i], AS[i1], AS[i2], .... AS[ik], from the array, 
// where 0 <= i< i1 < i2 < ..<ik < A.length

// The sequence S has to follow this rule, S[i+1] - S[i] are all the same value 
// (for 0 <= i < S.length - 1 ), and Sequence S can be formed from A

// Find out the Max possible length of the Longest Sequence.

// Input Format:
// -------------
// Line-1 -> An integer N, number of array elements
// Line-2 -> N space separated integers, elements of the array.

// Output Format:
// --------------
// Print an integer as your result.


// Sample Input-1:
// ---------------
// 4
// 2 6 10 14

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// 7
// 2 5 6 8 10 11 14

// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// The longest possible arithmetic series is 2 5 8 11 14.

import java.util.*;

public class Day60P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int maxLen = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                List<Integer> seq = new ArrayList<>();

                if (hm.containsKey(diff)) {
                    seq = new ArrayList<>(hm.get(diff));

                    // Check if we can extend the last element in the sequence
                    if (seq.get(seq.size() - 1) == nums[i]) {
                        seq.add(nums[j]);
                    } else if (!seq.contains(nums[i])) {
                        seq.add(nums[i]);
                        seq.add(nums[j]);
                    }
                } else {
                    // First time for this diff, start a new sequence
                    seq.add(nums[i]);
                    seq.add(nums[j]);
                }

                hm.put(diff, seq);
                maxLen = Math.max(maxLen, seq.size());
            }
        }
        System.out.println(hm);
        System.out.println(maxLen);
    //      public static int longestArithmeticSubsequence(int[] arr) {
    //     int n = arr.length;
    //     if (n <= 1) return n;
    //     int maxLen = 0;
    //     HashMap<Integer, Integer>[] dp = new HashMap[n];
    //     for (int i = 0; i < n; i++) {
    //         dp[i] = new HashMap<>();
    //         for (int j = 0; j < i; j++) {
    //             int diff = arr[i] - arr[j];
    //             int len = dp[j].getOrDefault(diff, 1) + 1;
    //             dp[i].put(diff, len);
    //             maxLen = Math.max(maxLen, len);
    //         }
    //     }
    //     return maxLen;
    // }
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     for(int i = 0; i < n; i++) {
    //         arr[i] = sc.nextInt();
    //     }
    //     System.out.println(longestArithmeticSubsequence(arr));
    // }
        // int difference = nums[1] - nums[0];
        // int count = Integer.MIN_VALUE;
        // int size = 1;
        // int prev = nums[0];
        // for(int i = 1 ; i < nums.length - 1 ; i++){
        //     if(nums[i] - prev == difference){
        //         prev = nums[i];
        //         size++;
        //         count = Math.max(count, size);
        //     }
        //     else{
        //         continue;
        //     }
        // }
        // System.out.println(count + 1);
        sc.close();
    }
}
