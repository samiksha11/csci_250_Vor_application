/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perciatelli_final;

/**
 *
 * @author samiksha solanki
 */


/*
 * VOR calculation class
 */
//package Perciatelli;

import javax.swing.JPanel;

/**
 *
 * @author samiksha solanki
 */
public class VORCAL {
	public static void main(String[] args)
{
                VORCAL myvor = new VORCAL();
		RadioValues rad = new RadioValues(0);
		for(int x = 0; x < 15; x++)
                {
                //radio Radial, station code, signal Quality, pilot Radial
			int ID = rad.generateID(); 
                        String sigQ = rad.generateSignalQuality(); 
                        double radi = rad.generateRadial();
		         System.out.println("******************************************************");
                        System.out.println(" Station ID = " + ID ); 
                        System.out.println(" Quality = " + sigQ );
                        System.out.println("Radial " + radi);
                        System.out.println("******************************************************");
			myvor.all_Signal_Values(radi, ID, sigQ, universal.getDegree(0, universal.offset));
                        }
}
	// retrieve input from the radio class
	int ID;
	double stationRad; 
	String sigQuality; 
	int Station_ID_Code_value;  
	
	// OBS values from the pilot
	
	double OBS; 
        
	
	
	// calculations for every new signals 
	String direction_VOR = ""; // to /from
	double degree_offset; //number of degrees from radial_ended
	double needle_needle_side; 
   
    
	
	public VORCAL(){
		
	}
	/**
	 
	 * @param radial The radial input from radio.
	 * @param Station_ID_Code_value Station ID .
	 * @param Signal_Quality
	 * @param radial_ended The radial from pilot.
	 */
	public void all_Signal_Values(double radial, int Station_ID_Code_value, String Signal_Quality, double radial_ended)
        {
            /* Calculated values, updated with every new signal*/

		this.stationRad = radial; 
		this.Station_ID_Code_value = Station_ID_Code_value; 
		this.sigQuality = Signal_Quality;
		this.OBS = radial_ended;
              //update calculated values
		this.direction_VOR = To_and_From(); //to, from or red
                  double degOff = deflection();
		if(degOff > 10)
                {
		          degree_offset = 10;
                        //System.out.println("hello3");
		}
		else
                {
			
                        degree_offset = degOff;
                       // System.out.println("hello2");
		}
             
                
                
                System.out.println("*********************************************************");
                System.out.println("Radio Radial: " + stationRad);
		System.out.println("Pilot OBS: " + OBS);
                System.out.println("Station Quality: " + sigQuality);
		 System.out.println("*********************************************************");
               
                if(degree_offset > 10){
			System.out.println("Deflection in Needle: 10 bars");
		}
		else{
			
                        System.out.println("Deflection in Needle: " + degree_offset + " bars");
		}
		if(this.needle_needle_side <0){
			System.out.println("Direction: negative ");    
		}
		else if(this.needle_needle_side == 0)
                {
			System.out.println("Direction: Center");
		}
		else{
			System.out.println("Direction: positive");
		}
		
                System.out.println("To/From: " + direction_VOR);
                //System.out.println("Hello");
	} 
	
	
	private double deflection(){
            
		double deflect = Closer_Distance(OBS, stationRad, true);
		
		if(deflect > 90)
                {
			deflect = 180 - deflect;
		}
		if(deflect == 0){
			this.needle_needle_side = 0;
		}
		return deflect;		
	}
	
	
	//
	 // Find the closer distance between 2 degree values
	 // @param Frst_degree first degree
	 // @param snd_degree second degree
	// @param update whether to update needle_needle_side variable 
	
	 
	public double Closer_Distance(double Frst_degree, double snd_degree, boolean update){
		double clkwiseDistance = Double.MIN_VALUE;
		double AnticlkwiseDistance = Double.MIN_VALUE;
		
		if(snd_degree == Frst_degree){
			return 0; // return 0 as distance is same
		}
		// condition if clkwiseDistance = distance clockwise from Frst_degree->snd_degree,
                //AnticlkwiseDistance = counterclockwise
		if(snd_degree > Frst_degree)
                {
			clkwiseDistance = snd_degree - Frst_degree;
			AnticlkwiseDistance = Frst_degree + 360 - snd_degree;
		}
		if(snd_degree < Frst_degree)
                {
			AnticlkwiseDistance = Frst_degree - snd_degree; //anticlock to  find the distance backwards from Frst_degree to snd_degree
			clkwiseDistance = snd_degree + 360 - Frst_degree;
		}
		
		if(clkwiseDistance < AnticlkwiseDistance) // condition for small distance
                {
			
			if(update){
				needle_needle_side = -1;
				
			}
			return clkwiseDistance;
		}
		//backward is closer
		if(update){
			needle_needle_side = 1;
		
		}
		return AnticlkwiseDistance;
	}
        /**
	 *  from,to, based on OBS and stationRad
	 * */
       
	private String To_and_From(){
           
		
            if(sigQuality.equals("bad")){
			return "RED";
		}
		//condition radial in 90 degrees of pilot radial, direction_VOR  from
		if(Closer_Distance(stationRad, OBS, false) <89){
			return "FROM";
		}
		if(Closer_Distance(stationRad, OBS, false) > 91){
			return "TO";
		}
		//too close to 90 degrees, neither from nor to
		return "RED";
	}
         public void print(String stationRad, String OBS, int degree_offset, String direction_VOR){
		System.out.println("*************************************************");
	        System.out.println("Radio Radial: " + stationRad);
		System.out.println("Pilot Radial: " + OBS);
                System.out.println("***************************************************");
		
                    if(degree_offset > 10)
                {
			//System.out.println("Deflection in Needle: grt than 10 bars");
		}
		else{
			
                        System.out.println("Deflection in Needle: " + degree_offset + " bars");
		}
		if(this.needle_needle_side <0){
			System.out.println("Direction: Left");
		}
		else if(this.needle_needle_side == 0){
			System.out.println("Direction: Center");
		}
		else{
			System.out.println("Direction: Right");
		}
		
                System.out.println("To/From: " + direction_VOR);
                //System.out.println("Hello");
	}

   
}

	
class update extends Thread{
	JPanel container;
	public update(JPanel container){
		this.container = container;
	}
	
	public void run(){

            VORCAL myvor = new VORCAL();
		RadioValues rad = new RadioValues(0);
		for(int x = 0; x < 15; x++)
                {
			//radio Radial, station code, signal Quality, pilot Radial
			int ID = rad.generateID(); String sigQ = rad.generateSignalQuality(); double radi = rad.generateRadial();
			
			myvor.all_Signal_Values(radi, ID, sigQ, universal.getDegree(0, universal.offset));
			//update universal variables
			universal.bar = myvor.needle_needle_side * myvor.degree_offset;
			universal.ID = myvor.Station_ID_Code_value;
			universal.dir = myvor.direction_VOR;
                        universal.sigQuality = myvor.sigQuality;
                        
			
			container.repaint();
			try {
				Thread.sleep(2000); //sleep 2 seconds
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

