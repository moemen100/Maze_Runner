package mm.entity.level.tile;

import mm.entity.breakablewall;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;

public class Tile {
public sprite sprite1;
public  static Tile grass=new Grass(sprite.grass);
public  static Tile wall=new breakablewall(sprite.wall);
public  static Tile rock=new Grass(sprite.rock);
public  static Tile pound=new wall(sprite.pound);
public  static Tile voidTile=new voidTile(sprite.voidsprite);
public static Tile tree = new wall(sprite.tree);
public static Tile exit = new Grass(sprite.exit);
public Tile(sprite sprite)
{
	this.sprite1=sprite;
	
}
public void render (int x, int y, screen screen)
{
	
}
public boolean solid()
{
	return false;
}
public boolean breaks()
{
	return false;
}
}
