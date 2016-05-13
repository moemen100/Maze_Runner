package mm.entity.level;

import mm.entity.dissappearingGift;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mm.entity.Bombs;
import mm.entity.Bombs;

import mm.entity.Entity;
import mm.entity.Entity;
import mm.entity.PlayerMP;
import mm.entity.PlayerMP;

import mm.entity.StaticGifts;
import mm.entity.StaticGifts;
import mm.entity.*;
import mm.entity.dissappearingGift;
import mm.entity.events.Event;
import mm.entity.gernade;
import mm.entity.gernade;
import mm.entity.graphics.screen;
import mm.entity.layers.Layer;
import mm.entity.level.tile.Node;
import mm.entity.level.tile.Tile;
import mm.entity.mop.Player;
import mm.entity.mop.monster;
import mm.entity.particles.particles;
import mm.entity.projectile.projectile;
import mm.entity.staticbomb;
import mm.entity.staticbomb;

public class level extends Layer implements Observer{
	protected int[] tiles;
	public int width;
	public int height;
	private boolean breaks=false;
	private int xscroll;
	private int yscroll;
	protected Comparator <Node> nodesorter=new Comparator <Node>()
			{
                @Override
		public int compare(Node n0,Node n1)
		{
			if(n1.fcost<n0.fcost)
				return+1;
			if(n1.fcost>n0.fcost)
				return-1;
			return 0;
		}
	};
private List<Entity> entities=new ArrayList<Entity>();
private List <projectile>projectiles=new ArrayList<projectile>();
private List <particles>particles=new ArrayList<particles>();
private List <Player>players=new ArrayList<Player>();
private List <Bombs>bombs=new ArrayList<Bombs>();
private List <Gifts>gifts=new ArrayList<Gifts>();
private Subject entity;     //New line added
public level(int width,int height)
{
        this.width=width;
		this.height=height;
		tiles=new int [width*height];
		generatelevel();
                //entity.register(this);     //New line added
		
	}
public void unsubscribe() {     //New method added
//entity.unregister(this);
    
}
	public boolean tilecollision(double x,double y,double xa,double ya,int size)
	{breaks=false;
       
		boolean solid=false;
		for(int c=0;c<4;c++)
		{int xt =(((int)x+(int)xa)+c%2*12)/16;
		int yt =(((int)y+(int)ya)+c/2*12+1)/16;
                  
		if(gettile(xt, yt).solid())
			{
                             
			solid=true;
			if(gettile(xt, yt).breaks())
			breaks=true;
			
			}
		}
		return solid;
		}
	public boolean breakabletile()
	{
		
		return breaks;
	}
	
	
       protected monster monster=new monster (this,20,20);
               
	public void update()
	{
             
	for(int i=0;i<entities.size();i++)
	{entities.get(i).update();}
	for(int i=0;i<projectiles.size();i++)
	{
		projectiles.get(i).update();
	
	}
	for(int i=0;i<particles.size();i++)
	{particles.get(i).update();}
            
	for(int i=0;i<players.size();i++)
            
	{players.get(i).update();}
        
        for(int i=0;i<bombs.size();i++)
	{bombs.get(i).update();}
        for(int i=0;i<gifts.size();i++)
	{gifts.get(i).update();}
	remove();
	
        if(monster.health<=0)
           add(monster=new monster (this,20,20));
	}
	
		public void onEvent(Event event)
	{
		getplayerat().onEvent(event);
		
	}
	public List<projectile> getprojectiles()
	{
		return projectiles;
		
	}
	
	protected void remove()
	{
		for(int i=0;i<entities.size();i++)
		{if(entities.get(i).isRemoved())entities.remove(i);}
		for(int i=0;i<projectiles.size();i++)
		{
			
			if(projectiles.get(i).isRemoved())projectiles.remove(i);}
	for(int i=0;i<particles.size();i++)
	{if(particles.get(i).isRemoved())particles.remove(i);}
for(int i=0;i<bombs.size();i++)
	{if(bombs.get(i).isRemoved())bombs.remove(i);}
for(int i=0;i<gifts.size();i++)
	{if(gifts.get(i).isRemoved())gifts.remove(i);}
	for(int i=0;i<players.size();i++)
	{if(players.get(i).isRemoved())players.remove(i);}
		
	}
	public List<Node> findpath (vector2i start,vector2i goal)
	{
		
		List<Node> openList=new ArrayList<Node>();
		List<Node> closeList=new ArrayList<Node>();
		Node current=new Node(start,null,0,getdistance(start,goal));
		openList.add(current);
		while(openList.size()>0)
		{
			Collections.sort(openList,nodesorter);
			
		current=openList.get(0);
			if(current.tile.equals(goal))
			{
				List<Node> path=new ArrayList<Node>();
				while(current.parent!=null)
				{
					path.add(current);
					current=current.parent;
				}
				openList.clear();
				closeList.clear();
				return path;
			}
			openList.remove(current);
			closeList.add(current);
			for(int i=0;i<9;i++)
			{
				if(i==4)continue;//skip middle
				int x=current.tile.getx();
				int y=current.tile.gety();
				int xi=(i%3)-1;//x=-1or1 or y=-1or1
				int yi=(i/3)-1;
				Tile at=gettile(x+xi,y+yi);
				if(at==null)
					continue;
				if(at.solid())continue;
				vector2i a= new vector2i(x+xi,y+yi);// same as tile at in vector form
				double gcost=current.gcost+getdistance(current.tile,a);
				double hcost=getdistance(a,goal);
				Node node=new Node(a,current,gcost,hcost);
				if(vecinlis(closeList,a)&&gcost>=node.gcost)
					continue;
				if(!vecinlis(openList,a)||gcost<node.gcost)openList.add(node);	
			
			
			}
			
			
		}
			closeList.clear();
		return null;
	}
	protected boolean vecinlis(List<Node> list,vector2i vector)
	{
		for(Node n:list)
		{
			if(n.tile.equals(vector))
				return true;
		}
		return false;
	}
	protected double getdistance(vector2i tile,vector2i goal)
	{
		double dx =tile.getx()-goal.getx();
		double dy =tile.gety()-goal.gety();
		return Math.sqrt (dx*dx+dy*dy);
	}

