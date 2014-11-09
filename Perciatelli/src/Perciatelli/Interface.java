/* Team Perciatelli;
 * VOR application
 * java 
 * IDE Netbeans.
 */
package Perciatelli;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;



public class Interface implements ActionListener {

	public static void main(String[] args){
		JFrame view = new JFrame("VOR DRIVER");
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interface VOR = new Interface();
	        view.setContentPane(VOR.label);
	        view.setVisible(true);
                view.getContentPane().setPreferredSize(new Dimension(500, 500));
                view.pack();
             }
    
       
         
        JPanel label = new JPanel();
        JPanel first = new JPanel(); 
	JPanel middle = new JPanel();
	JButton start = new JButton("START ");// start button
	JButton stop = new JButton("STOP");// stop button
	
	
	public Interface(){
            
            
	       label.add(first,BorderLayout.PAGE_START);
		start.addActionListener(this);
		first.add(start);
                label.add(middle,BorderLayout.PAGE_END);
		stop.addActionListener(this);
		middle.add(stop);
		
		
	}
	//@Override
	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource() == start)
                {       start.setEnabled(false);
		 Interface_update op = new Interface_update(this.label);
			op.start();
		}
                       if(event.getSource() == stop)
                {
			System.exit(0);
		}
	}

}
class Interface_update extends Thread
{
	
    JPanel label;
	public Interface_update(JPanel label)
        {
		
            this.label = label;
	}
	
	public void print()
        {
		
		RadioValues rad = new RadioValues(0);
		      int x= 0;
                     while (x<10)
                {
			 
                        int a = rad.generateID();
                        String sigQ = rad.generateSignalQuality(); 
                        double radi = rad.generateRadial();
		        System.out.println("******************************************************");
                        System.out.println(" Station ID = " + a ); 
                        System.out.println(" Quality = " + sigQ );
                        System.out.println("Radial " + radi);
                        System.out.println("******************************************************");
                        x++;
		}
	}
}
