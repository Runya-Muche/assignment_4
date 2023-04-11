/**
 * Represents a property object
 * @author runya
 *
 */

public class Property {

	// fields for the property class
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * Default constructor for property class
	 */
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	/**
	 * The copy constructor initializes the object
	 * as a copy of another property object
	 * @param prop The object to copy
	 */
	public Property(Property prop) {
		this.city = prop.city;
		this.owner = prop.owner;
		this.propertyName = prop.propertyName;
		this.rentAmount = prop.rentAmount;
		this.plot = new Plot(prop.plot);
	}
	
	/**
	 * The constructor initializes the fields.
	 * @param propertyName The property's name.
	 * @param city The property's city.
	 * @param rentAmount The rent of the property.
	 * @param owner The property's owner.
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	/**
	 * The constructor initializes the fields and plot object
	 * @param propertyName The property's name.
	 * @param city The property's city.
	 * @param rentAmount The rent of the property.
	 * @param owner The owner of the property.
	 * @param x The x value of the property's plot.
	 * @param y The y value of the property's plot.
	 * @param width The width of the property's plot.
	 * @param depth The depth of the property's plot.
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * getCity method
	 * @return The city field
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * getOwner method
	 * @return The owner field
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * getRentAmount method
	 * @return The rent field
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * getPropertyName method
	 * @return The property name field
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * setCity method
	 * @param city Sets a value to the city field
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * setOwner method
	 * @param owner Set's a value to the owner field
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * setRentAmount method
	 * @param rentAmount Set's a value to the rentAmount field
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	/**
	 * setPropertyName method
	 * @param propertyName Set's a value to the propertyName field
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * setPlot method 
	 * @param x The x value of the plot
	 * @param y The y value of the plot
	 * @param width The width value of the plot
	 * @param depth The depth value of the plot
	 * @return Plot with given parameter arguments
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x, y, width, depth);
	}
	
	/**
	 * getPlot method
	 * @return The plot field
	 */
	public Plot getPlot() {
		return this.plot;
	}
	
	/**
	 * toString method
	 * @return A string containing the property's information.
	 */
	public String toString() {
		String str = "Property Name: " + propertyName +
					"\nLocated in " + city +
					"\nBelonging to: " + owner +
					"\nRent Amount: " + rentAmount;
		return str;
	}
}
