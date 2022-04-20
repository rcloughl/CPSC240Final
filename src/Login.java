import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Login {
    public Login(){
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();

        JPanel panel = new JPanel();
        panel.setBounds(100, 5, 80, 80);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("aa1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(img));
        panel.add(picLabel);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        JLabel timeLabel = new JLabel("Local Time: ");
        JLabel time = new JLabel(dtf.format(now));


        JLabel label = new JLabel("Username: ");
        JTextField textField = new JTextField(15);
        contentPane.add(label);
        contentPane.add(textField);
        JLabel label2 = new JLabel("Password: ");
        JPasswordField pw = new JPasswordField(16);
        JButton b1 = new JButton("Login");
        JLabel l3 = new JLabel();
        l3.setFont(new Font("New user? Create account to continue",Font.ITALIC,10));
        l3.setText("New user? Create account to continue");
        JButton b2 = new JButton("Signup");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
                frame.dispose();
            }


        });

        b1.addActionListener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                     File directory = new File("userInfo");
                                     File[] deckList = directory.listFiles();
                                     assert deckList != null;
                                     for (File file : deckList) {
                                         Scanner scan = null;
                                         try {
                                             scan = new Scanner(file);
                                             assert scan != null;
                                             String fLine = scan.nextLine();
                                             String sLine = scan.nextLine();
                                             String userName = textField.getText();
                                             String passWord = String.valueOf(pw.getPassword());
                                             if (fLine.equals(userName) && sLine.equals(passWord)) {
                                                 new UserInfo(file);
                                                 frame.dispose();
                                                 break;
                                             }
                                         } catch (FileNotFoundException ex) {
                                             ex.printStackTrace();
                                         }
                                     }
                                 }
                             }
                    );

        time.setBounds(70, 105, 150, 20);
        timeLabel.setBounds(100, 90, 100, 20);
        label.setBounds(50,150,100,20);
        textField.setBounds(150, 150, 100,20);
        label2.setBounds(50,190,100,20);
        pw.setBounds(150,190, 100,20);
        b1.setBounds(100,240,80,20);
        l3.setBounds(60,265,200,20);
        b2.setBounds(100,290,80,20);
        contentPane.setLayout(null);
        contentPane.add(time);
        contentPane.add(timeLabel);
        contentPane.add(label2);
        contentPane.add(pw);
        contentPane.add(b1);
        contentPane.add(l3);
        contentPane.add(b2);
        frame.add(panel);

        frame.setSize(300,400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Login l = new Login();
    }
}