/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perciatelli_final;

/**
 *
 * @author samiksha solanki
 */

/* Team : Perciatelli
 * IDE: NEt BEANS.
 * Project: VOR APPLICATION.
 * class: RADIO
 */



import java.util.Random;

public class RadioValues      // class RadioValues
{
public static void main(String[] args)
{ 
               
		RadioValues rad = new RadioValues(0);
		for(int x = 0; x < 10; x++){
			//radio Radial, station code, signal Quality, pilot Radial
			int ID = rad.generateID(); 
                        String sigQ = rad.generateSignalQuality(); 
                        double radi = rad.generateRadial();
			//System.out.println("**DEBUG** ID = " + ID + " Quality = " + sigQ + " Radial " + radi);
			
			try {
				Thread.sleep(2000); //sleep 2 seconds
			} catch (InterruptedException e) 
                        {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}


	int test;
	int counter = 10;               // Added the counter as 10
	int spotID1 = test + 353;       // Final Station ID  
	int spotID2 = test + 242;         // starting station ID
	double startRad = 0;
	public RadioValues(int test)
        {
		this.test = test;
	}
        public double generateRadial()      // Function for generating the testvalues
        {
		double pinRadial;
		
		Random randomNo = new Random();
                
		pinRadial = randomNo.nextDouble() * 3.45;     // Created the random values for radial between 0-360
		int pinMove = randomNo.nextInt(2);
		if(pinMove > 0)
                {
                    
                   return pinRadial;
		}
                return 360 - pinRadial;
                
	}

	// function for creating the Station IDs between 242 and 353 as given in hawaii chart
	public int generateID()
        {
		Random rnd = new Random();
                int a = rnd.nextInt(spotID1-spotID2) + spotID2;
                System.out.println(a);  // print the random station Ids
               
		return a;
	}
	
	public String generateSignalQuality() // function for creating the signal quality good or bad signal
        {
		if(counter <= 0)
                {
			return "Good signal";
		}
                else if(this.counter < 5)
                {
			this.counter--;
			System.out.println(""
                                + "counter = " + this.counter);
			return "bad signal";
		}
		
		Random rn4 = new Random();
		int a = rn4.nextInt(3);
		if(a == 0)
                {
			this.counter--;
			System.out.println("counter = " + this.counter);
			return "bad signal";
		}
		return "Good Signal";
                
	}
}

 


