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
	static JTextArea output = new JTextArea();
	private static Color textColour = Color.green;
	private static Color bgColour = Color.black;
	private static int textSize = 12;
	private static String textFont = "Comic Sans MS";
	private static int textStyle = Font.BOLD;
	
	
	public static Color getTextColour() {
		return textColour;
	}
	public static void setTextStyle(int textStyle) {
		PrinterFrame.textStyle = textStyle;
	}

	public static void setTextColour(Color textColour) {
		PrinterFrame.textColour = textColour;
	}

	public static Color getBgColour() {
		return bgColour;
	}

	public static void setBgColour(Color bgColour) {
		PrinterFrame.bgColour = bgColour;
	}

	public static int getTextSize() {
		return textSize;
	}

	public static void setTextSize(int textSize) {
		PrinterFrame.textSize = textSize;
	}

	public static String getTextFont() {
		return textFont;
	}

	public static void setTextFont(String textFont) {
		PrinterFrame.textFont = textFont;
		
	}
	public static void update_the_settings()
	{
		output.setBackground(bgColour);
		output.setForeground(textColour);
		output.setFont(new Font(textFont, textStyle, textSize));
	}
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
		FilePrint file = new FilePrint();
		file.print(receipt);
		output.setFont(new Font(textFont, textStyle, textSize));
		System.out.println(textSize);
		output.setForeground(textColour);
		setBackground(bgColour);
		output.setText(receipt);
		
	}
	

}
