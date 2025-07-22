import java.util.*;
public class Day74P3 {
    public static int isABD(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char i : s.toCharArray()){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        Integer mini = hm.values().stream().min(Integer::compare).get();
        Integer maxi = hm.values().stream().max(Integer::compare).get();
        return Math.abs(mini - maxi);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                int valueOfABD = isABD(s.substring(i, j + 1));
                if(valueOfABD > 0){
                    count += valueOfABD;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
