package hrManagement;

import java.awt.EventQueue;


import hrManagement.ui.Login;


public class Main {

	public static void main(String[] args)   {
		
		Container container = new Container();
		container.wireDependencies();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = container.getLogin();
				    window.getFrame().setVisible(true);
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}

