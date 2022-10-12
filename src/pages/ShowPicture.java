package pages;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.TextField;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GrayFilter;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class ShowPicture extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPicture frame = new ShowPicture();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	ImageIcon img;
	int width, height;
	String link,formatName;
	File link2,link3;
	private TextField textField;
	JLabel panel2;
	Thread thread;
	public ShowPicture() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\S.HARIHARAN\\Downloads\\images (1).png"));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Image Processing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,882,545);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	     //String link = "C:\\Users\\arant\\Downloads\\download (4).jpg";	
	     //String buff = "C:\\Users\\arant\\Downloads\\download (5).jpg";
	     
		 //"C:\Users\arant\Downloads\download (5).jpg"
		//String link = new String();
		textField = new TextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				link = textField.getText();
				formatName = link.substring(link.lastIndexOf(".") + 1);
			}
		});
		textField.setBounds(10, 61, 225, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Your File Path");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(10, 22, 227, 28);
		contentPane.add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel("OR");
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
//		lblNewLabel_1.setForeground(new Color(255, 255, 255));
//		lblNewLabel_1.setBounds(46, 86, 51, 29);
//		contentPane.add(lblNewLabel_1);
		
		panel2 = new JLabel();
		panel2.setForeground(new Color(64, 128, 128));
		panel2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel2.setEnabled(false);
		panel2.setBounds(10, 98, 467, 400);		
		contentPane.add(panel2);
		
		
	    
	   //GreyScale
		JLabel panel1 = new JLabel(); 
		panel1.setBackground(new Color(64, 128, 128));
		panel1.setEnabled(false);
		panel1.setVerticalAlignment(SwingConstants.BOTTOM);	
		panel1.setBounds(34, 140, 300, 300);
		contentPane.add(panel1);
		
		JButton grey = new JButton("GreyScale");
		grey.setFont(new Font("Tahoma", Font.BOLD, 14));
		 thread = new Thread();
		grey.setBounds(487, 48, 116, 21);
		grey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  try {
					  if(link != null) {
							GreyScale g = new GreyScale(link);
							}else {
								GreyScale g = new GreyScale(link2);
							}
					thread.sleep(1000);
					panel2.setEnabled(true);
					img = new ImageIcon( "D:\\ImageOutput."+formatName);
					Image image = img.getImage();
					Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
				    ImageIcon scaledIcon = new ImageIcon(imgScale);
				    panel2.setIcon(scaledIcon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			}
		});
		contentPane.add(grey);
		
		//Sepia
		
		JButton sepia = new JButton("Sepia");
		sepia.setFont(new Font("Tahoma", Font.BOLD, 14));
		sepia.setBounds(487, 111, 116, 21);
		sepia.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
				  
		      try {
					  if(link != null) {
							Sepia g = new Sepia(link);
							}else {
								Sepia g = new Sepia(link2);
							}
					thread.sleep(1000);
					panel2.setEnabled(true);
					img = new ImageIcon( new String("D:\\ImageOutput."+formatName));
					System.out.println(formatName);
					Image image = img.getImage();
					Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
				    ImageIcon scaledIcon = new ImageIcon(imgScale);
				    panel2.setIcon(scaledIcon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			}
		});
		contentPane.add(sepia);
		
		//Green
		JButton green = new JButton("Green");
		green.setFont(new Font("Tahoma", Font.BOLD, 14));
		green.setBackground(new Color(240, 240, 240));
		green.setBounds(487, 171, 116, 21);
		green.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
				  
				  try {
					  if(link != null) {
							Green g = new Green(link);
							}else {
								Green g = new Green(link2);
							}
					thread.sleep(1000);
					panel2.setEnabled(true);
					img = new ImageIcon( "D:\\ImageOutput."+formatName);
					Image image = img.getImage();
					Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
				    ImageIcon scaledIcon = new ImageIcon(imgScale);
				    panel2.setIcon(scaledIcon);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			}
		});
		contentPane.add(green);
		
		//Blue
				JButton b = new JButton("Blue");
				b.setFont(new Font("Tahoma", Font.BOLD, 14));
				b.setBounds(714, 111, 116, 21);
				b.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							if(link != null) {
							Blue g = new Blue(link);
							}else {
								Blue g = new Blue(link2);
							}
							
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(b);
				
				//Red
				JButton r = new JButton("Red");
				r.setFont(new Font("Tahoma", Font.BOLD, 14));
				r.setBounds(714, 48, 116, 21);
				r.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							
							  if(link != null) {
									Red g = new Red(link);
									}else {
										Red g = new Red(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(r);
				
				//Blur
				JButton bl = new JButton("Blur");
				bl.setFont(new Font("Tahoma", Font.BOLD, 14));
				bl.setBounds(714, 171, 116, 21);
				bl.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							
							  if(link != null) {
									Blur g = new Blur(link);
									}else {
										Blur g = new Blur(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(bl);
				
				//BlackAndWhite
				JButton bw = new JButton("Black and White");
				bw.setFont(new Font("Tahoma", Font.BOLD, 14));
				bw.setBounds(570, 355, 185, 21);
				bw.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							panel2.revalidate();
							  if(link != null) {
									BlackAndWhite g = new BlackAndWhite(link);
									}else {
										BlackAndWhite g = new BlackAndWhite(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(bw);
				
				//Rotate left
				JButton rn = new JButton("Rotate Left");
				rn.setFont(new Font("Tahoma", Font.BOLD, 14));
				rn.setBackground(new Color(240, 240, 240));
				rn.setBounds(487, 241, 116, 21);
				rn.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							  if(link != null) {
									ImageRotation g = new ImageRotation(link);
									}else {
										ImageRotation g = new ImageRotation(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(rn);
				
				////Rotate right
				JButton rr = new JButton("Rotate Right");
				rr.setFont(new Font("Tahoma", Font.BOLD, 14));
				rr.setBackground(new Color(240, 240, 240));
				rr.setBounds(714, 241, 132, 21);
				rr.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							  if(link != null) {
									ImageRotation2 g = new ImageRotation2(link);
									}else {
										ImageRotation2 g = new ImageRotation2(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(rr);
				
				//Duo Mirroring
				JButton m = new JButton("Dual Mirror");
				m.setFont(new Font("Tahoma", Font.BOLD, 14));
				m.setBounds(487, 296, 116, 21);
				m.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							  if(link != null) {
									MirrorImage g = new MirrorImage(link);
									}else {
										MirrorImage g = new MirrorImage(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(m);
				
				//Negative
				JButton n = new JButton("Negative");
				n.setFont(new Font("Tahoma", Font.BOLD, 14));
				n.setBounds(714, 296, 116, 21);
				n.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							  if(link != null) {
									Negative g = new Negative(link);
									}else {
										Negative g = new Negative(link2);
									}
							thread.sleep(1000);
							panel2.setEnabled(true);
							img = new ImageIcon( "D:\\ImageOutput."+formatName);
							Image image = img.getImage();
							Image imgScale = image.getScaledInstance(panel2.getWidth(), panel2.getHeight(), Image.SCALE_SMOOTH);
						    ImageIcon scaledIcon = new ImageIcon(imgScale);
						    panel2.setIcon(scaledIcon);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
					}
				});
				contentPane.add(n);
				
				
				JButton btnNewButton = new JButton("EXIT");
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton.setBounds(745, 438, 85, 21);
				btnNewButton.addActionListener(new ActionListener() {
					@Override
			    	public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				contentPane.add(btnNewButton);
				
				JButton btnBack = new JButton("BACK");
				btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnBack.setBounds(487, 438, 85, 21);
				 btnBack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							  mainPage.main(null);
							  dispose();
							}
						});
				contentPane.add(btnBack);
	}
}