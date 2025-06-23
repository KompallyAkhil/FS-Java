/*
Galactic Communication Network
------------------------------
In a distant galaxy, an ancient civilization built a hierarchical communication network of interconnected relay stations. The structure of this network can be reconstructed using two ancient data logs:

Beacon Activation Order (analogous to in-order traversal)
Final Signal Sent Order (analogous to post-order traversal)
Using these logs, we can reconstruct the original relay network and process queries about signals reaching specific hierarchical levels.

Given the Beacon Activation Order and the Final Signal Sent Order of a galactic communication network, reconstruct the relay network. After reconstructing the hierarchy, and the output should list the relay stations in the order they appear in a level-wise transmission sequence.

Input Format:
-------------
An integer N representing the number of relay stations in the network.
A space-separated list of N integers representing the Beacon Activation Order (similar to in-order traversal).
A space-separated list of N integers representing the Final Signal Sent Order (similar to post-order traversal).

Output Format:
--------------
For each query, print the relay stations in order of their signal transmissions within the given depth range

Sample Input:
-------------
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
Sample Output:
---------------
[1, 2, 3, 4, 5, 6, 7]


Explanation:
The logs correspond to the following hierarchical relay network:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
The level order is : 1 2 3 4 5 6 7 
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
public class Day55P2 {
      public static TreeNode buildTree(int [] inOrder , int [] preOrder , int inStart , int inEnd , HashMap<Integer,Integer> inMap , int [] preIndex){
        if(inStart > inEnd) return null;
        
        int rootVal = preOrder[preIndex[0]--];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = inMap.get(rootVal);
        
        root.right = buildTree(inOrder,preOrder,inIndex + 1,inEnd,inMap,preIndex);
        root.left = buildTree(inOrder,preOrder,inStart,inIndex - 1,inMap,preIndex);
        
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
        int [] preIndex = {n - 1};
        TreeNode root = buildTree(inOrder,preOrder,0,n-1,inMap,preIndex);
        List<Integer> levelOrder = levelOrderTraversal(root);
        for(int i : levelOrder){
            System.out.print(i + " ");
        }
        sc.close();
    }
}
