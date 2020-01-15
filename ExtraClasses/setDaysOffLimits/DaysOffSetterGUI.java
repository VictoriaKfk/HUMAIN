package setDaysOffLimits;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.opencsv.exceptions.CsvException;


public class DaysOffSetterGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8422771868703335496L;
	/**
	 * 
	 */
	protected DaysOffSetter runGUI(DaysOffSetter dos) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaysOffSetterGUI frame = new DaysOffSetterGUI(dos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return dos;
	}
	
	private JPanel frmPreferences;
	private JTextField maxDaysOffMonth;
	private JTextField maxSickDaysMonth;
	private JTextField maxWorkHomeDaysMonth;
	private JTextField maxFieldDaysMonth;
	private JCheckBox chckbxDaysOff;
	private JCheckBox chckbxSickDaysOff; 
	private JCheckBox chckbxWorkFromHome;
	private JCheckBox chckbxFieldWorkDays;
	private JButton btnSave;

	/**
	 * Initialize the contents of the frame.
	 */
	public DaysOffSetterGUI(DaysOffSetter dos) {
		setBounds(100, 100, 395, 268);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.POPUP);
		
		frmPreferences = new JPanel();
		setContentPane(frmPreferences);
		frmPreferences.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		frmPreferences.setBackground(Color.WHITE);
		frmPreferences.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("93px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("96px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("31px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(10dlu;default)"),}));

		chckbxDaysOff = new JCheckBox("Days Off ");
		chckbxDaysOff.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxDaysOff.setBackground(Color.WHITE);
		frmPreferences.add(chckbxDaysOff, "3, 3, fill, fill");

		JLabel lblNoPerMonth = new JLabel("Max No / Month");
		lblNoPerMonth.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNoPerMonth.setBackground(Color.WHITE);
		frmPreferences.add(lblNoPerMonth, "5, 3, left, fill");

		maxDaysOffMonth = new JTextField();
		maxDaysOffMonth.setHorizontalAlignment(SwingConstants.LEFT);
		maxDaysOffMonth.setBackground(Color.WHITE);
		frmPreferences.add(maxDaysOffMonth, "7, 3, fill, center");
		maxDaysOffMonth.setColumns(10);

		chckbxSickDaysOff = new JCheckBox("Sick Days Off");
		chckbxSickDaysOff.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxSickDaysOff.setBackground(Color.WHITE);
		frmPreferences.add(chckbxSickDaysOff, "3, 5, fill, fill");

		JLabel lblMaxNo = new JLabel("Max No / Month");
		lblMaxNo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmPreferences.add(lblMaxNo, "5, 5, fill, fill");

		maxSickDaysMonth = new JTextField();
		maxSickDaysMonth.setColumns(10);
		frmPreferences.add(maxSickDaysMonth, "7, 5, fill, center");

		chckbxWorkFromHome = new JCheckBox("Work from Home Days");
		chckbxWorkFromHome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxWorkFromHome.setBackground(Color.WHITE);
		frmPreferences.add(chckbxWorkFromHome, "3, 7, fill, fill");

		JLabel lblMaxNo_1 = new JLabel("Max No / Month");
		lblMaxNo_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmPreferences.add(lblMaxNo_1, "5, 7, fill, fill");

		maxWorkHomeDaysMonth = new JTextField();
		maxWorkHomeDaysMonth.setColumns(10);
		frmPreferences.add(maxWorkHomeDaysMonth, "7, 7, fill, center");

		chckbxFieldWorkDays = new JCheckBox("Field Work Days");
		chckbxFieldWorkDays.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxFieldWorkDays.setBackground(Color.WHITE);
		frmPreferences.add(chckbxFieldWorkDays, "3, 9, fill, fill");

		JLabel lblMaxNo_2 = new JLabel("Max No / Month");
		lblMaxNo_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmPreferences.add(lblMaxNo_2, "5, 9, fill, fill");

		maxFieldDaysMonth = new JTextField();
		maxFieldDaysMonth.setColumns(10);
		frmPreferences.add(maxFieldDaysMonth, "7, 9, fill, center");

		btnSave = new JButton("     Save     ");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Color c = new Color(220, 220, 220);
		btnSave.setBackground(c);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnSave ) {
					
					if(chckbxDaysOff.isSelected()) {
						dos.setDaysOff(true);
					}
					
					if(chckbxSickDaysOff.isSelected()) {
						dos.setSickDaysOff(true);
						System.out.println(dos.isSickDaysOff());
					}
					
					if(chckbxFieldWorkDays.isSelected()) {
						dos.setFieldWorkDays(true);
					}
					
					if(chckbxWorkFromHome.isSelected()) {
						dos.setWorkfromHomeDaysOff(true);
					}
					
					if(!maxDaysOffMonth.getText().isEmpty()) {
						String days = maxDaysOffMonth.getText();
						int DaysOffMonth = Integer.parseInt(days);
						dos.setMaxNumDaysoff(DaysOffMonth);
					}
					
					if(!maxFieldDaysMonth.getText().isEmpty()) {
						String days = maxFieldDaysMonth.getText();
						int FieldDaysMonth = Integer.parseInt(days);
						dos.setMaxNumFieldWorkDays(FieldDaysMonth);
					}
					
					if(!maxSickDaysMonth.getText().isEmpty()) {
						String days = maxSickDaysMonth.getText();
						int SickDaysMonth = Integer.parseInt(days);
						dos.setMaxNumSickDaysoff(SickDaysMonth);
					}
					
					if(!maxWorkHomeDaysMonth.getText().isEmpty()) {
						String days = maxWorkHomeDaysMonth.getText();
						int WorkHomeDaysMonth = Integer.parseInt(days);
						dos.setMaxNumFieldWorkDays(WorkHomeDaysMonth);
					}
					
					
					try {
						DaysOffSetterCSV.updateCSV("FieldWorkDays", dos.isFieldWorkDays(), dos.getMaxNumFieldWorkDays());
						DaysOffSetterCSV.updateCSV("DaysOff", dos.isDaysOff(), dos.getMaxNumDaysoff());
						DaysOffSetterCSV.updateCSV("AbsenceSick", dos.isSickDaysOff(), dos.getMaxNumSickDaysoff());
						DaysOffSetterCSV.updateCSV("WorkfromHome", dos.isFieldWorkDays(), dos.getMaxNumWorkfromHomeDaysOff());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CsvException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			

					System.exit(0);
					
				}
			}
		});
		frmPreferences.add(btnSave, "5, 13, left, fill");

	} 

}

