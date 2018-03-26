/*  �жϹ����ж�ʤ��
 *  ������Ϣ��Coder-YJ @ 2017.12.02
 */
public class ChessRule  
{
	ChessPad chessPad;       //����
	boolean refereeResult;
	int xPos, yPos;          //���ӵ��λ��
	int chessManColor;       //���ӵ�������ɫ
	int chessManPoint[][];
	int continuePoint[][];   //���ӵ������ֱ���ϵ�����״̬
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
/*  �������ƣ�chessReferee()
 *  ��������
 *  ����ֵ��refereeResult �жϽ��
 *  �������ܣ��ж������ϵ�ǰ���ӵ����ӷ��Ƿ���������������������У���÷�ʤ�������ؽ��Ϊtrue, ���򷵻� false
 *  ������Ϣ��Coder-YJ
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
						if(sameCount == 5)            //�������飬�˳��ڲ�ѭ��
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
				if(sameCount == 5)      //�������飬�˳����ѭ����ʤ���жϽ���
				{
					break;
				}
			}
		}
		return refereeResult;
	}
	
/*  �������ƣ�cutPointsArray()
 * 	������ ��
 *  ����ֵ��void
 *  ���ܣ����������Ӻ�ȡ��������ˮƽ����ֱ�����Խǡ�б�ԽǷ�����������ʮ��λ�õ������״̬,��������ĸ������С�
 *  ������Ϣ��2017.12.3  By Coder-YJ
 */
	public void cutPointsArray()
	{
		int xStart = 0, xEnd = 0;
		int yStart = 0, yEnd = 0;      //��ʾ��ȡʼ��ͽ�ȡ�յ������
		
		if(xPos<4)                     //����ˮƽ����ֱ�����ȡ������꣬ÿ���������ʮ�������
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
		
		for(int i=xPos, j=yStart; j<=yEnd; j++)                            //ȡ�����ӵ㴹ֱ������������㣬���ʮ����
		{
			continuePoint[0][length[0]] = chessPad.chessManPoint[i][j];
			length[0] ++;
		}
		for(int i=xStart, j=yPos; i<=xEnd; i++)
		{
			continuePoint[1][length[1]] = chessPad.chessManPoint[i][j];    //ȡ�����ӵ�ˮƽ������������㣬���ʮ����
			length[1] ++;
		}
		
		xStart = xPos;                 //���³�ʼ����ȡ�����꣬�Խ�������Ҫ��������
		xEnd   = xPos;
		yStart = yPos;
		yEnd   = yPos;
		
		for(;;)                        //��ȡ���Խ�����������ʼ���꣬���ʮ����
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
		for(;;)                        //��ȡ���Խ���������������꣬���ʮ����
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
		for(int i=xStart, j=yStart; (i<=xEnd && j<=yEnd) ; i++,j++)   //��ȡ�����ӵ����Խ����ϵ�������
		{
			continuePoint[2][length[2]] = chessPad.chessManPoint[i][j];
			length[2] ++;
		}		
		
		xStart = xPos;
		xEnd   = xPos;
		yStart = yPos;
		yEnd   = yPos;
		
		for(;;)                        //��ȡ���Խ�����������ʼ���꣬���ʮ����
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
		for(;;)                        //��ȡ���Խ���������������꣬���ʮ����
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
		for(int i=xStart, j=yStart; (i<=xEnd && j>=yEnd) ; i++,j--)       //��ȡ�����ӵ����������ϵ�������
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
