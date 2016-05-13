package mm.entity;

import java.awt.Color;
import java.awt.Graphics;

import org.w3c.dom.ranges.RangeException;

import mm.entity.level.vector2i;

public class uiprogresss extends UIcomponents {
public double progress;
private vector2i size;
private Color foregroundcolor;
public uiprogresss(vector2i position, vector2i size)
{
	super(position);
	this.size=size;
	foregroundcolor=new Color(0);
}
public void setprogress(double progress)
{
	if(progress<0.0||progress>1.0)
		throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR,"progress must be between 0-1");
	this.progress=progress;
	
}
public void setforgroundcolor(int color)
{
this.foregroundcolor=new Color(color);

}
public double getprogress()
{
	return progress;
}
public void update()
{
	
}
public void render (Graphics g)
{
	g.setColor(color);
	g.fillRect(position.getx(), position.gety(), size.getx(), size.gety());
	g.setColor(foregroundcolor);
	g.fillRect(position.getx(), position.gety(), (int)(progress*size.getx()), size.gety());
	
}
}
