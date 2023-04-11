/**
 * Represents the Management Company object
 * @author runya
 *
 */

public class ManagementCompany {

	// the fields of the ManagementCompany class
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property[] properties;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Plot plot;
	private int numProp;
	
	/**
	 * Default constructor for ManagementCompany class
	 */
	public ManagementCompany() {
		name = "";
		taxID = "";
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		numProp = 0;
	}
	
	/**
	 * The constructor initializes the fields
	 * @param name The management company's name
	 * @param taxID The management company's taxID
	 * @param mgmFee The management company's mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		numProp = 0;
	}
	
	/**
	 * The constructor initializes the fields and plot object
	 * @param name The management company's name
	 * @param taxID The management company's taxID
	 * @param mgmFee The management company's mgmFee
	 * @param x The x value of the property's plot.
	 * @param y The y value of the property's plot.
	 * @param width The width of the property's plot.
	 * @param depth The depth of the property's plot.
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		numProp = 0;
	}
	
	/**
	 * The copy constructor initializes the object
	 * as a copy of another ManagementCompany object
	 * @param otherCompany The object to copy
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
		this.properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < otherCompany.properties.length; i++) {
			properties[i] = otherCompany.properties[i];
		}
		numProp = 0;
	}
	
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public  int addProperty(String name, String city, double rent, String owner) 
	{
		Property property = new Property(name, city, rent, owner);
		numProp++;
		return addProperty(property);
	}
	
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public  int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		numProp++;
		return addProperty(property);
	}

	/**
	 * 
	 * @param property
	 * @return
	 */
	public  int  addProperty( Property property ) 
	{
		int rtnValue=-1; //properties[] is full
		if  (property == null)
			rtnValue=-2; //property is null (shouldn't happen)
		else if (!plot.encompasses(property.getPlot()))
			rtnValue=-3; //mgmtCo plot does not encompass property plot
		else 
			for (int i=0; i<properties.length; i++)
			{
				if (properties[i] == null )
				{
					//create a new property to avoid information change 
					Property p =  new Property (property);
					properties[i] = p;
					rtnValue=i;
					numProp++;
					break;
				}
				else
					if (properties[i].getPlot().overlaps(property.getPlot())) {
						rtnValue=-4;  //if property plot overlaps ANY of properties in array, return -4
						break;
					}
			}
		
		return rtnValue;
	}
	
	/**
	 * Adds all the rentAmount values from 
	 * the property array objects
	 * @return The total of all the rent
	 */
	public double totalRent() {
		// initialize total to 0
		double total = 0;
		
		// loop over all the rent values 
		for (int i = 0; i < numProp; i++) {
			total += properties[i].getRentAmount();
		}
		
		return total;
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public String displayPropertyAtIndex(int i) {
		String str = properties[i].toString();
		return str;
	}
	
	/**
	 * getMAX_PROPERTY method
	 * @return The MAX_PROPERTY field
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * 
	 * @return
	 */
	public double maxRentProp() {
		double highest = properties[0].getRentAmount();
		
		for (int i = 1; i < numProp; i++) {
			if (highest < properties[i].getRentAmount()) {
				highest = properties[i].getRentAmount();
			}
		}
		
		return highest;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int maxRentPropertyIndex() {
		// initialize highest to the first value of the properties array rent amount
		double highest = properties[0].getRentAmount();
		int index = 0;
		
		// loop to see if there is a higher rent value from the other property objects
		for (int i = 1; i < properties.length; i++) {
			if (highest < properties[i].getRentAmount()) {
				index = i;
			}
		}
		
		// return the index with the highest rent amount
		return index;	
	}
	
	/**
	 * getPlot method
	 * @return The plot field
	 */
	public Plot getPlot() {
		return this.plot;
	}
	
	/**
	 * getName method
	 * @return The name field
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * toString method
	 * @return A string containing the management campony's information.
	 */
	public String toString() {
		String str = "List of properties for the " + name + ", taxID: " + taxID +
					"\n____________________________________________________________________";
	
		for (int i = 0; i < MAX_PROPERTY; i++) {
			str += " Property Name: " + properties[i].getPropertyName() +
					"  \nLocated in " + properties[i].getCity() + 
					"  \nBelonging to: " + properties[i].getOwner() +
					"  \nRent Amount: " + properties[i].getRentAmount();
		}
		
		return str;
	}

	
}
