// In a distant galaxy, an ancient civilization built a hierarchical communication 
// network of interconnected relay stations. The structure of this network can be 
// reconstructed using two ancient data logs:
//     - Beacon Activation Order (analogous to in-order traversal)
//     - Final Signal Sent Order (analogous to post-order traversal)
    
// Using these logs, we can reconstruct the original relay network and process q
// ueries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
// communication network, reconstruct the relay network. After reconstructing 
// the hierarchy, and the output should list the relay stations in the order they 
// appear in a level-wise transmission sequence.

// Input Format:
// -------------
// - An integer N representing the number of relay stations in the network.
// - A space-separated list of N integers representing the Beacon Activation Order 
//     (similar to in-order traversal).
// - A space-separated list of N integers representing the Final Signal Sent Order 
//     (similar to post-order traversal).

// Output Format:
// --------------
// A list of integers, level-wise transmission sequence.


// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// Sample Output:
// ---------------
// [1, 2, 3, 4, 5, 6, 7]


// Explanation:
// The logs correspond to the following hierarchical relay network:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// The level order is : 1 2 3 4 5 6 7 
// import java.util.*;
// class TreeNode{
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int val){
//         this.val = val;
//     }
//     TreeNode(int val,TreeNode left,TreeNode right){
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
// public class Day6P1 {
//     public static TreeNode traversal(List<Integer> inOrder, List<Integer> postOrder) {
//         if (inOrder.isEmpty() || postOrder.isEmpty()) {
//             return null;
//         }
        
//         int rootValue = postOrder.get(postOrder.size() - 1);
//         TreeNode root = new TreeNode(rootValue);
//         int rootIndex = inOrder.indexOf(rootValue);

//         List<Integer> leftInOrder = inOrder.subList(0, rootIndex);
//         List<Integer> rightInOrder = inOrder.subList(rootIndex + 1, inOrder.size());

//         List<Integer> leftPostOrder = postOrder.subList(0, leftInOrder.size());
//         List<Integer> rightPostOrder = postOrder.subList(leftInOrder.size(), postOrder.size() - 1);
    
//         root.left = traversal(leftInOrder, leftPostOrder);
//         root.right = traversal(rightInOrder, rightPostOrder);

//         return root;
//     }
//     public static List<Integer> levelOrderTraverse(TreeNode root){
//         List<Integer> result = new ArrayList<>();
//         if(root == null) return result;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             TreeNode node = queue.poll();
//             result.add(node.val);
//             if(node.left != null){
//                 queue.offer(node.left);
//             }
//             if(node.right != null){
//                 queue.offer(node.right);
//             }
//         }
//         return result;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int size = sc.nextInt();
//         int [] inOrder = new int[size];
//         int [] postOrder = new int[size];
//         for(int i = 0 ; i < size ; i++){
//             inOrder[i] = sc.nextInt();
//         }
//         for(int i = 0 ; i < size ; i++){
//             postOrder[i] = sc.nextInt();
//         }
//         List<Integer> arrInOrder = new ArrayList<>();
//         List<Integer> arrPostOrder = new ArrayList<>();
//         for(int i : inOrder) arrInOrder.add(i);
//         for(int i : postOrder) arrPostOrder.add(i);
//         TreeNode root = traversal(arrInOrder, arrPostOrder);
//         List<Integer> levelOrder = levelOrderTraverse(root);
//         System.out.println(levelOrder);
//         sc.close();
//     }
// }
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Day6P1 {
    
    private static int postIndex;
    private static Map<Integer, Integer> inMap;
    
    private static TreeNode buildTree(int[] inOrder, int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int rootVal = postOrder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        
        if (inStart == inEnd) return root;
        
        int inIndex = inMap.get(rootVal);
        
        root.right = buildTree(inOrder, postOrder, inIndex + 1, inEnd);
        root.left = buildTree(inOrder, postOrder, inStart, inIndex - 1);
        
        return root;
    }
    
    // Function to perform level-order traversal
    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] inOrder = new int[N];
        int[] postOrder = new int[N];
        
        for (int i = 0; i < N; i++) {
            inOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            postOrder[i] = sc.nextInt();
        }
        
        inMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inMap.put(inOrder[i], i);
        }
        
        postIndex = N - 1;
        
        TreeNode root = buildTree(inOrder, postOrder, 0, N - 1);
        
        List<Integer> result = levelOrder(root);
        
        System.out.println(result);
        sc.close();
    }
}
