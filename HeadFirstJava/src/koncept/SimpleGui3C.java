package koncept;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nikita on 22.7.2016.
 */
public class SimpleGui3C implements ActionListener
{
    JFrame frame;

    public static void main(String[] args)
    {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame.repaint();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }


}
