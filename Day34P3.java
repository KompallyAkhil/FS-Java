// In a garden, there is a row of plants. The gardener need to water them regularly.
// In the row of plants, some are empty places some are plants. you need to setup 
// the watering kits to water the row of plants at the empty places. A watering kit
// can supply water to its adjacent plants, i.e., if the watering kit is at 
// i-th position it can water the plants ar 'i+1'-th and 'i-1'-th  positions.

// You are given a string 'plants', consists of two characters only [P,E], where P 
// indiactes plant and E indicates empty place.

// Your task is to return the minimum number of watering kits needed so that 
// for every plant, the gardener can supply the water to all the plants in that 
// row OR -1 if it is impossible.


// Input Format:
// -------------
// A string, consists of only two characters P and E

// Output Format:
// --------------
// Print an integer result, the minimum num of watering kits.


// Sample Input-1:
// ---------------
// PEEEPEP

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// You can setup watering kits at index-1, index-5, so all the 3 plants gets water.


// Sample Input-2:
// ---------------
// PEPEEPP

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// ------------
// No empty place after the last plant in the row, so retrun -1.

import java.util.*;

public class Day34P3 {
    public static void main(String[] args) {
        String s = "PEEEPEP";
        int count = 0;
        if(s.startsWith("PP") || s.endsWith("PP") || s.indexOf("PPP") != -1){
            System.out.println(-1);
            return;
        }
        char [] st = s.toCharArray();
        for(int i = 0 ; i < st.length ; i++){
            if (st[i] == 'P') {
                // Try to place watering kit on the right side
                if (i + 1 < st.length && st[i + 1] == 'E') {
                    st[i + 1] = 'W'; // mark watering kit
                    count++;
                }
                // If not possible, try left side
                else if (i - 1 >= 0 && st[i - 1] == 'E') {
                    st[i - 1] = 'W'; // mark watering kit
                    count++;
                }
                // Otherwise, it's impossible to water this plant
                else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(Arrays.toString(st));
        System.out.println(count);
        // public static void main(String []args){
        // Scanner sc=new Scanner(System.in);
        // String str=sc.nextLine();
        // char c[]=str.toCharArray();
        // int res=0;
        // int p=0;
        // for(char ch:c){
        //     if(ch=='P')p++;
        // }
        // for(int i=1;i<c.length-1;i++){
        //     if(c[i]=='E' && c[i-1]=='P' && c[i+1]=='P'){
        //         res++;
        //         p-=2;
        //         i+=2;
        //     }
        // }
        // res+=p;
        // if(str.startsWith("PP") || str.endsWith("PP") || str.indexOf("PPP")!=-1) res=-1;
        // System.out.println(res);
    // }
    }
}
