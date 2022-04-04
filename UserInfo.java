import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

import static java.awt.Color.GREEN;


public class UserInfo {


    private ArrayList<String> data = new ArrayList<>();

    public UserInfo(File file) throws FileNotFoundException {
        JFrame frame = new JFrame("Account Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scanner scan = new Scanner(file);

        while (scan.hasNext()){
            data.add(scan.nextLine());
        }


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
            ArrayList<String> checking = showTransaction(data,"*");
            JFrame menu = new JFrame("Checking");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setSize(300,260);
            menu.setVisible(true);
            GridLayout grid = new GridLayout(20, 0,0,0);
            JPanel panel = new JPanel(grid);
            JLabel l2 = new JLabel("Transactions:");
            panel.add(l2);
            panel.setBounds(30,30,40,230);
            for (String i : checking){
                if (i.startsWith("-")) {
                    JLabel trans = new JLabel(i);
                    trans.setSize(5, 1);
                    panel.add(trans);
                }
                else
                {
                    JLabel trans = new JLabel(i);
                    trans.setSize(5, 1);
                    panel.add(trans);
                }
            }
            menu.add(panel);
        });

        b2.addActionListener(e -> {

        });

        b3.addActionListener( e -> {
        });

        b4.addActionListener( e -> {
        });

    }
    public ArrayList<String> showTransaction(ArrayList<String> data, String i ){
        ArrayList<String> trans = new ArrayList<>();
        int count=0;
        for ( String x : data) {
            if (count==1 && !x.equals(i)){
                trans.add(x);
            }
            if (x.equals(i)) {
                count++;
            }
            if(count == 2)
                break;
        }
        return trans;
    }

    public void deposit(ArrayList<String> data){


    }
}