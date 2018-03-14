package com.lintcode087;

/**85. 在二叉查找树中插入节点
 * 挑战：不使用递归
 * @author sumuxi
 *
 */
public class Solution {
    
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		t4.right = t5;
		TreeNode t3 = new TreeNode(3);
		t3.right = t4;
		TreeNode t2 = new TreeNode(2);
		t2.right = t3;
		TreeNode t1 = new TreeNode(1);
		t1.right = t2;
		
		System.out.println(new Solution().removeNode(t1, 3));
		System.out.println(t1.toString());
	}
	
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
    	TreeNode p = root, q=root;
    	while(p!=null){
    		if(value>p.val){
    			q = p;//始终记录p的父结点
    			p = p.right;
    		}else if(value<p.val){
    			q = p;//始终记录p的父结点
				p = p.left;
			}else{//value==p.val
				if(p==root){
					if(root.right==null){
						root = root.left;
						return root;
					}
					TreeNode t = p.right, s=p;
			    	while(t.left!=null){
			    		s = t;//始终记录t的父结点
			    		t = t.left;
			    	}
			    	root.val = t.val;
			    	if(s==p){
			    		s.right = t.right;
			    	}else {
			    		s.left = t.right;
					}
					return root;
				}
				deleteNode(q, p);
				break;
			}
    	}
    	return root;
    }

	private void deleteNode(TreeNode q, TreeNode p) {
		if(p.left!=null&&p.right!=null){//p有两个子节点,将p的后继的值复制给p,删除p的后继，即右子树的最小值(中序遍历的后继)
			TreeNode t = p.right, s=p;
	    	while(t.left!=null){
	    		s = t;//始终记录t的父结点
	    		t = t.left;
	    	}
	    	p.val = t.val;
	    	if(s==p){
	    		s.right = t.right;
	    	}else {
	    		s.left = t.right;
			}
		}else{
			if(p.left==null){//p没有子节点或只有一个子节点，直接删除即可
				if(p==q.left){
					q.left = p.right;
				}else {
					q.right = p.right;
				}
			}else{
				if(p==q.left){
					q.left = p.left;
				}else {
					q.right = p.left;
				}
			}
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
 */
class TreeNode {
     public int val;
     public TreeNode left, right;
     
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
     
     @Override
     public java.lang.String toString() {
     	return (left!=null?left.toString():"")
     			+" "+this.val+" "+(right!=null?right.toString():"");
     }
 }