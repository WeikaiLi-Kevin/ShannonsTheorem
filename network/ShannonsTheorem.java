
/*
 *  @(#)ShannonsTheorem.java   1.0 YY/MM/DD
 *
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warranty of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 */
package network;
import java.awt.Container;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/* Package for ShannonsTheorem class placement */
/**
 * 
 *
 * @version   1.0.0 Date
 */
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShannonsTheorem implements ShannonsController{
	/**
	 * This class computes the value of the Shannon's Theorem given the 
	 * values of the bandwidth and SNR
	 */
	/**
	 * model is a reference attribute of type ShannonsModel and type observable
	 */
	private ShannonsModel model = new ShannonsModel() ;
	/** CONSTRUCTORS    --------------------------------------   */
	/**
	 * Default constructor.
	 */
	public ShannonsTheorem(){
		super();
	};
	/**
	 * Parameterized constructor
	 * 
	 * @param bandwidth   the value of the bandwidth
	 * @param signalToNoise   the value of the SNR
	 */
	public ShannonsTheorem(double bandwidth, double signalToNoise){
		super();
		setBandwidth(bandwidth);
		setSignalToNoise(signalToNoise);
	}
	/**
	 * This method is for setting ShannonsModel object
	 * @param model ShannonsModel object
	 */
	private void setModel(ShannonsModel model){
		 this.model = model;
	}
	/**
	 * This method is for getting ShannonsModel object
	 * @return ShannonsModel object model
	 */
	private ShannonsModel getModel(){
		
		return model;
	}
	/**
	 * setter
	 * 
	 * @param h the value of the bandwidth
	 */
	public void setBandwidth(double h){
		getModel().setBandwidth(h);
	}
	/**
	 * getter
	 * 
	 * @return bandwidth the value of the bandwidth
	 */
	public double getBandwidth(){
		return getModel().getBandwidth();
	}

	/**
	 * setter
	 * 
	 * @param snr the value of the SNR
	 */
	public void setSignalToNoise(double snr){
		getModel().setSignalToNoise(snr);
	};
	
	/**
	 * getter
	 * 
	 * @return SNR the value of the SNR
	 */
	public double getSignalToNoise(){
		return getModel().getSignalToNoise();
	};
	
	/**
	 * This method computes the value of the maximum data rate
	 * @return the value of the maximum data rate 
	 */
	public double getMaximumDataRate(){
		return getModel().getMaximumDataRate();
	};
	
	/**
	 * This method used to pop up the initial interface and add observers to the Observable class ShannonsTheorem
	 */
	

	private void initGUI(){
		/**
		 * GUI Frame
		 */
		
		JFrame frame = new JFrame("Shannons Theorem MVC Vers:1.1.0");   //The frame used to contain the visible panels
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = frame.getContentPane();
		
		ShannonsPanel shannonsPanel1 = new ShannonsPanel(this);  //Get ShannonsPanel (JPanel) object 
		ShannonsSlider shannonsPanel2 = new ShannonsSlider(this); //Get ShannonsSilder (JPanel) object
		ShannonsPieChart shannonsPanel3 = new ShannonsPieChart(this); //Get ShannonsPiechart (JPanel) object
		JPanel p = new JPanel();  
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		// Put the three objects above into the Jpanel p 
		p.add(shannonsPanel1);
		p.add(shannonsPanel2);
		p.add(shannonsPanel3);
		c.add(p);
		
		addObserver(shannonsPanel1);
		addObserver(shannonsPanel2);
		addObserver(shannonsPanel3);
		frame.pack(); //Minimize the size of the GUI by packing the frame.
		frame.setVisible(true);
	}
	/**
	 *  This class implement the class ShannonsController.addObserver
	 *   add observer to the observable ShannonsTheorem object
	 */
	public void addObserver(Observer o){
		model.addObserver(o);
	}
	
	
	/**
	 * This is the main method which makes use of setBandwidth method and setSignalToNoise method
	 * @param args Unused
	 */
	public static void main(String arg[]) {
		// TODO Auto-generated method stub
		ShannonsTheorem shannonsTheorem = new ShannonsTheorem(); //Make a new ShannonsTheorem object
		shannonsTheorem.initGUI(); // Invoke the initGUI method of the ShannonsTheorem object to pop up the initial GUI
	}

}
