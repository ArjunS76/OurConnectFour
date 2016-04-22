package patil.saurabh.sethi.arjun;

public class ConnectFourWinner {

	private int player = 0;

	public ConnectFourWinner()

	{

		this.player = 0;
	}

	/**
	 * Sets player 1
	 */	public void setPlayer1()

	{
		this.player = 1;
	}

	/**
	 * Sets player 2
	 */
	public void setPlayer2()

	{

		this.player = 2;
	}
	
	/**
	 * Sets AI
	 */
	public void setAI()

	{

		this.player = 3;
	}

	/**
	 * Gets a player
	 * @return
	 */
	public int get()

	{
		return player;

	}
}
