package mmlib4j.targets;

import java.util.List;

public class BoundBox {

	public int x1, y1;
	public int x2, y2;

	public BoundBox(){}
	
	public BoundBox(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public void setBoundbox(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public double match(BoundBox r2) {
		return 2 * overlapArea(r2) / (this.area() + r2.area());
	}

	public int area() {
		return area(x1, y1, x2, y2);
	}

	public static int area(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (y2 - y1);
	}

	public double overlapArea(BoundBox r2) {
		int xMin = Math.max(x1, r2.x1);
		int xMax = Math.min(x2, r2.x2);

		int yMin = Math.max(y1, r2.y1);
		int yMax = Math.min(y2, r2.y2);

		if ((yMin > yMax) || (xMin > xMax))
			return 0.0;

		double overlap = area(xMin, yMin, xMax, yMax);
		
		return overlap;
	}

	public double unionArea(BoundBox r2) {
		int xMin = Math.min(x1, r2.x1);
		int xMax = Math.max(x2, r2.x2);
		int yMin = Math.min(y1, r2.y1);
		int yMax = Math.max(y2, r2.y2);
		double union = area(xMin, yMin, xMax, yMax);
		return union;
	}

	public static double bestMatch(List<BoundBox> listGT, BoundBox estimate){
		double bestMatch = 0;
		double match = 0;
		for(BoundBox gt: listGT){
			match = estimate.match(gt);
			if(match > bestMatch)
				bestMatch = match;
		}
		return bestMatch;
	}
	
	public static void main(String args[]) {	
		BoundBox a, b;		
		a = new BoundBox(250, 550, 497, 813);
		b = new BoundBox(250, 550, 783, 1000);		
		System.out.println(a.match(b));		
	}
	
}
