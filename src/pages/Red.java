package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class Red {
//   static String link = "C:\\Users\\arant\\Downloads\\download (5).jpg";
//	public static void main(String[] args) {
	Red(String link){
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
				int r = (p>>16)&0xff;
				
			
				p=(a<<24)|(r<<16)|0;
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
	Red(File link){
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
				int r = (p>>16)&0xff;
				
			
				p=(a<<24)|(r<<16)|0;
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