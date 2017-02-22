package uk.justinjankunas;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseGUI{
	
	//protected final double VERSION_ID = 0.6;
	protected final double VERSION_ID = 1.1;
	
	private JFrame window;
	private Container contPane;
	private ArrayList<JButton> actLis;
	
	public BaseGUI() {
		window = new JFrame();
		contPane = window.getContentPane();
		actLis = new ArrayList<JButton>();
		
		window.setTitle("Recycling Machine " + VERSION_ID);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,500);
		window.setLocationRelativeTo(null);
	}
	
	public JFrame getWindow() {
		return window;
	}

	protected void refresh(){
		window.setSize(window.getSize().width, window.getSize().height+1);
		window.setSize(window.getSize().width, window.getSize().height-1);
	}
	
	protected void add(JComponent component){
		contPane.add(component);
		
		if(component instanceof JButton){
			actLis.add((JButton)component);
		}
	}
	
	protected void removeComponent(Component component){
		contPane.remove(component);
		
		if(component instanceof JButton){
			for (int i = 0; i < actLis.size(); i++) {
				if(actLis.get(i).equals(component)){
					for (ActionListener act : actLis.get(i).getActionListeners()) {
						actLis.get(i).removeActionListener(act);
					}
					actLis.remove(i);
				}
			}
		}
	}
	
	protected void wipe(){
		for (Component comp : contPane.getComponents()) {
			removeComponent(comp);
		}
	}
	
	protected void addComponent(int x, int y, JComponent component, JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(component, gbc);
		
		System.out.println("Adding \"" + component.getName() + "\" to \"" + panel.getName() + "\" at " + x + ", " + y);
	}
	
	protected void addComponent(int x, int y, GridBagConstraints gbc, JComponent component, JPanel panel){
		gbc.insets = new Insets(2, 3, 2, 2);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(component, gbc);

		System.out.println("Adding \"" + component.getName() + "\" to \"" + panel.getName() + "\" at " + x + ", " + y);
	}
	
	protected void addComponent(int x, int y, int width, int height, JComponent component, JPanel panel){
		GridBagConstraints gbc  = new GridBagConstraints();
		gbc.gridwidth = width;
		gbc.gridheight = height;
		addComponent(x,y,gbc,component,panel);
	}

}