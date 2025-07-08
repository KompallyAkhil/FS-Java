// Given two strings S1 and S2, find if S2 can match S1 or not.

// A match that is both one-to-one (an injection) and onto (a surjection), 
// i.e. a function which relates each letter in string S1 to a separate and 
// distinct non-empty substring in S2, where each non-empty substring in S2
// also has a corresponding letter in S1.

// Return true,if S2 can match S1.
// Otherwise false.

// Input Format:
// -------------
// Line-1 -> Two strings S1 and S2

// Output Format:
// --------------
// Print a boolean value as result.


// Sample Input-1:
// ---------------
// abab kmitngitkmitngit

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// aaaa kmjckmjckmjckmjc

// Sample Output-2:
// ----------------
// true

// Sample Input-3:
// ---------------
// mmnn pqrxyzpqrxyz

// Sample Output-3:
// ----------------
// false
import java.util.*;
public class Day66P1 {
    public static boolean check(String s1 , String s2){
        return backtrack(s1,s2,0,0,new HashMap<>(),new HashSet<>());
    }
    public static boolean backtrack(String s1 , String s2 , int i , int j , Map<Character,String> hm , Set<String> set){
        if(i == s1.length() && j == s2.length()) return true;
        if(i == s1.length() || j == s2.length()) return false;
        
        char ch = s1.charAt(i);
        
        if(hm.containsKey(ch)){
            String mapped = hm.get(ch);
            if(!s2.startsWith(mapped,j)) return false;
            return backtrack(s1,s2,i + 1 , j + mapped.length(),hm,set);
        }
        
        for(int k = j + 1 ; k <= s2.length() ; k++){
            String candidate = s2.substring(j,k);
            if(set.contains(candidate)) continue;
            
            hm.put(ch,candidate);
            set.add(candidate);
            
            if(backtrack(s1,s2,i+1,k,hm,set)) return true;
            
            hm.remove(ch);
            set.remove(candidate);
        }
        return false;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        String s1 = s[0];
        String s2 = s[1];
        System.out.println(check(s1,s2));
        sc.close();
    }
    
}