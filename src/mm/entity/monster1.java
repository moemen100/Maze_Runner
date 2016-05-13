/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import java.util.Random;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.level;
import mm.entity.mop.mop;
import mm.entity.projectile.plasma_projectile;
import mm.entity.projectile.plasma_projectile1;
import mm.entity.projectile.projectile;

/**
 *
 * @author moemen
 */

	public class monster1 extends mop
	{
		private sprite Sprite;
		private int firerate;
		private int getR;
		private int animation;
		boolean iswalking=false;
		private static final Random randommove=new Random();
		
		public monster1(level level,int x, int y)
		{
                    
               super(level,x,y,"",2);
			this.x=x<<4;
		this.y=y<<4;
		this.health=75;
			firerate=plasma_projectile1.rateofire;
			
		}
	public void update()
	{if(firerate>0)
	firerate--;
		animation++;
		if(animation%60>10)
	{getR=randommove.nextInt(4);
	animation=animation-30;}
		
		double dir=Math.atan2(Level.getplayerat().getx()-x,Level.getplayerat().gety()-y);
	if(5>Math.abs(this.x-Level.getplayerat(0).getx())||5>Math.abs(this.y-Level.getplayerat(0).gety()))
        {shoot(x,y,dir);}
		int xa=0,ya=0;
                
		if(getR==0)
			{
			
		
			ya--;
	}
		if(getR==1)
			{
			if(ya<64)	
			ya++;
			
	}
		if(getR==2)
			{
			if(xa<64)
			xa++;
			}
		if(getR==3)
			{
			
			xa--;

			}
		iswalking=false;
		if(xa!=0||ya!=0)
			{move(xa,ya);
			iswalking=true;
			
			
			}
		
	}
	        public void render(screen screen)
{
//FF00AE;
// momken ya7sal error low direction msh equal 0,1,2,3
// error if enimation exceed the int limit 99999999
if(dir==0)
{
	Sprite=Sprite.mon_forw;
if(iswalking)
{
	
if(animation%20>10)
{
	Sprite=Sprite.mon_forw1;
	

}
if(animation%30>10)
{
	Sprite=Sprite.mon_forw2;
	

}

	

}

}




	



if(dir==2)
{
Sprite=Sprite.mon_back;

if(iswalking)
{

if(animation%20>10)
{
Sprite=Sprite.mon_back1;


}
if(animation%30>10)
{
Sprite=Sprite.mon_back2;


}






}}
if(dir==3)
{
Sprite=Sprite.mon_left;

if(iswalking)
{

if(animation%20>10)
{
Sprite=Sprite.mon_left1;


}
if(animation%30>10)
{
Sprite=Sprite.mon_left2;


}




}}
if(dir==1)
{
Sprite=Sprite.mon_right;

if(iswalking)
{

if(animation%20>10)
{
Sprite=Sprite.mon_right1;


}
if(animation%30>10)
{
Sprite=Sprite.mon_right2;


}




}}

screen.renderplayer(x, y,Sprite);
	

}
              
    protected void shoot(double dx, double dy, double dir) {
        if(firerate<=0)
      {
		projectile p=new plasma_projectile1(Level,x,y,dir);
			Level.add(p);}
		
firerate=plasma_projectile.rateofire;
		
	}    
        }