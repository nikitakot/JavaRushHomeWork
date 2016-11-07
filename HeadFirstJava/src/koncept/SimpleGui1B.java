package koncept;

/**
 * Created by Nikita on 19.7.2016.
 */

import javax.swing.*;
import java.awt.event.*;
public class SimpleGui1B implements ActionListener
{
    JButton button;

    public static void main(String[] args)
    {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("pisos");
        button.addActionListener(this);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        button.setText("sosi");
        new MiniMiniMusicApp().play();
    }
}
