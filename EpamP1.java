// Akhila is given a string S, Where S conatins only [aeiou] letters.
// A special subsequence defined as a sequence of letters derived from S
// that contains all five vowels in order. It means a specail subsequence 
// will have one or more a's followed by the one or more e's followed by 
// one or more i's followed by one or more o's followed by one or more u's.

// Your task is to help Akhila to return the length of the longest special 
// subsequence in S.

// Input Format:
// -------------
// Your code should be read input from the given attached file as a string (no line breaks)

// Output Format:
// --------------
// An integer, the length of longest subsequence.

// Sample input-1:
// ---------------
// aeeiooua

// Sample Output-1:
// ----------------
// 7

// Explanation:
// ------------
// Given S = "aeeiooua", then "aeiou" and "aeeioou" are special subsequences
// but "aeio" and "aeeioua" are not


// Sample input-2:
// ---------------
// aeiaaioooaauuuaeiou

// Sample Output-2:
// ----------------
// 10

import java.util.Scanner;

public class EpamP1 {
    public static void main(String [] args){
        // aeiaaioooaauuuaeiou
        // aeiou
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'a':
                    aCount++;
                    break;
                case 'e':
                    if (aCount > 0) {
                        eCount = Math.max(eCount, aCount) + 1;
                    }
                    break;
                case 'i':
                    if (eCount > 0) {
                        iCount = Math.max(iCount, eCount) + 1;
                    }
                    break;
                case 'o':
                    if (iCount > 0) {
                        oCount = Math.max(oCount, iCount) + 1;
                    }
                    break;
                case 'u':
                    if (oCount > 0) {
                        uCount = Math.max(uCount, oCount) + 1;
                    }
                    break;
            }
        }
        
        System.out.println(uCount);
        sc.close();
    }
}
