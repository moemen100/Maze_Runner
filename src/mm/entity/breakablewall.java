package mm.entity;

import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.level.tile.Tile;

public class breakablewall extends Tile {

	public breakablewall(sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void render(int x, int y, screen screen)
	{
		screen.rendertile(x<<4, y<<4,this);
		
	}
	public boolean solid()
	{
		return true;
	}
	public boolean breaks()
	{
		return true;
	}
	
}