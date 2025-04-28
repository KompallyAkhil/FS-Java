 /*
Ganesh has a habit of writing the words in backward order,
and writes the sentence without spaces.
 
Ganesh is given a sentence S (without spaces) and an integer C
His way of backward writing the sentence is as follows:
   - Break the sentence into 2C length words from begining to end.
   - Write the first C letters in backward direction of every 2C length word.
   - if there is a leftover word at the end of S with lenth lessthan 2C, then 
   - if length is lessthan C, write all the letters in backward direction.
   - if length is greater than or equal to C, write the first C letters
          in backward direction and keep the rest as it is.
           
 And return the sentence S after writing is completed.
 
Example of backward writing: 
Given sentence, S= "hellokmit" and C=2
Break the sentence into words: hell, okmi, t
Now apply backward writing on each word: ehll, komi, t
So, the final sentence is "ehllkomit"
 
 
Input Format:
-------------
Space separated string and integer, the word and C value
 
Output Format:
--------------
Print a string as result
 
 
Sample Input-1:
---------------
abcdefghijk 3

Sample Output-1:
----------------
cbadefihgjk
 

Sample Input-2:
---------------
appropriate 4
 
Sample Output-2:
----------------
rppaoprieta

*/

import java.util.*;

public class Day28P1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        String s = str[0];
        int c = Integer.parseInt(str[1]);
        int index = 0;
        int end = 2 * c;
        List<String> arr = new ArrayList<>();
        while(index < s.length()){
            int safe = Math.min(end,s.length());
            arr.add(s.substring(index,safe));
            index = end;
            end = (end) + (2 * c);
        }
        StringBuilder sb = new StringBuilder();
        for(String i : arr){
            StringBuilder  eachStr = new StringBuilder();
            if(i.length() > c){
                eachStr.append(i.substring(0,c));
                eachStr.reverse();
                eachStr.append(i.substring(c,i.length()));
                sb.append(eachStr.toString());
            }
            else{
                StringBuilder back = new StringBuilder();
                back.append(i.substring(0, i.length()));
                back.reverse();
                sb.append(back);
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
