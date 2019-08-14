package mmlib4j.features;


import java.util.HashSet;

import mmlib4j.images.ColorImage;
import mmlib4j.images.RealImage;
import mmlib4j.representation.tree.NodeLevelSets;
import mmlib4j.representation.tree.attribute.Attribute;
import mmlib4j.representation.tree.attribute.AttributeComputedIncrementally;
import mmlib4j.representation.tree.componentTree.NodeCT;
import mmlib4j.representation.tree.tos.NodeToS;
import mmlib4j.utils.Utils;

public class ComputerColorAttribute extends AttributeComputedIncrementally {

	public static final int MEAN_VOL_A = 100;
	public static final int MEAN_VOL_B = 101;
	public static final int DIST_TRUE_AB = 102;
	public static final int DIST_FALSE_AB = 103;
	final double somaAB[][];
	final double distAB[][];	
	final double [][] aRefTrue = {{-39.3747, 55.7235}, {-32.6289, 51.1890}, {-35.2757, 53.2713}};
	final double [][] bRefFalse = {{17.1317, 19.0871}, {3.5137, 3.4437}, {4.3955, 4.3223}};
	RealImage[] imgLab;
	
	//	
	double somaRGB[][] = null;
	final double distRGB[][];		
	final int [][] rgbRefTrue = { {126,202,0}, {90,161,0}, {112,155,0}, {145, 225, 37}, {62,64,61} };
	final int [][] rgbRefFalse = { {70,72,72}, {68,54,39}, {74, 79, 78}, {52, 54, 55}, {42,46,47} };			
	ColorImage imgRGB = null;
	int numNode;
	
	public ComputerColorAttribute(int numNode, NodeLevelSets root, ColorImage imgRGB, RealImage[] imgLab){
		long ti = System.currentTimeMillis();
		
		this.somaAB = new double[ numNode ][ 2 ];
		this.distAB = new double[ numNode ][ 2 ];
		this.imgLab = imgLab;
		
		this.numNode = numNode;
		this.imgRGB = imgRGB;
		this.somaRGB = new double[ numNode ][ 3 ];
		this.distRGB = new double[ numNode ][ 2 ];
		computerAttribute(root);
		if(Utils.debug){
			long tf = System.currentTimeMillis();
			System.out.println("Tempo de execucao [extraction of attribute - color]  "+ ((tf - ti) /1000.0)  + "s");
		}
	}
	
	public ComputerColorAttribute(int numNode, NodeLevelSets root, ColorImage imgRGB){
		long ti = System.currentTimeMillis();
				
		this.somaAB = null;
		this.distAB = null;
		
		this.numNode = numNode;
		this.imgRGB = imgRGB;
		this.somaRGB = new double[ numNode ][ 3 ];
		this.distRGB = new double[ numNode ][ 2 ];
		computerAttribute(root);
		if(Utils.debug){
			long tf = System.currentTimeMillis();
			System.out.println("Tempo de execucao [extraction of attribute - color]  "+ ((tf - ti) /1000.0)  + "s");
		}
	}
	
	@Override
	public void preProcessing(NodeLevelSets v) {
		for(int p: v.getCanonicalPixels()){
			somaRGB[v.getId()][0] += imgRGB.getRed(p);
			somaRGB[v.getId()][1] += imgRGB.getGreen(p);
			somaRGB[v.getId()][2] += imgRGB.getBlue(p);
			
			//
			//somaAB[v.getId()][0] += imgLab[1].getPixel(p);
			//somaAB[v.getId()][1] += imgLab[2].getPixel(p);
		}
	}
	
	@Override
	public void mergeChildren(NodeLevelSets parent, NodeLevelSets son) {
		somaRGB[parent.getId()][0] += somaRGB[son.getId()][0];
		somaRGB[parent.getId()][1] += somaRGB[son.getId()][1];
		somaRGB[parent.getId()][2] += somaRGB[son.getId()][2];
		
		//
		//somaAB[parent.getId()][0] += somaAB[son.getId()][0];
		//somaAB[parent.getId()][1] += somaAB[son.getId()][1];
	}

