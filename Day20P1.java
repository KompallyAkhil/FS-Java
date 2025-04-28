/*

"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1

Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
*/

import java.util.Scanner;
public class Day20P1 {
    public static boolean checkIsEmpathicWord(String s , String word){
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()){
            char c1 = s.charAt(i);
            char c2 = word.charAt(j);
            if(c1 != c2){
                return false;
            }
            int count1 = 0;
            int count2 = 0;
            while(i < s.length() && s.charAt(i) == c1){
                count1++;
                i++;
            }
            while(j < word.length() && word.charAt(j) == c2){
                count2++;
                j++;
            }
            if(count2 < count1 || (count2 < 3 &&  count2 != count1)){
                return false;
            }
        }
        return i == s.length() && j == word.length();
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        sc.nextLine();
        String [] isEmpathicWords = sc.nextLine().split(" ");
        int count = 0;
        for(String i : isEmpathicWords){
            if(checkIsEmpathicWord(i,word)){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
