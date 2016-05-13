package mm.entity.graphics;



import mm.entity.level.tile.Tile;

public class screen {
	public int width,height;
	public int[] pixles;
	private int xoffset;
	private int yoffset;
	public screen(int width,int height)
	{
		this.width=width;
		this.height=height;
		pixles=new int[width*height]; 
		
	}
	public void clear()
	{
		for(int i=0;i<pixles.length;i++)
			pixles[i]=0;
	}
	public void renderSprite(int xp, int yp,sprite sprite,boolean fixed)
	{
		if (fixed)
		{	xp-=xoffset;
		yp-=yoffset;}
		for(int y=0;y<sprite.getheight();y++)
		{int ya=y+yp;
		for(int x=0;x<sprite.getwidth();x++)
		{
		int xa=x+xp;
		if(xa<0||xa>=width||ya<0||ya>=height)
		continue;
		pixles[xa+ya*width]=sprite.pixels[x+y*sprite.getwidth()];
		
			}	}
		
	}
public void rendertile(int xp,int yp,Tile tile)
{
xp-=xoffset;
yp-=yoffset;
for(int y=0;y<tile.sprite1.Size;y++)
	{int ya=y+yp;
	for(int x=0;x<tile.sprite1.Size;x++)
	{
	int xa=x+xp;
	if(xa<-tile.sprite1.Size||xa>=width||ya<0||ya>=height)
	break;
	if(xa<0)
	xa=0;
        int col=tile.sprite1.pixels[x+y*tile.sprite1.Size];
		if(col !=0xffFFAE00&&col !=0xffFF00AE)
		pixles[xa+ya*width]=col;
	
	
		}	
	}
}
public void renderplayer(int xp,int yp,sprite player)
{
	xp-=xoffset;
	yp-=yoffset;
	for(int y=0;y<16;y++)
		{int ya=y+yp;
		for(int x=0;x<16;x++)
		{
		int xa=x+xp;
		if(xa<-16||xa>=width||ya<0||ya>=height)
		break;
		if(xa<0)
		xa=0;
		int col=player.pixels[x+y*16];
		if(col !=0xffFFAE00&&col !=0xffFF00AE)
		pixles[xa+ya*width]=col;
		
			}	
		}
}
public void setoffset(int xoffset,int yoffset)
{
	this.xoffset=xoffset;
	this.yoffset=yoffset;
}


}
