package pages;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class BlackAndWhite {
	BlackAndWhite(String link){
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
				Color c = new Color( img.getRGB(i, j));
				int r = c.getRed();
				int b = c.getBlue();
				int g = c.getGreen();
				int bw = (r+g+b)/3;
			
				img.setRGB(i, j, new Color(bw,bw,bw).getRGB());
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
   BlackAndWhite(File link){
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
				Color c = new Color( img.getRGB(i, j));
				int r = c.getRed();
				int b = c.getBlue();
				int g = c.getGreen();
				int bw = (r+g+b)/3;
			
				img.setRGB(i, j, new Color(bw,bw,bw).getRGB());
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
