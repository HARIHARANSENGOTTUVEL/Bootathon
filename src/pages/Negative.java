package pages;

import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;

import javax.imageio.ImageIO; 

public class Negative { 
	Negative(String link)
	{ 
		BufferedImage img = null; 
		File f = null; 
		try { 
			f = new File(link); 
			img = ImageIO.read(f); 
		} 
		catch (IOException e) { 
			System.out.println(e); 
		} 
		int width = img.getWidth(); 
		int height = img.getHeight(); 
		for (int y = 0; y < height; y++) { 
			for (int x = 0; x < width; x++) { 
				int p = img.getRGB(x, y); 
				int a = (p >> 24) & 0xff; 
				int r = (p >> 16) & 0xff; 
				int g = (p >> 8) & 0xff; 
				int b = p & 0xff; 
				r = 255 - r; 
				g = 255 - g; 
				b = 255 - b; 
				p = (a << 24) | (r << 16) | (g << 8) | b; 
				img.setRGB(x, y, p); 
			} 
		} 

		try { 
			String formatName = link.substring(link.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
		} 
		catch (IOException e) { 
			System.out.println(e); 
		} 
	} 
	Negative(File link)
	{ 
		BufferedImage img = null; 
		File f = null; 
		try { 
			f = link; 
			img = ImageIO.read(f); 
		} 
		catch (IOException e) { 
			System.out.println(e); 
		} 
		int width = img.getWidth(); 
		int height = img.getHeight(); 
		for (int y = 0; y < height; y++) { 
			for (int x = 0; x < width; x++) { 
				int p = img.getRGB(x, y); 
				int a = (p >> 24) & 0xff; 
				int r = (p >> 16) & 0xff; 
				int g = (p >> 8) & 0xff; 
				int b = p & 0xff; 
				r = 255 - r; 
				g = 255 - g; 
				b = 255 - b; 
				p = (a << 24) | (r << 16) | (g << 8) | b; 
				img.setRGB(x, y, p); 
			} 
		} 
		
		try { 
			String str = link.getPath();
			String formatName = str.substring(str.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
		} 
		catch (IOException e) { 
			System.out.println(e); 
		} 
	} 
}