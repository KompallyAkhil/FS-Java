/*
Write a program to construct a binary tree from level-order input, while treating -1 
as a placeholder for missing nodes. The program reads input, constructs the tree, 
and provides an in-order traversal to verify correctness.

Input Format:
---------------
Space separated integers, level order data (where -1 indiactes null node).

Output Format:
-----------------
Print the in-order data of the tree.


Sample Input:
----------------
1 2 3 -1 -1 4 5

Sample Output:
----------------
2 1 4 3 5

Explanation:
--------------
    1
   / \
  2   3
     / \
    4   5


Sample Input:
----------------
1 2 3 4 5 6 7

Sample Output:
----------------
4 2 5 1 6 3 7

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4  5 6  7

====================================
*/
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
public class Day7P1 {
    public static TreeNode builTreeNode(List<Integer> arr , int index){
        if (index >= arr.size() || arr.get(index) == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(index));

        root.left = builTreeNode(arr, 2 * index + 1); 
        root.right = builTreeNode(arr, 2 * index + 2);

        return root;
    }
   
    
    public static void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        System.out.print(root.val + " ");
        traversal(root.right);

    }

    public static void main(String[] args) {
        int [] nums = {1 ,2 ,3 ,-1, -1, 4, 5};
        List<Integer> list = new ArrayList<>();
        for(int i : nums) list.add(i);
        TreeNode node = builTreeNode(list, 0);
        traversal(node);
    }
    
}
