package mm.entity.mop;


import mm.entity.Entity;
import mm.entity.level.level;
import mm.entity.projectile.plasma_projectile;
import mm.entity.projectile.plasma_projectile1;
import mm.entity.projectile.projectile;

public abstract class mop extends Entity
{
	protected int dir=0;
 protected String name;
    protected int speed;
    protected int numSteps = 0;
     protected boolean shooting =false;
    protected boolean isMoving;
    protected int scale = 1;
    private State state;     //New line added
     public mop(level level, int x, int y, String name, int speed) {
        super(level);
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
        state = null;     //New line added
    }
     public void setState(State state) {    //New function added
    	 this.state = state;
     }
    	 public State getState() {     //New function added
    	 return state;
     }
	protected void move(int xa ,int ya)
	{
             
	if(ya!=0&&xa!=0)
		{
                move(xa,0);
		move(0,ya);
		  numSteps--;
                  return;
		}
    

       
         numSteps++;
       
       if(xa>0)
                 
    dir = new RightDirection().doAction(this);     //New line added to handle RightDirection
	if(xa<0)
		 
	dir = new LeftDirection().doAction(this);     //New line added to handle LeftDirection
	if(ya>0)
		 
	dir = new DownDirection().doAction(this);     //New line added to handle DownDirection
	if(ya<0)
		 
	dir = new UpDirection().doAction(this);     //New line added to handle UpDirection
     
	if(!tilecollision(x, y, xa, ya, 14))
	{
           
         
       
            x += xa * speed;
            y += ya * speed;
	}
	
	}
        @Override
	public void update()
	{
		
	}
        
	
	

	protected int getx(int xa)
	{return xa;}
	protected int gety(int ya)
	{return ya;}
        public String getName() {
        return name;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public boolean isMoving() {
        return isMoving;
    }
     public boolean isshooting() {
        return shooting;
    }

    public int getMovingDir() {
        return dir;
    }

    public void setNumSteps(int numSteps) {
        this.numSteps = numSteps;
    }
    

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    public void setshooting(boolean shooting) {
        this.shooting = shooting;
    }

    public void setMovingDir(int movingDir) {
        this.dir = movingDir;
    }
    
 public boolean tilecollision(double x,double y,double xa,double ya,int size)
	{
       
		boolean solid=false;
		for(int c=0;c<4;c++)
		{int xt =(((int)x+(int)xa)+c%2*13)/16;
		int yt =(((int)y+(int)ya)+c/2*13)/16;
                  
		if(Level.gettile(xt, yt).solid())
			{
                             
			solid=true;
			
			
			}
		}
		return solid;
		}
}


