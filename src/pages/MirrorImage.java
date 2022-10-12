package pages;

import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO; 

public class MirrorImage { 
	
	MirrorImage(String Link)
	{ 
		BufferedImage img = null; 

		File f = null; 
		try { 
			f = new File(Link); 
			img = ImageIO.read(f); 
		} 
		catch (IOException e) { 
			System.out.println("Error: " + e); 
		} 
		
		int width = img.getWidth(); 
		int height = img.getHeight(); 
//		BufferedImage mimg = new BufferedImage( 
//			width, height, BufferedImage.TYPE_INT_ARGB); 

		for (int y = 0; y < height; y++) { 
			for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) { 
				int p = img.getRGB(lx, y); 
				img.setRGB(rx, y, p); 
			} 
		} 
		
		try { 
			String formatName = Link.substring(Link.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
		} 
		catch (IOException e) { 
			System.out.println("Error: " + e); 
		} 
	} 
	MirrorImage(File Link)
	{ 
		BufferedImage img = null; 

		File f = null; 
		try { 
			f = Link; 
			img = ImageIO.read(f); 
		} 
		catch (IOException e) { 
			System.out.println("Error: " + e); 
		} 
		
		int width = img.getWidth(); 
		int height = img.getHeight(); 
//		BufferedImage mimg = new BufferedImage( 
//			width, height, BufferedImage.TYPE_INT_ARGB); 

		for (int y = 0; y < height; y++) { 
			for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) { 
				int p = img.getRGB(lx, y); 
				img.setRGB(rx, y, p); 
			} 
		} 
		
		try { 
			String str = Link.getPath();
			String formatName = str.substring(str.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
		} 
		catch (IOException e) { 
			System.out.println("Error: " + e); 
		} 
	} 
}