	public void add(Entity e)
	{		
if (e instanceof  projectile)
	projectiles.add((projectile)e);
if (e instanceof  Bombs)
	bombs.add((Bombs)e);
if (e instanceof  Gifts)
	gifts.add((Gifts)e);
else if (e instanceof  particles)
	particles.add((particles)e);
else if (e instanceof  Player)
	players.add((Player)e);
else
{
		entities.add(e);
}	}
public level(String path)
{
loadlevel(path);
}
	protected void generatelevel()
{
		
add(new dissappearingGift(this,5,5) );

add(new gernade(this,5,5) );
add(new gernade(this,20,20) );
add(new gernade(this,5,20) );
add(new gernade(this,20,20) );
add(new gernade(this,20,20) );
add(new gernade(this,20,20) );
add(new gernade(this,20,20) );
add(new gernade(this,20,20) );

                
}
	private void loadlevel(String path)
	{}
	private void time()
	{
		
	}
	
	public void setscroll(int xscroll,int yscroll)
	{
		this.xscroll=xscroll;
		this.yscroll=yscroll;
		
	}
public void render(screen screen)
{
	screen.setoffset(xscroll,yscroll);
	int x0=xscroll>>4;
	int x1=(xscroll+screen.width+16)>>4;
	int y0=yscroll>>4;
	int y1=(yscroll+screen.height+16)>>4;
	for(int y=y0; y<y1;y++)
	{
		for(int x=x0;x<x1;x++)
		{
                    
			gettile(x,y).render(x,y,screen);
			
		}
	}
	

for(int i=0;i<entities.size();i++)
{entities.get(i).render(screen);}
	
for(int i=0;i<particles.size();i++)
{particles.get(i).render(screen);
}
for(int i=0;i<players.size();i++)
{players.get(i).render(screen);
}
for(int i=0;i<gifts.size();i++)
{gifts.get(i).render(screen);
}

}


	public Tile gettile(int x,int y)
	{
            
	if(x<=0||y<=0||x>=width||y>=height)
return Tile.pound;
	if(tiles[x+y*width]==0)
		return Tile.grass;
	if(tiles[x+y*width]==1)
		return Tile.rock;
	if(tiles[x+y*width]==2)
		return Tile.wall;
        if (tiles[x + y * width] == 3)
			return Tile.tree;
        if(tiles[x+y*width]==4)
		return Tile.exit;
	return Tile.voidTile;
		
	}
	public List<Player> getplayers()
	{
		return players;
	}
        public List<Bombs> getbombs()
	{
		return bombs;
	}
        public List<Gifts> getgifts()
	{
		return gifts;
	}
	public List<Entity> getmops()
	{
		return entities;
	}
	public Player getplayerat(int index)
	{return players.get(index);
		
	}
	public Player getplayerat()
	{return players.get(0);
		
	}
	public boolean mobscollision(double x,double y,double xa,double ya,double xx,double yy,int size,int size1)
	{
		boolean solid=false;
		for(int c=0;c<4;c++)
		{int xt =(int) (((x+xa)+c%2*size)/16);
		int yt =(int) (((y+ya)+c/2*size)/16);
		int xtt =(int) (((xx)+c%2*size1)/16);
		int ytt =(int) (((yy)+c/2*size1)/16);
		
		if(xtt==xt&&ytt==yt)
			solid=true;
		
		}
		
		return solid;
	}
	
	public void settile(int x,int y)
	{
            //if(!tilecollision(x/16-1,y/16-1,0,0,0))
	 if(x<width&&y<height)	
            tiles[x+y*width]=0;
		
	}
	public synchronized void removePlayerMP(String username) {
        int index = 0;
        for (Entity e : getplayers()) {
            if (e instanceof PlayerMP && ((PlayerMP) e).getUsername().equals(username)) {
                break;
            }
            index++;
        }
        this.getplayers().remove(index);
    }
         public synchronized void movePlayer(String username, int x, int y, int numSteps, boolean isMoving, int movingDir,boolean shooting) {
         int index = getPlayerMPIndex(username);
        PlayerMP player = (PlayerMP) this.getplayers().get(index);
        player.x = x;
        player.y = y;
        player.setMoving(isMoving);
         player.setshooting(shooting);
        player.setNumSteps(numSteps);
        player.setMovingDir(movingDir);
    }
         private int getPlayerMPIndex(String username) {
        int index = 0;
        for (Entity e : getplayers()) {
            if (e instanceof PlayerMP && ((PlayerMP) e).getUsername().equals(username)) {
                break;
            }
            index++;
        }
        return index;
    }
         
         public void endGame() {
		
	}
          public int getL1() {
        return 0;
    }

    /**
     * @return the l2
     */
    public int getL2() {
        return 0;
    }

   
}

