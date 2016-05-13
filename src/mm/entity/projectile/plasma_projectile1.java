/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity.projectile;

import mm.entity.Game;
import mm.entity.geteffect;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.input.mouse;
import mm.entity.level.level;
import mm.entity.monster1;
import mm.entity.mop.monster;

/**
 *
 * @author moemen
 */
public class plasma_projectile1 extends projectile {
public static int rateofire=20;
private int anim;
private sprite sprite;
	public plasma_projectile1(level level,int x, int y, double dir) {
		super(level ,x, y, dir);
		range=100;
		damage=5;
		speed=1;
		sprite=mm.entity.graphics.sprite.player_fire;
		
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
		sprite=mm.entity.graphics.sprite.player_fire2;
		
	}
	

	else
	{
		sprite=mm.entity.graphics.sprite.player_fire21;
	}
	}
if(dx<0)	
{if(anim%20>10)
{
	sprite=mm.entity.graphics.sprite.player_fireleft2;
	
}


else
{
	sprite=mm.entity.graphics.sprite.player_fire1left21;
}
}
if((int)dy>80)	
{if(anim%20>10)
{
	sprite=mm.entity.graphics.sprite.player_firedwn2;
	
}


else
{
	sprite=mm.entity.graphics.sprite.player_firedwn21;
}
}
if((int)dy<-60)	
{if(anim%20>10)
{
	sprite=mm.entity.graphics.sprite.player_fire1up21;
	
}


else
{
	sprite=mm.entity.graphics.sprite.player_fireup21;
}
}

	

	
	
		
			
	if(Level.mobscollision(x, y, nx, ny,Level.getplayers().get(0).getx(),Level.getplayers().get(0).gety(),16, 16))
		{
		Level.getplayers().get(0).health=Level.getplayers().get(0).health-damage;
		
		
		this.remove();
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

}

