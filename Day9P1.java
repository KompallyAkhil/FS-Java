// A security team is setting up surveillance cameras in a multi-floor building. 
// Each floor has a certain number of cameras, and every camera is assigned 
// a resolution value (in megapixels). The placement follows a hierarchical 
// structure, similar to a tree:
// 	- Floor 0 (Ground Floor) has a single main camera (root camera).
// 	- From the next floor onward, each camera can have at most two sub-cameras, 
// 	one on the left side and one on the right side.
// 	- If a camera does not have a sub-camera at a position, it is represented as -1.
	
// The goal is to identify the camera with the highest resolution on each floor to 
// ensure optimal security coverage.

// Input Format:
// -------------
// A single line of space separated integers, the resolution values of cameras

// Output Format:
// --------------
// A list of integers, where eech integer represents the maximum resolution camera 
// on that floor.


// Sample Input-1:
// ---------------
// 2 4 3 6 4 -1 9

// Sample Output-1:
// ----------------
// [2, 4, 9]


// Sample Input-2:
// ---------------
// 3 4 7 7 3 8 4 

// Sample Output-2:
// ----------------
// [3, 4, 8]
import java.util.*;
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
public class Day9P1 {
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
    public static void highestAtEachLevel(TreeNode root ,int level, List<Integer> answer){
        if(root == null){
            return;
        }
        if(level == answer.size()){
            answer.add(root.val);
        }
        answer.set(level, Math.max(answer.get(level), root.val));
        highestAtEachLevel(root.left, level+1, answer);
        highestAtEachLevel(root.right, level + 1, answer);
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
        highestAtEachLevel(root,0, answer);
        System.out.println(answer);
        sc.close();
    }
    
}
