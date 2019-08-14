package mmlib4j.utils;

import mmlib4j.datastruct.SimpleLinkedList;
import mmlib4j.images.GrayScaleImage;
import mmlib4j.images.impl.ImageFactory;

public class MooreNeighborTracing {
	
	public static int BACKGROUND = 0;
	public static int FOREGROUND = 255;
	
	public static GrayScaleImage padImage(GrayScaleImage image, int paddingColor) {
		GrayScaleImage paddedImage = ImageFactory.createGrayScaleImage(ImageFactory.DEPTH_32BITS,
																	   image.getWidth()+2, 
																	   image.getHeight()+2);
		for(int x = 0; x < image.getWidth()+2; x ++) {
			for(int y = 0; y < image.getHeight()+2; y ++) {
				if(x == 0 || y == 0 || x == image.getWidth()+1 || y == image.getHeight()+1) {				
					paddedImage.setPixel(x + y*(image.getWidth()+2), paddingColor);
				} else {
					paddedImage.setPixel(x+y*(image.getWidth()+2), image.getPixel(x-1 + (y-1)*image.getWidth()));					
				}
			}
		}
		return paddedImage;
	}

	
	public static SimpleLinkedList<Integer> boundaries(GrayScaleImage image) {
		
		SimpleLinkedList<Integer> boundaries = new SimpleLinkedList<>();
		boolean inside = false;
		int pos = 0;

		// Need to start by padding the image by 1 pixel
		GrayScaleImage paddedImage = padImage(image, BACKGROUND);

		// Allocate new image as a 1D array
		GrayScaleImage borderImage =  ImageFactory.createGrayScaleImage(ImageFactory.DEPTH_32BITS, 
																		image.getWidth()+2, 
																		image.getHeight()+2);
		
		borderImage.initImage(BACKGROUND);
		
		// Defines the neighborhood offset position from current position and the neighborhood
		// position we want to check next if we find a new border at checkLocationNr
		int neighborhood[][] =  {
				{-1,7},
				{-3-image.getWidth(),7},
				{-image.getWidth()-2,1},
				{-1-image.getWidth(),1},
				{1,3},
				{3+image.getWidth(),3},
				{image.getWidth()+2,5},
				{1+image.getWidth(),5}
			};

		for(int y = 0; y < (image.getHeight()+2); y ++) {
			for(int x = 0; x < (image.getWidth()+2); x ++) {
				
				pos = x + y*(image.getWidth()+2);

				// Scan for BLACK pixel
				if(borderImage.getPixel(pos) == FOREGROUND && !inside) { // Entering an already discovered border
					inside = true;
				}
				else if(paddedImage.getPixel(pos) == FOREGROUND && inside){	// Already discovered border point				
					continue;
				}
				else if(paddedImage.getPixel(pos) == BACKGROUND && inside){	// Leaving a border			
					inside = false;
				}
				else if(paddedImage.getPixel(pos) == FOREGROUND && !inside){// Undiscovered border point
					
					borderImage.setPixel(pos, FOREGROUND);// Mark the start pixel
					int checkLocationNr = 1;	// The neighbor number of the location we want to check for a new border point
					int checkPosition;			// The corresponding absolute array address of checkLocationNr
					int newCheckLocationNr; 	// Variable that holds the neighborhood position we want to check if we find a new border at checkLocationNr
					int startPos = pos;			// Set start position
					int counter = 0; 			// Counter is used for the jacobi stop criterion
					int counter2 = 0; 			// Counter2 is used to determine if the point we have discovered is one single point
				
					// Trace around the neighborhood
					while(true) {
						
						checkPosition = pos + neighborhood[checkLocationNr-1][0];
						newCheckLocationNr = neighborhood[checkLocationNr-1][1];

						if(paddedImage.getPixel(checkPosition) == FOREGROUND){ // Next border point found						
							if(checkPosition == startPos) {
								
								counter ++;

								// Stopping criterion (jacob)
								if(newCheckLocationNr == 1 || counter >= 3) {
									// Close loop
									inside = true; // Since we are starting the search at were we first started we must set inside to true
									break;
								}
							}

							checkLocationNr = newCheckLocationNr; // Update which neighborhood position we should check next
							pos = checkPosition;
							counter2 = 0; 						// Reset the counter that keeps track of how many neighbors we have visited
							borderImage.setPixel(checkPosition, FOREGROUND);
						} else {
							// Rotate clockwise in the neighborhood
							checkLocationNr = 1 + (checkLocationNr % 8);
							if(counter2 > 8) {
								// If counter2 is above 8 we have traced around the neighborhood and
								// therefor the border is a single black pixel and we can exit
								counter2 = 0;
								break;
							} else {
								counter2++;
							}
						}
					}
				}
			}
		}

		// Remove white padding and return it
		//GrayScaleImage clippedBorderImage = ImageFactory.createGrayScaleImage(ImageFactory.DEPTH_32BITS, 
		//																		image.getWidth(), 
		//																		image.getHeight());	
		
		for(int x = 0; x < image.getWidth(); x ++) {
			for(int y = 0; y < image.getHeight(); y ++) {						
				if(borderImage.getPixel(x+1+(y+1)*(image.getWidth()+2)) == FOREGROUND) {
					boundaries.add(x+y*image.getWidth());
				}				
				//clippedBorderImage.setPixel(x+y*clippedBorderImage.getWidth(), borderImage.getPixel(x+1+(y+1)*(clippedBorderImage.getWidth()+2)));				
			}
		}
		return boundaries;

	}
		
}
