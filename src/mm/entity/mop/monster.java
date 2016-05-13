package mm.entity.mop;

import java.util.List;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.level;
import mm.entity.level.vector2i;
import mm.entity.level.tile.Node;
public class monster extends mop 
{
	private sprite Sprite;
	private int timer;
	
	private List <Node> path=null;
	private int animation;
	boolean iswalking=false;
	public monster(level level,int x, int y)
	{super(level,x,y,"",1);
		this.x=x<<4;
		this.y=y<<4;
		this.health=75;
		
		
	}
	
        @Override
        public void update()
{
    
	 int xa=0,ya=0;
	animation++;
	timer++;
	int px=Level.getplayerat(0).getx();
	int py=Level.getplayerat(0).gety();
	vector2i start=new vector2i(getx()/16,gety()/16);
	vector2i dest=new vector2i(px/16,py/16);
	if(timer%20==0)
		path=Level.findpath(start, dest);
	if(path!=null)
	{
		if(path.size()>0)
	{vector2i vec =path.get(path.size()-1).tile;
		if(x<vec.getx()<<4)xa++;	
		if(x>vec.getx()<<4)xa--;
		if(y<vec.gety()<<4)ya++;
		if(y>vec.gety()<<4)ya--;
	}
	}
        if (Level.tilecollision(x, y, xa, ya, 32)) {
           
            if(x/16<30)
             x++;
            else
            x--;
             if(y/16>0)
             y--;
             else
                 y++;
        }
	if(Level.mobscollision(x,y,xa,ya,px,py,48,48))
	{
		Level.getplayers().get(0).health--;
		}
		

		
	iswalking=false;
	if(xa!=0||ya!=0)
		{move(xa,ya);
		iswalking=true;
		
		}
	
}
        @Override
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
protected boolean ismonster(){
		return  true;}
		

}
