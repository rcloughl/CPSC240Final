import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserInfo {


    private ArrayList<String> data = new ArrayList<>();

    private ArrayList<String> checking = new ArrayList<>();
    private ArrayList<String> saving = new ArrayList<>();
    private ArrayList<String> credit = new ArrayList<>();

    public UserInfo(File file) throws FileNotFoundException {
        JFrame frame = new JFrame("Account Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Scanner scan = new Scanner(file);

        while (scan.hasNext()){
            data.add(scan.nextLine());
        }

        int count =0;
        for (String line : this.data){
            if (line.equals("*")){
                count++;
            }
            else
                if (line.equals("&")){
                    count++;
                }
                else
                    if (line.equals("/")){
                        count++;
                    }
                    else
                        if(count==1){
                            checking.add(line);
                        }
                        else
                            if(count==3){
                                saving.add(line);
                            }
                            else
                                if(count==5){
                                    credit.add(line);
                                }
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

            accountChanges(1,"0");


        });

        b2.addActionListener(e -> {
            deposit();
        });

        b3.addActionListener( e -> {
            withdraw();
        });

        b4.addActionListener( e -> {
            payBalanceDue();
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

    public void deposit(){
        JFrame make_deposit = new JFrame ("Make Deposit");
        make_deposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content_pane = make_deposit.getContentPane();
        make_deposit.setSize(300, 260);
        JLabel label = new JLabel("Enter deposit amount: ");
        content_pane.add(label);
        JButton button = new JButton("Deposit");
        content_pane.add(button);
        JTextField deposit_field = new JTextField(1);
        content_pane.add(deposit_field);
        button.setBounds(90, 150, 100, 20);
        label.setBounds(70,50,200,20);
        deposit_field.setBounds(90, 100, 100,20);
        content_pane.setLayout(null);
        make_deposit.setVisible(true);


        button.addActionListener(e -> {
            accountChanges(2, deposit_field.getText());
            make_deposit.dispose();
        });




    }

    public void withdraw(){
        JFrame frame = new JFrame("Withdraw");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container content_pane = frame.getContentPane();
        frame.setSize(300, 260);
        JLabel label = new JLabel("Enter withdrawal amount: ");
        content_pane.add(label);
        JButton button = new JButton("Withdraw");
        content_pane.add(button);
        JTextField withdraw_field = new JTextField(1);
        content_pane.add(withdraw_field);
        button.setBounds(90, 150, 100, 20);
        label.setBounds(80,50,200,20);
        withdraw_field.setBounds(90, 100, 100,20);
        content_pane.setLayout(null);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountChanges(2, "-"+withdraw_field.getText());
                frame.dispose();
            }
        });
    }
    public void accountChanges(int route, String money){

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Which account would you like to view?");
        JButton button1 = new JButton("Checking");
        JButton button2 = new JButton("Savings");
        JButton button3 = new JButton("Credit");
        Container container = frame.getContentPane();
        label1.setBounds(20, 30, 260, 20);
        button1.setBounds(0, 60, 90, 20);
        button2.setBounds(96, 60, 90, 20);
        button3.setBounds(192,60,90,20);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    String account="Checking";
                    String symbol="*";
                    if (route==1){
                        showTransaction(account,symbol);
                    }
                    else
                    {
                        checking.add(0,money);
                    }
                    save();
                    frame.dispose();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button2) {
                    String account="Savings";
                    String symbol="&";
                    if (route==1){
                        showTransaction(account,symbol);
                    }
                    else
                    {
                        saving.add(0,money);
                    }
                    save();
                    frame.dispose();
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button3){
                    String account="Credit";
                    String symbol="/";
                    if (route==1){
                        showTransaction(account,symbol);
                    }
                    else
                    {
                        credit.add(0,money);
                    }
                    save();
                    frame.dispose();
                }
            }
        });

        container.add(label1);
        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.setLayout(null);
        frame.setVisible(true);
    }

    public void showTransaction(String name, String type){
        ArrayList<String> info = showTransaction(data,type);
        JFrame menu = new JFrame(name);
        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setSize(300,260);
        menu.setVisible(true);
        GridLayout grid = new GridLayout(20, 0,0,0);
        JPanel panel = new JPanel(grid);
        JLabel l2 = new JLabel("Transactions:");
        panel.add(l2);
        panel.setBounds(30,30,40,230);
        for (String i : info){
            if (i.startsWith("-")) {
                JLabel trans = new JLabel(i);
                trans.setForeground(Color.red);
                trans.setSize(5, 1);
                panel.add(trans);
            }
            else
            {
                JLabel trans = new JLabel(i);
                trans.setForeground((Color.green));
                trans.setSize(5, 1);
                panel.add(trans);
            }
        }
        menu.add(panel);
    }

    public double creditDue(){
        double runningTotal=0;
        for ( String line : credit){
            runningTotal+=Double.parseDouble(line);
        }
        double temp = (runningTotal*100);
        int temp1= (int) temp;
        runningTotal=temp1/100;
        if (runningTotal>0){
            return 0;
        }
        else
        {
            runningTotal=0-runningTotal;
            return runningTotal;
        }

    }

    public void payBalanceDue(){

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Minimum Balance Due: " + (creditDue()*.1));
        JLabel label2 = new JLabel("Total amount owed: " + creditDue());
        Container contentPane = frame.getContentPane();

        JButton b1 = new JButton("Pay Minimum");
        JButton b2 = new JButton("Pay Current Balance");
        JButton b3 = new JButton("Pay Other Amount");

        label1.setBounds(5,0,300,40);
        label2.setBounds(0,35,300,40);
        b1.setBounds(150,40,135,80);
        b2.setBounds(5,130,135,80);
        b3.setBounds(150,130,135,80);

        contentPane.setLayout(null);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);

        frame.setSize(300,260);
        frame.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Minimum due");
                Container contentPane = frame.getContentPane();
                double cred = creditDue() * .1;
                if(cred == 0){
                    JLabel label = new JLabel("Nothing is owed so no minimum can be paid!");
                    label.setBounds(25,100,350,20);
                    contentPane.add(label);
                } else {
                    JLabel label = new JLabel(cred + "$ was the minimum payable which has now been paid.");
                    label.setBounds(25,100,350,20);
                    contentPane.add(label);
                    checking.add(0,String.valueOf(-cred));
                    credit.add(0,String.valueOf(cred));
                    save();
                }
                contentPane.setLayout(null);
                frame.setSize(400,300);
                frame.setVisible(true);
            }
        });


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cred = creditDue();
                frame.dispose();
                JFrame frame = new JFrame("Current Balance Payment");
                Container contentPane = frame.getContentPane();
                if(cred == 0){
                    JLabel label = new JLabel("Nothing is owed!");
                    label.setBounds(25,100,350,20);
                    contentPane.add(label);
                } else {
                    JLabel label = new JLabel(cred + "$ was your balance which is now paid.");
                    label.setBounds(25,100,350,20);
                    contentPane.add(label);
                    checking.add(0,String.valueOf(-cred));
                    credit.add(0,String.valueOf(cred));
                    save();
                }
                contentPane.setLayout(null);
                frame.setSize(400,300);
                frame.setVisible(true);

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Pay Other Amount");
                Container contentPane = frame.getContentPane();
                JLabel label = new JLabel("Enter how much you would like to pay:");
                JTextField text = new JTextField(15);
                JButton button = new JButton("Pay Amount");


                contentPane.setLayout(null);
                contentPane.add(button);
                button.setBounds(95, 80, 100, 20);
                contentPane.add(text);
                text.setBounds(95, 50, 100, 20);
                label.setBounds(25,25,350,20);
                contentPane.add(label);
                frame.setSize(300,200);
                frame.setVisible(true);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = text.getText();
                        double numb = Double.parseDouble(num);
                        checking.add(0,String.valueOf(-numb));
                        credit.add(0, String.valueOf(numb));
                        save();
                        frame.dispose();
                    }
                });

            }
        });

    }

    public void save(){
        String fileName = "userInfo/"+data.get(0)+".info";
        File fold= new File(fileName);
        fold.delete();
        File newFold = new File(fileName);
        String source="";
        source+=this.data.get(0)+"\n";
        source+=this.data.get(1)+"\n";
        source+="*\n";
        for (String info : checking){
            source+=info+"\n";
        }
        source+="*\n&\n";
        for (String info : saving){
            source+=info+"\n";
        }
        source+="&\n/\n";
        for (String info : credit){
            source+=info+"\n";
        }
        source+="/\n";
        source+=data.get(data.lastIndexOf("/")+1);
        data.clear();
        Scanner replace = new Scanner(source);
        while (replace.hasNext()){
            data.add(replace.nextLine());
        }

        try{
            FileWriter f2 = new FileWriter(newFold,false);
            f2.write(source);
            f2.close();
        }
        catch( IOException e){
            System.out.println("Try again.");
        }
    }
}