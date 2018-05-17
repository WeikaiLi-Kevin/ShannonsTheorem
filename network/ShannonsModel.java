  package network;

import java.util.Observable;

public class ShannonsModel extends Observable{
	/**
	 * This class is the model of Observer (MVC) pattern
	 * The class extended the "Observable" is under observation by the registered observers 
	 */
	/**
	 * bandwidth is a double to hold the value of the bandwidth.
	 */
	private double bandwidth = 0;
	/**
	 * signalToNoise is a double to hold the value of the SNR.
	 */
	private double signalToNoise = 0;
	/** CONSTRUCTORS    --------------------------------------   */
	/**
	 * Default constructor.
	 */
	public ShannonsModel(){
		super();
	};
	/**
	 * setter
	 * 
	 * 
	 * @param h the value of the bandwidth
	 */
	public void setBandwidth(double h){
		bandwidth = h;
		this.setChanged();  //used to check the bandwidth changed or not
		this.notifyObservers(); //  if the set is changed, the result will be sent to 
								//	the registered observers.
	};
	/**
	 * getter
	 * 
	 * @return bandwidth the value of the bandwidth
	 */
	public double getBandwidth(){
		return bandwidth;
	};

	/**
	 * setter
	 * 
	 * @param snr the value of the SNR
	 */
	public void setSignalToNoise(double snr){
		signalToNoise = snr;
		this.setChanged();	//used to check the bandwidth changed or not
		this.notifyObservers();//  if the set is changed, the result will be sent to 
								//	the registered observers.
	};
	
	/**
	 * getter
	 * 
	 * @return SNR the value of the SNR
	 */
	public double getSignalToNoise(){
		return signalToNoise;
	};
	
	/**
	 * This method computes the value of the maximum data rate
	 * @param hertz the value of the bandwidth
	 * @param signalToNoise  the value of the SDR
	 * @return the value of the maximum data rate 
	 */
	private double maximumDataRate(double hertz, double snr){
		if(hertz >=0 && snr >= 0){
		double x =Math.log(1.0+snr)/Math.log(2);
		double MDR = hertz * x ;
		return MDR;}
		else return -99;
	};
	
	/**
	 * This method computes the value of the maximum data rate 
	 * @return the value of the maximum data rate
	 */
	public double getMaximumDataRate(){
		return maximumDataRate(getBandwidth(),getSignalToNoise());
	};
	/**
	 * This method change the type of result from double to String
	 */
	public String toString(){return "The result is: "+String.format("%.2f",getMaximumDataRate()).toString();}

}
