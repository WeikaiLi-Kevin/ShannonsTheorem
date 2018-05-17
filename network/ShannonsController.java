package network;

import java.util.Observer;
/**
 * 
 * @author Li Weikai
 *	This interface implemented by ShannonsTheorem provide three abstract methods
 */
public abstract interface ShannonsController {
/**
 * The abstract method used to be implemented and add new observer
 * @param o  new observer 
 */
public abstract void addObserver(Observer o);
/**
 * The abstract method used to be implemented and set the bandwidth
 * @param bandwidth   new bandwidth input 
 */
public abstract void setBandwidth(double bandwidth);
/**
 * The abstract method used to be implemented and set the signal to noise
 * @param signalToNoiseRatio  new signal to noise input
 */
public abstract void setSignalToNoise(double signalToNoiseRatio);
}
