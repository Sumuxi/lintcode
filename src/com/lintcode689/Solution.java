package com.lintcode689;

/**689. 两数之和 - BST版本 
 * 挑战：Without any extra space.
 * @author sumuxi
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		t2.left = t1;
		t2.right = t3;
		t4.left = t2;
		t4.right = t5;
		
		int[] arr = new Solution().twoSum(t4, 3);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
	
	/**
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode node, int n) {
    	if(node==null||(node.left==null&&node.right==null))
    		return null;

    	int[] result = null;
    	TreeNode t1=null;
    	TreeNode t2=null;
    	if(n<node.val+node.val){
    		if(node.left==null){
    			return null;
    		}else{
    			t1 = node.left;
        		t2 = node;
    		}
    	}else {
    		if(node.right==null){
    			return null;
    		}else{
    			t1 = node;
        		t2 = node.right;
    		}
		}
    	while(t1!=t2&&t1!=null&&t2!=null){
        	int sum = t1.val+t2.val;
        	if(sum>n){
        		if(t1.left!=null){
        			t1 = t1.left;
        		}else
					t2 = t2.left;
        	}else if(sum<n){
        		if(t2.right!=null)
        			t2=t2.right;
        		else
        			t1 = t1.right;
        	}else{
        		result = new int[2];
        		result[0]=t1.val;
        		result[1]=t2.val;
        		break;
        	}
        }
    	return result;
    }
	
    private TreeNode root;
    
	/**这种方法过不了，可能是因为破坏了树结构
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum1(TreeNode node, int n) {
        if(node==null)
        	return null;
        
        int[] result = new int[2];
        root = node;
    	TreeNode t1=root, t2=root;
        t1=min();//找最小值同时删除最小值
        t2=max();//找最大值同时删除最大值
        while(t1.val<t2.val){
        	int sum = t1.val+t2.val;
        	if(sum>n){
        		t2 = max();//下一个最大值
        	}else if(sum<n){
        		t1 = min();//下一个最小值
        	}else{
        		result[0]=t1.val;
        		result[1]=t2.val;
        		break;
        	}
        }
        
		return result;//一定有一组结果
    }

	private TreeNode max() {
		if(root.right==null){
			TreeNode t = root;
			root = root.left;
			return t;
		}else {
			TreeNode t=root.right, s=root;
			while(t.right!=null){
				s = t;
				t = t.right;
			}
			s.right = t.left;
			return t;
		}
	}

	private TreeNode min() {
		if(root.left==null){
			TreeNode t = root;
			root = root.right;
			return t;
		}else {
			TreeNode t=root.left, s=root;
			while(t.left!=null){
				s = t;
				t = t.left;
			}
			s.left = t.right;
			return t;
		}
	}
    
}

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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }