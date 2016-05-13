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
public class StaticGifts extends Gifts {

   
   
   

    private List<Node> path = null;
    private int animation=1;
   

    

    public StaticGifts(level level,int x, int y) {
        super(level);
        this.x = x << 4;
        this.y = y << 4;
       Sprite=sprite.staticGift1;

    }
    private int i = 0;

    @Override
    public void update() {
        
        int xa = 0, ya = 0;
        

            animation++;
       
        
 for(i=0;i<Level.getplayers().size();i++)
 {
if(Level.mobscollision( this.x, this.y,xa,ya, Level.getplayers().get(i).getx(),Level.getplayers().get(i).gety(),16, 16))
{
 Level.getplayers().get(i).score++;
Level.getplayers().get(i).health+=5;
this.remove();
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
      
                
            
  
      
        

    }

   

    @Override
    public void render(screen screen) {
        
   
     if(animation<100)
            Sprite=sprite.desgift;
        
         if(animation>=50&&animation<=100)
         {Sprite=sprite.desgift1;}
          if(animation>=100&&animation<=150)
         {Sprite=sprite.desgift2;}
           
        if(animation>=150)
          animation=0;
        screen.renderplayer(x, y, Sprite);
    }

}
