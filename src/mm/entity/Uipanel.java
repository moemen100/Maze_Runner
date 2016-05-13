package mm.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import mm.entity.graphics.screen;
import mm.entity.level.vector2i;

public class Uipanel extends UIcomponents {
	private List <UIcomponents> components=new ArrayList<UIcomponents>();
	private vector2i size;
	public Uipanel(vector2i position,vector2i size) {
		super(position);
		this.position=position;
		this.size=size;
		color=new Color(0xcacaca);
		// TODO Auto-generated constructor stub
	}
public void addComponent(UIcomponents component)
{
	components.add(component);
}
	
	public void update() {
		for(UIcomponents component:components)
		{
			component.setoffset(position);
			component.update();
		}
		
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(position.getx(), position.gety(), size.getx(), size.gety());
		for(UIcomponents component:components)
		{
			
			component.render(g);
		}
		
	}

}
