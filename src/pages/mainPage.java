package pages;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;

public class mainPage extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

public mainPage() {
	setFont(new Font("Dialog", Font.BOLD, 14));
	setTitle("Image Processing");
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\S.HARIHARAN\\Downloads\\images (1).png"));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100,100,882,545);
	contentPane = new JPanel();
	contentPane.setForeground(new Color(255, 255, 255));
	contentPane.setBackground(new Color(64, 128, 128));
	contentPane.setBorder(new EmptyBorder(5,5,5,5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton fp = new JButton("File Path");
	fp.setFont(new Font("Tahoma", Font.BOLD, 18));
	fp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		  ShowPicture.main(null);
		  dispose();
		}
	});
	fp.setBounds(143, 251, 157, 31);
	contentPane.add(fp);
	
	JLabel lblChooseYourOption = new JLabel("Choose Your Option");
	lblChooseYourOption.setForeground(Color.WHITE);
	lblChooseYourOption.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblChooseYourOption.setBackground(SystemColor.menu);
	lblChooseYourOption.setBounds(317, 122, 227, 28);
	contentPane.add(lblChooseYourOption);
	
	JButton li = new JButton("Load Image");
	li.setFont(new Font("Tahoma", Font.BOLD, 18));
	li.setBounds(593, 251, 157, 31);
	li.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		  LoadImage.main(null);
		  dispose();
		}
	});
	contentPane.add(li);
	
	JButton btnNewButton = new JButton("Exit");
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton.setBounds(411, 370, 85, 21);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	contentPane.add(btnNewButton);
}
}