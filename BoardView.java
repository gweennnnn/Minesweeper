import javax.swing.*;
import java.awt.*;
import java.util.*;
public class BoardView extends JPanel implements Observer
{
        private MineModel model;
	private JButton[][] cell;
        public BoardView(MineModel model)
        {
            super();
            this.model = model;
            int size = model.boardSize();
            cell = new JButton[size][size];
            setLayout( new GridLayout(size, size) );
            
            for(int i = 0; i < size; i++)
            {
                for(int j = 0; j < size; j++)
                {
                    cell[i][j] = new JButton(" ");
				
				cell[i][j].addActionListener(
					new SquareListener(model, i, j));
				
				add(cell[i][j]);
                }
            }
        }
        
        public void update(Observable obs, Object obj)
        {
            int boardsize = model.boardSize();
            for(int i = 0; i < boardsize; i++)
            {
                for(int j = 0; j < boardsize; j++)
                {
                    if(model.getPublic(i, j) == MineSweeper.MINE)
                    {
                        cell[i][j].setText("X");
                        cell[i][j].setEnabled(false);
                        cell[i][j].setBackground(Color.RED);
                    }
                    else if (model.getPublic(i, j) != MineSweeper.UNEXPLORED)
                    {
                        cell[i][j].setText(Integer.toString(model.get(i, j)));
                        cell[i][j].setEnabled(false);
                        cell[i][j].setBackground(Color.YELLOW);
                    }
                    else if (model.getPublic(i, j) == MineSweeper.FAILED)
                    {
                        cell[i][j].setEnabled(false);
                    }
                    else
                    {
                        cell[i][j].setEnabled(true);
                        cell[i][j].setBackground(UIManager.getColor ( "Panel.background" ));
                        cell[i][j].setText("");
                    }
                }
            }
        }
}
