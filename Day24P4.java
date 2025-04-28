/* 
Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15
sample output-2
---------------
2,13


*/

import java.util.Scanner;

public class Day24P4 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int [] nums1 = new int [size1];
        for(int i = 0 ; i < size1 ; i++){
            nums1[i] = sc.nextInt();
        }
        int size2 = sc.nextInt();
        int [] nums2 = new int [size2];
        for(int i = 0 ; i < size2 ; i++){
            nums2[i] = sc.nextInt();
        }
        int closestNumber = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = nums2.length - 1;
        int answer1 = 0;
        int answer2 = 0;
        while(i < nums1.length && j >= 0){
            int answer = nums1[i] + nums2[j];
            int currDiff = Math.abs(closestNumber - answer);
            if(currDiff < min){
                answer1 = nums1[i];
                answer2 = nums2[j];
                min = currDiff;
            }
            if(answer < closestNumber){
                i++;
            }
            else if(answer > closestNumber){
                j--;
            }
            else{
                i++;
                j--;
            }
        }
        System.out.println(answer1+","+answer2);
        sc.close();
    }
}
