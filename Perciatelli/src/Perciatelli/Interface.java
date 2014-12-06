/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perciatelli_final;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.geom.Ellipse2D;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface implements ActionListener{
    public static void main(String[] args){
		JFrame view = new JFrame("VOR");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interface VOR = new Interface();
		 view.setContentPane(VOR.label);
	        view.getContentPane().setBackground(Color.YELLOW); 
                view.getContentPane().setPreferredSize(new Dimension(1000, 1000));
		view.pack();
		view.setVisible(true);
                
                	}
	JPanel label = new JPanel(); //panel holding everything
	JLabel title = new JLabel("VOR");
	JPanel middle = new JPanel(); //panel holding buttons on bottom
	
	JButton start = new JButton("Start");
	JButton stop = new JButton("STOP");
	JButton forward = new JButton("SET OBS FORWARD");   // move the vor forward
        JButton back = new JButton("SET OBS BACKWARD");   //move the vor backward
        JTextField numberEnter = new JTextField("",20);
        
	
	
	public Interface(){
		
		label.add(title,BorderLayout.PAGE_START);
		label.add(new VORmeter());
		label.add(middle,BorderLayout.PAGE_END);
		start.addActionListener(this);
		middle.add(start);
		stop.addActionListener(this);
		middle.add(stop);
		back.addActionListener(this);
		middle.add(back);
		forward.addActionListener(this);
		middle.add(forward);
                //middle.addActionListener(this);
                middle. add(numberEnter);
                
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
            VORCAL vor = new VORCAL();
            double vor_OBS = (double) vor.OBS;
		
		if(ae.getSource() == forward){
			
                    global.offset = global.offset - 5;
                        //System.out.println("Pilot Radial: " + OBS);
			
			label.repaint();
                        System.out.println("Pilot Radial: " + vor_OBS);
		}
		if(ae.getSource() == back)
                {
			
                    global.offset = global.offset + 5;
			System.out.println("Offset = " + global.offset);
			//System.out.println("Degree is: " + global.getDegree(0, global.offset));
			label.repaint();
		}
		if(ae.getSource() == stop){
			System.exit(0);
		}
		if(ae.getSource() == start){
			//back.setEnabled(false);
			//forward.setEnabled(false);
                  //  JTextField numberEnter = new JTextField("Station ID: " + global.ID,20);
                    //middle. add(numberEnter);
                                  //      String strI = String.valueOf(global.ID);
                 //   System.out.println("string is "+global.ID);
                   //  numberEnter.setText(strI);
                    int b = stationID_value();
                                        System.out.println("string test1"+b);

String strI;
                strI = Integer.toString(b);
                    numberEnter.setText(strI);
                                        System.out.println("string test2"+strI);

			start.setEnabled(false);
			update up = new update(this.label);
			up.start();
                       
		}
	}

    private int stationID_value() 
    {
    int a = global.ID;
System.out.println("string test2"+a);
return a;

    }

}
class update_1 extends Thread{
	JPanel label;
	public update_1(JPanel label){
		this.label = label;
	}
	
	public void run()
        {
               RadioValues rad = new RadioValues(0);
                VORCAL tr = new VORCAL();
		      int x= 0;
                     while (x<10)
                {       
                         int a = rad.generateID();
                        String sigQ = rad.generateSignalQuality(); 
                        double radi = rad.generateRadial();
		        
                      
                        tr.newSignal(radi, a, sigQ, global.getDegree(0, global.offset));
			//update global variable
			global.dir = tr.direction_VOR;
			//update gui
			label.repaint();
			
                        x++;
		}
                 
                
	}
}
class VORmeter extends JPanel{
	
	double x1, y1,radius; //used for getCoordinate()
	
        public VORmeter(){
        }
	public Dimension getPreferredSize() 
        
