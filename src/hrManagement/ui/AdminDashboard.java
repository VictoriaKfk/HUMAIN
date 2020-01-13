package hrManagement.ui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.opencsv.exceptions.CsvException;

import hrManagement.domain.Employee;
import hrManagement.logic.AdminLogic;
import hrManagement.repositories.EmployeeRepository;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class AdminDashboard extends JFrame {
    
	private String uname;
	private String password;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
	String col[] = {"ID","NAME","LASTNAME", "HIRING DATE", "EMAIL", "ADDRESS", "PHONE", "DEP", "TYPE", "POSITION"};
	DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	DefaultTableModel tableModel1 = new DefaultTableModel(col, 0);
	private JTextField textField_10;
	TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);

	//if you want to search the table using filters
	public void filter(String query) {
		
		table.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(query));
		
	}
	
	//constructor
	public AdminDashboard(String uname, String password) {
		
		this.uname = uname;
		this.password = password;

		EmployeeRepository employee = new EmployeeRepository();
		AdminLogic admin = new AdminLogic(employee);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 456);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add",new ImageIcon("C:\\Users\\asima\\Desktop\\add.png"));
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 11));
		Object[] row = new Object[10];
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				row[0] = textField.getText();
				row[1] = textField_1.getText();
				row[2] = textField_2.getText();
				row[3] = textField_3.getText();
				row[4] = textField_4.getText();
				row[5] = textField_5.getText();
				row[6] = textField_6.getText();
				row[7] = textField_7.getText();
				row[8] = textField_8.getText();
				row[9] = textField_9.getText();
				
				
				tableModel.addRow(row);
				
				admin.addEmployee(new Employee(
						row[0].toString(),
						row[1].toString(),
						row[2].toString(),
						row[3].toString(),
						row[4].toString(),
						row[5].toString(),
						row[6].toString(),
						row[7].toString(),
						row[8].toString(),
						row[9].toString()
						));
			}
		});
		btnNewButton.setBounds(888, 128, 104, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete",new ImageIcon("C:\\Users\\asima\\Desktop\\error.png"));
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selection = table.getSelectedRows();
				   for (int i = 0; i < selection.length; i++) {
				     selection[i] = table.convertRowIndexToModel(selection[i]);
				
				if (selection[i] >= 0) {
					String id = tableModel.getValueAt(selection[i], 0).toString();
					tableModel.removeRow(selection[i]);					
					try {
						admin.deleteEmployeeRecord(id);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CsvException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("Delete Error!");
				}
				   }
			}
		});
		btnNewButton_1.setBounds(888, 292, 102, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update",new ImageIcon("C:\\Users\\asima\\Desktop\\refresh.png"));
		btnNewButton_2.setBackground(new Color(255, 255, 204));
		btnNewButton_2.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					tableModel.setValueAt(textField.getText(), i, 0);
					tableModel.setValueAt(textField_1.getText(), i, 1);
					tableModel.setValueAt(textField_2.getText(), i, 2);
					tableModel.setValueAt(textField_3.getText(), i, 3);
					tableModel.setValueAt(textField_4.getText(), i, 4);
					tableModel.setValueAt(textField_5.getText(), i, 5);
					tableModel.setValueAt(textField_6.getText(), i, 6);
					tableModel.setValueAt(textField_7.getText(), i, 7);
					tableModel.setValueAt(textField_8.getText(), i, 8);
					tableModel.setValueAt(textField_9.getText(), i, 9);
					
					try {
						admin.updateEmployeeRecord(new Employee(
								textField.getText(),
								textField_1.getText(),
								textField_2.getText(),
								textField_3.getText(),
								textField_4.getText(),
								textField_5.getText(),
								textField_6.getText(),
								textField_7.getText(),
								textField_8.getText(),
								textField_9.getText()
								));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    } else {
			    	System.out.println("Update Error!");
			}
			}
		});
		btnNewButton_2.setBounds(886, 210, 104, 33);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 45, 613, 305);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int[] selection = table.getSelectedRows();
				   for (int i = 0; i < selection.length; i++) {
				     selection[i] = table.convertRowIndexToModel(selection[i]);
				   
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String id = model.getValueAt(selection[i],0).toString();
				String name = model.getValueAt(selection[i],1).toString();
				String lname = model.getValueAt(selection[i],2).toString();
				String dohr = model.getValueAt(selection[i],3).toString();
				String email = model.getValueAt(selection[i],4).toString();
				String add = model.getValueAt(selection[i],5).toString();
				String ph = model.getValueAt(selection[i],6).toString();
				String dept = model.getValueAt(selection[i],7).toString();
				String types = model.getValueAt(selection[i],8).toString();
				String pos = model.getValueAt(selection[i],9).toString();
				textField.setText(id);
				textField_1.setText(name);
				textField_2.setText(lname);
				textField_3.setText(dohr);
				textField_4.setText(email);
				textField_5.setText(add);
				textField_6.setText(ph);
				textField_7.setText(dept);
				textField_8.setText(types);
				textField_9.setText(pos);
				   }
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnLoadEmployeeData = new JButton("Load Employee Data");
		btnLoadEmployeeData.setBackground(new Color(255, 255, 204));
		btnLoadEmployeeData.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnLoadEmployeeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				table.setModel(tableModel);
				ArrayList<Employee> emp ;
				
				emp = admin.getAllData();
				
				
				for (int i = 0; i < emp.size(); i++){
					   String id = emp.get(i).getId();
					   String name = emp.get(i).getName();
					   String lastName = emp.get(i).getLastname();
					   String doh = emp.get(i).getDoh();
					   String email = emp.get(i).getEmail();
					   String address = emp.get(i).getAddress();
					   String phone = emp.get(i).getPhone();
					   String dep = emp.get(i).getDepartment();
					   String type = emp.get(i).getFulltime();
					   String position = emp.get(i).isManager();

					   Object[] data = {id, name, lastName, doh, email, address, 
					                               phone, dep, type, position};

					   tableModel.addRow(data);

					}
			}
		});
		btnLoadEmployeeData.setBounds(110, 361, 169, 33);
		contentPane.add(btnLoadEmployeeData);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField.setBounds(738, 41, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblId.setBounds(644, 47, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblName.setBounds(644, 72, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblLastName.setBounds(644, 106, 84, 14);
		contentPane.add(lblLastName);
		
		JLabel lblHiringDate = new JLabel("Hiring Date");
		lblHiringDate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblHiringDate.setBounds(644, 163, 84, 20);
		contentPane.add(lblHiringDate);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmail.setBounds(644, 194, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAddress.setBounds(644, 219, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPhone.setBounds(644, 251, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblDept = new JLabel("Dept");
		lblDept.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDept.setBounds(644, 276, 46, 14);
		contentPane.add(lblDept);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblType.setBounds(644, 301, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPosition.setBounds(644, 336, 46, 14);
		contentPane.add(lblPosition);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_1.setBounds(738, 70, 104, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_2.setBounds(738, 104, 104, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_3.setBounds(738, 164, 104, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_4.setBounds(738, 188, 104, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_5.setBounds(738, 217, 104, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_6.setBounds(738, 245, 104, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_7.setBounds(738, 274, 104, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_8.setBounds(738, 305, 104, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textField_9.setBounds(738, 330, 104, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String query = textField_10.getText();
				filter(query);
			}
		});
		textField_10.setBounds(382, 362, 138, 33);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\asima\\Desktop\\search.png"));
		lblNewLabel.setBounds(339, 361, 33, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("My Profile",new ImageIcon("C:\\Users\\asima\\Desktop\\profile.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDashBoard ud = new UserDashBoard(uname, password);
				ud.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton_3.setBounds(898, 11, 116, 43);
		contentPane.add(btnNewButton_3);
		
	    
		
		validate();
	}
}
