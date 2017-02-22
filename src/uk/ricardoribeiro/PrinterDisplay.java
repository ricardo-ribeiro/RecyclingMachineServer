package uk.ricardoribeiro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 *The PrinterDisplay class extends the JInternalFrame and implements the PrinterInterface class 
 *this means that the method print has to be defined on this class but we also add the functionality 
 *of JFrame which lets us create a printer console outside the main GUI Display
 * 
 * 
 * 
 */
public class PrinterDisplay extends JFrame implements PrinterInterface{
	private static Color textColour = Color.green;
	private static Color bgColour = Color.black;
	private static int textSize = 12;
	private static String textFont = "Comic Sans MS";
	private static int textStyle = Font.BOLD;
	
	
	public static Color getTextColour() {
		return textColour;
	}

	public static void setTextColour(Color textColour) {
		PrinterDisplay.textColour = textColour;
	}

	public static Color getBgColour() {
		return bgColour;
	}

	public static void setBgColour(Color bgColour) {
		PrinterDisplay.bgColour = bgColour;
	}

	public static int getTextSize() {
		return textSize;
	}

	public static void setTextSize(int textSize) {
		PrinterDisplay.textSize = textSize;
	}

	public static String getTextFont() {
		return textFont;
	}

	public static void setTextFont(String textFont) {
		PrinterDisplay.textFont = textFont;
	}


	private static final long serialVersionUID = 238403742294218467L;
	JTextArea output = new JTextArea();
	public PrinterDisplay()
	{
		super();
		setTitle("Printer Console");
		output.setForeground(Color.green);
		output.setBackground(Color.black);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(output);
		output.setEditable(false);
		setSize(325,310);
		//setVisible(true);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see uk.ricardoribeiro.PrinterInterface#print()
	 * @Author Ricardo Ribeiro
	 */
	public void print(String receipt)
	{
		output.setFont(new Font(textFont, textStyle, textSize));
				output.setForeground(textColour);
				setBackground(bgColour);
				//setDisabledTextColor(textColour);
		output.setText(receipt);
	}

	public static int getTextStyle() {
		return textStyle;
	}

	public static void setTextStyle(int textStyle) {
		PrinterDisplay.textStyle = textStyle;
	}

}
