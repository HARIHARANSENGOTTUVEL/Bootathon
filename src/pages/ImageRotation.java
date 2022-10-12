package pages;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;

// Main class
public class ImageRotation {

	public static BufferedImage rotate(BufferedImage img)
	{

		int width = img.getWidth();
		int height = img.getHeight();
		BufferedImage newImage = new BufferedImage(
			img.getWidth(), img.getHeight(), img.getType());
		Graphics2D g2 = newImage.createGraphics();
		g2.rotate(Math.toRadians(90), width / 2,
				height / 2);
		g2.drawImage(img, null, 0, 0);
		return newImage;
	}

    ImageRotation(String link)
	{
		try {
			BufferedImage originalImg = ImageIO.read( new File(link));
			BufferedImage SubImg = rotate(originalImg);
			String formatName = link.substring(link.lastIndexOf(".") + 1);	
			File outputfile = new File("D:\\ImageOutput."+formatName);
			ImageIO.write(SubImg, formatName, outputfile);
			
		}
		catch (IOException e) {

			e.printStackTrace();
		}
	}
    
    ImageRotation(File link)
	{
		try {
			BufferedImage originalImg = ImageIO.read(link);
			BufferedImage SubImg = rotate(originalImg);
			String str = link.getPath();
			String formatName = str.substring(str.lastIndexOf(".") + 1);
			File f = new File("D:\\ImageOutput."+formatName); 
			ImageIO.write(SubImg,formatName, f);
			
		}
		catch (IOException e) {

			e.printStackTrace();
		}
	}
}