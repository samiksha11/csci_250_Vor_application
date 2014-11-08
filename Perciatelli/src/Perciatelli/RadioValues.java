package Perciatelli;


import java.util.Random;

public class RadioValues 
{
	int test;
	int counter = 10;
	int spotID1 = test + 353;
	int spotID2 = test + 242;
	double startRad = 0;
	public RadioValues(int test)
        {
		this.test = test;
	}
        public double generateRadial()
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
}
	
	