/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Perciatelli;

import java.awt.Dimension;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samiksha solank
 */
public class VORmeterTest {
    
    public VORmeterTest() {
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
     * Test of getPreferredSize method, of class VORmeter.
     */
    @Test
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        VORmeter instance = new VORmeter();
        
        Dimension expResult = new Dimension(500,500);
       
        Dimension result = instance.getPreferredSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findPoint method, of class VORmeter.
     */
    @Test
    public void testFindPoint() {
        System.out.println("findPoint");
        double x = 1.0;
        double y = 1.0;
        double distance = 10.0;
        double slope = 1.0;
        VORmeter instance = new VORmeter();
        instance.findPoint(x, y, distance, slope);
        
    }

    /**
     * Test of MeterCoordinate method, of class VORmeter.
     */
    @Test
    public void testMeterCoordinate() {
        System.out.println("MeterCoordinate");
        float Meterdegree = 0.0F;
        float r = 0.0F;
        VORmeter instance = new VORmeter();
        instance.MeterCoordinate(Meterdegree, r);
       
    }

    /**
     * Test of MeterSlope method, of class VORmeter.
     */
    @Test
    public void testMeterSlope() {
        System.out.println("MeterSlope");
        double x1 = 20.0;
        double y1 = 20.0;
        double x2 = 10.0;
        double y2 = 20.0;
        VORmeter instance = new VORmeter();
        double expResult = 1.0;
        double result = instance.MeterSlope(x1, y1, x2, y2);
        assertEquals(expResult, result, 1.0);
        
    }
     public void testMeterSlope_1() {
        System.out.println("MeterSlope");
        double x1 = 30.0;
        double y1 = 30.0;
        double x2 = 10.0;
        double y2 = 10.0;
        VORmeter instance = new VORmeter();
        double expResult = 1.0;
        double result = instance.MeterSlope(x1, y1, x2, y2);
        assertEquals(expResult, result, 1.0);
        
    }
    /**
     * Test of paintComponent method, of class VORmeter.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        VORmeter instance = new VORmeter();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}