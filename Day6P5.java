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
// (binary tree of zones) and display them level wise.

// Input Format:
// --------------
// An integer N representing the number of zones colonized.
// A space-separated list of N integers representing the Planetary Layout Order (in-order).
// A space-separated list of N integers representing the Survey Order ( pre-order ).

// Output Format:
// ---------------
// Print all zone IDs in level order:

// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 1 2 4 5 3 6 7

// Sample Output:
// ---------------
// 3 2 4 5 6 7

// Explanation:
// The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7

// Level Order: [1, 2, 3, 4, 5, 6, 7]

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Day6P5 {

    // Method to build the tree using in-order and pre-order arrays
    public static TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inMap, int[] preIndex) {
        if (inStart > inEnd) return null;

        // Pick current node from pre-order traversal
        int rootVal = preorder[preIndex[0]++];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this node in in-order traversal
        int inIndex = inMap.get(rootVal);

        // Build left and right subtrees recursively
        root.left = buildTree(inorder, preorder, inStart, inIndex - 1, inMap, preIndex);
        root.right = buildTree(inorder, preorder, inIndex + 1, inEnd, inMap, preIndex);

        return root;
    }

    // Method to perform level-order traversal
    public static List<Integer> levelOrderTraversal(TreeNode root) {
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
        int[] inorder = new int[N];
        int[] preorder = new int[N];

        for (int i = 0; i < N; i++) inorder[i] = sc.nextInt();
        for (int i = 0; i < N; i++) preorder[i] = sc.nextInt();

        // Create a map for quick index lookup in in-order
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < N; i++) inMap.put(inorder[i], i);

        int[] preIndex = {0};  // Pointer to track pre-order traversal
        TreeNode root = buildTree(inorder, preorder, 0, N - 1, inMap, preIndex);

        // Get level-order traversal
        List<Integer> levelOrder = levelOrderTraversal(root);

        // Print result
        for (int val : levelOrder) {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();
    }
}
