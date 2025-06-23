/*
In a distant future, humanity has begun interstellar colonization, establishing zones of habitation and control on a new planet. Scientists have recorded two types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how the colonization started, with the first zone established and then expanding into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows how zones were positioned relative to each other on the map, based on territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy (binary tree of zones) and display them level wise.

Input Format:
--------------
An integer N representing the number of zones colonized.
A space-separated list of N integers representing the Planetary Layout Order (in-order).
A space-separated list of N integers representing the Survey Order ( pre-order ).

Output Format:
---------------
Print all zone IDs in level order:

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7

Sample Output:
---------------
3 2 4 5 6 7

Explanation:
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
        1
       / \
      2   3
     / \  / \
    4   5 6  7

Level Order: [1, 2, 3, 4, 5, 6, 7]

*/
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Day55P1 {
     public static TreeNode buildTree(int [] inOrder , int [] preOrder , int inStart , int inEnd , HashMap<Integer,Integer> inMap , int [] preIndex){
        if(inStart > inEnd) return null;
        
        int rootVal = preOrder[preIndex[0]++];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = inMap.get(rootVal);
        
        root.left = buildTree(inOrder,preOrder,inStart,inIndex - 1,inMap,preIndex);
        root.right = buildTree(inOrder,preOrder,inIndex + 1,inEnd,inMap,preIndex);
        
        return root;
    }
    public static List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> arr = new ArrayList<>();
        
        if(root == null) return arr;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            arr.add(node.val);
            
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return arr;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] inOrder = new int [n];
        int [] preOrder = new int [n];
        for(int i = 0 ; i < n ; i++){
            inOrder[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; i++){
            preOrder[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            inMap.put(inOrder[i],i);
        }
        int [] preIndex = {0};
        TreeNode root = buildTree(inOrder,preOrder,0,n-1,inMap,preIndex);
        List<Integer> levelOrder = levelOrderTraversal(root);
        for(int i : levelOrder){
            System.out.print(i + " ");
        }
        // System.out.println(levelOrder);
        sc.close();
    }
}
