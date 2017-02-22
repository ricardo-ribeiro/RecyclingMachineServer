package uk.ricardoribeiro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

/**
 * 
 *  The PrinterFrame class extends the JInternalFrame and implements the PrinterInterface class
 *  this means that the method print has to be defined on this class but we also add
 *  the functionality of JInternalFrame wich provides a  lightweight object that provides many of the features of a native frame.
 * @author ricardo
 *
 */
public class PrinterFrame extends JInternalFrame implements PrinterInterface{
	JTextArea output = new JTextArea();
	private static Color textColour = Color.green;
	private static Color bgColour = Color.black;
	private static int textSize = 12;
	private static String textFont = "Helvetica";
	private static int textStyle = Font.PLAIN;
	public PrinterFrame() {
		// TODO Auto-generated constructor stub
		super("Printer Console",true,true,true);
		output.setForeground(Color.green);
		output.setBackground(Color.black);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(output);
		output.setEditable(false);
		setSize(325,310);
		setVisible(true);
	}
	
	@Override
	public void print(String receipt) {
		// TODO Auto-generated method stub
		output.setFont(new Font(textFont, textStyle, textSize));
		System.out.println(textSize);
		output.setForeground(textColour);
		setBackground(bgColour);
		output.setText(receipt);
		
	}
	

}
