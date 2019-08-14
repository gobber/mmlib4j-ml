package mmlib4j.features;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import mmlib4j.datastruct.Queue;
import mmlib4j.datastruct.SimpleLinkedList;
import mmlib4j.images.GrayScaleImage;
import mmlib4j.images.impl.ImageFactory;
import mmlib4j.models.Models;
import mmlib4j.representation.tree.NodeLevelSets;
import mmlib4j.representation.tree.attribute.Attribute;
import mmlib4j.representation.tree.attribute.AttributeComputedIncrementally;
import mmlib4j.representation.tree.componentTree.ComponentTree;
import mmlib4j.representation.tree.componentTree.NodeCT;
import mmlib4j.representation.tree.tos.NodeToS;
import mmlib4j.utils.Utils;


/**
 * MMLib4J - Mathematical Morphology Library for Java 
 * @author Wonder Alexandre Luz Alves
 *
 */
public class ComputerContrastAttribute extends AttributeComputedIncrementally{
	
	ContrastAttribute attr[];
	int numNode;
	GrayScaleImage img;
	boolean mapPruning[];
	double predictions[];
	NodeLevelSets root;

	public ExtractFeatures extract = new ExtractFeatures(null, null);	
	public ArrayList<NodeLevelSets>[] ascendantsPaths;	
	public ArrayList<NodeLevelSets>[] descendantsPaths;	
	public SimpleLinkedList<NodeCT> bestNodes;
	double[] sumAttributeOfDescPath;
	public double nodesMatching[];
	public Models model;
	ComponentTree tree;
	double threshold = 0.3;
	int delta = 0;
	
	public ComputerContrastAttribute(int numNode, 
									 NodeLevelSets root, 
									 GrayScaleImage img, 
									 boolean mapPruning[], 									
									 int delta,
									 Models model,
									 ComponentTree tree,
									 double threshold){
		
		long ti = System.currentTimeMillis();
		this.numNode = numNode;
		this.attr = new ContrastAttribute[numNode];
		this.img = img;
		this.mapPruning = mapPruning;
		this.root = root;
		this.model = model;
		this.tree = tree;
		this.threshold = threshold;
		
		// Extract features during computation
		this.nodesMatching = new double[numNode];
		this.ascendantsPaths        = new ArrayList[numNode];
		this.descendantsPaths       = new ArrayList[numNode];
		this.sumAttributeOfDescPath = new double[numNode];
		this.delta = delta;
				
		// Corrigir		
		//extract.attr = attr;		
		extract.setAscendantsPaths(ascendantsPaths);
		extract.setDescendantsPaths(descendantsPaths);		
		extract.find(delta);	
			
		bestNodes = new SimpleLinkedList<>();
		
		computerAttribute(root);
		
		if(Utils.debug){
			long tf = System.currentTimeMillis();
			System.out.println("Tempo de execucao [extraction of attribute - contrast]  "+ ((tf - ti) /1000.0)  + "s");
		}
	}

	public ContrastAttribute[] getAttribute(){
		return attr;
	}
	
	public void addAttributeInNodesCT(HashSet<NodeCT> hashSet){
		for(NodeLevelSets node: hashSet){
			addAttributeInNodes(node);
		}
	} 
	
	public void addAttributeInNodesToS(HashSet<NodeToS> hashSet){
		for(NodeLevelSets node: hashSet){
			addAttributeInNodes(node);
		}
	} 
	
	public void addAttributeInNodes(NodeLevelSets node){
		node.addAttribute(Attribute.LEVEL, new Attribute(Attribute.LEVEL, node.getLevel()));
	} 
	
	public void preProcessing(NodeLevelSets node) {
				
		attr[node.getId()] = new ContrastAttribute();	
		
		attr[node.getId()].highest = attr[node.getId()].lowest = node.getLevel();		
		attr[node.getId()].level = node.getLevel();
		
		if(node.getParent() != null)
			attr[node.getId()].contrastParentNode = Math.max(
															node.getParent().getLevel() - node.getLevel(), 
															node.getLevel() - node.getParent().getLevel());
		
		//------Ultimate levelings-------
		
		//update the set Nr(id) and NotNr(id)
		if(mapPruning[node.getId()]){ 			
			attr[node.getId()].firstNodeNotInNR = node.getParent();
			attr[node.getId()].rootNodeInNR = node;
			
			if(node.getParent() != null)
				attr[node.getId()].beforeNodeInNR = attr[node.getParent().getId()].rootNodeInNR;			
			
		}else{
			if(node.getParent() != null) {
				attr[node.getId()].firstNodeNotInNR = attr[node.getParent().getId()].firstNodeNotInNR;
				attr[node.getId()].rootNodeInNR = attr[node.getParent().getId()].rootNodeInNR;
			}
		}
		
		
		if(attr[node.getId()].firstNodeNotInNR != null){ //computer the i-th residue
			
			attr[node.getId()].residue = Math.max(
													node.getLevel() - attr[node.getId()].firstNodeNotInNR.getLevel(), 
													attr[node.getId()].firstNodeNotInNR.getLevel() - node.getLevel()
												 );			
			
			attr[node.getId()].idResiduo = attr[node.getId()].rootNodeInNR.getId();
			
			if(attr[node.getId()].residue > attr[node.getParent().getId()].maxResidue){ 
				//new value for the maximum residue
				attr[node.getId()].maxResidue = attr[node.getId()].residue;

				//updating the index that produced maximum residues
				attr[node.getId()].rootAssociatedWithMaxResidue = attr[node.getId()].rootNodeInNR;
			}
			else{ 
				//propagation of maximum residue
				attr[node.getId()].maxResidue = attr[node.getParent().getId()].maxResidue;
				attr[node.getId()].rootAssociatedWithMaxResidue = attr[node.getParent().getId()].rootAssociatedWithMaxResidue;
			}
			
		}	
		
	}
	
