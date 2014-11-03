import javax.swing.JPanel;
import java.awt.BorderLayout;
public class MineComponent extends JPanel
{
    public MineComponent()
    {
        super();
        MineSweeper minesweeper = new MineSweeper();
        System.out.println(minesweeper);
        MineModel model = new MineModel(minesweeper);
        
        BoardView view = new BoardView(model);
        model.addObserver(view);
        
        
        setLayout( new BorderLayout() );
        this.add(view, BorderLayout.CENTER);
        ControlPanel panel = new ControlPanel(model);
        this.add(panel, BorderLayout.SOUTH);
    }
}
