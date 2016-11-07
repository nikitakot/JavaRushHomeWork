package koncept;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nikita on 24.7.2016.
 */
public class SimpleAnimation
{
    int x = 70;
    int y = 70;

    public static void main(String[] args)
    {
        SimpleAnimation simpleAnimation = new SimpleAnimation();
        simpleAnimation.go();

    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for (int i = 0;i<130;i++)
        {
            x++;
            y++;
            drawPanel.repaint();

            try
            {
                Thread.sleep(50);
            }
            catch (Exception e)
            {

            }
        }

    }

    class MyDrawPanel extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.PINK);
            g.fillOval(x,y,40,40);
        }
    }
}
