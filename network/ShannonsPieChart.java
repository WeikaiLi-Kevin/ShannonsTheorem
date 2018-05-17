package network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
//It is a JPane, return JPane



public class ShannonsPieChart extends JPanel  implements Observer{
	/**
	 * The class get the Graphic to get point from user click mouse and 
	 * show the output in Pie chart
	 */
	
	/**
	 * controller ShannonsController variable, use to connect with ShannonsTheorem
	 */
	private	ShannonsController controller;
	
	/**
	 * maxDataRateLBL JLabel variable, get the result of max data rate and show the result on the GUI
	 */
	private DefaultPieDataset maxDataRateLBL;
	
	/**
	 * point Point object initialize the object (0,0)
	 */
	private Point point = new Point(0,0);
	
	/**
	 * This class get the shannonsController object and show the initial GUI 
	 * @param ctl    deliver the parameter to the object controller  
	 */
	public ShannonsPieChart(ShannonsController ctl){
		 controller = ctl;
		initGUI();
	}
	
	/**
	 * Getter
	 * This method get the DefaultPieDataset of the maximum data rate computed 
	 * @return maxDataRateLBL the DefaultPieDataset of the maximum data rate
	 */
	public DefaultPieDataset getMaxDataRateLBL(){
		return maxDataRateLBL;
	};
	
	/**
	 * Setter 
	 * This method set the max data rate by delivering the variable of DefaultPieDataset  
	 * @param mdrlbl  the DefaultPieDataset of the maximum data rate
	 */
	public void setMaxDataRateLBL(DefaultPieDataset mdrlbl){
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
		DefaultPieDataset dataset = new DefaultPieDataset();// use to set value of pie chart
		dataset.setValue("Bandwidth",0);//set initial result of the Bandwidth
		dataset.setValue("Signal To Noise",0);//set initial result of the Signal To Noise
		dataset.setValue("Max Data Rate",0);//set initial result of the max data rate
		setMaxDataRateLBL(dataset); //Set the content of initial result of max data rate 
		JFreeChart pieChart = ChartFactory.createPieChart("Shannons Theorem", dataset, true,true,false);
		//pie plot use to multiply the pattern and display of pie chart
		PiePlot plot = (PiePlot)pieChart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        //show the message if there is no data available
		plot.setNoDataMessage("No data available");
        
        // make the result show the numbers on the pie chart
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%")));
        plot.setCircular(false);
        plot.setLabelGap(0.02);
		ChartPanel cp = new ChartPanel(pieChart);  //use to put pie chart into JPanel 
		add(cp);
		add(createResult());
	}
	
	/**
	 * This method get the panel of signal to noise and bandwidth for getting the input of Graphics point 
	 * @return JPanel of the input signal to noise and bandwidth 
	 */
	private JPanel createResult(){
		JPanel panel3 = new JPanel(){
	        @Override
	        protected void paintComponent (Graphics g) {
	            super.paintComponent(g);
	            paint2D((Graphics2D)g);  //use to paint the pattern on the GUI
	        }
	        /**
	         * performs a linear mapping from 2D coordinates to other 2D coordinates
	         */
	        protected void paint2D (Graphics2D g2) {
	            AffineTransform tform = AffineTransform.getTranslateInstance( 0, 0);
	            tform.scale(0.1, 0.1);    
	            //set the properties of g2
	            g2.setTransform( tform);
	            g2.setColor( Color.BLUE);  
	             }
	        @Override
	        public Dimension getPreferredSize() {
	           return new Dimension(100, 100);
	        }
	    };
		panel3.setBackground(Color.gray);
		Graphics g = panel3.getGraphics();
		//add mouse listener, if the user clicks mouse, the point will show the X and Y value on the graphics.
		panel3.addMouseListener( new MouseAdapter() {
            // define a point 
            public void mousePressed( MouseEvent event )
            {  
                   point = new Point( event.getX(), event.getY() );    //get the X and Y value of point which the user clicked
                   controller.setBandwidth(event.getX());
                   controller.setSignalToNoise(event.getY());    
                   	
                   //g.drawOval( point.x , point.y , 1, 1 );       //show the point on the graphic 
                   //g.drawString("x=" + point.x + " y=" + point.y, point.x, point.y  );  //show the X, Y number of the point on the graphic
                    
            } // end method mousePressed
             
        });
		return panel3;
	}
	
	/**
	 * This method used to notify all registered observers of the change on the registered observer objects
	 */
	public void update(Observable o, Object arg){
		
			getMaxDataRateLBL().setValue("Bandwidth",((ShannonsModel) o).getBandwidth());//update the result of bandwidth from the input of the user 
			getMaxDataRateLBL().setValue("Signal To Noise",((ShannonsModel) o).getSignalToNoise());//update the result of update the result of signal to noise from the input of the user
			getMaxDataRateLBL().setValue("Max Data Rate",((ShannonsModel) o).getMaximumDataRate());//update the result of maximum data rate which is computed by 
																									//the bandwidth and the signal to noise from the input of the user 
			
	
	}
}