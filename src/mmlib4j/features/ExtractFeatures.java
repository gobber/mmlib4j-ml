package mmlib4j.features;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mmlib4j.debug.Debug;

//import mmlib4j.features.ComputerContrastAttribute.ContrastAttribute;
import mmlib4j.representation.tree.attribute.ComputerContrastAttribute.ContrastAttribute;

import mmlib4j.files.DataWriter;
import mmlib4j.models.datastruct.Matrix;
import mmlib4j.representation.tree.NodeLevelSets;
import mmlib4j.representation.tree.attribute.Attribute;
import mmlib4j.representation.tree.componentTree.ConnectedFilteringByComponentTree;
import mmlib4j.targets.Target;

public class ExtractFeatures {
		
	private ArrayList<NodeLevelSets>[] ascendantsPaths;	
	public ArrayList<NodeLevelSets>[] getAscendantsPaths() {
		return ascendantsPaths;
	}

	public void setAscendantsPaths(ArrayList<NodeLevelSets>[] ascendantsPaths) {
		this.ascendantsPaths = ascendantsPaths;
	}

	public ArrayList<NodeLevelSets>[] getDescendantsPaths() {
		return descendantsPaths;
	}

	public void setDescendantsPaths(ArrayList<NodeLevelSets>[] descendantsPaths) {
		this.descendantsPaths = descendantsPaths;
	}

	private ArrayList<NodeLevelSets>[] descendantsPaths;
	public ContrastAttribute attr[];
	public List<NodeLevelSets> nodesNr;
	private double[] sumAttributeOfDescPath;	
	private int delta; 	
	private int cont;	
	private int accumulatedAttributeInPath = Attribute.AREA;
	private ConnectedFilteringByComponentTree tree;
	private Target target;	
	private String ascPrefix   = "Asc_";
	private String descPrefix  = "Desc_";	
	private String nodePrefix  = "Node_";	
	private String outputName  = "Matching";	
	private DataWriter dataWriter = new DataWriter();	
	private int numberOfFeatures;	
	
	// Testes
	//private String[] features = {"highest", "lowest", "level", "altitude", "contrastParentNode", "residue", "maxResidue"};
	/*private String[] features = {"level", 
								"altitude", 
								"residue", 
								"maxResidue", 
								"TBMR", 
								"DIST_FALSE_RGB", 
								"DIST_TRUE_RGB", 
								"MOMENT_COMPACTNESS", 
								"MOMENT_ECCENTRICITY",
								"BIT_QUADS_NUMBER_HOLES",	
								};*/
	
	private String[] features = {"level", "altitude", "residue", "maxResidue","MOMENT_COMPACTNESS", "MOMENT_ECCENTRICITY"};
	
	public ExtractFeatures(ConnectedFilteringByComponentTree tree, Target target) {		
		this.tree          = tree;		
		this.target 	   = target;
	}
	
	public ExtractFeatures load() {
		
		Debug.getInstance().start();
		Debug.getInstance().show("Loading features...\n");
		
		/*for(Feature feature : features) {						
			feature.setImgRGB(imgRGB);
			feature.loadFeature(tree);			
		}*/
		
		Debug.getInstance().show("Loaded features");
		Debug.getInstance().end();
				
		return this;
		
	}
	
	public ExtractFeatures find(int delta) {
		
		this.delta            = delta;
		//this.numberOfFeatures = ((2*delta)+1)*features.length;
		this.numberOfFeatures = features.length;
		
		Debug.getInstance().start();
		Debug.getInstance().show("Loading paths...\n");
		
		ascendantsPaths      = new ArrayList[tree.getNumNode()];
		descendantsPaths       = new ArrayList[tree.getNumNode()];
		sumAttributeOfDescPath = new double[tree.getNumNode()];
		
		for(NodeLevelSets node: nodesNr) {									
			ArrayList<NodeLevelSets> ascendantPath = getNodesAscendantsPath(node);
			ascendantsPaths[node.getId()] = ascendantPath;
			maxAttributeDescendantsPath(ascendantPath.get(ascendantPath.size()-1), node);			
		}
					
		sumAttributeOfDescPath = null;
		
		Debug.getInstance().show("Loaded paths");
		Debug.getInstance().end();
		
		return this;
		
	}	
	
