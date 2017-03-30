package uk.ricardoribeiro;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TechnicianLogin extends JFrame{
	private JTextField txt_username;
	private JTextField txt_password;

	public TechnicianLogin(xmlapi xmlapi) {
		setTitle("Technician Login");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 3;
		getContentPane().add(lblUsername, gbc_lblUsername);
		
		txt_username = new JTextField();
		GridBagConstraints gbc_txt_username = new GridBagConstraints();
		gbc_txt_username.insets = new Insets(0, 0, 5, 5);
		gbc_txt_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_username.gridx = 4;
		gbc_txt_username.gridy = 3;
		getContentPane().add(txt_username, gbc_txt_username);
		txt_username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		txt_password = new JTextField();
		txt_password.setColumns(10);
		GridBagConstraints gbc_txt_password = new GridBagConstraints();
		gbc_txt_password.insets = new Insets(0, 0, 5, 5);
		gbc_txt_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_password.gridx = 4;
		gbc_txt_password.gridy = 4;
		getContentPane().add(txt_password, gbc_txt_password);
		SpeechPrint talk = new SpeechPrint();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users users = new Users();
				if(users.verifyUser(txt_username.getText(), txt_password.getText()))
				{
					talk.print("Welcome "+txt_username.getText());
					TechnicalInterventions interventions = new TechnicalInterventions();
					interventions.addEntry(txt_username.getText(), "TECH:LOGIN");
					TechnicianScreen tech = new TechnicianScreen(xmlapi,txt_username.getText(),interventions);
					// Login Sucessefull
					setVisible(false);
				}else
				{
					//Invalid Login
					talk.print("Wrong User or Password");
				}
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 4;
		gbc_btnLogin.gridy = 5;
		getContentPane().add(btnLogin, gbc_btnLogin);
		setSize(200,150);
		setVisible(true);
	}

}
