package mmlib4j.utils;

import mmlib4j.representation.tree.NodeLevelSets;
import mmlib4j.representation.tree.attribute.AttributeComputedIncrementally;
import mmlib4j.representation.tree.componentTree.ComponentTree;
import mmlib4j.representation.tree.componentTree.NodeCT;


public class DietzNumbering extends AttributeComputedIncrementally{
	
	int cnt = 0;
	int preOrder[];
	int postOrder[];
	ComponentTree tree;
	
	public DietzNumbering(ComponentTree tree) {
		this.tree = tree;
		preOrder  = new int[tree.getNumNode()];
		postOrder = new int[tree.getNumNode()];
		computerAttribute(tree.getRoot());
	}
	
	public boolean isAncestor(NodeCT u, NodeCT v) {
		return (preOrder[u.getId()] <= preOrder[v.getId()] && postOrder[v.getId()] <= postOrder[u.getId()]);
	}
	
	public boolean isDescendant(NodeCT u, NodeCT v) {
		return isAncestor(v, u);
	}

	@Override
	public void preProcessing(NodeLevelSets v) {
		preOrder[v.getId()] = cnt++;
	}

	@Override
	public void mergeChildren(NodeLevelSets parent, NodeLevelSets son) {}

	@Override
	public void posProcessing(NodeLevelSets parent) {
		postOrder[parent.getId()] = cnt++;		
	}
}