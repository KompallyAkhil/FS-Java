/*
Bubloo is working with computer networks, where servers are connected 
in a hierarchical structure, represented as a Binary Tree. Each server (node) 
is uniquely identified by an integer value.

Bubloo has been assigned an important task: find the shortest communication 
path (in terms of network hops) between two specific servers in the network.

Network Structure:
------------------
The network of servers follows a binary tree topology.
Each server (node) has a unique identifier (integer).
If a server does not exist at a certain position, it is represented as '-1' (NULL).

Given the root of the network tree, and two specific server IDs (E1 & E2), 
determine the minimum number of network hops (edges) required to 
communicate between these two servers.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
4 8

Sample Output-1:
----------------
4

Explanation:
------------
The edegs between 4 and 8 are: [4,1], [1,2], [2,3], [3,8]


Sample Input-2:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
6 6

Sample Output-2:
----------------
0

Explanation:
------------
No edegs between 6 and 6.
*/

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
public class Day11P3 {
    public static TreeNode LeastCommonAncestor(TreeNode root , int val1 , int val2 ){
        if (root == null || root.val == val1 || root.val == val2) {
            return root;
        }

        TreeNode left = LeastCommonAncestor(root.left, val1, val2);
        TreeNode right = LeastCommonAncestor(root.right, val1, val2);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
        // if (left != null && right != null) {
        //     return root; 
        // }

        // return (left != null) ? left : right; 
        // while (root != null) {
        //     if(val1.val > root.val && val2.val > root.val){
        //         root = root.right;
        //     }
        //     else if(val1.val < root.val && val2.val < root.val){
        //         root = root.left;
        //     }
        //     else{
        //         return root;
        //     }
        // }
        // return null;
    } 
    public static int findLevel(TreeNode root , int level, int source){
        if (root == null) {
            return -1; 
        }
        if (root.val == source) {
            return level;
        }
    
        int left = findLevel(root.left, level + 1, source);
        if (left != -1) return left; 
    
        return findLevel(root.right, level + 1, source);
    }
    public static TreeNode buildTree(List<Integer> arr , int start){
        TreeNode root = new TreeNode(arr.get(start));
        int j = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty() && j < arr.size()){
            TreeNode curr = q.poll();
            if(arr.get(j) != -1){
                curr.left = new TreeNode(arr.get(j));
                q.add(curr.left);
            }
            j++;
            if(j < arr.size()  && arr.get(j) != -1){
                curr.right = new TreeNode(arr.get(j));
                q.add(curr.right);
            }
            j++;
        }
        return root;
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
        int val1 = sc.nextInt();
        int val2 = sc.nextInt();
        TreeNode root = buildTree(nums1,0);
        TreeNode lca = LeastCommonAncestor(root, val1,val2);
        System.out.println(lca.val);
        int LCA = lca != null ? lca.val : -1;

        int levelOfValue1 = findLevel(root, 0, val1);
        int levelOfValue2 = findLevel(root, 0, val2);

        if (levelOfValue1 == -1 || levelOfValue2 == -1) {
            System.out.println(-1);
        } else if (val1 == val2) {
            System.out.println(-1);
        } else {
            int distance = (levelOfValue1 + levelOfValue2) - 2 * findLevel(root, 0, LCA);
            System.out.println("Distance : "+ distance);
        }
        sc.close();
    }
}