       {
        return new Dimension(500,500);
         }
      

      
    


        
	//
	// Find the point located a certain distance away from (x, y) with given slope.
	// @param x
	// @param y
	 // @param distance
	 //
	public void findPoint(double x, double y, double distance, double slope){
		x1 = (distance/Math.sqrt(1 + Math.pow(slope, 2))) + x;
		y1 = ((slope*distance)/Math.sqrt(1 + Math.pow(slope, 2))) + y;
	}
	/**
	 * Find the coordinate on the circle, store in x1, y1.
	 * @param Meterdegree The cooresponding degree of coordinate
	 */
	public void MeterCoordinate(float Meterdegree, float r)
        {
		 double sinr = (r * Math.sin(Math.toRadians(Meterdegree)));
                 double cosr = (r * Math.cos(Math.toRadians(Meterdegree)));
                 float Metercenter = 210; 
		if(Meterdegree < 0)
                {
			Meterdegree  = Meterdegree + 360;
		}
		if(Meterdegree >= 360)
                {
			Meterdegree =  Meterdegree - 360;
		}
		if(Meterdegree < 91)
                {
		
			
                         x1 = Metercenter + sinr;
			
                          y1 = Metercenter - cosr;
		}
		
		else if((Meterdegree > 90) && (Meterdegree<= 180))
                {
			
                         x1 = Metercenter + sinr;
				
                         y1 = Metercenter - cosr;
		}
		else if((Meterdegree > 180) && (Meterdegree < 271))
                {
			
				x1 = Metercenter + sinr;
				y1 = Metercenter - cosr;
		}
		else if((Meterdegree > 270) && (Meterdegree<= 360))
                {
			
				
                                       x1 = Metercenter + sinr;
                                      y1 = Metercenter - cosr;
		}
		
		
	}
    
	
	public double MeterSlope(double x1, double y1, double x2, double y2)
        {
        
		
            double deltaY = y2 - y1;
          double  deltaX = x2 - x1;
          double RC = deltaY / deltaX;

             if (deltaY == 0)
         {
          System.out.println("The slope is 0, no linear line.");
           }
             else if (deltaX == 0)
          {
          System.out.println("Not a Linear Line");
         }        
             else
      {
    System.out.println("The crosspoint with Y, if x is 0, : ");
      } 
             return RC;
	}
	@Override
	
         public void paintComponent(Graphics g)
        {
		super.paintComponent(g);
                Graphics2D g2D = (Graphics2D) g;    
		 g.setColor(Color.black);
                g2D.setStroke(new BasicStroke(5F));   // width of the  VOR_Meter
                
                
		g.drawOval(10, 10, 400, 400);
                //g.drawOval(10, 10, 40, 40);
                
		//g.drawOval(60, 60, 300, 300); 
                g.drawOval(60, 60, 300, 300);
                g.drawOval(50,60,50,50);
               
                int j = 110;
                while (j<= 310)
                {
                   
			if(j == 210)
                        {
				 //  center line
                                g.drawLine(j, 170, j, 250);
                               
			}
			else{
				// all other marks in meter
                                g.drawLine(j, 205, j, 215);
			}
                        j= j+20;
		}
		//draw 
		g.drawLine(60,210,80,210);
              
		//draw TO FROM
		if(global.dir.equals("TO"))
                {
			g.drawString("TO", 280, 170);
		}
		if(global.dir.equals("FROM"))
                {
			g.drawString("FR", 280, 260);
			
                }
		if(global.dir.equals("RED"))
                {
			g.drawString("TO", 280, 170);
			g.drawString("FROM", 280, 260);
		}
		
		// moving station IDs
		
               
		g.drawString("Station ID: " + global.ID, 100, 450);
                g.drawString("Signal Quality: " + global.sigQuality, 100, 460);
                g.drawString("obs: " + global.OBS, 100, 470);
                //JTextField numberEnter = new JTextField("Station ID: " + global.ID);
                
		
		//draw the obs (moving)
                int x = 0;
                while(x<= 360)
                {
			//this.MeterCoordinate(x + global.offset, 150);
                        this.MeterCoordinate(x + global.offset, 50);
			//g.drawOval((int)x1 - 2, (int)y1 - 2, 4, 4);
                      // g.drawOval((int)x1 - 2, (int)y1 + 5, 6, 6);
                        
                        g.drawOval((int)x1 - 12, (int)y1 + 12, 14, 14);
                       // g.drawOval((int)x1 - 30, (int)y1 - 30, 30, 30);
                         //g.drawOval(50,60,50,50);
                        x= x+15;
                         
		}
		//draw VOR needle
                double a= (10 * global.bar);
               g.drawLine(210 + (int) a , 210 + 50, 210 + (int) a, 160);
		
		//draw N S W E symbols (moving)
		this.MeterCoordinate(0 + global.offset, 170); // for North
		
		g.drawString("North", (int)x1, (int)y1);
		
		this.MeterCoordinate(90  + global.offset, 170); // for East
		
		g.drawString("East", (int)x1, (int)y1);
		
		this.MeterCoordinate(180  + global.offset, 170); // for South
		
		g.drawString("South", (int)x1, (int)y1);
		
                this.MeterCoordinate(270  + global.offset, 170); // for West
		g.drawString("West", (int)x1, (int)y1);
		
	}
 
	
}

class global{
	public static int offset = 0;
	public static int ID = 0;
        public static String sigQuality = "";
	public static double bar = 0; //deflection needle, 10 is max
	public static String dir = ""; //to, from
        public static float OBS = 0;
	public static double getDegree(double original, double offset)
        {
		double Meterdegree = original - offset;
		while(Meterdegree < 0){
			Meterdegree =  Meterdegree + 360;
		}
		while(Meterdegree > 359){
			Meterdegree =  Meterdegree - 360;
		}
		return Meterdegree;		
	}
	
}








