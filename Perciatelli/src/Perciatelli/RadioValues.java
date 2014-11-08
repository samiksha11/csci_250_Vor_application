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
	
	public int generateID()
        {
		Random rnd = new Random();
                int a = rnd.nextInt(spotID1-spotID2) + spotID2;
                System.out.println(a);
               
		return a;
	}
	
	public String generateSignalQuality()
        {
		if(counter <= 0)
                {
			return "Good signal";
		}
		if(this.counter < 5)
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
