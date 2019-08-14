package mmlib4j.targets;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mmlib4j.representation.tree.NodeLevelSets;

public class BoundingBoxMatching implements Target{
	
	private List<BoundBox> listGT;
	
	public BoundingBoxMatching(){}
	
	public BoundingBoxMatching(File ground) {		
		load(ground);		
	}
	
	public BoundingBoxMatching load(File ground) {
		
		listGT = new ArrayList<BoundBox>();
		Scanner csvfile = null;
		
		try {
			csvfile = new Scanner(ground);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner datacsv = null;
		int minX, minY, maxX, maxY;
		int index;
		
		while (csvfile.hasNextLine()) {
			
			minX=Integer.MAX_VALUE;
			minY=Integer.MAX_VALUE; 
			maxX=Integer.MIN_VALUE; 
			maxY=Integer.MIN_VALUE;
			index = 0;
			
			datacsv = new Scanner(csvfile.nextLine());
			datacsv.useDelimiter(",");
			
			while (datacsv.hasNext()) {
				
				int value = Integer.parseInt(datacsv.next());					
				
				if(index == 0) {
					index = 1;
					if(value < minX) {
						minX = value;
					}
					
					if(value > maxX) {
						maxX = value;
					}
					
				} else {
					index = 0;
					if(value < minY) {
						minY = value;
					}
					
					if(value > maxY) {
						maxY = value;
					}
				}					
				
			}				
			
			listGT.add(new BoundBox(minX, minY, maxX, maxY));			
			datacsv.close();
			
		}
		
		csvfile.close();
		return this;
	}
	
	@Override
	public double match(NodeLevelSets node) {				
		BoundBox estimate = new BoundBox(node.getXmin(), node.getYmin(), node.getXmax(), node.getYmax());						
		return BoundBox.bestMatch(listGT, estimate);		
	}

	public List<BoundBox> getListGT() {
		return listGT;
	}

	public void setListGT(List<BoundBox> listGT) {
		this.listGT = listGT;
	}
	
}
