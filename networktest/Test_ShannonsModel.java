package networktest;

import junit.framework.*;

import network.ShannonsModel;


/**
 *	JUnit tests for the ShannonsTheorem class from the "network" project.
 * @author Weikai Li
 * @version 1.0.0
 */
public class Test_ShannonsModel extends TestCase {


	public Test_ShannonsModel(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsModel.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsTheorem Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsTheorem End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
      System.out.println("\tExecuting Test_ShannonsTheorem.testConstructors");
		model = new ShannonsModel();
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", model);
	}
	

	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
      System.out.println("\tgetMDR");
		model = new ShannonsModel();
		model.setBandwidth(10);
		double result1 = model.getBandwidth();
		double expResult1 = 10;
		assertEquals(result1,expResult1);
		
		model.setBandwidth(0);
	   double result2 = model.getBandwidth();
		double expResult2 = 0;
		assertEquals(result2,expResult2);
		
		model.setSignalToNoise(-10);
		double result3 = model.getSignalToNoise();
		double expResult3 = -10;
	
		assertEquals(result3,expResult3);

		model.setSignalToNoise(10);
		double result4 = model.getSignalToNoise();
		double expResult4 = 10;
		
		assertEquals(result4,expResult4,0.01);

	}

	/**
	 * Test the mutators.
	 */
	public void testMutators(){
		
	}
	/**
	 * Test the behaviors
	 */
	public void testMaximumDataRate(){
		model = new ShannonsModel();
		model.setBandwidth(10);
		model.setSignalToNoise(10);
		double result8 = model.getMaximumDataRate();
		double expResult8 = 34.59;
		assertEquals(result8,expResult8,0.01);
		
		model.setBandwidth(10000);
		model.setSignalToNoise(10000);
		double result1 = model.getMaximumDataRate();
	
		double expResult1 = 132878.57;
		assertEquals(result1,expResult1,0.01);
		model.setBandwidth(-10);
		model.setSignalToNoise(10);
		double result2 = model.getMaximumDataRate();
		double expResult2 = -99.00;
		assertEquals(result2,expResult2,0.01);
		
		model.setBandwidth(10);
		model.setSignalToNoise(-10);
		double result3 = model.getMaximumDataRate();
		double expResult3 = -99.00;
		assertEquals(result3,expResult3,0.01);
		
		model.setBandwidth(0);
		model.setSignalToNoise(0);
		double result4 = model.getMaximumDataRate();
		double expResult4 = 0;
	
		assertEquals(result4,expResult4,0.01);
		
		model.setBandwidth(-10);
		model.setSignalToNoise(-10);
		double result5 = model.getMaximumDataRate();
		double expResult5 = -99.00;
	
		assertEquals(result5,expResult5,0.01);
		model.setBandwidth(0.00001);
		model.setSignalToNoise(10);
		double result6 = model.getMaximumDataRate();
		double expResult6 = 0;
		
		assertEquals(result6,expResult6,0.01);
		
		double expResult7 = 0;
		model.setBandwidth(10);
		model.setSignalToNoise(0.00001);
		double result7 = model.getMaximumDataRate();
		assertEquals(result7,expResult7,0.01);
		
	}



	/*	STAND-ALONE ENTRY POINT -----------------------------------------	*/
	/**
	 *	Main line for standalone operation.
	 *	@param	args	Standard string command line parameters.
	 */
	public static void main(String[] args) {
      System.out.println("Executing Test_ShannonsTheorem suite");
      junit.textui.TestRunner.run(suite());
  }



   /* ATTRIBUTES	-----------------------------------------------	*/
   private ShannonsModel model = null;


}	/*	End of CLASS:	Test_ShannonsTheorem.java				*/
