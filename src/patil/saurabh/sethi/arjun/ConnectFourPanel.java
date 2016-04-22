package patil.saurabh.sethi.arjun;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The Panel class where the code for the main game is written
 * Also the same panel in which the game runs upon
 * @author Saurabh
 * 
 *
 */
public class ConnectFourPanel extends JPanel {

	JButton gridButton[][];
	private static JLabel[][] gridLabel;

	private static ConnectFourWinner[][] box = new ConnectFourWinner[8][7];
	private JButton[] clickButtons;
	static boolean game = true;
	static boolean different = false;
	int[] columnOne = new int[7];
	private String option;
	static boolean playerTurn = false;
	

	static BufferedImage purple;

	static BufferedImage yellow;

	private static ConnectFourController control = new ConnectFourController();
	
	private static Random rand = new Random();

	/**
	 * Panel class
	 * Declaration of the buttons and the labels (The Grid display)
	 * Sets the game in player vs player or plaver vs AI mode 
	 */
	public ConnectFourPanel() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500, 500));
		setFont(new Font("Arial", Font.BOLD, 15));

		try

		{
			yellow = ImageIO.read(new File("Yelloe.png"));
			purple = ImageIO.read(new File("purple.jpg"));
		}

		catch (Exception e)

		{

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		setLayout(new GridLayout(8, 7));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

		int rows = 8;
		int columns = 7;

		gridLabel = new JLabel[rows][columns];
		clickButtons = new JButton[7];
		int labelCounter = 1;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				box[i][j] = new ConnectFourWinner();

				if (i == 0) {
					clickButtons[i] = new JButton("");
					clickButtons[i].setText(String.valueOf(labelCounter));
					clickButtons[i].setEnabled(true);
					clickButtons[i].setBackground(new Color(255, 128, 0));
					clickButtons[i].addActionListener(new buttonListener());
					clickButtons[i].setBorder(border);
					add(clickButtons[i]);
				} else {
					gridLabel[i][j] = new JLabel();
					gridLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					gridLabel[i][j].setBorder(border);

					add(gridLabel[i][j]);
				}
				labelCounter++;
			}
		}

		String[] selection = { "Player v player", "Player v computer" };

		option = (String) JOptionPane.showInputDialog(null, "What mode?", "Mode Selection",
				JOptionPane.PLAIN_MESSAGE, null, selection, null);

		if (option.equals("Player v player")) {
			changeColor(columns, rows);
		}
		else if(option.equals("Player v computer")){
			pureRandom(columns, rows);
			
		}

	}

	/**
	 * Button listener class
	 * Sets the values in the row of buttons from 1-7
	 * @author Saurabh
	 *
	 */
	public class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			String buttonValue = btn.getText();

			int column = Integer.parseInt(buttonValue) - 1;
			if (control.getHeight(column) > 1 && control.getHeight(column) <= 8 && option.equals("Player v player")) {
				control.changeColour(Integer.parseInt(buttonValue));

			}else if(control.getHeight(column) > 1 && control.getHeight(column) <= 8 && option.equals("Player v computer")){
				control.changeColourAI(Integer.parseInt(buttonValue));
			}

		}
	}

	/**
	 * Win detection methods
	 * None worked, methods were formed correctly though
	 * Includes: Vertical, Horizontal, Diagonal right, Diagonal left checking methods
	 * @param column
	 * @param row
	 */

