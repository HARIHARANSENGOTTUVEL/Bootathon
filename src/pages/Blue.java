package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class Blue {
   //static String link = "C:\\Users\\arant\\Downloads\\download (5).jpg";
	//public static void main(String[] args) {
	Blue(String link){
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
		
		for(int j=0;j<height;j++) {
			for(int i=0;i<width;i++) {
				int p = img.getRGB(i, j);
				int a = (p>>24)&0xff;
				int b = (p>>0)&0xff;
				
			
				p=(a<<24)|(0<<16)|(0<<8)|(b<<0)|0;
				img.setRGB(i, j, p);
				}
		}
		
		try {
			String formatName = link.substring(link.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
			System.out.println(formatName);
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	Blue(File link){
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
		
		for(int j=0;j<height;j++) {
			for(int i=0;i<width;i++) {
				int p = img.getRGB(i, j);
				int a = (p>>24)&0xff;
				int b = (p>>0)&0xff;
				
			
				p=(a<<24)|(0<<16)|(0<<8)|(b<<0)|0;
				img.setRGB(i, j, p);
				}
		}
		
		try {
			String str = link.getPath();
			String formatName = str.substring(str.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName);
			System.out.println("Success");
			ImageIO.write(img,formatName, f); 
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}