package mm.entity.level.tile;

import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;

public class Grass extends Tile {

	public Grass(sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void render(int x, int y, screen screen)
	{
		screen.rendertile(x<<4, y<<4,this);
		
	}


 
 
}
