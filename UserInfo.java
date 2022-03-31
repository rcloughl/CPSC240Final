import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class UserInfo {
    private File file;


    public UserInfo(File file){
        JFrame frame = new JFrame("Account Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();

        JButton b1 = new JButton("Check Accounts");
        JButton b2 = new JButton("Make Deposit");
        JButton b3 = new JButton("Make Withdrawal");
        JButton b4 = new JButton("Pay Balance Due");
        JLabel l1= new JLabel("Hello, what would you like to do?");

        l1.setBounds(5,0,300,40);
        b1.setBounds(5,40,135,80);
        b2.setBounds(145,40,135,80);
        b3.setBounds(5,130,135,80);
        b4.setBounds(145,130,135,80);

        contentPane.setLayout(null);
        contentPane.add(l1);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(b4);

        frame.setSize(300,260);
        frame.setVisible(true);

        b1.addActionListener(e -> {
        });

        b2.addActionListener(e -> {
        });

        b3.addActionListener( e -> {
        });

        b4.addActionListener( e -> {
        });

    }
}