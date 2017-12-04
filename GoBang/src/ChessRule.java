/*  判断规则，判断胜负
 *  创建信息：Coder-YJ @ 2017.12.02
 */
public class ChessRule  
{
	ChessPad chessPad;       //棋盘
	boolean refereeResult;
	int xPos, yPos;          //落子点的位置
	int chessManColor;       //落子点棋子颜色
	int chessManPoint[][];
	int continuePoint[][];   //落子点各方向直线上的棋子状态
	int length[]; 
	ChessRule(ChessPad chessPad) 
	{
		this.chessPad = chessPad;
		init();
	}
	
	public void init()
	{
		refereeResult = false;
		xPos = chessPad.xPos;
		yPos = chessPad.yPos;
		chessManColor = chessPad.chessManColor;
		chessManPoint = chessPad.chessManPoint;
		continuePoint = new int[4][9];
		length = new int[4];
		for(int i=0; i<4; i++)
		{
			length[i] = 0;
		}
	}
/*  函数名称：chessReferee()
 *  参数：无
 *  返回值：refereeResult 判断结果
 *  函数功能：判断棋盘上当前落子点落子方是否出现五子连珠的情况，若有，则该方胜利，返回结果为true, 否则返回 false
 *  创建信息：Coder-YJ
 */
	public Boolean chessReferee()
	{
		int sameCount = 0;
		init();
		cutPointsArray();
		for(int k=0; k<4; k++)
		{
			if(length[k] >=5)
			{
				for(int j=0; j<length[k]; j++)
				{
					if(continuePoint[k][j] == chessManColor)
					{
						sameCount ++;
						if(sameCount == 5)            //五子连珠，退出内层循环
						{
							refereeResult = true;
							break;
						}
					}
					else
					{
						sameCount = 0;
					}
				}
				if(sameCount == 5)      //五子连珠，退出外层循环，胜负判断结束
				{
					break;
				}
			}
		}
		return refereeResult;
	}
	
/*  函数名称：cutPointsArray()
 * 	参数： 无
 *  返回值：void
 *  功能：当落下棋子后，取出该棋子水平、垂直、主对角、斜对角方向上连续的十个位置点的棋子状态,并存放在四个数组中。
 *  创建信息：2017.12.3  By Coder-YJ
 */
	public void cutPointsArray()
	{
		int xStart = 0, xEnd = 0;
		int yStart = 0, yEnd = 0;      //表示截取始点和截取终点的坐标
		
		if(xPos<4)                     //计算水平、垂直方向截取点的坐标，每个方向最多十个坐标点
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
		else if(yPos > 14)
		{
			yStart = yPos - 4;
			yEnd   = 18;
		}
		else
		{
			yStart = yPos - 4;
			yEnd   = yPos + 4;
		}
		
		for(int i=xPos, j=yStart; j<=yEnd; j++)                            //取出落子点垂直方向最多连续点，最多十个点
		{
			continuePoint[0][length[0]] = chessPad.chessManPoint[i][j];
			length[0] ++;
		}
		for(int i=xStart, j=yPos; i<=xEnd; i++)
		{
			continuePoint[1][length[1]] = chessPad.chessManPoint[i][j];    //取出落子点水平方向最多连续点，最多十个点
			length[1] ++;
		}
		
		xStart = xPos;                 //重新初始化截取点坐标，对角线上需要单独处理
		xEnd   = xPos;
		yStart = yPos;
		yEnd   = yPos;
		
		for(;;)                        //获取主对角线连续点起始坐标，最多十个点
		{
			if((xStart)>0 && yStart>0)
			{
				;
			}
			else
			{
				break;
			}
			
			if((xPos-xStart) >= 4 || (yPos-yStart) >= 4)
			{
				break;
			}
			xStart -- ;
			yStart -- ;
		}
		for(;;)                        //获取主对角线连续点结束坐标，最多十个点
		{
			if( (xEnd)<18 && yEnd<18)
			{
				;
			}
			else
			{
				break;
			}
			if((xEnd-xPos) >= 4 || (yEnd-yPos)>=4)
			{
				break;
			}
			xEnd ++ ;
			yEnd ++ ;
		}
		for(int i=xStart, j=yStart; (i<=xEnd && j<=yEnd) ; i++,j++)   //截取出落子点主对角线上的连续点
		{
			continuePoint[2][length[2]] = chessPad.chessManPoint[i][j];
			length[2] ++;
		}		
		
		xStart = xPos;
		xEnd   = xPos;
		yStart = yPos;
		yEnd   = yPos;
		
		for(;;)                        //获取副对角线连续点起始坐标，最多十个点
		{
			if( (xStart)>0 && yStart<18)
			{
				;
			}
			else
			{
				break;
			}
			if((xPos-xStart) >= 4 || (yStart - yPos) >= 4)
			{
				break;
			}
			xStart -- ;
			yStart ++ ;
		}
		for(;;)                        //获取副对角线连续点结束坐标，最多十个点
		{
			if( (xEnd)<18 && yEnd>0)
			{
				;
			}
			else
			{
				break;
			}
			if((xEnd-xPos) >= 4 || (yPos-yEnd) >= 4)
			{
				break;
			}
			xEnd ++ ;
			yEnd -- ;
		}
		for(int i=xStart, j=yStart; (i<=xEnd && j>=yEnd) ; i++,j--)       //截取出落子点主副角线上的连续点
		{
			continuePoint[3][length[3]] = chessPad.chessManPoint[i][j];
			length[3] ++;
		}
		
		
//		for(int i=0; i<4; i++)
//		{
//			System.out.print("length[" + i + "]");;
//			for(int j=0; j<length[i]; j++)
//			{
//				System.out.print("  "+continuePoint[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("xPos: " + xPos + "  yPos: " + yPos);
	}

}