	public double stableAttribute(NodeLevelSets node, int att) {
		
		return (double)((double)ascendantsPaths[node.getId()].get(ascendantsPaths[node.getId()].size()-1).getAttributeValue(att) - 
				(double)descendantsPaths[node.getId()].get(0).getAttributeValue(att)) / (double) node.getAttribute(att).getValue();
		
	}
	
	public String header(String separator) {
		String header = "";
		String cell   = "";		
		int dir = -1;
		
		for(int i = delta ; i <= delta ; i += dir) {			
			if(dir == 1) {				
				cell = ascPrefix  + i + "_";				
			} else {				
				cell = descPrefix + i + "_";				
			}			
			if(i == 0) {
				dir  = 1;
				cell = nodePrefix;
			}			
			for(String feature : features) {						
				header += cell + feature + separator;				
			}			
		}				
		
		header += outputName;		
		return header;		
	}
	
	private void extract(NodeLevelSets node, Matrix matrix, int row) {		
		cont = 0;		
		//featureExtractionOfAscendant(node, matrix, row);		
		//featureExtractionOfDescendant(node, matrix, row);	
		
		double level =  (double)((double)attr[ascendantsPaths[node.getId()].get(ascendantsPaths[node.getId()].size()-1).getId()].level - 
				(double)attr[descendantsPaths[node.getId()].get(0).getId()].level) / (double) attr[node.getId()].level;
		
		double residue =  (double)((double)attr[ascendantsPaths[node.getId()].get(ascendantsPaths[node.getId()].size()-1).getId()].residue - 
				(double)attr[descendantsPaths[node.getId()].get(0).getId()].residue) / (double) attr[node.getId()].residue;
		
		double maxResidue =  (double)((double)attr[ascendantsPaths[node.getId()].get(ascendantsPaths[node.getId()].size()-1).getId()].maxResidue - 
				(double)attr[descendantsPaths[node.getId()].get(0).getId()].maxResidue) / (double) attr[node.getId()].maxResidue;			
		
		matrix.set(row, cont++, level);			
		matrix.set(row, cont++, stableAttribute(node, Attribute.ALTITUDE));
		matrix.set(row, cont++, residue);			
		matrix.set(row, cont++, maxResidue);								
		matrix.set(row, cont++, stableAttribute(node, Attribute.MOMENT_COMPACTNESS));
		matrix.set(row, cont++, stableAttribute(node, Attribute.MOMENT_ECCENTRICITY));
	}
	
	public double[] x (NodeLevelSets node) {				
		if(descendantsPaths[node.getId()] == null || 
		   ascendantsPaths[node.getId()].size() != delta+1 || 
		   descendantsPaths[node.getId()].size() != delta+1 )
					return null;
		
		Matrix x = new Matrix(1, numberOfFeatures);		
		extract(node, x, 0);				
		return x.getData();		
	}
	
	public Matrix y (NodeLevelSets node) {		
		Matrix y = new Matrix(1, 1);		
		y.set(0, target.match(node));		
		return y;		
	}	
	
	public Matrix Y() {		
		Matrix Y = new Matrix(nodesNr.size(), 1);
		int row = 0;
		
		Debug.getInstance().start();
		Debug.getInstance().show("Extracting set Y...\n");
		
		for(NodeLevelSets node : nodesNr) {			
			Y.set(row, target.match(node));						
			row++;		
		}
		
		Debug.getInstance().show("Extracted set Y");
		Debug.getInstance().end();
		
		return Y;		
	}
	
	public Matrix X() {		
		Matrix X = new Matrix(nodesNr.size(), numberOfFeatures);
		int row = 0;
		
		Debug.getInstance().start();
		Debug.getInstance().show("Extracting set X...\n");
		
		for(NodeLevelSets node : nodesNr) {							
			extract(node, X, row);						
			row++;		
		}
		
		Debug.getInstance().show("Extracted set X");
		Debug.getInstance().end();
		
		return X;		
	}
	
	public Matrix samples () {			
		Matrix samples = new Matrix(nodesNr.size(), numberOfFeatures+1);
		int row = 0;
		
		Debug.getInstance().start();
		Debug.getInstance().show("Extracting features...\n");
		
		for(NodeLevelSets node : nodesNr) {								
			extract(node, samples, row);				
			samples.set(row, (samples.numColumns()-1), target.match(node));								
			row++;		
		}
		
		Debug.getInstance().show("Extracted features");
		Debug.getInstance().end();
		
		return samples;		
	}
	
