// Given the preorder and postorder traversals of a binary tree, construct 
// the original binary tree and print its level order traversal.

// Input Format:
// ---------------
// Space separated integers, pre order data
// Space separated integers, post order data

// Output Format:
// -----------------
// Print list of list of integers, the level-order data of the tree.


// Sample Input:
// ----------------
// 1 2 4 5 3 6 7
// 4 5 2 6 7 3 1

// Sample Output:
// ----------------
// [[1], [2, 3], [4, 5, 6, 7]]

// Explanation:
// --------------
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7


// Sample Input:
// ----------------
// 1 2 3
// 2 3 1

// Sample Output:
// ----------------
// [[1], [2, 3]]

// Explanation:
// --------------
//     1
//    / \
//   2  3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day7P2 {
    private static int postIndex;
    
    public static TreeNode buildTree(int[] preOrder, int[] postOrder, int start, int end, HashMap<Integer, Integer> postMap) {
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preOrder[postIndex++]);
        
        if (start == end) {
            return root;
        }
        
        int postIndex = postMap.get(root.val);
        root.left = buildTree(preOrder, postOrder, start, postIndex, postMap);
        root.right = buildTree(preOrder, postOrder, postIndex + 1, end - 1, postMap);
        
        return root;
    }
    public static void lvlOrder(TreeNode root, List<List<Integer>> answer, int order) {
        if(root == null) {
            return;
        }
        if(answer.size() <= order) {
            answer.add(new ArrayList<>());
        }
        answer.get(order).add(root.val);
        lvlOrder(root.left, answer, order + 1);
        lvlOrder(root.right, answer, order + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] inOrder = new int[size];
        int [] postOrder = new int[size];
        for(int i = 0 ; i < size ; i++){
            inOrder[i] = sc.nextInt();
        }
        for(int i = 0 ; i < size ; i++){
            postOrder[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0 ; i < size ; i++){
            inMap.put(inOrder[i], i);
        }
        postIndex = 0;
        TreeNode root = buildTree(inOrder,postOrder,0,size - 1 , inMap);
        List<List<Integer>> answer = new ArrayList<>();
        lvlOrder(root, answer, 0);
        System.out.println(answer);
        sc.close();
    }
    
}
