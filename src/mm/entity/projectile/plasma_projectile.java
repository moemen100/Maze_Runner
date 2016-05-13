package mm.entity.projectile;

import mm.entity.Game;
import mm.entity.geteffect;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.input.mouse;
import mm.entity.level.level;
import mm.entity.monster1;
import mm.entity.mop.monster;

public class plasma_projectile extends projectile {
public static int rateofire=20;
private int anim;
private sprite sprite;

	public plasma_projectile(level level,int x, int y, double dir) {
		super(level ,x, y, dir);
		range=100;
		damage=20;
		speed=1;
		sprite=mm.entity.graphics.sprite.player_fire;
		iskilled=false;
nx=speed*Math.sin(angle);
ny=speed*Math.cos(angle);

	}
public void update()
{
anim++;
move();

}


private double dx ;
private double dy;
protected void move()
{
	if (mouse.getMouseb()==1)
		
	{
		  dx=mouse.getMousex()-Game.WIDTH/2;
		
	 dy=mouse.getMousey()-Game.HEIGHT/2;}
	//7assal error
if(dx>=0)	
	{if(anim%20>10)
	{
		sprite=mm.entity.graphics.sprite.player_fire;
		
	}
	

	else
	{
		sprite=mm.entity.graphics.sprite.player_fire1;
	}
	}
if(dx<0)	
{if(anim%20>10)
{
	sprite=mm.entity.graphics.sprite.player_fireleft;
	
}


else
{
	sprite=mm.entity.graphics.sprite.player_fire1left1;
}
}
if((int)dy>80)	
{if(anim%20>10)
{
	sprite=mm.entity.graphics.sprite.player_firedwn;
	
}


else
{
	sprite=mm.entity.graphics.sprite.player_firedwn1;
}
}
if((int)dy<-60)	
{if(anim%20>10)
{
	sprite=mm.entity.graphics.sprite.player_fire1up1;
	
}


else
{
	sprite=mm.entity.graphics.sprite.player_fireup1;
}
}

	

{if(Level.tilecollision(x, y, nx, ny, 16)==true)
	{

		if (Level.breakabletile())
			
	{
           for(int c=0;c<4;c++)
         Level.settile((((int)x+(int)nx)+c%2*12-1)/16,(((int)y+(int)ny)+c/2*12+1)/16);}
	Level.add(new geteffect(Level,(int)x,(int)y,90,20));
	
	
	this.remove();
	
	}}
	for(int i=0;i<Level.getmops().size();i++)
	{
		if(Level.getmops().get(i)instanceof monster||Level.getmops().get(i)instanceof monster1)
			
	if(Level.mobscollision(x, y, nx, ny,Level.getmops().get(i).getx(),Level.getmops().get(i).gety(),16, 16))
		{
		if(Level.getmops().get(i)instanceof monster||Level.getmops().get(i)instanceof monster1)
		{this.remove();
		
		Level.getmops().get(i).health=	Level.getmops().get(i).health-damage;
		
		if(Level.getmops().get(i).health<=0   )
		{Level.getmops().remove(i);
		Level.add(new geteffect(Level,(int)x+20,(int)y+20,50,20));
                iskilled=true;}
		}
		}
	}
       
        for(int i=0;i<Level.getbombs().size();i++)
	{
		
		          
	if(Level.mobscollision(x, y, nx, ny,Level.getbombs().get(i).getx(),Level.getbombs().get(i).gety(),16, 16))
		{
		                 
		this.remove(); 
		Level.getbombs().get(i).remove();
		Level.add(new geteffect(Level,(int)x+20,(int)y+20,50,5));
                
		}
		}
	
	x+=nx;
	y+=ny;
	if(distance()>range)
		remove();
	
}
public double distance ()
{double dist=0;
dist=Math.sqrt(Math.abs((xorgin-x)*(xorgin-x)+(yorgin-y)*(yorgin-y)));
return dist;	
}

@Override
public void render(screen screen)
{
	screen.renderplayer((int)x,(int) y, sprite);
	
	
}

    /**
     * @return the iskilled
     */
    

}
