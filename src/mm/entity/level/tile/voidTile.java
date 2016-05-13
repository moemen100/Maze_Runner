package mm.entity.level.tile;

import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;

public class voidTile extends Tile 
{

	public voidTile(sprite Sprite) {
		super(Sprite);
		
	}
	public void render (int x,int y,screen screen)
	{
		screen.rendertile(x<<4 , y<<4, this);
	}
}
