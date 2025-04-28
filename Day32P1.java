import java.util.*;
public class Day32P1 {
     public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] st = sc.nextLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);
        int [] nums = new int [n];
        String [] arr = sc.nextLine().split(",");
        for(int i = 0 ; i < n ; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        int totalPrice = 0;
        int lastElement = nums[nums.length - 1];
        for(int i = 0 ; i < nums.length - 1 ; i++){
            totalPrice += nums[i];
        }
        if(lastElement - k > 0){
            totalPrice += lastElement - k;
        }
        System.out.println(totalPrice + 1);
        sc.close();
    }
}
