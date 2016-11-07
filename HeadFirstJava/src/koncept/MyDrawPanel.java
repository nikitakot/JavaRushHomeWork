package koncept;

import javax.swing.*;

/**
 * Created by Nikita on 20.7.2016.
 */
import java.awt.*;
import javax.swing.*;
public class MyDrawPanel extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math .random() * 255);
        int green= (int) (Math .random() * 255);
        int blue= (int) (Math .random() * 255);
        Color startColor = new Color(red, green, blue);

        GradientPaint gradient= new GradientPaint(70 ,70,startColor, 150,150, Color.orange);
        g2d.setPaint(gradient);
        g2d.fillOval(70,70,100,100);
    }

    /*public static void main(String[] args)
    {
        MyDrawPanel panel = new MyDrawPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);

        frame.setSize(600, 300);
        frame.setVisible(true);
    }*/
}
