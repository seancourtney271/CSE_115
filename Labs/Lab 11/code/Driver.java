package code;

import javax.swing.*;
import java.awt.*;

public class Driver{


    public static void startGUI(){
        GUI instance = new GUI();

        JFrame frame = new JFrame("CSE115: Chat Lab");

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(instance.getChatPanel());
        frame.getContentPane().add(instance.getControlPanel());

        for(Component c : frame.getContentPane().getComponents()){
            c.setBackground(Color.getHSBColor(0.55f,0.15f,0.95f));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                startGUI();
                
            }
        });
    }

}
