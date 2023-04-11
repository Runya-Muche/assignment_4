/**
 * Represents a Plot object 
 * @author runya
 *
 */
public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;

	/**
	 * Plot default constructor initializing object
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * The copy constructor initializes the object
	 * as a copy of another Plot object
	 * @param p The object to copy
	 */
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	/**
	 * The plot constructor with initial values.
	 * @param x The x value of the plot.
	 * @param y The y value of the plot.
	 * @param width The width of the plot.
	 * @param depth The depth of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Checks to see if plots are overlapping.
	 * @param plot Object being compared for overlapping.
	 * @return A boolean value if plot is overlapping
	 */
	public boolean overlaps(Plot plot) {
		boolean status = false;
		
		// set second plot values to different variables
		int x2 = plot.x;
		int y2 = plot.y;
		int w2 = plot.width;
		int d2 = plot.depth;
		
		// conditional for the plot 
		if ((x2 < x + width) && (x2 + w2 > x) && (y2 < y + depth) && (y2 + d2 > y)) {
			status = true; 
		}
		
		// return statement
		return status;
	}
	
	/**
	 * Checks to see if plots are encompassing one another.
	 * @param plot Object that is being checked if it encompasses another
	 * @return A boolean value if plots is encompassing.
	 */
	public boolean encompasses(Plot plot) {

		// initial boolean statement 
		boolean status = false;
		
		// set variables for the second plot objects values
		int x2 = plot.x;
		int y2 = plot.y;
		int w2 = plot.width;
		int d2 = plot.depth;
		
		// test to see where the plot is being encompassed
		if ((x2 >= x) && (y2 >= y) && (x2 + w2 <= x + width) && (y2 + d2 <= y + depth))
				{
			status = true;
		}
		
		// return the boolean value
		return status;
	}
	
	/**
	 * setX method
	 * @param x Sets a value to the x field
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * setY method
	 * @param y Sets a value to the y field
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * setWidth method
	 * @param width Sets a value to the width field
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * setDepth method
	 * @param depth Set's a value the depth field
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * getX method
	 * @return The x field
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * getY method
	 * @return The y field
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * getWidth method
	 * @return The width field
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * getDepth method
	 * @return The depth field
	 */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * toString method
	 * @return A string containing the plot points and dimensions.
	 */
	public String toString() {
		String str = "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		
		return str;
	}
}
