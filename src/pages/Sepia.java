package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class Sepia {
	public Sepia(String link) {
	//public static void main(String[] args) {
		BufferedImage img = null;
		File f = null;
		try {
			  f = new File(link);
			 img = ImageIO.read(f);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				int p = img.getRGB(i, j);
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = (p>>0)&0xff;
				
				int tr = (int)(0.393*r+0.769*g+0.189*b);
				int tg=(int)(0.349*r+0.686*g+0.168*b);
				int tb = (int)(0.272*r+0.534*g+0.131*b);
				
				if(tr>255) {
					r = 255;
				}else {
					r = tr;
				}
				if(tg>255) {
					g = 255;
				}else {
					g = tg;
				}
				if(tb>255) {
					b = 255;
				}else {
					b = tb;
				}
				p=(a<<24)|(r<<16)|(g<<8)|b;
				img.setRGB(i, j, p);
				}
		}
		
		try {
			String formatName = link.substring(link.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public Sepia(File link) {
		//public static void main(String[] args) {
			BufferedImage img = null;
			File f = null;
			try {
				  f = link;
				 img = ImageIO.read(f);
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			int width = img.getWidth();
			int height = img.getHeight();
			
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					int p = img.getRGB(i, j);
					int a = (p>>24)&0xff;
					int r = (p>>16)&0xff;
					int g = (p>>8)&0xff;
					int b = (p>>0)&0xff;
					
					int tr = (int)(0.393*r+0.769*g+0.189*b);
					int tg=(int)(0.349*r+0.686*g+0.168*b);
					int tb = (int)(0.272*r+0.534*g+0.131*b);
					
					if(tr>255) {
						r = 255;
					}else {
						r = tr;
					}
					if(tg>255) {
						g = 255;
					}else {
						g = tg;
					}
					if(tb>255) {
						b = 255;
					}else {
						b = tb;
					}
					p=(a<<24)|(r<<16)|(g<<8)|b;
					img.setRGB(i, j, p);
					}
			}
			
			try {
				String str = link.getPath();
				String formatName = str.substring(str.lastIndexOf(".") + 1);
				f = new File("D:\\ImageOutput."+formatName); 
				ImageIO.write(img,formatName, f); 
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}