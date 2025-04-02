import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val , TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Day9P3 {
      public static TreeNode buildTree(List<Integer> arr , int start){
        TreeNode root = new TreeNode(arr.get(start));
        int j = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty() && j < arr.size()){
            TreeNode cur = q.poll();
            if(arr.get(j) != -1){
                cur.left = new TreeNode(arr.get(j));
                q.add(cur.left);
            }
            j++;
            if(j < arr.size()  && arr.get(j) != -1){
                cur.right = new TreeNode(arr.get(j));
                q.add(cur.right);
            } 
            j++;
        }
        return root;
    }
    public static void leftMostElementAtEachLevel(TreeNode root , int level ,List<Integer> answer){
        if(root == null){
            return;
        }
        if(level == answer.size()){
            answer.add(root.val);
        }
        answer.set(level,root.val);
        leftMostElementAtEachLevel(root.left, level + 1, answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String [] nums = s.split(" ");
        int [] arr = new int [nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        List<Integer>  nums1 = new ArrayList<>();
        for(int i : arr){
            nums1.add(i);
        }
        TreeNode root = buildTree(nums1,0);
        List<Integer> answer = new ArrayList<>();
        leftMostElementAtEachLevel(root,0, answer);
        System.out.println(answer);
        sc.close();
    }
}
