package uk.ricardoribeiro;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TechnicianScreen extends JFrame{
	public TechnicianScreen(xmlapi xmlapi, String user, TechnicalInterventions interventions) {
		
		
		setTitle("Tech Window");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnReset = new JButton("Reset Machine");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xmlapi.resetMachine();
				interventions.addEntry(user, "RESET::MACHINE");
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 1;
		getContentPane().add(btnReset, gbc_btnReset);
		setSize(150,150);
		setVisible(true);
	}

}
