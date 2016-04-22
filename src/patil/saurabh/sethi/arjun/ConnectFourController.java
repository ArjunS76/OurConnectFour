package patil.saurabh.sethi.arjun;

/**
 * Controller class that returns the last available spot
 * @author Saurabh
 *
 */
public class ConnectFourController {

	private int[] rowHeight = new int[7];

	public ConnectFourController() {

		for (int i = 0; i < 7; i++) {
			rowHeight[i] = 8;
		}
	}

	
	/**
	 * Method that returns the height available
	 * 
	 * @param column
	 * @return
	 */
	public int getHeight(int column)
	{
		
		System.out.print(rowHeight[column]);
		return rowHeight[column];
	}

	/**
	 * Method that assists with changingColor method
	 * @param column
	 */
	public void changeColour(int column) {

		column--;
		rowHeight[column]--;
		ConnectFourPanel.changeColor(column, rowHeight[column]);
	}

	/**
	 * AI 
	 * 
	 * @param column
	 */
	public void changeColourAI(int column) {

		column--;
		rowHeight[column]--;

		ConnectFourPanel.pureRandom(column, rowHeight[column]);
	}

}
