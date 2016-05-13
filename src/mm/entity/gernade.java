package mm.entity;

import java.util.List;

import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.level;
import mm.entity.level.vector2i;
import mm.entity.level.tile.Node;
import mm.entity.level.tile.Tile;
import mm.entity.mop.monster;
import mm.entity.projectile.projectile;

public class gernade extends Bombs {

    
    private int timer;

    private List<Node> path = null;
    private int animation=1;
     private int animation0=1;
    boolean explode = false;

    

    public gernade(level level,int x, int y) {
        super(level);
        this.x = x << 4;
        this.y = y << 4;
        Sprite = Sprite.pound;
        damage=20;

    }
    private int i = 0;

    @Override
    public void update() {
       animation0++;
        int xa = 0, ya = 0;
        if(explode)
        {

            animation++;
        timer=1;}
        if(!explode)
        {timer++;}
        
if(Level.mobscollision( this.x, this.y,1,1, Level.getplayerat(0).getx(),Level.getplayerat(0).gety(),16, 16))
{explode=true;}
if(animation%120==0)
{
if(Level.mobscollision( this.x, this.y,1,1, Level.getplayerat(0).getx(),Level.getplayerat(0).gety(),16, 16))
{Level.getplayerat(0).health-=damage;}
Level.add(new geteffect(Level,x,y,50,20));
Level.getplayers().get(i).score++;
this.remove();
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
        if (timer % 1000== 0) {
            int x=this.x;
            int y=this.y;
            while(x==this.x&&y==this.y||this.y==Level.getplayerat(0).gety()||this.x==Level.getplayerat(0).getx())
            { xa=(-29+random.nextInt(60))*16;
            ya=(-29+random.nextInt(60))*16;
          
        if (xa != 0 || ya != 0) {
            move(xa, ya);
          
        }
                
            }
  
      
        }

    }

   

    @Override
    public void render(screen screen) {
       if(animation==1)
       {if(animation0<400)
            Sprite=sprite.desbomb;
        
         if(animation0>=400&&animation0<=800)
         {Sprite=sprite.desbomb1;}
        if(animation0>=800)
          animation0=0;}
       else
       {  if(animation>60)
            Sprite=sprite.desbomb2;
        
         if(animation>1&&animation<=60)
         {Sprite=sprite.desbomb3;}
        if(animation>=800)
            animation=0;
            }
       screen.renderplayer(x, y, Sprite);
    }
    

}
