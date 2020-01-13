package hrManagement.ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hrManagement.logic.Authentication;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ForgotPassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField usernameField;
	private JTextField questionField;
	private JTextField answerField;
	private JPasswordField passwordField;
	private Authentication authentication;
	private JTextField textField;
	

	
	public ForgotPassword(Authentication authentication) {
		
		this.authentication = authentication;
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblChangeYourPassword = new JLabel("Change your password here");
			lblChangeYourPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
			lblChangeYourPassword.setBounds(121, 10, 175, 14);
			contentPanel.add(lblChangeYourPassword);
		}
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEnterUsername.setBounds(44, 71, 125, 14);
		contentPanel.add(lblEnterUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(223, 68, 136, 20);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblEnterYourSecurity = new JLabel("Enter your security question");
		lblEnterYourSecurity.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEnterYourSecurity.setBounds(44, 102, 213, 14);
		contentPanel.add(lblEnterYourSecurity);
		
		questionField = new JTextField();
		questionField.setBounds(223, 99, 136, 20);
		contentPanel.add(questionField);
		questionField.setColumns(10);
		
		JLabel lblEnterYourAnswer = new JLabel("Enter your answer");
		lblEnterYourAnswer.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEnterYourAnswer.setBounds(44, 133, 109, 14);
		contentPanel.add(lblEnterYourAnswer);
		
		answerField = new JTextField();
		answerField.setBounds(223, 130, 136, 20);
		contentPanel.add(answerField);
		answerField.setColumns(10);
		
		JLabel lblEnterNewPassword = new JLabel("Enter new password");
		lblEnterNewPassword.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEnterNewPassword.setBounds(44, 164, 109, 14);
		contentPanel.add(lblEnterNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 161, 136, 20);
		contentPanel.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(223, 35, 136, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setBounds(44, 38, 46, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton submitButton = new JButton("Submit");
				submitButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				submitButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
				            if(authentication.resetMyPassword(usernameField.getText(), questionField.getText(),
				                    answerField.getText(), passwordField.getText()))
				            {
				                JOptionPane.showMessageDialog(null, "Password Reset Successfully.");
				                
				                
				            }
				            else
				                JOptionPane.showMessageDialog(null, "Can't Reset.");
				        }catch(HeadlessException e){
				            JOptionPane.showMessageDialog(null, e.getMessage());
				        }
				    }
				});
				
				submitButton.setActionCommand("Submit");
				buttonPane.add(submitButton);
				getRootPane().setDefaultButton(submitButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