/*	public static boolean winCheckerColumn(int column, int row) {

		boolean same=true;
		int currentRow=row;
		JLabel initial=gridLabel[row][column];
		int length =1;
		while (same && currentRow<6){
					if (initial.equals(gridLabel[currentRow+1][column])){
						length++;
						currentRow++;
					} else {
						same= false;
					}
			}
		if (length == 4){
			return true;
		}
		else {
			return false;
		}
		}
	
	
	public static boolean winCheckerRow(int column, int row) {
		boolean same=true;
		int currentRow=row;
		JLabel initial=gridLabel[row][column];
		int length =1;
		while (same && currentRow<6){
					if (initial.equals(gridLabel[currentRow][column+1])){
						length++;
						column++;
					} else {
						same= false;
					}
			}
		if (length == 4){
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean winCheckerDiagonallyLeft(int column, int row) {

				boolean same=true;
		int currentRow=row;
		JLabel initial=gridLabel[row][column];
		int length =1;
		while (same && currentRow<6){
					if (initial.equals(gridLabel[currentRow+1][column-1])){
						length++;
						currentRow++;
						column--;
					} else {
						same= false;
					}
			}
		if (length == 4){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean winCheckerDiagonallyRight(int column, int row) {

				boolean same=true;
		int currentRow=row;
		JLabel initial=gridLabel[row][column];
		int length =1;
		while (same && currentRow<6){
					if (initial.equals(gridLabel[currentRow+1][column+1])){
						length++;
						currentRow++;
						column++;
					} else {
						same= false;
					}
			}
		if (length == 4){
			return true;
		}
		else {
			return false;
		}
	}*/

	/**
	 * Returns a bollean value to declare which player's turn it is
	 * 
	 * @param playerTurn
	 * @return
	 */
	public static boolean playerAssignment(boolean playerTurn) {
		if (!playerTurn){
			return playerTurn;
		}
		else{
			playerTurn= true;
			return playerTurn;
		}
	
	}
	
	/**
	 * Basically the main game-running method
	 * Alters from Player 1 to Player 2 
	 * Drops the respective color based on the player
	 * @param column
	 * @param row
	 */
	public static void changeColor(int column, int row) {

		if (row > 0 && row <= 7) {
			System.out.println("(" + row + "," + column + ")");

			if (ConnectFourPanel.playerAssignment(playerTurn)==false) {
				box[row][column].setPlayer1();
				gridLabel[row][column].setIcon(new ImageIcon(purple));
			/* if (winCheckerColumn(row, column)|| winCheckerRow(row, column) || winCheckerDiagonallyLeft(row, column) || winCheckerDiagonallyRight(row, column)){
						System.out.println("Player 1 won");
					}
				else{
					System.out.println("");
					}*/
				playerTurn=true;
			}
			else{
				box[row][column].setPlayer2();
				gridLabel[row][column].setIcon(new ImageIcon(yellow));
				/* if (winCheckerColumn(row, column)|| winCheckerRow(row, column) || winCheckerDiagonallyLeft(row, column) || winCheckerDiagonallyRight(row, column)){
						System.out.println("Player 2 won");
					}
				else{
					System.out.println("");
					}*/
				playerTurn=false;
			}
			

		}

		else{


			JOptionPane.showMessageDialog(null, "Column is full");

		}
		
	}
	
	/**
	 * Similar method to changeColor, but this one works with player 1 and AI
	 * All components do not work
	 * 
	 * @param column
	 * @param row
	 */
	public static void pureRandom(int column, int row) {

		if (row > 0 && row <= 7) {
			System.out.println("(" + row + "," + column + ")");

			if (ConnectFourPanel.playerAssignment(playerTurn)==false) {
				
				playerTurn=true;

				box[row][column].setPlayer1();
				gridLabel[row][column].setIcon(new ImageIcon(purple));
		/*		if (winCheckerColumn(row, column)|| winCheckerRow(row, column) || winCheckerDiagonallyLeft(row, column) || winCheckerDiagonallyRight(row, column)){
						System.out.println("Player 1 won");
					}
				else{
					System.out.println("");
					*/
			}
			
			
			playerTurn = false;

			
					
					int columnAI = rand.nextInt(7);
					while(box[control.getHeight(columnAI)][columnAI].get()==0 || box[control.getHeight(columnAI)][columnAI].get() == 1 )
					{
						System.out.print(columnAI + " column ");
						columnAI = rand.nextInt(7);

					}
					

					
					box[control.getHeight(columnAI)][columnAI].setAI();
					gridLabel[control.getHeight(columnAI)][columnAI].setIcon(new ImageIcon(yellow));
					System.out.print("Job Done");
				
				/* if (winCheckerColumn(row, column)|| winCheckerRow(row, column) || winCheckerDiagonallyLeft(row, column) || winCheckerDiagonallyRight(row, column)){
						System.out.println("AI won");
					}
				else{
					System.out.println("");
					}*/
				
				
				
				
		//	}

		}

		else

		{

			JOptionPane.showMessageDialog(null, "Column is full");

		}

	}
	}
