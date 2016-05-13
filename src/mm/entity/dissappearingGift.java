/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import mm.entity.Gifts;
import java.util.List;
import mm.entity.Bombs;
import mm.entity.geteffect;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.level;
import mm.entity.level.tile.Node;
import mm.entity.level.tile.Tile;

/**
 *
 * @author moemen
 */
 public class dissappearingGift extends Gifts {

    
    
    private int timer=1;

    private List<Node> path = null;
    private int animation=1;
   

    

    public dissappearingGift(level level,int x, int y) {
        super(level);
        this.x = x << 4;
        this.y = y << 4;
        Sprite = sprite.pound;

    }
    private int i = 0;

    @Override
    public void update() {
        
        int xa = 0, ya = 0;
        
           
            animation++;
        
        
        timer++;
       

for(i=0;i<Level.getplayers().size();i++)
 {
if(Level.mobscollision( this.x, this.y,xa,ya, Level.getplayers().get(i).getx(),Level.getplayers().get(i).gety(),16, 16))
{
 Level.getplayers().get(i).score++;
 Level.getplayers().get(i).playerammoo+=5;
this.remove();
}}

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
        if (timer % 1000 == 0) {
            int x=this.x;
            int y=this.y;
            while(x==this.x&&y==this.y||this.y==Level.getplayerat(0).gety()||this.x==Level.getplayerat(0).getx())
            { xa=(-29+random.nextInt(60))*16;
            ya=(-29+random.nextInt(60))*16;
          
        if (xa != 0 || ya != 0) {
            move(xa, ya);
          
        }
                
            }
  timer=1;
      
        }

    }

   

    @Override
    public void render(screen screen) {
        if(animation<100)
            Sprite=sprite.staticGift;
        
         if(animation>=100&&animation<=200)
         {Sprite=sprite.staticGift1;}
        if(animation>200)
          animation=0;
        screen.renderplayer(x, y, Sprite);
    }

}
