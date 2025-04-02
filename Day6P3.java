// In a distant future, humanity has begun interstellar colonization, establishing 
// zones of habitation and control on a new planet. Scientists have recorded two 
// types of data regarding how these zones were structured:

// 1. Survey Order (analogous to pre-order traversal) – This record details how 
// the colonization started, with the first zone established and then expanding 
// into new zones following a systematic approach.
// 2. Planetary Layout (analogous to in-order traversal) – This document shows 
// how zones were positioned relative to each other on the map, based on 
// territorial boundaries.

// Using this information, scientists need to reconstruct the colonization hierarchy 
// (binary tree of zones) and analyze areas within a specific range of levels. 
// However, due to security concerns, patrol teams will scan these zones in a 
// zigzag pattern:
//     - Odd levels (starting from 1) should be inspected from left to right.
//     - Even levels should be inspected from right to left.

// Input Format:
// -------------
// An integer N representing the number of zones colonized.
// N space-separated integers representing the Planetary Layout Order (in-order).
// N space-separated integers representing the Survey Order (pre-order).
// Two space sepaarted integers,Lower Level (L), Upper Level (U)

// Output Format:
// --------------
// Print all zone IDs within the specified levels, but in spiral order:
//     - Odd levels → Left to Right.
//     - Even levels → Right to Left.

// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 1 2 4 5 3 6 7
// 2 3

// Sample Output:
// --------------
// 3 2 4 5 6 7

// Explanation:
// ------------
// The given Planetary Layout (in-order) and Survey Order (pre-order) correspond 
// to the following colonization hierarchy:

//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7

// Levels 2 to 3 in Regular Order:
// Level 2 → 2 3
// Level 3 → 4 5 6 7 

// Spiral Order:
// Level 2 (Even) → 3 2 (Right to Left)
// Level 3 (Odd) → 4 5 6 7 (Left to Right)
import java.util.*;
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

public class Day6P3 {
    private static int index = 0;
    public static TreeNode buildTree(int [] inOrder , int [] postOrder ,int start , int end , HashMap<Integer,Integer> inMap){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(postOrder[index++]);
        if(start == end){
            return root;
        }
        int inIndex = inMap.get(root.val);
        root.left = buildTree(inOrder, postOrder, start, inIndex - 1, inMap);
        root.right = buildTree(inOrder, postOrder, inIndex + 1, end - 1, inMap);
        return root;

    }
    public static List<Integer> getNodes(TreeNode root , int left , int right){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty() && left <= right) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                if(level >= left && level <= right){
                    currentLevel.add(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(level >= left && level <= right){
                if(level % 2 == 1){
                    result.addAll(currentLevel);
                }
                else{
                    Collections.reverse(currentLevel);
                    result.addAll(currentLevel);
                }
            }
            level++;
        }
        return result;
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
        int left = sc.nextInt();
        int right = sc.nextInt();
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0 ; i < size ; i++){
            inMap.put(inOrder[i], i);
        }
        index = 0;
        TreeNode root = buildTree(inOrder,postOrder,0,size - 1 , inMap);
        List<Integer> result = getNodes(root,left,right);
        System.out.println(result);
        sc.close();
    }
    
}
