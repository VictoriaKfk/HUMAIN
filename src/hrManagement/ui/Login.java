package hrManagement.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hrManagement.domain.User;
import hrManagement.logic.Authentication;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	
	
	private JFrame frame;
	private JTextField username;
	private JPasswordField passwordField;
	private Authentication authentication;
	private JTextField idtextField;
	private JTextField nameTextField;
	private JPasswordField passwordField_1;
	private JTextField answertextField_3;
	private JTextField questiontextField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Login(Authentication authentication) {
		this.authentication = authentication;
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 852, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(330, 308, 46, 14);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 8, true));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(436, 21, 336, 370);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSignUp = new JLabel(" PLEASE SIGN UP");
		lblSignUp.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblSignUp.setBounds(92, 42, 234, 37);
		panel.add(lblSignUp);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account yet?");
		lblDontHaveAn.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblDontHaveAn.setBounds(37, 11, 255, 40);
		panel.add(lblDontHaveAn);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setBounds(51, 97, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(51, 134, 79, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(51, 170, 79, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Security Question");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(51, 213, 117, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Security Answer");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(51, 251, 117, 14);
		panel.add(lblNewLabel_4);
		
		idtextField = new JTextField();
		idtextField.setBounds(178, 94, 86, 20);
		panel.add(idtextField);
		idtextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(178, 131, 86, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(178, 167, 86, 20);
		panel.add(passwordField_1);
		
		questiontextField_2 = new JTextField();
		questiontextField_2.setBounds(178, 210, 86, 20);
		panel.add(questiontextField_2);
		questiontextField_2.setColumns(10);
		
		answertextField_3 = new JTextField();
		answertextField_3.setBounds(178, 248, 86, 20);
		panel.add(answertextField_3);
		answertextField_3.setColumns(10);
		
		JRadioButton AdminBut = new JRadioButton("Admin");
		AdminBut.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		AdminBut.setBounds(80, 289, 72, 23);
		panel.add(AdminBut);
		
		
		buttonGroup.add(AdminBut);
		
		JRadioButton userBut = new JRadioButton("User");
		userBut.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		userBut.setBounds(191, 289, 72, 23);
		panel.add(userBut);
		buttonGroup.add(userBut);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnNewButton.setBounds(132, 322, 96, 37);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 8, true));
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setLayout(null);
		panel_1.setBounds(54, 21, 336, 370);
		frame.getContentPane().add(panel_1);
		
		JLabel lblPleaseLogIn = new JLabel("PLEASE LOG IN");
		lblPleaseLogIn.setBounds(91, 24, 205, 38);
		panel_1.add(lblPleaseLogIn);
		lblPleaseLogIn.setForeground(Color.BLACK);
		lblPleaseLogIn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(125, 287, 98, 38);
		panel_1.add(btnLogin);
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnLogin.setBackground(SystemColor.menu);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(23, 182, 98, 32);
		panel_1.add(lblPassword);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(23, 118, 98, 32);
		panel_1.add(lblUsername);
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		username = new JTextField();
		username.setBounds(168, 122, 128, 28);
		panel_1.add(username);
		username.setForeground(SystemColor.desktop);
		username.setBackground(SystemColor.text);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 186, 128, 28);
		panel_1.add(passwordField);
		
		JButton forgotPasswordButton = new JButton("Forgot your password?");
		forgotPasswordButton.setBounds(93, 336, 168, 23);
		panel_1.add(forgotPasswordButton);
		forgotPasswordButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		forgotPasswordButton.setForeground(Color.BLACK);
		forgotPasswordButton.setBackground(SystemColor.menu);
		forgotPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ForgotPassword fp = new ForgotPassword(authentication);
				fp.setVisible(true);
				
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname=username.getText();
				String psd=passwordField.getText();
				
				if(authentication.login(uname, psd)) {
					if(authentication.isAdmin(uname)) {
						AdminDashboard ad = new AdminDashboard(uname,psd);
						ad.setVisible(true);
						frame.dispose();
						
						
					}else {
						UserDashBoard ud = new UserDashBoard(uname,psd);
						ud.setVisible(true);
						frame.dispose();
					}
						
				}
				else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminBut.setActionCommand("admin");
				userBut.setActionCommand("user");
				
				User user = new User(
						idtextField.getText(), 
						nameTextField.getText(), 
						passwordField_1.getText(), 
						buttonGroup.getSelection().getActionCommand(),
						questiontextField_2.getText(),
						answertextField_3.getText()				
						);
				
				if(authentication.signUp(user)) {					
					JOptionPane.showMessageDialog(frame, "You have successfully signed up! You can log in now!");
				}else {
					JOptionPane.showMessageDialog(frame, "You cannot sign up with this id!");					
				}				
			}
		});
	}
}



	