	public Matrix sample (NodeLevelSets node) {			
		Matrix sample = new Matrix(1, numberOfFeatures+1);		
		extract(node, sample, 0);	
		sample.set(sample.numColumns()-1, target.match(node));				
		return sample;		
	}
	
	public void save(String outputDir, String fileName) {
		
		Debug.getInstance().start();
		Debug.getInstance().show("Extracting features...\n");
		
		File outdir = new File(outputDir);		
		
		if(!outdir.exists()) {
			outdir.mkdirs();
		}
			
		dataWriter.create(outputDir + fileName);						
		dataWriter.write(header(dataWriter.getSeparator()));
		
		for(NodeLevelSets node : nodesNr) {	
			
			if(descendantsPaths[node.getId()] == null || 
			   ascendantsPaths[node.getId()].size() != delta+1 || 
			   descendantsPaths[node.getId()].size() != delta+1 )
				continue;
			
			dataWriter.write(sample(node));						
		}
		
		Debug.getInstance().show("Saved features into " + fileName + dataWriter.getExtension());
		Debug.getInstance().end();
		
		dataWriter.close();		
		
	}
	
	
	public void write(DataWriter dataWriter, boolean printHeader) {
		if(printHeader) {
			int temp = delta;
			delta = 0;
			dataWriter.write(header(dataWriter.getSeparator()));
			delta = temp;
			
		}
		
		for(NodeLevelSets node : nodesNr) {	
			
			if(descendantsPaths[node.getId()] == null || 
			   ascendantsPaths[node.getId()].size() != delta+1 || 
			   descendantsPaths[node.getId()].size() != delta+1 )
				continue;
			
			dataWriter.write(sample(node));						
		}				
				
	}
	
	public ArrayList<NodeLevelSets> getNodesAscendantsPath(NodeLevelSets node){
		
		NodeLevelSets n = node;		
		ArrayList<NodeLevelSets> ascendantPath = new ArrayList<>();
		int h = 0;			
				
		while(n != null && h <= delta) {
			ascendantPath.add(n);
			sumAttributeOfDescPath[n.getId()] += n.getAttributeValue(accumulatedAttributeInPath);
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
	
	public void featureExtractionOfAscendant(NodeLevelSets node, Matrix matrix, int row) {						
		for(NodeLevelSets n : ascendantsPaths[node.getId()]) {							
			matrix.set(row, cont++, attr[n.getId()].level);			
			matrix.set(row, cont++, n.getAttributeValue(Attribute.ALTITUDE));
			matrix.set(row, cont++, attr[n.getId()].residue);			
			matrix.set(row, cont++, attr[n.getId()].maxResidue);						
			matrix.set(row, cont++, n.getAttributeValue(Attribute.TBMR));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.DIST_FALSE_RGB));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.DIST_TRUE_RGB));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.MOMENT_COMPACTNESS));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.MOMENT_ECCENTRICITY));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.BIT_QUADS_NUMBER_HOLES));			
		}		
	}
	
	public void  featureExtractionOfDescendant(NodeLevelSets node, Matrix matrix, int row) {		
		// get descendants
		for(int i = 0 ; i < descendantsPaths[node.getId()].size()-1 ; i++ ) {
			NodeLevelSets n = descendantsPaths[node.getId()].get(i);			
			matrix.set(row, cont++, attr[n.getId()].level);					
			matrix.set(row, cont++, n.getAttributeValue(Attribute.ALTITUDE));
			matrix.set(row, cont++, attr[n.getId()].residue);			
			matrix.set(row, cont++, attr[n.getId()].maxResidue);						
			matrix.set(row, cont++, n.getAttributeValue(Attribute.TBMR));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.DIST_FALSE_RGB));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.DIST_TRUE_RGB));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.MOMENT_COMPACTNESS));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.MOMENT_ECCENTRICITY));
			matrix.set(row, cont++, n.getAttributeValue(Attribute.BIT_QUADS_NUMBER_HOLES));
		}	
	}

	public ConnectedFilteringByComponentTree getTree() {
		return tree;
	}

	public void setTree(ConnectedFilteringByComponentTree tree) {
		this.tree = tree;
	}

	public Target getTarget() {
		return target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}	
	
	public int getAccumulatedAttributeInPath() {
		return accumulatedAttributeInPath;
	}

	public void setAccumulatedAttributeInPath(int accumulatedAttributeInPath) {
		this.accumulatedAttributeInPath = accumulatedAttributeInPath;
	}
	
}

