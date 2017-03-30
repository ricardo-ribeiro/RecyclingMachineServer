package uk.ricardoribeiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.perisic.beds.CustomerPanel;

import uk.justinjankunas.SettingsGUI;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
/**
 * GMain Class 
 * Gui main class.
 * Creates the Main gui window and initialises all the required to function with the recycling machine.
 * This class extends JFrame Class.
 * @author Ricardo Ribeiro
 * @extends JFrame
 */
public class GMain extends JFrame{
	// Defining a new object of the class type Customer Panel
	CustomerPanel myPanel = null; 
	// Defining and instaciating a new object of the Class CurrentStatusFrame 
	CurrentStatusFrame currentStatusFrame = new CurrentStatusFrame();
	public GMain thisClass = this;
	
	// Different Printing method initialisation
	// these methods implement the Printer Interface hence all provide a print method
	Console console = new Console();
	// New Printer Displau 
	PrinterDisplay printerDisplay = new PrinterDisplay();
	// New Printer frame object
	PrinterFrame printerFrame = new PrinterFrame();
	// New File printer obeject
	FilePrint filePrint = new FilePrint();
	// New object of the speech print class
	SpeechPrint speechPrint = new SpeechPrint();

	public GMain()
	{
		// Calling the super method runs the extended (JFrame) class constructor
		super();
		// Try to set the Windows design if it is running on windows
		try {
			  UIManager.setLookAndFeel(
			            UIManager.getCrossPlatformLookAndFeelClassName());
	       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
		// set background window color
		setForeground(SystemColor.window);
		// setting the title
		setTitle("Recycling Machine");
		// Calling the method print on the object speach print -- makes text to speech
		speechPrint.print("Welcome to the recycling machine");
		// set the size of the main window
		setSize(800,600);
		// Set the default operation to dispose the program on close button
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//JPanel panel = new JPanel();
		 currentStatusFrame.setBounds(6, 147, 400, 304);
		// Initialising a object desktop of the class JDesktopPane
		// A container used to create a multiple-document interface or a virtual desktop.
		JDesktopPane Desktop = new JDesktopPane();
		// Initialising a printerFrame object 
		PrinterFrame printerFrame = new PrinterFrame();
		// Initialising a filePrinter object
		FilePrint filePrinter = new FilePrint();
		//Setting the size of the printerframe
		printerFrame.setSize(352, 310);
		// Creating the Customer Panel Defaulting the printer to the printer frame obj
		myPanel = new CustomerPanel(printerFrame);

		//Desktop.setBackground(SystemColor.activeCaption);
		
// Start of within window that contains the item buttons
		
		// Initialising a new JTnternalFrame
		JInternalFrame withinWindow = new JInternalFrame("Add Items to Recycle", false, false, false);
		withinWindow.setForeground(SystemColor.desktop);
		withinWindow.setIconifiable(true);
		withinWindow.setLocation(6, 17);
		JPanel panelWithin = new JPanel();
		// Creating a new object button of the class JButton 
		JButton button = new JButton("Can");
		// then we add a headless action listener on the button object
		// this will be listening for a event on the specific button
		// when the user click on it if fires the event action performed 
		// and we add a new item by executing the method item received in the mypanel object
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					currentStatusFrame.addCan();
					myPanel.itemReceived(1);
				} catch (SlotFullExecption e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		// the method add on the object panel whithin will add the object to the window
		panelWithin.add(button);
		// then we add a headless action listener on the button object
				// this will be listening for a event on the specific button
				// when the user click on it if fires the event action performed 
				// and we add a new item by executing the method item received in the mypanel object
		JButton bottleButton = new JButton("Bottle");
		bottleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					currentStatusFrame.addBottle();
					myPanel.itemReceived(2);
				} catch (SlotFullExecption e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}

			}
		});
		// then we add a headless action listener on the button object
				// this will be listening for a event on the specific button
				// when the user click on it if fires the event action performed 
				// and we add a new item by executing the method item received in the mypanel object
		panelWithin.add(bottleButton);
		JButton crateBtn = new JButton("Crate");
		crateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					currentStatusFrame.addCrate();
					myPanel.itemReceived(3);
				} catch (SlotFullExecption e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}

			}
		});
		panelWithin.add(crateBtn);
		// then we add a headless action listener on the button object
				// this will be listening for a event on the specific button
				// when the user click on it if fires the event action performed 
				// and we add a new item by executing the method item received in the mypanel object
		JButton newpaperButton = new JButton("Newspaper");
		newpaperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					currentStatusFrame.addNewspaper();
					myPanel.itemReceived(4);
				} catch (SlotFullExecption e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}

			}
		});
		panelWithin.add(newpaperButton);
		withinWindow.setContentPane(panelWithin);
		withinWindow.setSize(418, 100);
	    withinWindow.setVisible(true);
		
