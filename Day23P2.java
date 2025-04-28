import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day23P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        arr.add(nums);
        for(int i = 1 ; i <= n ; i++){
            List<Integer> pre = arr.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0 ; j < i - 1 ; j++){
                row.add(pre.get(j) + pre.get(j+1));
            }
            row.add(1);
            arr.add(row);
        }
        System.out.println(arr.get(n));
        sc.close();
    }
}
