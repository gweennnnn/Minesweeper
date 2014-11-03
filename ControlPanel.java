
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ControlPanel extends JPanel
{
    public ControlPanel(final MineModel model)
    {
        JButton easy = new JButton("Easy");
        JButton normal = new JButton("Normal");
        JButton hard = new JButton("Hard");
        JButton reveal = new JButton("Reveal");
        JButton reset  = new JButton("Reset");
        JButton exit = new JButton("Exit");
        ScoreLabel score = new ScoreLabel(model);
        model.addObserver(score);
        
        easy.addActionListener(
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                model.increaseDifficulty(10);
                            }
                        }
                );
        
        normal.addActionListener(
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                model.increaseDifficulty(15);
                            }
                        }
                );
        
        hard.addActionListener(
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                model.increaseDifficulty(20);
                            }
                        }
                );
        
        reveal.addActionListener(
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                int boardsize = model.boardSize();
                                
                                for(int i = 0; i < boardsize; i++)
                                {
                                    for(int j = 0; j < boardsize; j++)
                                            model.turn(i, j);
                                }
                            }
                            
                        }
                );
        
        reset.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.reset();
				}
			});
        
        exit.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
        
        this.add(score);
        this.add(easy);
        this.add(normal);
        this.add(hard);
        this.add(reveal);
        this.add(reset);
        this.add(exit);
        
    }
}
