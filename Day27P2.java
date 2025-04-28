// Naresh is working on expression of words.
// If you give him an expression like, [p,q,r]s[t,u],
// Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
// Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

// Naresh will be given an expression as a string EXP, like the above format.
// He needs to return all words that can be formed in like mentioned above, 
// Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

// NOTE: 
// Expression consist of lowercase alphabets, comma, and square brackets only.

// Input Format:
// -------------
// A string EXP, expression.

// Output Format:
// --------------
// Print list of words, formed from the expression.


// Sample Input-1:
// ---------------
// [b]c[e,g]k

// Sample Output-1:
// ----------------
// [bcek, bcgk]


// Sample Input-2:
// ---------------
// [a,b][c,d]

// Sample Output-2:
// ----------------
// [ac, ad, bc, bd]


// Sample Input-3:
// ---------------
// [xyz]a[b,c]

// Sample Output-3:
// ----------------
// [xyzab, xyzac]

import java.util.*;

public class Day27P2 {
    public static void backtrack(List<List<String>> parts,int index,StringBuilder current ,List<String> result){
        if(index == parts.size()){
            result.add(current.toString());
            return;
        }
        for(String i : parts.get(index)){
            current.append(i);
            backtrack(parts,index + 1 ,current,result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<String>> parts = new ArrayList<>();
        int i = 0;
        while( i < s.length()){
            if(s.charAt(i) == '['){
                List<String> group = new ArrayList<>();
                i++;
                while (s.charAt(i) != ']'){
                    if(s.charAt(i) != ','){
                        group.add(String.valueOf(s.charAt(i)));
                    }
                    i++;
                }
                parts.add(group);
                i++;
            }
            else{
                parts.add(Collections.singletonList(String.valueOf(s.charAt(i))));
                i++;
            }
        }
        List<String> result = new ArrayList<>();
        backtrack(parts,0,new StringBuilder(),result);
        System.out.println(result);
        sc.close();
    }
}
