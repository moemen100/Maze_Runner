package mm.entity;

import java.awt.Color;
import java.awt.Graphics;

import mm.entity.level.vector2i;

public class UIcomponents {
public vector2i position;
protected vector2i offset;
public Color color;
public UIcomponents(vector2i position)
{
	this.position=position;
	offset=new vector2i();
	}
public UIcomponents setcolor(int color)
{
	this.color=new Color(color);
	return this;
}
public void update()
{
	
}
public void render (Graphics g)
{
	
}
void setoffset(vector2i offset)
{
	this.offset=offset;
}
}
