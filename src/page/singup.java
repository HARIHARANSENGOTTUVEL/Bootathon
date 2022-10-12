package page;
import pages.*;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class singup extends JFrame
{
    Label l1, l2,l3,l4,l5;
    TextField t1, t2, t3,t4,t5;
    Button b1, b2;
    String username, password, number, emailid, age;
    private Label l1_1;
    singup()
    {
    	setFont(new Font("Dialog", Font.BOLD, 18));
    	setTitle("Sign Up");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\S.HARIHARAN\\Downloads\\images.png"));
    	getContentPane().setBackground(new Color(64, 128, 128));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1 = new Label("Name");
        l1.setFont(new Font("Dialog", Font.BOLD, 14));
        l1.setForeground(new Color(255, 255, 255));
        l2 = new Label("Age");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Dialog", Font.BOLD, 14));
        l3 = new Label("PhoneNumber");
        l3.setForeground(new Color(255, 255, 255));
        l3.setFont(new Font("Dialog", Font.BOLD, 14));
        l4 = new Label("Email Id");
        l4.setForeground(new Color(255, 255, 255));
        l4.setFont(new Font("Dialog", Font.BOLD, 14));
        l5 = new Label("Password");
        l5.setForeground(new Color(255, 255, 255));
        l5.setFont(new Font("Dialog", Font.BOLD, 14));
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        t5 = new TextField();
        b1 = new Button("Sign Up");
        b1.setFont(new Font("Dialog", Font.BOLD, 12));
        b2 = new Button("Login");
        b2.setFont(new Font("Dialog", Font.BOLD, 12));
        t1.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                username = t1.getText();
            }
        });
        t2.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                age = t2.getText();
            }
        });
        t3.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                number = t3.getText();
            }
        });
        t4.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                 emailid = t4.getText();
            }
        });
        t5.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e)
            {
                password = t5.getText();
            }
        });
         b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	
                Boolean flag = true;
                String regex1 = "[a-zA-z]{5,20}";
                if(!username.matches(regex1))
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }
                String regex2 = "[1-9a-zA-Z]*";
                if(!password.matches(regex2))
                {
                    flag = false;
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
                if(flag)
                {
                	mysqllink.update(username,age,number,emailid,password);
                }
                t1.setText("");
                t2.setText("");
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	Form.main(null);
            	dispose();
            }
        });
        l1.setBounds(400, 200, 200, 30);
        l2.setBounds(400, 250, 200, 30);
        l3.setBounds(400, 300, 200, 30);
        l4.setBounds(400, 350, 200, 30);
        l5.setBounds(400, 400, 200, 30);
        t1.setBounds(600, 200, 200, 30);
        t2.setBounds(600, 250, 200, 30);
        t3.setBounds(600, 300, 200, 30);
        t4.setBounds(600, 350, 200, 30);
        t5.setBounds(600, 400, 200, 30);
        b1.setBounds(600, 500, 100, 25);
        b2.setBounds(600, 600, 100, 25);
        
        getContentPane().add(l1); getContentPane().add(l2); getContentPane().add(t1); getContentPane().add(t2); getContentPane().add(b1); getContentPane().add(b2); getContentPane().add(l3); getContentPane().add(t3); getContentPane().add(l4); getContentPane().add(l5); getContentPane().add(t4); getContentPane().add(t5);
 
 l1_1 = new Label("Sign Up");
 l1_1.setForeground(Color.WHITE);
 l1_1.setFont(new Font("Dialog", Font.BOLD, 18));
 l1_1.setBounds(524, 94, 200, 45);
 getContentPane().add(l1_1);
        setSize(1280, 720);
        setBackground(Color.white);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new singup();
    }
}