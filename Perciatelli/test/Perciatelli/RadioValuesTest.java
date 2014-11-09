/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Perciatelli;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

                 
/**
 *
 * @author samiksha solanki
 */
public class RadioValuesTest {
    
    
    public RadioValuesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateRadial method, of class RadioValues.
     */
    @Test
    /*public void testGenerateRadial() {
        System.out.println("Radial");
        double instance = generateRadial();
        double expResult = 370.0;
        double result = instance.generateRadial();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/
    
     public void testGenerateRadial() {
    int test1=0;
    int test21 = test1 + 360;
     int test22 = test1 + 0;

    for (int i = 0; i < 360; i++) {
       
        if (test21 > test1) {
            
        } else {
        }
        if (test21 < 0) {
            fail("Incorrect value of radial");
        }

        if (test21 < 360) {
            test21 = 353;
        }

        if (test22 > 0) {
            test22 = 0;
        }
    }

    if (test22 == test21) {
        fail("The largest radial count is the same as the lowest radial count. ");
    }

    if (test22 != 0) {
        fail("The lowest pin is " + test22 + " and it should be zero.");
    }


}

    /**
     * Test of generateID method, of class RadioValues.
     */
    @Test
    public void testGenerateID() {
        
        int test1=0;
    int test21 = test1 + 353;
     int test22 = test1 + 242;

    for (int i = 0; i < 353; i++) {
        
        if (test21 > test1) {
            } 
        else 
        {
        }
        if (test21 < 0) {
            fail("Incorrect value of ID");
        }

        if (test21 < 353) {
            test21 = 353;
        }

        if (test22 > 242) {
            test22 = 242;
        }
    }

    if (test22 == test21) {
        fail("The biggest station Id count is the same as the lowest station id. ");
    }

    }

    /**
     * Test of generateSignalQuality method, of class RadioValues.
     */
    @Test
   /* public void testGenerateSignalQuality() {
        System.out.println("generateSignalQuality");
        RadioValues instance = null;
        String expResult = "";
        String result = instance.generateSignalQuality();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }*/
    public void testGenerateSignalQuality() 
    {
        System.out.println("generateSignalQuality");
      //  RadioValues instance = new RadioValues();
        //String expResult = "";
        int counter = 10;
        if(counter <= 0)
                {
//			return "Good signal";
                    System.out.println("Good Signal");
		}
         else if(counter < 5)
                {
			counter--;
			System.out.println(""
                                + "counter = " +counter);
//			return "bad signal";
                        System.out.println("Bad Signal");

		}
        Random rn4 = new Random();
		int a = rn4.nextInt(3);
		if(a == 0)
                {
			counter--;
			System.out.println("counter = " +counter);
//			return "bad signal";
                                                System.out.println("Bad Signal");

		}
        
		
    
        }
    

   
    

    private double generateRadial() {
        {
		double pinRadial;
		
		Random randomNo = new Random();
                
		pinRadial = randomNo.nextDouble() * 3.45;
		int pinMove = randomNo.nextInt(2);
		if(pinMove > 0)
                {
                    
                   return pinRadial;
		}
                return 360 - pinRadial;
                
	}
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
             }
       