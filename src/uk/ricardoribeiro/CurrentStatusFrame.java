package uk.ricardoribeiro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import com.perisic.beds.ReceiptBasis;

import java.util.Vector;

/**
 * 
 * The CurrentStatusFrmae extends the JInternalFrame hence inherits all the method definitions and
 * also add extra functionality.
 * 
 * This Frame represents the window "Current Status" and is mainly composed of progress bars and
 * method definitions to update the status.
 * 
 * Each Progress bar represents a slot. And its maximum is 20. When adding a need item its performed
 * a check if it is full. If it is a exception is thrown Slot Full Exception
 * @author ricardo
 *
 */
public class CurrentStatusFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5214761516922756514L;
	JProgressBar progressBarCan;
	JProgressBar progressBarBottle;
	JProgressBar progressBarCrate;
	JProgressBar progressBarNewspaper;
	public void resetProgressBars()
	{
		progressBarCan.setValue(0);
		progressBarBottle.setValue(0);
		progressBarCrate.setValue(0);
		progressBarNewspaper.setValue(0);
	}
	public void addCan() throws SlotFullExecption
	{
		if(!isFull(progressBarCan))
		{
			progressBarCan.setValue(progressBarCan.getValue()+1);
			
		}else
		{
			throw new SlotFullExecption();
		}
			
	}
	// Method that returns if a given progress bar reached the maximum limit
	// this method return a boolean value either the progress bar is greater than 20
	private boolean isFull(JProgressBar pgrbar) 
	{
		// 20-1 because it start from 0
		System.err.print(Math.floor(ReceiptBasis.Limit/4));
		if(pgrbar.getValue() > Math.floor(ReceiptBasis.Limit/4) ){
			//System.out.println(pgrbar.getValue());
			return true;
			}
		else{
			//System.out.println(pgrbar.getValue());
			return false;
			}
	}
	// The methods to add new items into check if the slot has reached a maximum. 
	// and if it did it will throw a slot full execption
	public void addBottle() throws SlotFullExecption
	{
		if(!isFull(progressBarBottle))
		{
			progressBarBottle.setValue(progressBarBottle.getValue()+1);
			
		}else
		{
			throw new SlotFullExecption();
		}
	}
	public void addCrate() throws SlotFullExecption
	{
		if(!isFull(progressBarCrate))
		{
			progressBarCrate.setValue(progressBarCrate.getValue()+1);

		}else
		{
			throw new SlotFullExecption();
		}		
	}
	public void addNewspaper() throws SlotFullExecption
	{
		if(!isFull(progressBarNewspaper))
		{
			progressBarNewspaper.setValue(progressBarNewspaper.getValue()+1);

		}else
		{
			throw new SlotFullExecption();
		}		
	}
	// Methods to remove a item from the visible progrss bar
	public void removeCan()
	{
		progressBarCan.setValue(progressBarCan.getValue()-1);
	}
	public void removeBottle()
	{
		progressBarBottle.setValue(progressBarBottle.getValue()-1);
	}
	public void removeCrate()
	{
		progressBarCrate.setValue(progressBarCrate.getValue()-1);
	}
	public void removeNewspaper()
	{
		progressBarNewspaper.setValue(progressBarNewspaper.getValue()-1);
	}
	public Vector retrieveStatus()
	{
		
		
		progressBarCan.getValue();
		progressBarBottle.getValue();
		progressBarCrate.getValue();
		progressBarNewspaper.getValue();
		
		Vector nvc = new Vector();
		nvc.add(progressBarCan.getValue());
		nvc.add(progressBarBottle.getValue());
		nvc.add(progressBarCrate.getValue());
		nvc.add(progressBarNewspaper.getValue());
		
		return nvc;
	}
	
	/**
	 * Current Status Frame constructor initialises the frame 
	 * 
	 */
	public CurrentStatusFrame()
	{
		  	this.setTitle("Current Status");
		    this.setBounds(6, 147, 400, 304);
		    GridBagLayout gridBagLayout = new GridBagLayout();
		    gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		    gridBagLayout.rowHeights = new int[]{10, 10, 0, 0, 0, 0, 0, 0, 0, 0};
		    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		    gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		    this.getContentPane().setLayout(gridBagLayout);
		    
		    // Adding the progress bars into the frame
		    
		    progressBarCan = new JProgressBar();
		    progressBarCan.setStringPainted(true);
		    progressBarCan.setToolTipText("");
		    progressBarCan.setMaximum(20);
		    progressBarCan.setOrientation(SwingConstants.VERTICAL);
		    GridBagConstraints gbc_progressBarCan = new GridBagConstraints();
		    gbc_progressBarCan.insets = new Insets(0, 0, 5, 5);
		    gbc_progressBarCan.fill = GridBagConstraints.VERTICAL;
		    gbc_progressBarCan.gridheight = 7;
		    gbc_progressBarCan.gridx = 1;
		    gbc_progressBarCan.gridy = 1;
		    this.getContentPane().add(progressBarCan, gbc_progressBarCan);

		    progressBarBottle = new JProgressBar();
		    progressBarBottle.setStringPainted(true);
		    progressBarBottle.setMaximum(20);
		    progressBarBottle.setOrientation(SwingConstants.VERTICAL);
		    GridBagConstraints gbc_progressBarBottle = new GridBagConstraints();
		    gbc_progressBarBottle.fill = GridBagConstraints.VERTICAL;
		    gbc_progressBarBottle.gridheight = 7;
		    gbc_progressBarBottle.insets = new Insets(0, 0, 5, 5);
		    gbc_progressBarBottle.gridx = 4;
		    gbc_progressBarBottle.gridy = 1;
		    this.getContentPane().add(progressBarBottle, gbc_progressBarBottle);
		    
		    progressBarCrate = new JProgressBar();
		    progressBarCrate.setStringPainted(true);
		    progressBarCrate.setMaximum(20);
		    progressBarCrate.setOrientation(SwingConstants.VERTICAL);
		    GridBagConstraints gbc_progressBar = new GridBagConstraints();
		    gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		    gbc_progressBar.fill = GridBagConstraints.VERTICAL;
		    gbc_progressBar.gridheight = 7;
		    gbc_progressBar.gridx = 7;
		    gbc_progressBar.gridy = 1;
		    this.getContentPane().add(progressBarCrate, gbc_progressBar);
		    
		    progressBarNewspaper = new JProgressBar();
		    progressBarNewspaper.setStringPainted(true);
		    progressBarNewspaper.setMaximum(20);
		    progressBarNewspaper.setOrientation(SwingConstants.VERTICAL);
		    GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		    gbc_progressBar_1.gridheight = 7;
		    gbc_progressBar_1.fill = GridBagConstraints.VERTICAL;
		    gbc_progressBar_1.insets = new Insets(0, 0, 5, 0);
		    gbc_progressBar_1.gridx = 9;
		    gbc_progressBar_1.gridy = 1;
		    this.getContentPane().add(progressBarNewspaper, gbc_progressBar_1);
		    
		    JLabel lblCan = new JLabel("Cans");
		    GridBagConstraints gbc_lblCan = new GridBagConstraints();
		    gbc_lblCan.insets = new Insets(0, 0, 0, 5);
		    gbc_lblCan.gridx = 1;
		    gbc_lblCan.gridy = 8;
		    this.getContentPane().add(lblCan, gbc_lblCan);
		    
		    JLabel lblBottles = new JLabel("Bottles");
		    GridBagConstraints gbc_lblBottles = new GridBagConstraints();
		    gbc_lblBottles.insets = new Insets(0, 0, 0, 5);
		    gbc_lblBottles.gridx = 4;
		    gbc_lblBottles.gridy = 8;
		    this.getContentPane().add(lblBottles, gbc_lblBottles);
		    
		    JLabel lblNewLabel = new JLabel("Crate");
		    GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		    gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		    gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		    gbc_lblNewLabel.gridx = 7;
		    gbc_lblNewLabel.gridy = 8;
		    this.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		    
		    JLabel lblNespapers = new JLabel("Nespaper");
		    GridBagConstraints gbc_lblNespapers = new GridBagConstraints();
		    gbc_lblNespapers.gridx = 9;
		    gbc_lblNespapers.gridy = 8;
		    this.getContentPane().add(lblNespapers, gbc_lblNespapers);
	}
	
}
