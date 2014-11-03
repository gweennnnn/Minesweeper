import java.awt.event.*;
public class SquareListener implements ActionListener
{
    private MineModel model;
    private int x;
    private int y;
    
    public SquareListener(MineModel model, int x, int y)
    {
        this.model = model;
        this.x = x;
        this.y = y;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        boolean z = model.wasItAMine(x, y);
        model.turn(x, y);
    }
}
