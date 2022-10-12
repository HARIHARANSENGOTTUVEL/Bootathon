package pages;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.nio.file.Files;

import javax.imageio.ImageIO;

public class Blur {
	Blur(String link){
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
		
		Kernel k = new Kernel(4,4,new float[] {1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3),
				1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3),
				1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3),
				1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3)});
		ConvolveOp cp = new ConvolveOp(k);
		img = cp.filter(img, null);
		
		try {
			String formatName = link.substring(link.lastIndexOf(".") + 1);
			f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(img,formatName, f); 
		}catch(Exception e) {
			System.out.println(e);
		}

	}
   Blur(File link){
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
		
		Kernel k = new Kernel(4,4,new float[] {1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3),
				1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3),
				1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3),
				1f/(3*3),1f/(3*3),1f/(3*3),1f/(3*3)});
		ConvolveOp cp = new ConvolveOp(k);
		img = cp.filter(img, null);
		
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