// END OF WITHINWINDOW

// Start of printer options printer
	    
		JInternalFrame printOptionsWindow = new JInternalFrame("Printer Options", true, false, false);
		printOptionsWindow.setIconifiable(true);
		printOptionsWindow.setLocation(448, 17);
		JPanel printOptpanelWithin = new JPanel();
		JButton consoleBtn = new JButton("Console");
		consoleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// setting a new customer panel in order to change
				// the printer
				myPanel = new CustomerPanel(console);
				// resseting the progress bars back to zero
				currentStatusFrame.resetProgressBars();
			}
		});
		JButton externalBtn = new JButton("External Display");
		externalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel = new CustomerPanel(printerDisplay);
				printerDisplay.setVisible(true);
				currentStatusFrame.resetProgressBars();
				//PrinterDisplay printerDisplay = new PrinterDisplay();
			}
		});
		JButton internalBtn = new JButton("Internal Display");
		internalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel = new CustomerPanel(printerFrame);
				currentStatusFrame.resetProgressBars();
						
			}
		});
		JButton FileBtn = new JButton("File");
		FileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel = new CustomerPanel(filePrint);
				currentStatusFrame.resetProgressBars();
			}
		});
		printOptpanelWithin.add(consoleBtn);
		printOptpanelWithin.add(externalBtn);
		printOptpanelWithin.add(internalBtn);
		printOptpanelWithin.add(FileBtn);
		printOptionsWindow.setContentPane(printOptpanelWithin);
		JButton btnNewButton = new JButton("Speak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPanel = new CustomerPanel(speechPrint);
				currentStatusFrame.resetProgressBars();
			}
		});
		printOptpanelWithin.add(btnNewButton);
		printOptionsWindow.setSize(327, 150);
		printOptionsWindow.setVisible(true);
		

		
		
		printerFrame.setClosable(false);
		printerFrame.setIconifiable(true);
		printerFrame.setLocation(428, 171);

		setContentPane(Desktop);
	    Desktop.add(withinWindow);
	    Desktop.add(printerFrame);
	    Desktop.add(printOptionsWindow);
	    Desktop.add(currentStatusFrame);
	    
// Start of Action Internal Frame    
	    JInternalFrame internalFrame_1 = new JInternalFrame("Action");
	    internalFrame_1.setIconifiable(true);
	    internalFrame_1.setBounds(6, 480, 751, 92);
	    Desktop.add(internalFrame_1);
	    
	    JButton btnPrintReceipt = new JButton("Print Receipt");
	    btnPrintReceipt.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		currentStatusFrame.resetProgressBars();	
					try {
						myPanel.printReceipt();
					} catch (MachineEmptyException e1) {
						printerFrame.output.setText(e1.getMessage());
					
					}
	    	}
	    });
	    JButton btnSettingsGUI = new JButton("Settings GUI");
	    btnSettingsGUI.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SettingsGUI settings = new SettingsGUI();
					
	    	}
	    });
	    internalFrame_1.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
	    internalFrame_1.getContentPane().add(btnPrintReceipt);
	    
	    JButton btnTechnicianLogin = new JButton("Technician Login");
	    btnTechnicianLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		TechnicianLogin tecL = new TechnicianLogin(new xmlapi(thisClass,new Users(),new TechnicalInterventions()));
	    		
	    		
	    	}
	    });
	    internalFrame_1.getContentPane().add(btnTechnicianLogin);
	    internalFrame_1.getContentPane().add(btnSettingsGUI);

	    internalFrame_1.setVisible(true);
	    currentStatusFrame.setVisible(true);
// End og Action Internal Frame
	   
		setVisible(true);
	}
	
	@SuppressWarnings("rawtypes")
	public Vector getCurrentMachineStatus()
	{
		
		return currentStatusFrame.retrieveStatus();
		
	}
}
