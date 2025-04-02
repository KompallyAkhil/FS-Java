import java.util.*;
public class Day3P2 {
    public static boolean isPrimeNumber(String sub){
        if(Integer.valueOf(sub) <= 1){
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(Integer.valueOf(sub)) ; i++){
            if(Integer.valueOf(sub) % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime(String s , int k , String sub){
        return Integer.valueOf(s) % Integer.valueOf(sub) == 0 && isPrimeNumber(sub);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        int end = k;
        int i = 0;
        int count = 0;
        while (end <= s.length()){
            if(isPrime(s, k, s.substring(i,end))){
                count++;
            }
            i++;
            end++;
        }
        System.out.println(count);
        sc.close();
    }
}
