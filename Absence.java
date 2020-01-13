import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.util.ArrayList;

public class Absence extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtAbsence;
    private JCheckBox chckbxSick, chckbxDayOff, chckbxWorkFromHome, chckbxFieldWork;
    private JButton btnOk;
    Daysoff d1 = new Daysoff(2439);
	Daysoff d2 = new Daysoff(2439);
	Daysoff d3 = new Daysoff(2439);
	Daysoff d4 = new Daysoff(2439);
	AttendanceTracker at = new AttendanceTracker(2439);
	AttendanceTracker at1 = new AttendanceTracker(2439);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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
		
		txtAbsence = new JTextField();
		txtAbsence.setFont(new Font("Arial", Font.BOLD, 18));
		txtAbsence.setBackground(Color.GRAY);
		txtAbsence.setText("Absence");
		txtAbsence.setBounds(161, 13, 85, 40);
		contentPane.add(txtAbsence);
		txtAbsence.setColumns(10);
		
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
					System.exit(0);
				}
			}
		});
		btnOk.setBounds(323, 228, 97, 25);
		contentPane.add(btnOk);
	}
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == btnOk ) {
			System.exit(0);
		}
	     if (chckbxSick.isSelected()) {  
	    	d1.countdaysoff(d1.daysoff);
	    	d1.AbsenceSick();
			d1.JustifiedAbsence(d1.JustifiedAbsence);
			System.out.println(d1.countdaysoff(d1.daysoff) + d1.AbsenceSick() + d1.JustifiedAbsence(d1.JustifiedAbsence));
	     }  else if (chckbxDayOff.isSelected()){ 
			d2.countdaysoff(d2.daysoff);
			System.out.println(d2.countdaysoff(d2.daysoff));
	     }  else if (chckbxWorkFromHome.isSelected()) {
	    	 d3.countabsences(at.);
	    	 d3.WorkFromHome();
	    	 d3.JustifiedAbsence(d3.JustifiedAbsence);
	    	 System.out.println(d3.countabsences(at.seasonTracker(21,2))+ d3.WorkFromHome() + d3.JustifiedAbsence(d3.JustifiedAbsence));
	     } else if (chckbxFieldWork.isSelected()) {
	    	 d4.countabsences(at1.seasonTracker());
	    	 d4.WorkField();
	    	 d4.JustifiedAbsence(d4.JustifiedAbsence);
	    	 System.out.println(d4.countabsences(at1.seasonTracker()) + d4.WorkField() + d4.JustifiedAbsence(d4.JustifiedAbsence));
	     }
   }
}
