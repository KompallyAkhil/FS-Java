/*
There are some pages in a website, each page links with atmost two other pages.
Each page displays a number on it. The complete website is given as binary tree 
using the level order insertion technique.

You need to return the number of pages where the number in the page is equal to 
the sum of the numbers of its descendants. A descendant refers to any page that 
is linked but lower down the tree stucture of the website, no matter how many 
levels lower.

Input Format:
-------------
Single line of comma separated integers, numbers displayed in web-pages as Tree.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
11 3 5 2 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
3 2 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
For the pages diplaying the number 0: The sum of descendants is 0,
since they have no descendant pages.

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
public class Day16P3 {
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
    static int count = 0;
    public static int  countValues(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = countValues(root.left);
        int right = countValues(root.right);
        int total = left + right;
        if(root.val == total){
            count++;
        }
        return root.val + total;
    }
    public static void main(String [] args){
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
        countValues(root);
        System.out.println(count);
        sc.close();
    }
    
}
