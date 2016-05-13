package mm.entity.graphics;

public class sprite {
	
public final int Size;
private int width ,height;
private int x,y;
public int [] pixels;
private spritesheet sheet;
public static sprite grass =new sprite (16,0,0,spritesheet.tiles);
public static sprite pound =new sprite (16,0,1,spritesheet.tiles);
public static sprite wall =new sprite (16,0,2,spritesheet.tiles);
public static sprite rock =new sprite (16,0,3,spritesheet.tiles);
public static sprite tree = new sprite(16, 4, 11, spritesheet.tiles);
public static sprite exit = new sprite(16, 8, 12, spritesheet.tiles);
public static sprite voidsprite=new sprite(16,0xffBfff);
public static sprite player_forw=new sprite (16,5,4,spritesheet.tiles);
public static sprite player_forw1=new sprite (16,6,4,spritesheet.tiles);
public static sprite player_forw2=new sprite (16,7,4,spritesheet.tiles);
public static sprite player_back=new sprite (16,5,5,spritesheet.tiles);
public static sprite player_back1=new sprite (16,6,5,spritesheet.tiles);
public static sprite player_back2=new sprite (16,7,5,spritesheet.tiles);
public static sprite player_left=new sprite (16,5,6,spritesheet.tiles);
public static sprite player_left1=new sprite (16,6,6,spritesheet.tiles);
public static sprite player_left2=new sprite (16,7,6,spritesheet.tiles);
public static sprite player_right=new sprite (16,5,7,spritesheet.tiles);
public static sprite player_right1=new sprite (16,6,7,spritesheet.tiles);
public static sprite player_right2=new sprite (16,7,7,spritesheet.tiles);
public static sprite mon_forw=new sprite (16,7,0,spritesheet.tiles);
public static sprite mon_forw1=new sprite (16,8,0,spritesheet.tiles);
public static sprite mon_forw2=new sprite (16,9,0,spritesheet.tiles);
public static sprite mon_back=new sprite (16,7,1,spritesheet.tiles);
public static sprite mon_back1=new sprite (16,8,1,spritesheet.tiles);
public static sprite mon_back2=new sprite (16,9,1,spritesheet.tiles);
public static sprite mon_left=new sprite (16,7,2,spritesheet.tiles);
public static sprite mon_left1=new sprite (16,8,2,spritesheet.tiles);
public static sprite mon_left2=new sprite (16,9,2,spritesheet.tiles);
public static sprite mon_right=new sprite (16,7,3,spritesheet.tiles);
public static sprite mon_right1=new sprite (16,8,3,spritesheet.tiles);
public static sprite mon_right2=new sprite (16,9,3,spritesheet.tiles);
public static sprite mon1_forw=new sprite (16,5,4,spritesheet.tiles);
public static sprite mon1_forw1=new sprite (16,6,4,spritesheet.tiles);
public static sprite mon1_forw2=new sprite (16,7,4,spritesheet.tiles);
public static sprite mon1_back=new sprite (16,5,5,spritesheet.tiles);
public static sprite mon1_back1=new sprite (16,6,5,spritesheet.tiles);
public static sprite mon1_back2=new sprite (16,7,5,spritesheet.tiles);
public static sprite mon1_left=new sprite (16,5,6,spritesheet.tiles);
public static sprite mon1_left1=new sprite (16,6,6,spritesheet.tiles);
public static sprite mon1_left2=new sprite (16,7,6,spritesheet.tiles);
public static sprite mon1_right=new sprite (16,5,7,spritesheet.tiles);
public static sprite mon1_right1=new sprite (16,6,7,spritesheet.tiles);
public static sprite mon1_right2=new sprite (16,7,7,spritesheet.tiles);
public static sprite player_fire=new sprite (16,1,4,spritesheet.tiles);
public static sprite player_fire1=new sprite (16,2,4,spritesheet.tiles);
public static sprite player_firedwn=new sprite (16,1,7,spritesheet.tiles);
public static sprite player_firedwn1=new sprite (16,2,7,spritesheet.tiles);
public static sprite player_fireup1=new sprite (16,1,6,spritesheet.tiles);
public static sprite player_fire1up1=new sprite (16,2,6,spritesheet.tiles);
public static sprite player_fireleft=new sprite (16,1,5,spritesheet.tiles);
public static sprite player_fire1left1=new sprite (16,2,5,spritesheet.tiles);
public static sprite player_fire2=new sprite (16,1,12,spritesheet.tiles);
public static sprite player_fire21=new sprite (16,2,12,spritesheet.tiles);
public static sprite player_firedwn2=new sprite (16,1,13,spritesheet.tiles);
public static sprite player_firedwn21=new sprite (16,2,13,spritesheet.tiles);
public static sprite player_fireup21=new sprite (16,1,14,spritesheet.tiles);
public static sprite player_fire1up21=new sprite (16,2,14,spritesheet.tiles);
public static sprite player_fireleft2=new sprite (16,1,15,spritesheet.tiles);
public static sprite player_fire1left21=new sprite (16,2,15,spritesheet.tiles);
public static sprite staticGift=new sprite (16,4,9,spritesheet.tiles);
public static sprite staticGift1=new sprite (16,5,9,spritesheet.tiles);
public static sprite staticbomb=new sprite (16,6,9,spritesheet.tiles);
public static sprite staticbomb1=new sprite (16,7,9,spritesheet.tiles);
public static sprite staticbomb2=new sprite (16,8,9,spritesheet.tiles);
public static sprite staticbomb3=new sprite (16,9,9,spritesheet.tiles);
public static sprite staticbomb4=new sprite (16,10,9,spritesheet.tiles);
public static sprite desbomb=new sprite (16,10,12,spritesheet.tiles);
public static sprite desbomb1=new sprite (16,11,12,spritesheet.tiles);
public static sprite desbomb2=new sprite (16,12,12,spritesheet.tiles);
public static sprite desbomb3=new sprite (16,13,12,spritesheet.tiles);
public static sprite desgift=new sprite (16,10,10,spritesheet.tiles);
public static sprite desgift1=new sprite (16,11,10,spritesheet.tiles);
public static sprite desgift2=new sprite (16,12,10,spritesheet.tiles);
public static sprite desgift3=new sprite (16,13,10,spritesheet.tiles);
public static sprite particle_normal=new sprite (3,0xFF1E22);

public  sprite(int width ,int height,int colour)
{Size=-1;
this.width=width;
this.height=height;
pixels=new int [width*height];
setcolour(colour);
	
}
public sprite (int size,int x,int y,spritesheet sheet)
{
	Size=size;
this.width=size;
this.height=size;
	
	pixels=new int[Size*Size];
	this.x=x*size;
	this.y=y*size;
	this.sheet=sheet;
	load();
	
}

public int getwidth()
{return width;}
public int getheight()
{return height;}

public sprite (int size, int colour)
{Size=size;
this.width=size;
this.height=size;
pixels=new int [Size*Size];
setcolour(colour);
}
private void setcolour(int colour)
{for(int i=0;i<width*height;i++)
	pixels[i]=colour;
		
	}
private void load()
{
	for(int y=0 ;y<Size;y++)
	{for(int x=0 ;x<Size;x++)
		{

		pixels[x+y*Size]=sheet.pixles[(x+this.x)+(y+this.y)*sheet.Size];
	}

	}
}
}
