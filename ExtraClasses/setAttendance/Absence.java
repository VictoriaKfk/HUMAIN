package setAttendance;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.opencsv.exceptions.CsvException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Absence extends JFrame  {

	private JPanel contentPane;
	private JLabel txtAbsence;
    private JCheckBox chckbxSick, chckbxDayOff, chckbxWorkFromHome, chckbxFieldWork;
    private JButton btnOk;
    Daysoff d1 = new Daysoff("hr2");
    CSVabsence csva = new CSVabsence();
	int i1;
	int i2;
	int i3;
	
	/**
	 * Launch the application.
	 */
	public void runGUI() {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Absence frame = new Absence();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Absence() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAbsence = new JLabel();
		txtAbsence.setFont(new Font("Arial", Font.BOLD, 18));
		txtAbsence.setBackground(Color.GRAY);
		txtAbsence.setText("Absence");
		txtAbsence.setBounds(161, 13, 85, 40);
		contentPane.add(txtAbsence);
		//txtAbsence.setColumns(10);
		
		JCheckBox chckbxSick = new JCheckBox("Sick");
		chckbxSick.setBackground(Color.GRAY);
		chckbxSick.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxSick.setForeground(Color.BLACK);
		chckbxSick.setBounds(161, 77, 113, 25);
		contentPane.add(chckbxSick);
		
		JCheckBox chckbxDayOff = new JCheckBox("Day off");
		chckbxDayOff.setBackground(Color.GRAY);
		chckbxDayOff.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxDayOff.setBounds(161, 119, 113, 25);
		contentPane.add(chckbxDayOff);
		
		JCheckBox chckbxWorkFromHome = new JCheckBox("Work from home");
		chckbxWorkFromHome.setBackground(Color.GRAY);
		chckbxWorkFromHome.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxWorkFromHome.setBounds(161, 159, 133, 25);
		contentPane.add(chckbxWorkFromHome);
		
		JCheckBox chckbxFieldWork = new JCheckBox("Field work");
		chckbxFieldWork.setBackground(Color.GRAY);
		chckbxFieldWork.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxFieldWork.setBounds(161, 202, 113, 25);
		contentPane.add(chckbxFieldWork);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(Color.WHITE);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOk ) {
					
					if (chckbxSick.isSelected()) {  
				    	i1 = d1.countdaysoff(d1.maxDO);
				    	i2 = d1.absenceSick();
						i3 = d1.justifiedAbsence(d1.JustifiedAbsence);
						System.out.println(i1 +","+ i2  +","+ i3);
				     }  else if (chckbxDayOff.isSelected()){ 
						i1 = d1.countdaysoff(d1.maxDO);
						System.out.println(i1);
				     }  else if (chckbxWorkFromHome.isSelected()) {
				    	 i1 = d1.countabsences(Daysoff.seasonFullDayAbsences);
				    	 i2 = d1.workFromHome();
				    	 i3 = d1.justifiedAbsence(d1.JustifiedAbsence);
				    	 System.out.println(i1 +","+ i2 +","+ i3);
				     } else if (chckbxFieldWork.isSelected()) {
				    	 i1 = d1.countabsences(Daysoff.seasonFullDayAbsences);
				    	 i2 = d1.workField();
				    	 i3 = d1.justifiedAbsence(d1.JustifiedAbsence);
				    	 System.out.println(i1 +","+ i2 +","+ i3);
				     }
					
					try {
						csva.updateCSV("hr2", "5", i1, i3);
					} catch (IOException | CsvException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
			}
		});
		btnOk.setBounds(323, 228, 97, 25);
		contentPane.add(btnOk);
		
		JLabel lblCheckOnlyOne = new JLabel("Check only one option");
		lblCheckOnlyOne.setBounds(138, 45, 133, 16);
		contentPane.add(lblCheckOnlyOne);
	}
}
