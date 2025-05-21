// Indus Infra Ltd purchased a land of size L * W acres, for their upcoming venture.
// The land is divided into rectangular plots, using fences. They have kept some 
// H horizontal fences as hfences[] and V vertical fences as vfences[] on the land,
// where hfence[i] is the distance from the top of the land to the i-th horizontal
// fence and, vfence[j] is the distance from the top of the land to the j-th 
// vertical fence. Each 1*1 cell is one acre plot.

// Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
// Your task is to help Mr.RGV to find the biggest plot vailable after the fences 
// are setup in the venture.
// NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

// Input Format:
// -------------
// Line-1: 4 space separated integers, L,W,H and V
// Line-2: H space separated integers, hfence[] in the range [0, L]
// Line-3: V space sepaarted integers, vfence[] in the range [0, W]

// Output Format:
// --------------
// Print an integer result, the area of biggest plot.


// Sample Input-1:
// ---------------
// 5 6 2 2
// 2 3
// 2 5

// Sample Output-1:
// ----------------
// 6


// Sample Input-2:
// ---------------
// 5 6 1 1
// 3
// 4

// Sample Output-2:
// ----------------
// 12

import java.util.*;
public class Day46P2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        int H = Integer.parseInt(s[2]);
        int V = Integer.parseInt(s[3]);
        int [] hfence = new int [H + 2];
        int [] vfence = new int [V + 2];
        hfence[0] = 0;
        hfence[H + 1] = Integer.parseInt(s[0]);
        for(int i = 0 ; i < H ; i++){
            hfence[i] = sc.nextInt();
        }
        vfence[0] = 0;
        vfence[V + 1] = Integer.parseInt(s[1]);
        for(int i = 0 ; i < V ; i++){
            vfence[i] = sc.nextInt();
        }
        Arrays.sort(hfence);
        Arrays.sort(vfence);
        int h = 0;
        for(int i = 1 ; i < hfence.length ; i++){
            h = Math.max(h, hfence[i] - hfence[i - 1]);
        }
        int w = 0;
        for(int i = 1 ; i < vfence.length ; i++){
            w = Math.max(w, vfence[i] - vfence[i - 1]);
        }
        System.out.println(h + " " + w);
        System.out.println(h * w);
        sc.close();
    }
}