	public void mergeChildren(NodeLevelSets node, NodeLevelSets son) {
		attr[node.getId()].highest = Math.max(attr[node.getId()].highest, attr[son.getId()].highest);
		attr[node.getId()].lowest = Math.min(attr[node.getId()].lowest, attr[son.getId()].lowest);
	}

	public void posProcessing(NodeLevelSets root) {
		
		// Post-processing root		
		if(root.isNodeMaxtree()){
			attr[root.getId()].altitude = attr[root.getId()].highest - root.getLevel() + 1; 
		}
		else{
			attr[root.getId()].altitude = root.getLevel() - attr[root.getId()].lowest + 1;
		}
		
		// Strategy	machine learning
		if(attr[root.getId()].rootNodeInNR == root && attr[root.getId()].beforeNodeInNR != null) {		
			
			ArrayList<NodeLevelSets> ascendantPath = getNodesAscendantsPath(root);
			ascendantsPaths[root.getId()] = ascendantPath;
			maxAttributeDescendantsPath(ascendantPath.get(ascendantPath.size()-1), root);					

			// Prediction			
			double[] x = extract.x(root);
			if(x != null) {
				double outPred = model.predict(x);
				nodesMatching[root.getId()] = outPred;
			}
			
			if(nodesMatching[root.getId()] > threshold) {									

				int numberOfDesc = 0;
				int numberOfWinners = 0;
				Iterator<NodeCT> it = bestNodes.iterator();
					
				while(it.hasNext()) {
					NodeCT n = it.next();
					if(tree.isDescendant(n, (NodeCT) root)) {
						numberOfDesc++;
						if(nodesMatching[n.getId()] <= nodesMatching[root.getId()]) {								
							it.remove();
							numberOfWinners++;
						}
					}
				}
				
				if(numberOfWinners == numberOfDesc)
					bestNodes.add((NodeCT) root);		
			
			}			
			
		}
						
	}
	
	public ArrayList<NodeLevelSets> getNodesAscendantsPath(NodeLevelSets node){
		
		NodeLevelSets n = node;		
		ArrayList<NodeLevelSets> ascendantPath = new ArrayList<>();
		int h = 0;			
				
		while(n != null && h <= delta) {
			ascendantPath.add(n);
			sumAttributeOfDescPath[n.getId()] += n.getAttributeValue(Attribute.AREA);			
			n = attr[n.getId()].beforeNodeInNR;			
			h++;
		}
		
		return ascendantPath;
	}
	
	public void maxAttributeDescendantsPath(NodeLevelSets nodeAsc, NodeLevelSets nodeDes){		
		
		if(descendantsPaths[nodeAsc.getId()] == null) {
			descendantsPaths[nodeAsc.getId()]  = ascendantsPaths[nodeDes.getId()];
			sumAttributeOfDescPath[nodeAsc.getId()] = sumAttributeOfDescPath[nodeDes.getId()]; 
		}
			
		if(sumAttributeOfDescPath[nodeAsc.getId()] < sumAttributeOfDescPath[nodeDes.getId()]) {
			descendantsPaths[nodeAsc.getId()] = ascendantsPaths[nodeDes.getId()];
			sumAttributeOfDescPath[nodeAsc.getId()] = sumAttributeOfDescPath[nodeDes.getId()];
		}
			
	}
	
	
	public GrayScaleImage getUltimateLevelingAssociatedIndex(){
		GrayScaleImage imgOut = ImageFactory.createGrayScaleImage(32, img.getWidth(), img.getHeight());
		
		Queue<NodeLevelSets> fifo = new Queue<>();
		fifo.enqueue(root);
		while(!fifo.isEmpty()){
			
			NodeLevelSets node = fifo.dequeue();
			for(Object son: node.getChildren()){ fifo.enqueue((NodeLevelSets)son); }
			
			if(attr[node.getId()].maxResidue != 0){
				for(int p: node.getCanonicalPixels()){
					imgOut.setPixel(p, attr[node.getId()].rootAssociatedWithMaxResidue.getId() + 1);
				}
			}
			
		}
		return imgOut;
	}
	
	public class ContrastAttribute {				
		
		public HashMap<String, Integer> attributes = new HashMap<>();
		
		public int highest;
		public int lowest;
		public int level;
		public int altitude;
		public int contrastParentNode;
		
		NodeLevelSets rootAssociatedWithMaxResidue; //raiz do conjunto Nr(i) que produziu o maximo residuo
		public double residue; 
		public double maxResidue;
		
		NodeLevelSets firstNodeNotInNR; //primeiro node do caminho do rootNodeInNR até <rootNode-Not-InNR>
		public NodeLevelSets rootNodeInNR; //raiz do conjunto Nr(i)
		public NodeLevelSets beforeNodeInNR;
		int idResiduo; //Note que: idResiduo = rootNodeInNR.getId()
		
	}
	
}
