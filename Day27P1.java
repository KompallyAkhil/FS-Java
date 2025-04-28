import java.util.*;
public class Day27P1 {
    public static void generateBinaryString(int n , String str , List<String> binaryString){
        if(n == 0){
            binaryString.add(str);
            return;
        }
        generateBinaryString(n - 1,str + "0",binaryString);
        generateBinaryString(n - 1,str + "1",binaryString);
        
    }
    public static int convert(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i = 1 ; i < s.length() ; i++){
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            if(prev == curr){
                sb.append(0);
            }
            else{
                sb.append(1);
            }
        }
        return Integer.parseInt(sb.toString(),2);
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> binaryString = new ArrayList<>();
        generateBinaryString(n,"",binaryString);
        List<Integer> answer = new ArrayList<>();
        for(String i : binaryString){
            answer.add(convert(i));
        }
        System.out.println(answer);
        sc.close();
    }
    
}