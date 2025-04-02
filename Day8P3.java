// In an Intelligence Agency, each senior officer supervises either two junior officers 
// or none. The senior officer is assigned a clearance level equal to the higher clearance 
// level of the two junior officers they supervise.

// The clearance levels are represented as integer values in the range [1, 50], and 
// multiple officers may have the same clearance level.

// At the end, all officers (senior and junior) are collectively referred to as 
// agents in the system.

// You are provided with a hierarchical clearance level tree where each node represents 
// an officer's clearance level. The tree structure follows these rules:
// 	- If a node has two children, its clearance level is the maximum of the two children's
// 	  clearance levels.
// 	- If a node has no children, it's clearance level is same as exists.
// 	- The value -1 indicates an empty (null) position.
// Your task is to find the second highest clearance level among all agents in the agency. 
// If no such level exists, return -2.

// Input Format:
// -------------
// A single line of space separated integers, clearance levels of each individual.

// Output Format:
// --------------
// Print an integer, second top agent based on rank.


// Sample Input-1:
// ---------------
// 5 5 4 -1 -1 2 4

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// 3 3 3 3 3

// Sample Output-2:
// ----------------
// -2

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
public class Day8P3 {
    public static TreeNode buildTree(List<Integer> arr , int start){
        // if (start >= arr.size() || arr.get(start) == -1) {
        //     return null;
        // }

        // TreeNode root = new TreeNode(arr.get(start));

        // root.left = buildTree(arr, 2 * start + 1);
        // root.right = buildTree(arr, 2 * start + 2);

        // return root;
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
    public static int findSecondHighest(TreeNode root) {
        if (root == null) return -2;

        int max1 = -1, max2 = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val > max1) {
                max2 = max1;
                max1 = node.val;
            } else if (node.val < max1 && node.val > max2) {
                max2 = node.val;
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return (max2 == -1) ? -2 : max2;
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
        System.out.println(findSecondHighest(root));
        sc.close();
    }
    
}
