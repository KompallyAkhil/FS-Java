
import java.util.*;

public class Day37P3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        while(arr[0] != arr[arr.length - 1]){
            for(int i = 0 ; i < n - 1; i++){
                arr[i] = arr[i] + 1;
            }
            count++;
            Arrays.sort(arr);
        }
        System.out.println(count);
        sc.close();
    }
}
