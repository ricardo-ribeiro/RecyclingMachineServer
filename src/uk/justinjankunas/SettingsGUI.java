package uk.justinjankunas;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import uk.ricardoribeiro.PrinterDisplay;;

public class SettingsGUI extends BaseGUI {
	
	private JPanel master, fontPanel;
	private JScrollPane sp;
	private JList<String> fonts;
	private JColorChooser fontColourChooser, bgColourChooser;
	private JLabel fontColour, fontChanger, bgColour; 
	private JButton saveFontColour, saveFont, saveBgColour, saveAll;
	private JRadioButton bold, italic, plain;
	private ButtonGroup fontStyles;
	private JComboBox<Integer> sizeSelector;
	
	private int[] sizes = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 38, 72};
	
	public SettingsGUI(){
		super();
		initComponents();
		initGUI();
		add(master);
		getWindow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getWindow().setSize(1600, 700);
		getWindow().setVisible(true);
		getWindow().setLocationRelativeTo(null);
		getWindow().setTitle(getWindow().getTitle() + " - Settings");
		refresh();
	}
	
	public void initComponents(){
		master = new JPanel();
		master.setLayout(new GridBagLayout());
		
		fontPanel = new JPanel();
		fontPanel.setLayout(new GridBagLayout());
		
		fonts = new JList<String>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		fonts.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		fonts.setVisibleRowCount(10);
		
		sp = new JScrollPane(fonts);
		
		fontColourChooser = new JColorChooser(PrinterDisplay.getTextColour());
		bgColourChooser = new JColorChooser(PrinterDisplay.getBgColour());
		
		fontColour = new JLabel("Reciept font colour");
		fontChanger = new JLabel("Reciept font");
		bgColour = new JLabel("Reciept background colour");

		fontColour.setFont(new Font(fontColour.getFont().getFontName(), fontColour.getFont().getStyle(),32));
		fontColour.setHorizontalAlignment(SwingConstants.CENTER);

		fontChanger.setFont(new Font(fontChanger.getFont().getFontName(), fontChanger.getFont().getStyle(),32));
		fontChanger.setHorizontalAlignment(SwingConstants.CENTER);

		bgColour.setFont(new Font(bgColour.getFont().getFontName(), bgColour.getFont().getStyle(),32));
		bgColour.setHorizontalAlignment(SwingConstants.CENTER);
		
		bold = new JRadioButton("Bold");
		italic = new JRadioButton("Italic");
		plain = new JRadioButton("Plain");
		
		fontStyles = new ButtonGroup();
		
		saveFontColour = new JButton("Save");
		saveFont = new JButton("Save");
		saveBgColour = new JButton("Save");
		saveAll = new JButton("Save all");
		
		sizeSelector = new JComboBox<Integer>();
		for (int i : sizes) {
			sizeSelector.addItem(i);
		}
	}
	
	public void initGUI(){
		
		fontStyles.add(bold);
		fontStyles.add(italic);
		fontStyles.add(plain);
		
		saveFontColour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int save = JOptionPane.showConfirmDialog(null, "Do you want to save your changes?", "Save changes", JOptionPane.YES_NO_OPTION);
				
				if(save == 0){
					PrinterDisplay.setTextColour(fontColourChooser.getColor());
					JOptionPane.showMessageDialog(null, "Settings saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		saveFont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int save = JOptionPane.showConfirmDialog(null, "Do you want to save your changes?", "Save changes", JOptionPane.YES_NO_OPTION);
				
				if(save == 0){
					PrinterDisplay.setTextFont(fonts.getSelectedValue());
					PrinterDisplay.setTextSize((int)sizeSelector.getSelectedItem());
					
					if(bold.isSelected()){
						PrinterDisplay.setTextStyle(Font.BOLD);
					}else if(italic.isSelected()){
						PrinterDisplay.setTextStyle(Font.ITALIC);
					}else{
						PrinterDisplay.setTextStyle(Font.PLAIN);
					}
					JOptionPane. showMessageDialog(null, "Settings saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		saveBgColour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int save = JOptionPane.showConfirmDialog(null, "Do you want to save your changes?", "Save changes", JOptionPane.YES_NO_OPTION);
				
				if(save == 0){
					PrinterDisplay.setBgColour(bgColourChooser.getColor());
					JOptionPane. showMessageDialog(null, "Settings saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		saveAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrinterDisplay.setTextColour(fontColourChooser.getColor());

				PrinterDisplay.setTextFont(fonts.getSelectedValue());
				PrinterDisplay.setTextSize((int)sizeSelector.getSelectedItem());
				
				if(bold.isSelected()){
					PrinterDisplay.setTextStyle(Font.BOLD);
				}else if(italic.isSelected()){
					PrinterDisplay.setTextStyle(Font.ITALIC);
				}else{
					PrinterDisplay.setTextStyle(Font.PLAIN);
				}
				
				PrinterDisplay.setBgColour(bgColourChooser.getColor());
				JOptionPane. showMessageDialog(null, "Settings saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
			}
		});		
		addComponent(0, 0, 3, 1, sp, fontPanel);
		addComponent(1, 1, sizeSelector, fontPanel);
		addComponent(0, 2, bold, fontPanel);
		addComponent(1, 2, italic, fontPanel);
		addComponent(2, 2, plain, fontPanel);
		
		addComponent(0, 0, fontColour, master);
		addComponent(1, 0, fontChanger, master);
		addComponent(2, 0, bgColour, master);
		
		addComponent(0, 1, fontColourChooser, master);
		addComponent(1, 1, fontPanel, master);
		addComponent(2, 1, bgColourChooser, master);
		
		addComponent(0, 2, saveFontColour, master);
		addComponent(1, 2, saveFont, master);
		addComponent(2, 2, saveBgColour, master);
		
		addComponent(0, 3, 3, 1, saveAll, master);
		
	}

}

//---------------------------------------------------------------------------------------------------------------------