	@Override
	public void posProcessing(NodeLevelSets parent) { 
		somaRGB[parent.getId()][0] /= parent.getArea();
		somaRGB[parent.getId()][1] /= parent.getArea();
		somaRGB[parent.getId()][2] /= parent.getArea();		
		
		double rm = somaRGB[parent.getId()][0];
		double gm = somaRGB[parent.getId()][1];
		double bm = somaRGB[parent.getId()][2];				
		
		double sumRgbTrue = 0, sumRgbFalse = 0;
		
		for( int i = 0 ; i < rgbRefTrue.length-4 ; i++ ) {			
			sumRgbTrue += Math.pow( rm-rgbRefTrue[i][0], 2 ) + Math.pow( gm-rgbRefTrue[i][1], 2 ) + Math.pow( bm-rgbRefTrue[i][2], 2 );
			sumRgbFalse += Math.pow( rm-rgbRefFalse[i][0], 2 ) + Math.pow( gm-rgbRefFalse[i][1], 2 ) + Math.pow( bm-rgbRefFalse[i][2], 2 );			
		}
		
		distRGB[ parent.getId() ][ 0 ] = Math.sqrt( sumRgbTrue );
		distRGB[ parent.getId() ][ 1 ] = Math.sqrt( sumRgbFalse );	
		
		//
		/*somaAB[parent.getId()][0] /= parent.getArea();
		somaAB[parent.getId()][1] /= parent.getArea();
		
		double amean = somaAB[parent.getId()][0];
		double bmean = somaAB[parent.getId()][1];
		
		double sumAbTrue = 0, sumAbFalse = 0;
		
		sumAbTrue += Math.pow( amean-aRefTrue[1][0], 2 ) + Math.pow( bmean-aRefTrue[1][1], 2 );
		sumAbFalse += Math.pow( amean-bRefFalse[1][0], 2 ) + Math.pow( bmean-bRefFalse[1][1], 2 );
		
		distAB[ parent.getId() ][ 0 ] = Math.sqrt( sumAbTrue );
		distAB[ parent.getId() ][ 1 ] = Math.sqrt( sumAbFalse );*/	
		
	}
	
	public void addAttributeInNodes( NodeLevelSets node ) {
		Attribute attR = new Attribute(Attribute.MEAN_VOL_R, somaRGB[ node.getId() ][0]);
		Attribute attG = new Attribute(Attribute.MEAN_VOL_G, somaRGB[ node.getId() ][1]);
		Attribute attB = new Attribute(Attribute.MEAN_VOL_B, somaRGB[ node.getId() ][2]);
		
		Attribute attDistF = new Attribute(Attribute.DIST_TRUE_RGB, distRGB[ node.getId() ][0]);
		Attribute attDistB = new Attribute(Attribute.DIST_FALSE_RGB, distRGB[ node.getId() ][1]);
		
		node.addAttribute(Attribute.MEAN_VOL_R,  attR);
		node.addAttribute(Attribute.MEAN_VOL_G,  attG);
		node.addAttribute(Attribute.MEAN_VOL_B,  attB);
		node.addAttribute(Attribute.DIST_TRUE_RGB,  attDistF);
		node.addAttribute(Attribute.DIST_FALSE_RGB,  attDistB);
		
		//		
		/*node.addAttribute(MEAN_VOL_A,  new Attribute(MEAN_VOL_A, somaAB[node.getId()][0]));
		node.addAttribute(MEAN_VOL_B,  new Attribute(MEAN_VOL_B, somaAB[node.getId()][1]));
		node.addAttribute(DIST_TRUE_AB,  new Attribute(DIST_TRUE_AB, distAB[node.getId()][0]));
		node.addAttribute(DIST_FALSE_AB,  new Attribute(DIST_FALSE_AB, distAB[node.getId()][1]));*/	
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
}
