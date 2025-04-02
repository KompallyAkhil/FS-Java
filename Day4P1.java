// In a film festival, there is a lineup of movies, each with a rating. The festival 
// organizer wants to find the maximum total rating of 'k' sequence of movies while 
// following these rules:
//     1. The sequence must be exactly k movies long.
//     2. Each movie in the sequence must have a distinct rating.
//     3. None of the movies in the sequence should have a restricted rating, as 
//        these are reserved for special screenings.

// Given an array movieRatings representing the sequence of movie ratings, an integer k 
// representing the length of the sequence, and a set restrictedRatings (of size m) of 
// special ratings, find the maximum total rating of any valid sequence. 
// If no valid sequence exists, return -1.

// Input Format:
// -------------
// Line-1: 3 space separated integers, n, k, m
// Line-2: n space separated integers, movieRatings[].
// Line-3: m space separated integers, restrictedRatings[].

// Output Format:
// -------------
// An integer, the maximum total rating of any valid sequence


// Sample Input-1:
// ---------------
// 7 3 2
// 1 5 4 2 9 9 9
// 2 9

// Sample Output-1:
// ----------------
// 10

// Explanation: 
// ------------
// The sequences of movie ratings with length 3 are:
// - [1, 5, 4] which meets the requirements and has a total rating of 10.
// - [5, 4, 2] which does not meet the requirements because 2 is in the 
// restricted set.
// - [4, 2, 9] which does not meet the requirements because 2 and 9 are in 
// the restricted set.
// - [2, 9, 9] which does not meet the requirements because 2 and 9 are in 
// the restricted set and 9 is repeated.
// - [9, 9, 9] which does not meet the requirements because 9 is in 
// the restricted set and repeated.

// We return 10 because it is the maximum total rating of all the sequences 
// that meet the conditions.


// Sample Input-2:
// ---------------
// 3 3 1
// 4 4 4
// 4

// Sample Output-2:
// ----------------
// -1

// Explanation: The sequences of movie ratings with length 3 are:
// [4, 4, 4] which does not meet the requirements because 4 is repeated and in the 
// restricted set.
// We return -1 because no sequences meet the conditions.

// Constraints:
// ------------
// 0 <= m <= n <=1000
// k <= n
// 0 ≤ restrictedRatings.length ≤ 1000
import java.util.*;
public class Day4P1 {
    public static int sumOfValid(List<Integer> arr , List<Integer> notValidIntegers){
        int sum = 0;
        for(int i : arr){
            if(notValidIntegers.contains(i)){
                return -1;
            }
            else{
                sum += i;
            }
        }
        return sum;
    }
    public static int validSum(int sums , int front , int last , List<Integer> notValidIntegers){
        if(notValidIntegers.contains(front) && notValidIntegers.contains(last)){
            return -1;
        }
        return sums;
    }
    public static void main(String[] args) {
        int [] nums = {1 ,5 ,4 ,2 ,9, 9, 9};
        int [] restrict = {2,9};
        int size = 3;
        List<Integer> arr = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        for(int i : restrict) set.add(i);
        for(int i : nums) arr.add(i);
        int sums = 0;
        for(int i = 0 ; i < size ; i++){
            sums += arr.get(i);
        }
        System.out.println(sums);
        int start = 0;
        int end = size;
        int maxi = -1;
        while (end <= arr.size()){
            int front = arr.get(start);
            int last = arr.get(end - 1);
            sums -= front;
            int sumOfs = validSum(sums, front, last, set);
            System.out.println(sums);
            System.out.println(sumOfs);
            sums += last;
            start++;
            end++;
            // System.out.println(arr.subList(start,end));
            // if(set.contains(front) || set.contains(last)){
                
            // }
            // System.out.println(front);
            // System.out.println(last);
            // int sumOf = sumOfValid(arr.subList(start, end), set);
            // maxi = Math.max(maxi, sumOf);
            // System.out.println(sumOfValid(arr.subList(start, end), set));
            // System.out.println(arr.subList(start, end));
        }
        System.out.println(maxi);
    }
    
}
