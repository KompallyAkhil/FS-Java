// The Indian Army has established multiple military camps at strategic locations 
// along the Line of Actual Control (LAC) in Galwan. These camps are connected in 
// a hierarchical structure, with a main base camp acting as the root of the network.

// To fortify national security, the Government of India has planned to deploy 
// a protective S.H.I.E.L.D. that encloses all military camps forming the outer 
// boundary of the network.

// Structure of Military Camps:
//     - Each military camp is uniquely identified by an integer ID.
//     - A camp can have at most two direct connections:
//         - Left connection → Represents a subordinate camp on the left.
//         - Right connection → Represents a subordinate camp on the right.
//     - If a military camp does not exist at a specific position, it is 
//       represented by -1
	
// Mission: Deploying the S.H.I.E.L.D.
// Your task is to determine the list of military camp IDs forming the outer 
// boundary of the military network. This boundary must be traversed in 
// anti-clockwise order, starting from the main base camp (root).

// The boundary consists of:
// 1. The main base camp (root).
// 2. The left boundary:
//     - Starts from the root’s left child and follows the leftmost path downwards.
//     - If a camp has a left connection, follow it.
//     - If no left connection exists but a right connection does, follow the right connection.
//     - The leftmost leaf camp is NOT included in this boundary.
// 3. The leaf camps (i.e., camps with no further connections), ordered from left to right.
// 4. The right boundary (in reverse order):
//     - Starts from the root’s right child and follows the rightmost path downwards.
//     - If a camp has a right connection, follow it.
//     - If no right connection exists but a left connection does, follow the left connection.
//     - The rightmost leaf camp is NOT included in this boundary.


// Input Format:
// -------------
// space separated integers, military-camp IDs.

// Output Format:
// --------------
// Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


// Sample Input-1:
// ---------------
// 5 2 4 7 9 8 1

// Sample Output-1:
// ----------------
// [5, 2, 7, 9, 8, 1, 4]


// Sample Input-2:
// ---------------
// 11 2 13 4 25 6 -1 -1 -1 7 18 9 10

// Sample Output-2:
// ----------------
// [11, 2, 4, 7, 18, 9, 10, 6, 13]


// Sample Input-3:
// ---------------
// 1 2 3 -1 -1 -1 5 -1 6 7

// Sample Output-3:
// ----------------
// [1, 2, 7, 6, 5, 3]

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

public class Day9P4 {
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
    public static void allLeftElements(TreeNode root , List<Integer> leftIntegers){
        if(root == null) return;
        leftIntegers.add(root.val);
        allLeftElements(root.left, leftIntegers);
    }
    public static void allRightElements(TreeNode root , List<Integer> rightIntegers){
        if(root == null) return;
        rightIntegers.add(root.val);
        allRightElements(root.right, rightIntegers);
    }
    public static void getLeaf(TreeNode root,List<Integer> l){
        if(root==null) return;
        if(root.left==null && root.right==null){
            l.add(root.val);
            return;
        }
        getLeaf(root.left,l);
        getLeaf(root.right,l);
    }
    public static List<Integer> getNotLeftOrRight(List<Integer> leafNodes, List<Integer> leftBoundary, List<Integer> rightBoundary) {
        List<Integer> notLeftOrRight = new ArrayList<>();
        for (int leaf : leafNodes) {
            if (!leftBoundary.contains(leaf) && !rightBoundary.contains(leaf)) {
                notLeftOrRight.add(leaf);
            }
        }
        return notLeftOrRight;
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
        answer.add(root.val);
        List<Integer> leftElements = new ArrayList<>();
        List<Integer> rightElements = new ArrayList<>();
        List<Integer> norLeftRight = new ArrayList<>();
        allLeftElements(root.left, leftElements);
        allRightElements(root.right, rightElements);
        getLeaf(root, norLeftRight);
        List<Integer> notLeftOrRight = getNotLeftOrRight(norLeftRight, leftElements, rightElements);
        answer.addAll(leftElements);
        answer.addAll(notLeftOrRight);
        Collections.reverse(rightElements);
        answer.addAll(rightElements);
        System.out.println(answer);
        sc.close();
    }
}
