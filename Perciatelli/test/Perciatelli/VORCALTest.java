/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Perciatelli;

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
public class VORCALTest {
    
    public VORCALTest() {
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
     * Test of main method, of class VORCAL.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        VORCAL.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of newSignal method, of class VORCAL.
     */
    @Test
    public void testNewSignal() {
        System.out.println("newSignal");
        double radial =357.7655741573244;
        int stationCode =  259;
        String quality = "Good";
        double doubleendedRad = 0.0;
        VORCAL instance = new VORCAL();
        instance.newSignal(radial, stationCode, quality, doubleendedRad);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Closer_Distance method, of class VORCAL.
     */
    @Test
    public void testCloser_Distance() {
        System.out.println("Closer_Distance");
        double clkwiseDistance = Double.MIN_VALUE;
       double AnticlkwiseDistance = Double.MIN_VALUE;
        double Frst_degree = 10.0;
        double snd_degree = 20.0;
        boolean update = false;
        VORCAL instance = new VORCAL();
        double expResult = 10.0;
       System.out.println("equal");
       if(snd_degree > Frst_degree)
                {
			clkwiseDistance = snd_degree - Frst_degree;
			AnticlkwiseDistance = Frst_degree + 360 - snd_degree;
                        System.out.println("clkwiseDistance"+clkwiseDistance);
                        
		}
		if(snd_degree < Frst_degree)
                {
			AnticlkwiseDistance = Frst_degree - snd_degree; //anticlock to  find the distance backwards from Frst_degree to snd_degree
			clkwiseDistance = snd_degree + 360 - Frst_degree;
                        System.out.println("AnticlkwiseDistance"+AnticlkwiseDistance);
		}
		
        double result = instance.Closer_Distance(Frst_degree, snd_degree, update);
        assertEquals(expResult, result, 10.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    public void testCloser_Distance1() {
        System.out.println("Closer_Distance");
        double clkwiseDistance = Double.MIN_VALUE;
       double AnticlkwiseDistance = Double.MIN_VALUE;
        double Frst_degree = 5.0;
        double snd_degree = 10.0;
        boolean update = false;
        VORCAL instance = new VORCAL();
        double expResult = 0.0;
        clkwiseDistance = snd_degree - Frst_degree;
        AnticlkwiseDistance = Frst_degree + 360 - snd_degree;
        System.out.println("clkwiseDistance"+clkwiseDistance);
        System.out.println("AnticlkwiseDistance"+AnticlkwiseDistance);
        
        double result = instance.Closer_Distance(Frst_degree, snd_degree, update);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    /**
     * Test of print method, of class VORCAL.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        String stationRad = "NULL";
        String pilot_radian ="NULL";
        int degree_offset = 0;
        String direction_VOR = "Left";
        VORCAL instance = new VORCAL();
        instance.print(stationRad, pilot_radian, degree_offset, direction_VOR);
        // TODO review the generated test code and remove the default call to fail.
        
    }
     public void testPrint2() {
        System.out.println("print");
        String stationRad = "NULL";
        String pilot_radian ="NULL";
        int degree_offset = 0;
        String direction_VOR = "Right";
        VORCAL instance = new VORCAL();
        instance.print(stationRad, pilot_radian, degree_offset, direction_VOR);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}