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


public class LoadImage extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadImage frame = new LoadImage();
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
	JButton li;
	public LoadImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\S.HARIHARAN\\Downloads\\images (1).png"));
		setTitle("Image Processing");
		setFont(new Font("Dialog", Font.BOLD, 14));
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
		
		//Load Image
	    li = new JButton("Load Image");
		li.setForeground(new Color(255, 255, 255));
		li.setBackground(new Color(64, 128, 128));
		li.setFont(new Font("Tahoma", Font.BOLD, 18));
	    li.setBounds(44, 48, 159, 28);
	    li.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    		JFileChooser jf = new JFileChooser();
	    		jf.showOpenDialog(li);
	    		File f= jf.getSelectedFile();
	    		BufferedImage bf = ImageIO.read(f);
	    		link2 = f;
	    		String str = link2.getPath();
	    		formatName = str.substring(str.lastIndexOf('.')+1);
	    		}catch(Exception e1) {
	    			e1.printStackTrace();
	    			}
	    	}
	    });
		contentPane.add(li);	
		
		panel2 = new JLabel();
		panel2.setForeground(new Color(64, 128, 128));
		panel2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel2.setEnabled(false);
		panel2.setBounds(10, 86, 472, 412);		
		contentPane.add(panel2);
		
	   //GreyScale
		
		JButton grey = new JButton("GreyScale");
		grey.setFont(new Font("Tahoma", Font.BOLD, 14));
		thread = new Thread();
		grey.setBounds(504, 53, 116, 21);
		grey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  try {
					 
				    GreyScale g = new GreyScale(link2);
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
		sepia.setBounds(504, 111, 116, 21);
		sepia.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
				  
		      try {
								Sepia g = new Sepia(link2);
							
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
		contentPane.add(sepia);
		
		//Green
		JButton green = new JButton("Green");
		green.setFont(new Font("Tahoma", Font.BOLD, 14));
		green.setBackground(new Color(240, 240, 240));
		green.setBounds(504, 171, 116, 21);
		green.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
				  
				  try {
					  
								Green g = new Green(link2);
							
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
				b.setBounds(727, 111, 116, 21);
				b.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  try {
						  
								Blue g = new Blue(link2);
							
							
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
				r.setBounds(727, 53, 116, 21);
				r.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							
										Red g = new Red(link2);
									
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
				bl.setBounds(727, 171, 116, 21);
				bl.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							
										Blur g = new Blur(link2);
									
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
				bw.setBounds(584, 335, 185, 21);
				bw.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							
										BlackAndWhite g = new BlackAndWhite(link2);
									
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
				rn.setBounds(504, 221, 116, 21);
				rn.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							 
										ImageRotation g = new ImageRotation(link2);
									
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
				rr.setBounds(727, 221, 132, 21);
				rr.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							 
										ImageRotation2 g = new ImageRotation2(link2);
									
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
				m.setBounds(504, 276, 116, 21);
				m.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
							  
										MirrorImage g = new MirrorImage(link2);
									
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
				n.setBounds(727, 276, 116, 21);
				n.addActionListener(new ActionListener() {
					@Override
				public void actionPerformed(ActionEvent e) {
						  
						  try {
										Negative g = new Negative(link2);
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
				
				JLabel lblClickToLoad = new JLabel("Click To Load Image");
				lblClickToLoad.setForeground(Color.WHITE);
				lblClickToLoad.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblClickToLoad.setBackground(SystemColor.menu);
				lblClickToLoad.setBounds(44, 10, 227, 28);
				contentPane.add(lblClickToLoad);
				
				JButton btnNewButton = new JButton("BACK");
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton.setBounds(504, 411, 85, 21);
			    btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  mainPage.main(null);
						  dispose();
						}
					});
				contentPane.add(btnNewButton);
				
				JButton btnExit = new JButton("EXIT");
				btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnExit.setBounds(758, 413, 85, 21);
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				contentPane.add(btnExit);
				
					
		
	}
}