package mm.entity.particles;

import mm.entity.Entity;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.level;

public class particles extends Entity {
private sprite sprite;
private int life;
protected double xx,yy,zz;
protected double xa,ya,za;
private int time=0;
private boolean breaks=false;

public particles(level level,int x, int y,int life)
{
    super(level);
  this.x=x;
this.y=y;
this.xx=x;
this.yy=y;
this.life=life;
sprite=sprite.particle_normal;
this.xa=random.nextGaussian();
this.ya=random.nextGaussian();
this.zz=random.nextFloat()+2.0;

}

public void update()
{
time++;
if(time>7400)
	time=0;
if(time>life)
remove();
 
za-=0.1;

  if(zz<0)
  {
	  zz=0;
	  za*=-0.55;
	  xa*=0.4;
	  ya*=0.4;
  }
  
  move(xx + xa, (yy + ya) + (zz + za));
  

}
private void move(double x, double y) {
	if(collision(x , y))
	{
		this.xa *=-0.5;
		this.ya *=-0.5;
		this.za *=-0.5;
	}
	this.xx +=xa;
	this.yy +=ya;
	this.zz += za;
    
	
}
public boolean collision(double x,double y)
{   
	breaks=false;
	boolean solid=false;
	for(int c=0;c<4;c++)
	{
	double xt =( x - c%2*16 )/16;
	double yt =( y - c/2*16+1 )/16;
	int ix=(int) Math.ceil(xt);
	int iy=(int) Math.ceil(yt);
	if(c % 2 == 0) ix = (int) Math.floor(xt);
	if(c / 2 == 0) iy = (int) Math.floor(yt);
	if(Level.gettile(ix, iy).solid())
		{
		solid=true;
		if(Level.gettile(ix, iy).breaks())
		breaks=true;
		
		}
	}
	return solid;
	}

public void render (screen screen)
{
	screen.renderSprite((int)xx-1, (int)yy - (int)zz-1, sprite,true);
	}
}