package com.lintcode176;

import java.util.ArrayList;

/**176. 图中两个点之间的路线
 * 挑战：
 * @author sumuxi
 *
 */
public class Solution {
    
	/**深度优先搜索
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
		if (s == t)
			return true;
		if (s.neighbors.size() == 0)//s.neighbors一定不为空
			return false;
		for (int i = 0; i < s.neighbors.size(); i++) {
			if (hasRoute(graph, s.neighbors.get(i), t))
				return true;
		}
		return false;
	}
	
	//题意是只需要找从s到t的路径，所以下面的方法不对
    public boolean hasRoute1(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        if(findPath(s, t))
        	return true;
        else 
        	return findPath(t, s);
    }

	private boolean findPath(DirectedGraphNode source, DirectedGraphNode target) {
		if(source==target)
			return true;
		ArrayList<DirectedGraphNode> neighbors = source.neighbors;
		if(source.neighbors.size() == 0)//s.neighbors一定不为空
			return false;
		for (DirectedGraphNode node : neighbors) {
			if(findPath(node, target))
				return true;
		}
		return false;
	}
    
}

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
