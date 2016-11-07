package koncept;

/**
 * Created by Nikita on 19.7.2016.
 */
import javax.swing.*;

public class SimpleGui1
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("pisos");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
