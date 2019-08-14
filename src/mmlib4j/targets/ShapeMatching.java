package mmlib4j.targets;

import mmlib4j.representation.tree.attribute.Attribute;
import mmlib4j.representation.tree.MorphologicalTreeFiltering;
import mmlib4j.representation.tree.NodeLevelSets;
import mmlib4j.representation.tree.componentTree.ComponentTree;
import mmlib4j.representation.tree.componentTree.NodeCT;
import mmlib4j.representation.tree.tos.NodeToS;
import mmlib4j.representation.tree.tos.TreeOfShape;

public class ShapeMatching implements Target {		
		
	private MorphologicalTreeFiltering binaryTree;
	NodeLevelSets bestNode = null;
	
	public ShapeMatching() {}
	
	public ShapeMatching(MorphologicalTreeFiltering binaryTree) {
		this.binaryTree = binaryTree;		
	}
	
	private double overlapArea(TreeOfShape tree, NodeToS node, NodeToS ground) {		
		double intersection = 0;		
		for(int p: node.getPixelsOfCC()) {						
			if(tree.getSC(p) == ground)
				intersection++;							
		}		
		return intersection;		
	}	
	
	private double overlapArea(ComponentTree tree, NodeCT node, NodeCT ground) {		
		double intersection = 0;		
		for(int p: node.getPixelsOfCC()) {						
			if(tree.getSC(p) == ground)
				intersection++;							
		}		
		return intersection;		
	}	
	
	private double bestMatch(TreeOfShape tree, NodeToS node) {
		double bestMatch = 0;
		double match = 0;		
		for(NodeToS ground : tree.getLeaves()) {
			match = match(node, ground);			
			if(match > bestMatch) {
				bestMatch = match;
				bestNode = ground;
			}
		}		
		return bestMatch;
	}
	
	private double bestMatch(ComponentTree tree, NodeCT node) {
		double bestMatch = 0;
		double match = 0;		
		for(NodeCT ground : tree.getLeaves()) {
			match = match(node, ground);			
			if(match > bestMatch) {
				bestMatch = match;
				bestNode = ground;
			}
		}		
		return bestMatch;
	}
	
	private double bestMatch(NodeLevelSets node) {
		if(binaryTree instanceof ComponentTree){
			return bestMatch((ComponentTree) binaryTree, (NodeCT) node);
		}
		else if(binaryTree instanceof TreeOfShape){
			return bestMatch((TreeOfShape) binaryTree, (NodeToS) node);
		}
		else {
			return 0;
		}
	}

	public double match(NodeLevelSets node, NodeLevelSets ground) {		
		if(binaryTree instanceof ComponentTree){
			return 2 * overlapArea((ComponentTree) binaryTree, (NodeCT) node, (NodeCT) ground) / (node.getAttributeValue(Attribute.AREA) + ground.getAttributeValue(Attribute.AREA));
		}
		else if(binaryTree instanceof TreeOfShape){
			return 2 * overlapArea((TreeOfShape) binaryTree, (NodeToS) node, (NodeToS) ground) / (node.getAttributeValue(Attribute.AREA) + ground.getAttributeValue(Attribute.AREA));
		}
		else {
			return 0;
		}
	}
	
	@Override
	public double match(NodeLevelSets node) {		
		return bestMatch(node);
	}		
	
}
