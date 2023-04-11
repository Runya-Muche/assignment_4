

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany mgmt;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mgmt = new ManagementCompany("runya", "taxNum", 7);
		
		p1 = new Property("house1", "city1", 350, "owner1", 5, 1, 1, 2);
		p2 = new Property("house2", "city2", 600, "owner2", 3, 1, 1, 2);
		p3 = new Property("house3", "city3", 1100, "owner3", 7, 1, 1, 2);
		
		//student add three properties, with plots, to mgmt co
		mgmt.addProperty(p1);
		mgmt.addProperty(p2);
		mgmt.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		mgmt = null;
		p1 = p2 = p3 = p4 = p5 = p6 = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson", 0, 0, 1, 1);
		p5 = new Property ("Mystic Cove", "Lakepointe", 5327, "Joey BagODonuts",1,1,2,2);
		p6 = new Property ("Too Many Properties", "Lakepointe", 1000, "Joey BagODonuts",6,3,3,2);
		
		//student should add property with 8 args
		
		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		
		assertEquals(mgmt.addProperty(p4), 3, 0);
		assertEquals(mgmt.addProperty(p5), 4, 0);
		assertEquals(mgmt.addProperty(p6), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmt.maxRentProp(), 1100, 0);
		
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmt.totalRent(), 2050, 0);
	}

 }
