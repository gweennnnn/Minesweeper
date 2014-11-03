
import java.util.Random;

public class MineSweeper
{
    private int boardsize;
    private int[][] board;
    private int[][] publicBoard;
    public static final int BLANK = 0;
    public static final int MINE = 9;
    public static final int UNEXPLORED = 222;
    public static final int FAILED = 999;
    private Random rand;
    private int noOfMines;
    private int score;
    
    public MineSweeper()
    {
        this.score = 0;
        this.noOfMines = 10;
        this.rand = new Random();
        this.boardsize = 10;
        this.board = new int[boardsize][boardsize];
        this.publicBoard = new int [boardsize] [boardsize];
        
        setMines();
        setBoard();
    }
    
    private void setBoard()
    {
        for(int i = 0; i < boardsize; i++)
        {
            for(int j = 0; j < boardsize; j++)
            {
                this.publicBoard[i][j] = UNEXPLORED;
                
                if(this.board[i][j] != MINE)
                {
                    int mines = countSurroundingMines(i, j);
                    this.board[i][j] = mines;
                }
            }
        }
    }
    
    private int countSurroundingMines(int x, int y)
    {
        int count = 0;
        if((x + 1) < boardsize && this.board[x+1][y] == MINE)
            count++;
        if((x - 1) >= 0 && this.board[x-1][y] == MINE)
            count++;
        if((y + 1) < boardsize && this.board[x][y+1] == MINE)
            count++;
        if((y - 1) >= 0 && this.board[x][y-1] == MINE)
            count++;
        if((y + 1) < boardsize && (x + 1) < boardsize && this.board[x+1][y+1] == MINE)
            count++;
        if((y - 1) >= 0 && (x-1) >= 0 && this.board[x-1][y-1] == MINE)
            count++;
        if((x + 1) < boardsize && (y - 1) >= 0 && this.board[x+1][y-1] == MINE)
            count++;
        if((x - 1) >= 0 && (y + 1) < boardsize && this.board[x-1][y+1] == MINE)
            count++;
        return count;
    }
    
    private void setMines()
    {
        for(int i = 0; i < this.noOfMines; i++)
        {
            int mineXVal = rand.nextInt(boardsize);
            int mineYVal = rand.nextInt(boardsize);
            while(board[mineXVal][mineYVal] == MINE)
            {
                mineXVal = rand.nextInt(boardsize);
                mineYVal = rand.nextInt(boardsize);
            }
            
            board[mineXVal][mineYVal] = MINE;
        }
    }
    
    public void setNoOfMines(int noOfMines)
    {
        this.noOfMines = noOfMines;
    }
    
    public void wipeBoard()
    {
        
        for(int i = 0; i < boardsize; i++)
        {
            for(int j = 0; j < boardsize; j++)
                board[i][j] = 0;
        }
    }
    
    public void newGame()
    {
        score = 0;
        wipeBoard();
        setMines();
        setBoard();
    }
    
    public int get(int x, int y)
    {
        return board[x][y];
    }
    
    public int getPublic(int x, int y)
    {
        return this.publicBoard[x][y];
    }
    
    public void setPublic(int x, int y)
    {
        if(this.board[x][y] != MINE)
            score++;
        this.publicBoard[x][y] = this.board[x][y];
    }
    
    public boolean wasItAMine(int x, int y)
    {
        if(this.board[x][y] == MINE)
        {
            return true;
        }
        return false;
    }
    
    public int boardSize()
    {
        return this.boardsize;
    }
    
    public String toString()
    {
        String returnStr = "";
        for(int i = 0; i < this.boardsize; i++)
        {
            for(int j = 0; j < this.boardsize; j++)
            {
                returnStr = returnStr + "| " + this.board[i][j] + " ";
            }
            returnStr = returnStr + "\n";
        }
        return returnStr;
    }
    
    public void failedGame()
    {
        for(int i = 0; i < this.boardsize; i++)
        {
            for(int j = 0; j < this.boardsize; j++)
            {
                if(this.board[i][j] == MINE)
                    this.publicBoard[i][j] = MINE;
                else
                    this.publicBoard[i][j] = FAILED;
            }
        }
    }
    
    public int score()
    {
        return this.score;
    }
}
