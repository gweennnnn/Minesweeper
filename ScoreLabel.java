import javax.swing.JLabel;
import java.util.Observable;
import java.util.Observer;
public class ScoreLabel extends JLabel implements Observer
{
    private MineModel model;
    
    public ScoreLabel(MineModel model)
    {
            super();

            this.model = model;
            double score = model.score();
            setText("Score: " + score);
    }

    @Override
    public void update(Observable o, Object o1)
    {
        double score = model.score();
        setText("Score: " + score);
    }
}
