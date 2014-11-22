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
public class globalTest {
    
    public globalTest() {
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
     * Test of getDegree method, of class global.
     */
    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        double original = 20.0;
        double offset = 10.0;
        double expResult = 10.0;
        double result = global.getDegree(original, offset);
        assertEquals(expResult, result, 10.0);
        
    }
}