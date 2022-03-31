import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.*;
public class SignUp {
    private String userFileName;
    private ArrayList<String> userInfo;


    public void setUserFileName(String userFileName){
        this.userFileName= userFileName;
    }

    public String getUserFileName(){
        return userFileName;
    }
    public String getUserName(){
        return userInfo.get(0);
    }
    public String getPassWord(){
        return userInfo.get(1);
    }
    public int getInitialDeposit(){
        String deposit = userInfo.get(2);
        int deposit1 = Integer.parseInt(deposit);
        return deposit1;
    }
    public int getAnnualSalary(){
        String annual = userInfo.get(3);
        int annualSalary = Integer.parseInt(annual);
        return annualSalary;
    }

    public void save(PrintWriter pw){
        pw.println(getUserName());
        pw.println(getPassWord());
        pw.println(getInitialDeposit());
        pw.println(getAnnualSalary());
    }
    //
    public void saveInfo() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(getUserFileName()));
        save(pw);
        pw.close();
    }

    public void createDir(){
        File file = new File("./userInfo/");
        if (file.exists()){
            System.out.println();
        }else{
            file.mkdir();
        }
    }

    public void createUserInfo(){
        createDir();
        setUserFileName("./userInfo/" + getUserName() + ".info");
        try {
            saveInfo();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("User " + getUserFileName() + " was created." );
    }

    public SignUp(){
        JFrame frame = new JFrame("Sign up");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        JLabel l1 = new JLabel("Enter Username: ");
        JLabel l2 = new JLabel("Enter Password: ");
        JLabel l3 = new JLabel("Initial Deposit: ");
        JLabel l4 = new JLabel("Annual Salary: ");
        JTextField uNameTf = new JTextField(16);
        JTextField pwTf = new JTextField(16);
        JTextField initialDTf = new JTextField(16);
        JTextField annualSTf = new JTextField(16);
        JButton createB = new JButton("Create");
        l1.setBounds(40,40,150,20);
        uNameTf.setBounds(145,43,100,20);
        l2.setBounds(40,80,150,20);
        pwTf.setBounds(145,83,100,20);
        l3.setBounds(40,120,150,20);
        initialDTf.setBounds(145,123,100,20);
        l4.setBounds(40,160,150,20);
        annualSTf.setBounds(145,163,100,20);
        createB.setBounds(90,250,100,20);
        userInfo = new ArrayList<>();
        createB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInfo.add(uNameTf.getText());
                userInfo.add(pwTf.getText());
                userInfo.add("*");
                userInfo.add(initialDTf.getText());
                userInfo.add("*");
                userInfo.add(annualSTf.getText());
                createUserInfo();
                new Login();
                frame.dispose();
            }
        });
        container.setLayout(null);
        container.add(l1);
        container.add(uNameTf);
        container.add(l2);
        container.add(pwTf);
        container.add(l3);
        container.add(initialDTf);
        container.add(l4);
        container.add(annualSTf);
        container.add(createB);
        frame.setVisible(true);

    }
}