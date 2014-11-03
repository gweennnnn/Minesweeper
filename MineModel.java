import java.util.Observable;
public class MineModel extends Observable
{
    private MineSweeper minesweeper;
    
    public MineModel(MineSweeper minesweeper)
    {
        super();
        this.minesweeper = minesweeper;
    }
    
    public int get(int x, int y)
    {
        return minesweeper.get(x, y);
    }
    
    public int getPublic(int x, int y)
    {
        return minesweeper.getPublic(x, y);
    }
    
    public void turn(int x, int y)
    {
        minesweeper.setPublic(x, y);
        setChanged();
        notifyObservers();
    }
    
    public boolean wasItAMine(int x, int y)
    {
        if(minesweeper.wasItAMine(x, y))
        {
            minesweeper.failedGame();
            setChanged();
            notifyObservers();
            return true;
        }
        return false;
    }
    
    public int boardSize()
    {
        return minesweeper.boardSize();
    }
    
    public void increaseDifficulty(int mines)
    {
        minesweeper.setNoOfMines(mines);
        reset();
    }
    
    public void reset()
    {
        minesweeper.newGame();
        setChanged();
        notifyObservers();
    }
    
    public int score()
    {
        return minesweeper.score();
    }
}
