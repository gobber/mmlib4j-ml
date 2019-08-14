package mmlib4j.metrics;

import java.util.List;

import mmlib4j.datastruct.SimpleLinkedList;
import mmlib4j.images.GrayScaleImage;
import mmlib4j.targets.BoundBox;
import mmlib4j.utils.MooreNeighborTracing;

public class Metrics {
	
	public static double modHausdorffDist(GrayScaleImage predImg, GrayScaleImage groundImg) {
		
		SimpleLinkedList<Integer> predBoundaries = MooreNeighborTracing.boundaries(predImg);
		SimpleLinkedList<Integer> groundBoundaries = MooreNeighborTracing.boundaries(groundImg);
		
		double fhd = 0;		
		for(int p : predBoundaries) {
			double mindist = Double.MAX_VALUE;			
			for(int q : groundBoundaries) {
				int px = p % predImg.getWidth(); int py = p / predImg.getWidth();
				int qx = q % groundImg.getWidth(); int qy = q / groundImg.getWidth();				
				double dist = Math.sqrt(Math.pow(px - qx, 2) + Math.pow(py - qy, 2));
				if(dist < mindist){
					mindist = dist;
				}				
			}
			fhd = fhd + mindist;			
		}
		
		fhd = fhd / predBoundaries.size();
		
		double rhd = 0;		
		for(int p : groundBoundaries) {
			double mindist = Double.MAX_VALUE;			
			for(int q : predBoundaries) {
				int px = p % predImg.getWidth(); int py = p / predImg.getWidth();
				int qx = q % groundImg.getWidth(); int qy = q / groundImg.getWidth();				
				double dist = Math.sqrt(Math.pow(px - qx, 2) + Math.pow(py - qy, 2));
				if(dist < mindist){
					mindist = dist;
				}				
			}
			rhd = rhd + mindist;			
		}
		
		rhd = rhd / groundBoundaries.size();
		
		return Math.max(fhd,  rhd);
		
	}
	
	public static double dsc(GrayScaleImage predImg, GrayScaleImage groundImg) {
		
		long predSize = 0, groundSize = 0;
		double overlap = 0;		
		
		if(predImg.getWidth() != groundImg.getWidth() || predImg.getHeight() != groundImg.getHeight())
			return 0;
		
		for(int p = 0 ; p < predImg.getSize() ; p++) {			
			int predPixel = predImg.getPixel(p) > 0 ? 1 : 0;
			int groundPixel = groundImg.getPixel(p) > 0 ? 1 : 0;			
			overlap += predPixel * groundPixel;
			groundSize += groundPixel;
			predSize += predPixel;			
		}
		
		return (2 * overlap) / (predSize + groundSize);
		
	}

	public static double sbd(List<BoundBox> listGT, List<BoundBox> listEstimates) {
		double sumMaxscore1 = 0, 
			   sumMaxscore2 = 0;
		for(BoundBox estimate : listEstimates) {		
			sumMaxscore1 += BoundBox.bestMatch(listGT, estimate);
		}
		for(BoundBox ground : listGT) {
			sumMaxscore2 += BoundBox.bestMatch(listEstimates, ground);	
		}		
		return Math.min(sumMaxscore1/listEstimates.size(),  sumMaxscore2/listGT.size());
	}
	
	public static int dic(List<BoundBox> listGT, List<BoundBox> listEstimates) {
		return listGT.size() - listEstimates.size();
	}
	
	public static int absDic(List<BoundBox> listGT, List<BoundBox> listEstimates) {
		return Math.abs(dic(listGT, listEstimates));
	}
	
}
