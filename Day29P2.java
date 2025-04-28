// You are a database integrity engineer working for a global cloud company. 
// Your team maintains a distributed database network, where each server either:
//     - Stores equivalent data to another server (serverX == serverY).
//     - Stores different data from another server (serverX != serverY).

// The transitive consistency rule must be followed:
//     - If A == B and B == C, then A == C must be true.
//     - If A == B and B != C, then A != C must be true.

// Your task is to analyze the given constraints and determine whether they 
// follow transitive consistency. If all relations are consistent, return true; 
// otherwise, return false

// Input Format:
// -------------
// Space separated strnigs, list of relations

// Output Format:
// --------------
// Print a boolean value, whether transitive law is obeyed or not.


// Sample Input-1:
// ---------------
// a==b c==d c!=e e==f

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// a==b b!=c c==a

// Sample Output-2:
// ----------------
// false

// Explanation:
// ------------
// {a, b} form one equivalence group.
// {c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
// However, b != c contradicts b == a and c == a.

// Sample Input-3:
// ---------------
// a==b b==c c!=d d!=e f==g g!=d

// Sample Output-3:
// ----------------
// true

import java.util.Scanner;

public class Day29P2 {
    static int [] parent = new int [26];
    public static void initialize(){
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void union(int x , int y){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return;
        }
        if(px < py){
            parent[py] = px;
        }
        else{
            parent[px] = py;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        boolean found = true;
        initialize();
        for(String i : s){
            if(i.contains("==")){
                int c1 = i.charAt(0) -'a';
                int c2 = i.charAt(3) -'a';
                union(c1,c2);
            }
        }
        for(String i : s){
            if(i.contains("!=")){
                int c1 = i.charAt(0) -'a';
                int c2 = i.charAt(3) -'a';
                int findc1 = find(c1);
                int findc2 = find(c2);
                if(findc1 == findc2){
                    found = false;
                    break;
                }
            }
        }
        System.out.println(found);
        sc.close();
    }
}
