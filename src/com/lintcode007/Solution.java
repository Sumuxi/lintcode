package com.lintcode007;

/** 7. 二叉树的序列化和反序列化,AC
 * @author sumuxi
 *
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(8);
		
		Solution s = new Solution();
		String data = s.serialize(root);
		System.out.println(data);
		
		String str = s.serialize(s.deserialize(data));
		System.out.println(str);
	}
	
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
    	StringBuilder sb = new StringBuilder();
    	write(sb, root);
    	return sb.toString();
    }

    public void write(StringBuilder sb, TreeNode node) {
		// TODO Auto-generated method stub
    	if (node==null) {
			sb.append("#,");
			return;
		}
		sb.append(node.val+",");
		write(sb, node.left);
		write(sb, node.right);
    }

	/**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
    	java.util.Scanner sc = new java.util.Scanner(data);
    	sc.useDelimiter(",");
    	return read(sc);
    }

	public TreeNode read(java.util.Scanner sc) {
		// TODO Auto-generated method stub
		String val;
		if ((val=sc.next()).equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left= read(sc);
		root.right = read(sc);
		return root;
	}
}


class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
       this.val = val;
       this.left = this.right = null;
   }
}
 