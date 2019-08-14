package mmlib4j.primitives;

import java.util.ArrayList;
import mmlib4j.representation.tree.componentTree.ComponentTree;
import mmlib4j.representation.tree.componentTree.NodeCT;
import mmlib4j.representation.tree.pruningStrategy.MappingStrategyOfPruning;

public class Primitives {
	
	private boolean mappingSelectedNodes[];	
	private ComponentTree tree;	
	private ArrayList<MappingStrategyOfPruning> primitives;
	
	public Primitives(ComponentTree tree) {		
		this.tree = tree;		
		mappingSelectedNodes = new boolean[tree.getNumNode()];				
		for(NodeCT node : tree.getListNodes()) {			
			mappingSelectedNodes[node.getId()] = true;			
		}		
	}
	
	public Primitives(ComponentTree tree, ArrayList<MappingStrategyOfPruning> primitives) {		
		this(tree);		
		this.primitives = primitives;		
	}

	public Primitives intersect() {				
		
		ArrayList<boolean[]> mapSelectedNodes = new ArrayList<>();
		for(MappingStrategyOfPruning primitive : primitives) {
			mapSelectedNodes.add(primitive.getMappingSelectedNodes());
		}
		
		for(NodeCT node: tree.getListNodes()) {						
			for(boolean selectednodes[] : mapSelectedNodes) {								
				mappingSelectedNodes[node.getId()] = mappingSelectedNodes[node.getId()] & selectednodes[node.getId()];			
			}			
		}		
		return this;		
	}
	
	public boolean[] getMappingSelectedNodes() {		
		return mappingSelectedNodes;		
	}

	public void setMappingSelectedNodes(boolean nodesNr[]) {		
		this.mappingSelectedNodes = nodesNr;	
	}
	
}
