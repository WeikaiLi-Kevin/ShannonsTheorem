package network;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//It is a JPane, return JPane
public class ShannonsPanel extends JPanel implements Observer{
	/**
	 * The class get the text field to get input from user and 
	 * show the output in Label
	 */
	
	/**
	 * controller ShannonsController variable, use to connect with ShannonsTheorem
	 */
	private	ShannonsController controller;
	
	/**
	 * maxDataRateLBL JLabel variable, get the result of max data rate and show the result on the GUI
	 */
	private JLabel maxDataRateLBL;
	
	/**
	 * This class get the shannonsController object and show the initial GUI 
	 * @param ctl    deliver the parameter to the object controller  
	 */
	public ShannonsPanel(ShannonsController ctl){
		 controller = ctl;
		 initGUI();
	}
	
	/**
	 * Getter
	 * This method get the JLabel of the maximum data rate computed 
	 * @return maxDataRateLBL the JLabel of the maximum data rate
	 */
	public JLabel getMaxDataRateLBL(){
		return maxDataRateLBL;
	};
	
	/**
	 * Setter 
	 * This method set the max data rate by delivering the variable of JLabel  
	 * @param mdrlbl  the JLabel of the maximum data rate
	 */
	public void setMaxDataRateLBL(JLabel mdrlbl){
		maxDataRateLBL = mdrlbl;
	};
	
	/**
	 * Setter
	 * This method set the MVC controller by delivering the object of ShannonsController
	 * @param ctl the object of ShannonsController
	 */
	public void setController(ShannonsController ctl){
		controller = ctl;
	};
	
	/**
	 * This method used to pop up the initial interface and add observers to the Observable class ShannonsTheorem
	 */
	private void initGUI(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel l1 = new JLabel("Maximum data rate is ?");  //Initial showed JLabel result of the max data rate
		setMaxDataRateLBL(l1);      //Set the content of initial result of max data rate 
		add(getMaxDataRateLBL());	//add the panel of the computed result of max data rate  into the panel ShannonsPanel
		add(createBandwidthPanel());	//	add the panel of the number of the bandwidth into the panel ShannonsPanel
		add(createSignalToNoisePanel());	//add the panel of the number of the Signal To Noise into the panel ShannonsPanel
	}
	
	/**
	 * This method get the panel of signal to noise for getting the input of TextField 
	 * @return JPanel of signal to noise 
	 */
	private JPanel createSignalToNoisePanel(){
		JPanel panel3 = new JPanel();
		JLabel l3 = new JLabel("SignalToNoise (in DB):");
		JTextField t3 = new JTextField();
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS));
		panel3.add(l3);
		panel3.add(t3);
		// add an action listener to get input from user in the text field
		t3.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0) {
				 controller.setSignalToNoise( Double.parseDouble(t3.getText()));  //update the result of signal to noise which the user input from text field
	                }
		});
		return panel3;
	}
	
	/**
	 *	This method get the panel of bandwidth for getting the input of TextField 
	 * @return JPanel of bandwidth 
	 */
	private JPanel createBandwidthPanel(){
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		JLabel l2 = new JLabel("Bandwidth (in hertz):");
		JTextField t2 = new JTextField();
		panel2.add(l2);
		panel2.add(t2);
		// add an action listener to get input from user in the text field
		t2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent arg0) {
				 controller.setBandwidth( Double.parseDouble(t2.getText())); //update the result of bandwidth which the user input from text field
			 }
		});
		return panel2;
	}
	
	/**
	 * This method used to notify all registered observers of the change on the registered observer objects
	 */
	public void update(Observable o, Object arg){

			getMaxDataRateLBL().setText(("Maximum data rate is: "+((ShannonsModel) o).getMaximumDataRate()));//update the result of maximum data rate which is computed by 
																												//the bandwidth and the signal to noise from the input of the user 
		
	}
}
