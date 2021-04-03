package code;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Driver implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Driver());
	}
	
	@Override public void run() {	
		JFrame window = new JFrame("Lab exercise");
		JPanel p = new JPanel();
		window.add(p);
		new GUI(p);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
