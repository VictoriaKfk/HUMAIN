import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calendar extends JFrame {

	private JPanel contentPane;
	private JTextField txtChooseADay;
	private JRadioButton radioButton,radioButton_1,radioButton_2,radioButton_3,radioButton_4,radioButton_5,
	radioButton_6,radioButton_7,radioButton_8,radioButton_9,radioButton_10,radioButton_11,radioButton_12,
	radioButton_13,radioButton_14,radioButton_15,radioButton_16,radioButton_17,radioButton_18,radioButton_19,
	radioButton_20,radioButton_21,radioButton_22,radioButton_23,radioButton_24,radioButton_25,
	radioButton_26,radioButton_27,radioButton_28,radioButton_29,radioButton_30;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar frame = new Calendar();
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
	public Calendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton radioButton = new JRadioButton("01");
		radioButton.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton.setBounds(18, 40, 45, 25);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("02");
		radioButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_1.setBounds(18, 70, 45, 25);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("03");
		radioButton_2.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_2.setBounds(18, 97, 45, 25);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("04");
		radioButton_3.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_3.setBounds(18, 127, 45, 25);
		contentPane.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("05");
		radioButton_4.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_4.setBounds(18, 159, 45, 25);
		contentPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("06");
		radioButton_5.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_5.setBounds(18, 189, 45, 25);
		contentPane.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("07");
		radioButton_6.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_6.setBounds(18, 219, 45, 25);
		contentPane.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("08");
		radioButton_7.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_7.setBounds(75, 40, 45, 25);
		contentPane.add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("09");
		radioButton_8.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_8.setBounds(74, 70, 45, 25);
		contentPane.add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("10");
		radioButton_9.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_9.setBounds(74, 97, 45, 25);
		contentPane.add(radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("11");
		radioButton_10.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_10.setBounds(74, 127, 45, 25);
		contentPane.add(radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("12");
		radioButton_11.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_11.setBounds(74, 159, 46, 25);
		contentPane.add(radioButton_11);
		
		JRadioButton radioButton_12 = new JRadioButton("13");
		radioButton_12.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_12.setBounds(74, 189, 45, 25);
		contentPane.add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("14");
		radioButton_13.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_13.setBounds(74, 219, 46, 25);
		contentPane.add(radioButton_13);
		
		JRadioButton radioButton_15 = new JRadioButton("16");
		radioButton_15.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_15.setBounds(123, 70, 45, 25);
		contentPane.add(radioButton_15);
		
		JRadioButton radioButton_14 = new JRadioButton("15");
		radioButton_14.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_14.setBounds(123, 40, 45, 25);
		contentPane.add(radioButton_14);
		
		JRadioButton radioButton_16 = new JRadioButton("17");
		radioButton_16.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_16.setBounds(123, 97, 45, 25);
		contentPane.add(radioButton_16);
		
		JRadioButton radioButton_17 = new JRadioButton("18");
		radioButton_17.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_17.setBounds(123, 127, 45, 25);
		contentPane.add(radioButton_17);
		
		JRadioButton radioButton_18 = new JRadioButton("19");
		radioButton_18.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_18.setBounds(124, 159, 45, 25);
		contentPane.add(radioButton_18);
		
		JRadioButton radioButton_19 = new JRadioButton("20");
		radioButton_19.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_19.setBounds(123, 189, 45, 25);
		contentPane.add(radioButton_19);
		
		JRadioButton radioButton_20 = new JRadioButton("21");
		radioButton_20.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_20.setBounds(123, 219, 45, 25);
		contentPane.add(radioButton_20);
		
		JRadioButton radioButton_21 = new JRadioButton("22");
		radioButton_21.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_21.setBounds(176, 40, 45, 25);
		contentPane.add(radioButton_21);
		
		JRadioButton radioButton_22 = new JRadioButton("23");
		radioButton_22.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_22.setBounds(176, 70, 45, 25);
		contentPane.add(radioButton_22);
		
		JRadioButton radioButton_23 = new JRadioButton("24");
		radioButton_23.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_23.setBounds(176, 97, 45, 25);
		contentPane.add(radioButton_23);
		
		JRadioButton radioButton_24 = new JRadioButton("25");
		radioButton_24.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_24.setBounds(176, 127, 45, 25);
		contentPane.add(radioButton_24);
		
		JRadioButton radioButton_25 = new JRadioButton("26");
		radioButton_25.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_25.setBounds(176, 159, 45, 25);
		contentPane.add(radioButton_25);
		
		JRadioButton radioButton_26 = new JRadioButton("27");
		radioButton_26.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_26.setBounds(176, 189, 45, 25);
		contentPane.add(radioButton_26);
		
		JRadioButton radioButton_27 = new JRadioButton("28");
		radioButton_27.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_27.setBounds(176, 219, 45, 25);
		contentPane.add(radioButton_27);
		
		JRadioButton radioButton_28 = new JRadioButton("29");
		radioButton_28.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_28.setBounds(237, 40, 45, 25);
		contentPane.add(radioButton_28);
		
		JRadioButton radioButton_29 = new JRadioButton("30");
		radioButton_29.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_29.setBounds(237, 70, 45, 25);
		contentPane.add(radioButton_29);
		
		JRadioButton radioButton_30 = new JRadioButton("31");
		radioButton_30.setFont(new Font("Arial", Font.PLAIN, 14));
		radioButton_30.setBounds(237, 97, 45, 25);
		contentPane.add(radioButton_30);
		
		txtChooseADay = new JTextField();
		txtChooseADay.setFont(new Font("Arial", Font.PLAIN, 16));
		txtChooseADay.setText("Choose a day for your day off");
		txtChooseADay.setBounds(99, 9, 215, 22);
		contentPane.add(txtChooseADay);
		txtChooseADay.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOk ) {
					System.exit(0);
				}
			}
		});
		btnOk.setBounds(311, 219, 97, 25);
		contentPane.add(btnOk);
	}
	public void actionPerformed(ActionEvent e) {
		 if (radioButton.isSelected()) {
	    	 System.out.print("The day off requested is:" + radioButton + "of the month");
	     } else if (radioButton_1.isSelected()) {
	    	 System.out.print("The day off requested is:" + radioButton_1 + "of the month");
	     } else if (radioButton_2.isSelected()) {
	    	 System.out.print("The day off requested is:" + radioButton_2 + "of the month");
	     } else if (radioButton_3.isSelected()) {
	    	 System.out.print("The day off requested is:" + radioButton_3 + "of the month");
		 } else if (radioButton_4.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_4 + "of the month");
		 } else if (radioButton_5.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_5 + "of the month");
		 } else if (radioButton_6.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_6 + "of the month");
		 } else if (radioButton_7.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_7 + "of the month");
		 } else if (radioButton_8.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_8 + "of the month");
		 } else if (radioButton_9.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_9 + "of the month");
		 } else if (radioButton_10.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_10 + "of the month");
		 } else if (radioButton_11.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_11 + "of the month");
		 } else if (radioButton_12.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_12 + "of the month");
		 } else if (radioButton_13.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_13 + "of the month");
		 } else if (radioButton_14.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_14 + "of the month");
		 } else if (radioButton_15.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_15 + "of the month");
		 } else if (radioButton_16.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_16 + "of the month");
		 } else if (radioButton_17.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_17 + "of the month");
		 } else if (radioButton_18.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_18 + "of the month");
		 } else if (radioButton_19.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_19 + "of the month");
		 } else if (radioButton_20.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_20 + "of the month");
		 } else if (radioButton_21.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_21 + "of the month");
		 } else if (radioButton_22.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_22 + "of the month");
		 } else if (radioButton_23.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_23 + "of the month");
		 } else if (radioButton_24.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_24 + "of the month");
		 } else if (radioButton_25.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_25 + "of the month");
		 } else if (radioButton_26.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_26 + "of the month");
		 } else if (radioButton_27.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_27 + "of the month");
		 } else if (radioButton_28.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_28 + "of the month");
		 } else if (radioButton_29.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_29 + "of the month");
		 } else if (radioButton_30.isSelected()) {
			 System.out.print("The day off requested is:" + radioButton_30 + "of the month");
		 } 
	}
}
