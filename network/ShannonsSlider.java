package network;


import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
//It is a JPane, return JPane

public class ShannonsSlider extends JPanel  implements Observer{
	/**
	 * The class get the slider to get input from user and 
	 * show the output in bar chart
	 */
	
	/**
	 * controller ShannonsController variable, use to connect with ShannonsTheorem
	 */
	private	ShannonsController controller;

	/**
	 * maxDataRateLBL DefaultCategoryDataset variable, get the result of max data rate and show the result on the GUI
	 */
	private DefaultCategoryDataset maxDataRateLBL;
	
	/**
	 * This class get the shannonsController object and show the initial GUI 
	 * @param ctl    deliver the parameter to the object controller  
	 */
	public ShannonsSlider(ShannonsController ctl){
		 controller = ctl;
		initGUI();
	}
	
	/**
	 * Getter
	 * This method get the DefaultCategoryDataset of the maximum data rate computed 
	 * @return maxDataRateLBL the DefaultCategoryDataset of the maximum data rate
	 */
	public DefaultCategoryDataset getMaxDataRateLBL(){
		return maxDataRateLBL;
	};
	
	/**
	 * Setter 
	 * This method set the max data rate by delivering the variable of DefaultCategoryDataset  
	 * @param mdrlbl  the DefaultCategoryDataset of the maximum data rate
	 */
	public void setMaxDataRateLBL(DefaultCategoryDataset mdrlbl){
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
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(0,"Bandwidth","");//set initial result of the Bandwidth
		dataset.addValue(0,"Signal To Noise","");//set initial result of the Signal To Noise
		dataset.addValue(0,"Max Data Rate","");//set initial result of the max data rate
		setMaxDataRateLBL(dataset); //Set the content of initial result of max data rate 
		JFreeChart barChart = ChartFactory.createBarChart("Shannons Theorem", "", "Value", getMaxDataRateLBL());
		//add the panel of the computed result of max data rate  into the panel ShannonsPanel
		ChartPanel cp = new ChartPanel(barChart);
		add(cp);
		add(createBandwidthPanel());//	add the panel of the number of the bandwidth into the panel ShannonsPanel
		add(createSignalToNoisePanel());//add the panel of the number of the Signal To Noise into the panel ShannonsPanel
		
	}
	
	/**
	 * This method get the panel of signal to noise for getting the input of slider 
	 * @return JPanel of signal to noise 
	 */
	private JPanel createSignalToNoisePanel(){
		JSlider slider1 = new JSlider();
		//set the pattern and properties of slider
		slider1.setMinorTickSpacing(2);
		slider1.setMajorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		JPanel panel3 = new JPanel();
		JLabel l3 = new JLabel("SignalToNoise (in DB):");
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS));
		panel3.add(l3);
		panel3.add(slider1);
		// add an action listener to get input from user in the slider
		
		slider1.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent ce){
				//update the result of signal to noise which the user input from slider
			       
				controller.setSignalToNoise((double)slider1.getValue());		
			}
		});
		return panel3;
	}
	
	/**
	 *	This method get the panel of bandwidth for getting the input of slider 
	 * @return JPanel of bandwidth 
	 */
	private JPanel createBandwidthPanel(){
		JSlider slider2 = new JSlider();
		//set the pattern and properties of slider
		slider2.setMinorTickSpacing(2);
		slider2.setMajorTickSpacing(10);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		JLabel l2 = new JLabel("Bandwidth (in hertz):");
		panel2.add(l2);
		panel2.add(slider2);
		// add an action listener to get input from user in the slider
		slider2.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent ce){
				//update the result of bandwidth which the user input from slider
				controller.setBandwidth((double)slider2.getValue());
					}
		});
		return panel2;
	}
	
	/**
	 * This method used to notify all registered observers of the change on the registered observer objects
	 */
	public void update(Observable o, Object arg){
		
		getMaxDataRateLBL().setValue(((ShannonsModel) o).getBandwidth(),"Bandwidth","");//update the result of bandwidth from the input of the user 
		getMaxDataRateLBL().setValue(((ShannonsModel) o).getSignalToNoise(),"Signal To Noise","");//update the result of update the result of signal to noise from the input of the user
		getMaxDataRateLBL().setValue(((ShannonsModel) o).getMaximumDataRate(),"Max Data Rate","");//update the result of maximum data rate which is computed by 
																									//the bandwidth and the signal to noise from the input of the user 
		
		
			
		
	}
}