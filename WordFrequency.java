import java.util.*;
public class WordFrequency {
    public static String isCheck(String s){
        StringBuilder sb = new StringBuilder();
        for(char i : s.toCharArray()){
            if(Character.isLetterOrDigit(i) || Character.isWhitespace(i)){
                sb.append(i);
            }
        }
        return sb.toString();
    }
     public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        Set<String> arr = new HashSet<>();
        for(String i : s){
            String f = isCheck(i);
            arr.add(f.toLowerCase());
        }
        HashMap<String,Integer> hm = new HashMap<>();
        for(String i : arr){
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        System.out.println(arr);
       for(String i : arr){
        System.out.println(hm.get(i));
       }
        sc.close();
    }
}
