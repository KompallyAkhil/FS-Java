import java.util.*;

public class Day42P2 {
    public static String find(String[] dict, String word) {
        String lowerWord = word.toLowerCase();
        String vowelMasked = mask(lowerWord);

        for (String d : dict) {
            if (d.equals(word)) return d; // Exact match
        }

        for (String d : dict) {
            if (d.equalsIgnoreCase(word)) return d; // Case-insensitive match
        }

        for (String d : dict) {
            if (mask(d.toLowerCase()).equals(vowelMasked)) return d; // Vowel-error match
        }

        return "";
    }
     public static String mask(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] dic = sc.nextLine().split(",");
        String [] words = sc.nextLine().split(",");
        List<String> answer = new ArrayList<>();
        for(String i : words){
            answer.add(find(dic,i));
        }
        System.out.println(answer);
        sc.close();
    }    
}
