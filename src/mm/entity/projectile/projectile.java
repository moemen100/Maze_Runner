package mm.entity.projectile;

import java.util.Random;

import mm.entity.level.tile.Tile;
import mm.entity.Entity;
import mm.entity.level.level;

public class projectile extends Entity {
	protected int damage;
	protected double speed;
	protected double range;
        protected boolean iskilled;
	protected double angle,nx,ny;
	protected Random random= new Random();
	protected Tile tile;
	protected final int xorgin;
	protected double x,y;
	protected  final int yorgin;
	public projectile(level level,int x ,int y ,double dir)
	{super(level);
		xorgin=x;
		yorgin=y;
		angle=dir;
            
	this.x=x ;
	this.y=y ;
	}
	public int getspritesize()
	{
		return tile.sprite1.Size;
	}
	protected void move()
	{
		
	}
        public boolean Iskilled() {
        return iskilled;
    }

}
