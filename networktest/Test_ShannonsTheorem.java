/*
 *  @(#)Test_ShannonsTheorem.java	Feb 17, 2005
 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 *
 */

package networktest;

import junit.framework.*;
import network.ShannonsModel;
import network.ShannonsTheorem;


/**
 *	JUnit tests for the ShannonsTheorem class from the "network" project.
 * @author Weikai Li
 * @version 1.0.0
 */
public class Test_ShannonsTheorem extends TestCase {


	public Test_ShannonsTheorem(String name) { super(name);	}

	public static Test suite() { return new TestSuite(Test_ShannonsTheorem.class);		}

	protected void setUp() throws Exception { System.out.println("Test_ShannonsTheorem Begin");	}

	protected void tearDown() throws Exception { System.out.println("Test_ShannonsTheorem End");	}

 	/**
 	 * Test the constructors.
 	 */
	public void testConstructors() {
      System.out.println("\tExecuting Test_ShannonsTheorem.testConstructors");
		shannonsTheorem = new ShannonsTheorem();
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);

		shannonsTheorem = new ShannonsTheorem(10.0, 20.0);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		/*
		 *	TODO:	Add tests for your parameterized constructors here
		 */
		shannonsTheorem = new ShannonsTheorem(10, 20);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		shannonsTheorem = new ShannonsTheorem(-10, -20);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		
		shannonsTheorem = new ShannonsTheorem(1000000.0, 100000.0);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		
		shannonsTheorem = new ShannonsTheorem(-10, 20);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		
		shannonsTheorem = new ShannonsTheorem(10,-10);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		
		shannonsTheorem = new ShannonsTheorem(0.0001,0.0001);
		assertNotNull("\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null", shannonsTheorem);
		
	}
	

	/**
	 * Test the accessors.
	 */
	public void testAccessors() {
	      System.out.println("\tgetMDR");
	      shannonsTheorem = new ShannonsTheorem();
	      shannonsTheorem.setBandwidth(10);
			double result1 = shannonsTheorem.getBandwidth();
			double expResult1 = 10;
			assertEquals(result1,expResult1);
			
			shannonsTheorem.setBandwidth(0);
		   double result2 = shannonsTheorem.getBandwidth();
			double expResult2 = 0;
			assertEquals(result2,expResult2);
			
			shannonsTheorem.setSignalToNoise(-10);
			double result3 = shannonsTheorem.getSignalToNoise();
			double expResult3 = -10;
		
			assertEquals(result3,expResult3);

			shannonsTheorem.setSignalToNoise(10);
			double result4 = shannonsTheorem.getSignalToNoise();
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
	public void testMaximumDataRate() {
      System.out.println("\tgetMDR");
		shannonsTheorem = new ShannonsTheorem(10,10);
		double expResult8 = 34.59;
		double result8 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result8,expResult8,0.01);
		shannonsTheorem = new ShannonsTheorem(10000,10000);
		double expResult1 = 132878.57;
		double result1 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result1,expResult1,0.01);
		shannonsTheorem = new ShannonsTheorem(-10,10);
		double expResult2 = -99.00;
		double result2 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result2,expResult2,0.01);
		shannonsTheorem = new ShannonsTheorem(10,-10);
		double expResult3 = -99.00;
		double result3 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result3,expResult3,0.01);
		shannonsTheorem = new ShannonsTheorem(0,0);
		double expResult4 = 0;
		double result4 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result4,expResult4,0.01);
		shannonsTheorem = new ShannonsTheorem(-10,-10);
		double expResult5 = -99.00;
		double result5 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result5,expResult5,0.01);
		shannonsTheorem = new ShannonsTheorem(0.00001,10);
		double expResult6 = 0;
		double result6 = shannonsTheorem.getMaximumDataRate();
		assertEquals(result6,expResult6,0.01);
		shannonsTheorem = new ShannonsTheorem(10,0.00001);
		double expResult7 = 0;
		double result7 = shannonsTheorem.getMaximumDataRate();
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
   private ShannonsTheorem shannonsTheorem = null;


}	/*	End of CLASS:	Test_ShannonsTheorem.java				*/
