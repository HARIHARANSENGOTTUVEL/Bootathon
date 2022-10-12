package page;
import pages.*;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Form extends JFrame
{
    Label l1, l2;
    TextField t1, t2, t3;
    Button b1, b2, b3;
    String name, password,command;
    Form()
    {
    	setFont(new Font("Dialog", Font.BOLD, 20));
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\S.HARIHARAN\\Downloads\\images.png"));
    	setTitle("Login");
    	getContentPane().setBackground(new Color(64, 128, 128));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new Label("Name");
        l1.setFont(new Font("Dialog", Font.BOLD, 18));
        l1.setForeground(new Color(255, 255, 255));
        l1.setBackground(new Color(64, 128, 128));
        l2 = new Label("Password");
        l2.setFont(new Font("Dialog", Font.BOLD, 18));
        l2.setBackground(new Color(64, 128, 128));
        l2.setForeground(new Color(255, 255, 255));
        t1 = new TextField();
        t2 = new TextField();
        b1 = new Button("Forgot Password");
        b1.setFont(new Font("Dialog", Font.BOLD, 12));
        b3 = new Button("SignUp");
        b3.setFont(new Font("Dialog", Font.BOLD, 12));
        t1.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                name = t1.getText();
            }
        });
        t2.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                password = t2.getText();
            }
        });
        t2.setEchoChar('*');
        b2 = new Button("Login");
        b2.setFont(new Font("Dialog", Font.BOLD, 12));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(login.check(name, password))
                {
                	JOptionPane.showMessageDialog(null, "Login Successfull");
                	mainPage.main(null);
                	dispose();
                }
                else
                {
                	JOptionPane.showMessageDialog(null, "Try again");
                }
                t1.setText("");
                t2.setText("");
            }
        });
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                //new forgot();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                singup.main(null);
            }
        });
        l1.setBounds(400, 200, 200, 30);
        l2.setBounds(400, 250, 200, 30);
        t1.setBounds(600, 200, 200, 30);
        t2.setBounds(600, 250, 200, 30);
        b1.setBounds(600, 300, 100, 25);
        b2.setBounds(600, 400, 100, 25);
        b3.setBounds(600, 500, 100, 25);
        
        getContentPane().add(l1); getContentPane().add(l2); getContentPane().add(t1); getContentPane().add(t2); getContentPane().add(b1); getContentPane().add(b2); getContentPane().add(b3);
 
 Label l1_1 = new Label("Login Here");
 l1_1.setForeground(Color.WHITE);
 l1_1.setFont(new Font("Dialog", Font.BOLD, 18));
 l1_1.setBackground(new Color(64, 128, 128));
 l1_1.setBounds(500, 84, 200, 36);
 getContentPane().add(l1_1);
        setSize(1280, 720);
        setBackground(Color.white);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Form();
    }
}