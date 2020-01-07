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
import java.awt.event.*;

public class Absence extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtAbsence;
    private JCheckBox chckbxSick, chckbxDayOff, chckbxWorkFromHome, chckbxFieldWork;
    private JButton btnOk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Daysoff d1 = new Daysoff();
		Daysoff d2 = new Daysoff();
		Daysoff d3 = new Daysoff();
		Daysoff d4 = new Daysoff();
		Daysoff d5 = new Daysoff();
		Daysoff d6 = new Daysoff();
		Daysoff d7 = new Daysoff();
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAbsence = new JTextField();
		txtAbsence.setFont(new Font("Arial", Font.PLAIN, 16));
		txtAbsence.setBackground(Color.LIGHT_GRAY);
		txtAbsence.setText("Absence");
		txtAbsence.setBounds(165, 13, 81, 40);
		contentPane.add(txtAbsence);
		txtAbsence.setColumns(10);
		
		JCheckBox chckbxSick = new JCheckBox("Sick");
		chckbxSick.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxSick.setForeground(Color.BLACK);
		chckbxSick.setBounds(161, 77, 113, 25);
		contentPane.add(chckbxSick);
		
		JCheckBox chckbxDayOff = new JCheckBox("Day off");
		chckbxDayOff.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxDayOff.setBounds(161, 119, 113, 25);
		contentPane.add(chckbxDayOff);
		
		JCheckBox chckbxWorkFromHome = new JCheckBox("Work from home");
		chckbxWorkFromHome.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxWorkFromHome.setBounds(161, 159, 133, 25);
		contentPane.add(chckbxWorkFromHome);
		
		JCheckBox chckbxFieldWork = new JCheckBox("Field work");
		chckbxFieldWork.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxFieldWork.setBounds(161, 202, 113, 25);
		contentPane.add(chckbxFieldWork);
		
		JButton btnOk = new JButton("OK");
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
	    	d5.countabsences();
			d1.JustifiedAbsence();
	     }  else if (chckbxDayOff.isSelected()){ 
			d2.countdaysoff();	
	     }  else if (chckbxWorkFromHome.isSelected()) {
	    	 d6.countabsences();
	    	 d3.JustifiedAbsence();
	     } else if (chckbxFieldWork.isSelected()) {
	    	 d7.countabsences();
	    	 d4.JustifiedAbsence();
	     }
   }
}
