
public class ChessRule  
{

	ChessPad chessPad;
	boolean refereeResult;
	int xPos, yPos;
	int chessManPoint[][];
	int continuePoint[][];
	ChessRule(ChessPad chessPad) 
	{
		this.chessPad = chessPad;
		refereeResult = false;
		xPos = chessPad.xPos;
		yPos = chessPad.yPos;
		chessManPoint = chessPad.chessManPoint;
		continuePoint = new int[4][10];
	}
	
	public Boolean chessReferee()
	{
		int sameCount = 0;
		int xTemp, yTemp;
//		for(int k=0; k<)
		
		return refereeResult;
	}
	
	public void cutPointsArray()
	{
		int xStart, xEnd;
		int yStart, yEnd;
		if(xPos<4)
		{
			xStart = 0;
			xEnd   = xPos + 4;
		}
		else if(xPos > 14)
		{
			xStart = xPos - 4;
			xEnd   = 18;
		}
		else
		{
			xStart = xPos - 4;
			xEnd   = xPos + 4;
		}
		
		if(yPos<4)
		{
			yStart = 0;
			yEnd   = yPos + 4;
		}
		else if(xPos > 14)
		{
			yStart = yPos - 4;
			yEnd   = 18;
		}
		else
		{
			yStart = yPos - 4;
			yEnd   = yPos + 4;
		}
	}

}
