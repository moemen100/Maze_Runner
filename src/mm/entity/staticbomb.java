/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import java.util.List;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.level;
import mm.entity.level.tile.Node;

/**
 *
 * @author moemen
 */

public class staticbomb extends Bombs {

    
   
    private int timer;

    private List<Node> path = null;
    private int animation=1;
    private int animation0=1;
    boolean explode = false;

    

    public staticbomb(level level,int x, int y) {
        super(level);
        this.x = x << 4;
        this.y = y << 4;
        Sprite = sprite.pound;

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
{Level.getplayerat(0).health-=50;}
Level.add(new geteffect(Level,x,y,50,20));
this.remove();
StaticBombPool pool = StaticBombPool.getInstance();     //Get an instance of staticBombPool to use in Object pool design pattern
pool.release(this);     //Release the static bomb used
}

 if (Level.tilecollision(x, y, xa, ya, 32)) {
           
            if(x/16<Level.width)
             x++;
            else
            x--;
             if(y/16>Level.height)
             y--;
             else
                 y++;
        }
      
                
            
  
      
        

    }

   

    @Override
    public void render(screen screen) {
       if(animation==1)
       {if(animation0<400)
            Sprite=sprite.staticbomb;
        
         if(animation0>=400&&animation0<=800)
         {Sprite=sprite.staticbomb1;}
        if(animation0>=800)
          animation0=0;}
       else
       {  if(animation>60)
            Sprite=sprite.staticbomb2;
        
         if(animation>1&&animation<=60)
         {Sprite=sprite.staticbomb3;}
        if(animation>=800)
            animation=0;
            }
       
        screen.renderplayer(x, y, Sprite);
    }

}
