package patil.saurabh.sethi.arjun;

import javax.swing.JFrame;
/**
 * Driver class Creates the JFrame Gets components from JPanel and displays them
 * on JFrame
 * 
 * @author Saurabh
 */
public class ConnectFourDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Connect (4) Four");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ConnectFourPanel());
		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);


	}

}
