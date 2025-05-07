import java.util.*;

public class Day36P2 {
    public static boolean checkCanWin(int [] nums , boolean [] visited ,int start){
        if(start > nums.length - 1 || start < 0 || visited[start]){
            return false;
        }
        if(nums[start] == 0){
            return true;
        }
        visited[start] = true;
        return checkCanWin(nums, visited,start + nums[start]) || checkCanWin(nums, visited,start - nums[start]);
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        boolean [] visited = new boolean[n];
        System.out.println(checkCanWin(nums,visited,pos));
        sc.close();
    }
}
