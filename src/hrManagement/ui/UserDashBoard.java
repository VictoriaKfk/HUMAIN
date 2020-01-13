package hrManagement.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hrManagement.domain.Employee;
import hrManagement.logic.UserLogic;
import hrManagement.repositories.EmployeeRepository;
import hrManagement.repositories.UserRepository;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextField;

public class UserDashBoard extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private String uname; 
	private String password;
	String col[] = {"ID","NAME","LASTNAME","DEPT","POSITION"};
	DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	private JTextField nametextField;
	private JTextField lnametextField;
	private JTextField phonetextField;
	private JTextField emailtextField;
	private JTextField addresstextField;
	

	
	public UserDashBoard(String uname, String password) {
		this.uname = uname;
		this.password = password;
		
		EmployeeRepository emp = new EmployeeRepository();
		UserRepository user = new UserRepository();
		UserLogic userLog = new UserLogic(user,emp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 456);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String id = user.getIDByUserPassUname(password, uname);
		String dept = userLog.getDeptById(id);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 110, 438, 204);
		contentPane.add(scrollPane);
		table = new JTable(tableModel);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane.setViewportView(table);
		
		
		JButton btnLoadEmployeeData = new JButton("Load your colleagues' list");
		btnLoadEmployeeData.setBackground(SystemColor.inactiveCaptionBorder);
		btnLoadEmployeeData.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnLoadEmployeeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(425, 67, 420, 192);
				contentPane.add(scrollPane);
				table = new JTable(tableModel);
				scrollPane.setViewportView(table);*/
				table.setModel(tableModel);
				ArrayList<Employee> coll ;
				
				coll = userLog.getColleagues(dept);
				
				
				for (int i = 0; i < coll.size(); i++){
					   String id = coll.get(i).getId();
					   String name = coll.get(i).getName();
					   String lastName = coll.get(i).getLastname();
					   String dep = coll.get(i).getDepartment();
					   String position = coll.get(i).isManager();

					   Object[] data = {id, name, lastName, dep, position};

					   tableModel.addRow(data);

					}
			}
		});
		btnLoadEmployeeData.setBounds(608, 48, 218, 33);
		contentPane.add(btnLoadEmployeeData);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(28, 22, 351, 364);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\asima\\Desktop\\user.png"));
		lblNewLabel_1.setBounds(26, 11, 65, 65);
		panel.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel.setBounds(107, 26, 101, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setText("Welcome " + uname);
		
		JLabel lblId = new JLabel("ID : " + id);
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblId.setBounds(253, 26, 65, 14);
		panel.add(lblId);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(46, 99, 59, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(46, 148, 73, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(46, 192, 59, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(46, 234, 46, 14);
		panel.add(lblNewLabel_5);
		
		nametextField = new JTextField();
		nametextField.setBounds(167, 104, 86, 20);
		panel.add(nametextField);
		nametextField.setColumns(10);
		nametextField.setText(emp.getByEmployeeId(id).getName());
		
		lnametextField = new JTextField();
		lnametextField.setBounds(167, 145, 86, 20);
		panel.add(lnametextField);
		lnametextField.setColumns(10);
		lnametextField.setText(emp.getByEmployeeId(id).getLastname());
		
		
		phonetextField = new JTextField();
		phonetextField.setBounds(167, 189, 86, 20);
		panel.add(phonetextField);
		phonetextField.setColumns(10);
		phonetextField.setText(emp.getByEmployeeId(id).getPhone());
		
		emailtextField = new JTextField();
		emailtextField.setBounds(167, 234, 86, 20);
		panel.add(emailtextField);
		emailtextField.setColumns(10);
		emailtextField.setText(emp.getByEmployeeId(id).getEmail());
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(46, 283, 46, 14);
		panel.add(lblNewLabel_6);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(167, 280, 86, 20);
		panel.add(addresstextField);
		addresstextField.setColumns(10);
		addresstextField.setText(emp.getByEmployeeId(id).getAddress());
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Your info has been successfully updated");
			}
		});
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnUpdate.setBounds(119, 330, 89, 23);
		panel.add(btnUpdate);
		
		JLabel lbldept = new JLabel("Department : " + dept);
		lbldept.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lbldept.setBounds(130, 50, 133, 14);
		panel.add(lbldept);
		
		validate();
	}
}
