package mm.entity.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class spritesheet {
private String path;
public final int Size;
public int[] pixles;

public static spritesheet tiles=new spritesheet("/New folder/Capture22.PNG",256);
public spritesheet(String path, int size)
{	

	this.path=path;
	Size=size;
	pixles=new int [Size*Size];
	load();
}
private void load()
{
try{
	BufferedImage image=ImageIO.read(spritesheet.class.getResource(path));
int w =image.getWidth();
int h=image.getHeight();
image.getRGB(0, 0, w, h, pixles, 0, w);

}
catch(IOException e)
{
e.printStackTrace();	
}
}

}
