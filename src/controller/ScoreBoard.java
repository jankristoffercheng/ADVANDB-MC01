package controller;

public class ScoreBoard {
	
	private Double scoreBoard[][];
	private int rowsize;
	private int colsize;
	public ScoreBoard(int rowsize, int colsize)
	{
		scoreBoard = new Double[rowsize][colsize];
		this.rowsize = rowsize;
		this.colsize = colsize;
		initializeScoreBoard();
	}
	
	private void initializeScoreBoard()
	{
		for(int i = 0 ; i < rowsize; i++)
		{
			for(int j = 0 ; j < colsize; j++)
			{
				scoreBoard[i][j] = 0.00;
			}
		}
	}
	
	public void setDataToElement(int queryNo, int typeNo, Double duration) {
		scoreBoard[queryNo][typeNo] = duration;
	}
	
	public Object[][] getData()
	{
		return scoreBoard;
	}
}
