import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import javax.imageio.*;
public class Imagine {
	private String path;
	private BufferedImage img=null;
	int height;
    int width;
    
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public void openPath() {
		try{
			img=ImageIO.read(new File(path));
			height = img.getHeight();
		    width = img.getWidth();
	
		}
		catch(IOException e){
			System.out.println("Adresa invalida");
		}
		
	}
	public void rotate(String k){
		
		
	   
		int da=0;
		BufferedImage aux=null;
		String pathDestinatie;
		String numeFisier;
		File file = null;
	
	
		int i,j;
		if(k.equals("90")){
			aux= new BufferedImage(height, width, img.getType());
			for(i=0; i<width; i++)
				for(j=0; j<height; j++){
					aux.setRGB(j,i,img.getRGB(i, height-j-1));
				}
		}
		else if(k.equals("180")){
			aux= new BufferedImage(width, height, img.getType());
			for(i=0; i<height; i++)
				for(j=0; j<width; j++){
					aux.setRGB(j,i,img.getRGB(width-j-1, height-i-1));
				}
		}
		else if(k.equals("270")){
			aux= new BufferedImage(height, width, img.getType());
			for(i=0; i<width; i++)
				for(j=0; j<height; j++){
					aux.setRGB(j,i,img.getRGB(width-i-1, j));
				}
		}

			
			da=0;
			System.out.println("Introduceti calea imaginii rezultat:");
			Scanner scan = new Scanner(System.in);
			pathDestinatie=scan.nextLine();
			System.out.println("Introduceti numele imaginii rezultat:");
			
			numeFisier=scan.nextLine()+".bmp";
			long startTime = System.currentTimeMillis();	
					file = new File(pathDestinatie, numeFisier);
					try{
						ImageIO.write(aux, "bmp", file);
						System.out.println("Succes!");
						long stopTime = System.currentTimeMillis();
					    long elapsedTime = stopTime - startTime;
					    System.out.println("Transformare efectuata in "+elapsedTime + "ms");
					}
					catch(IOException e){
						System.out.println("Adresa invalida");
					}
		
			
		
 
	}
	
	
}
