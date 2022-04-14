import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.*;

class PopUp{
    public PopUp(){
        JFrame frame = new JFrame();
        frame.setSize(250,150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Do you want to login now?");
        JButton button1 = new JButton("Yes");
        JButton button2 = new JButton("Exit");
        Container container = frame.getContentPane();
        label1.setBounds(40,30,200,20);
        button1.setBounds(40,60,60,20);
        button2.setBounds(120,60,60,20);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1){
                    new Login();
                    frame.dispose();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button2){
                    frame.dispose();
                }
            }
        });

        container.add(label1);
        container.add(button1);
        container.add(button2);
        container.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        PopUp o = new PopUp();
    }
}