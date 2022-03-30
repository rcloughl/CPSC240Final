import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login {
    public Login(){
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();

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
        label.setBounds(50,100,100,20);
        textField.setBounds(150, 100, 100,20);
        label2.setBounds(50,140,100,20);
        pw.setBounds(150,140, 100,20);
        b1.setBounds(100,190,80,20);
        l3.setBounds(60,215,200,20);
        b2.setBounds(100,240,80,20);
        contentPane.setLayout(null);
        contentPane.add(label2);
        contentPane.add(pw);
        contentPane.add(b1);
        contentPane.add(l3);
        contentPane.add(b2);


        frame.setSize(300,400);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        Login log = new Login();
    }
}