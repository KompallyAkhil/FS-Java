
import java.util.*;

public class Day64P1 {
     public static int checkSum(int [] nums){
        int maximum = nums[0];
        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            sum = Math.max(nums[i],sum + nums[i]);
            maximum = Math.max(maximum,sum);
        }
        return maximum;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        int [] nums = new int [s.length];
        for(int i = 0 ; i < s.length ; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            int [] modified = Arrays.copyOf(nums,nums.length);
            modified[i] = modified[i] * modified[i];
            maxi = Math.max(maxi,checkSum(modified));
        }
        System.out.println(maxi);
        sc.close();
    }
}
