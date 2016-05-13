package mm.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import mm.entity.graphics.screen;

public class uimanger {
private List<Uipanel>panels=new ArrayList<Uipanel>();
public uimanger(){
	
}
public void update(){
	for(Uipanel panel:panels)
	{
		panel.update();
	}
	
}
public void render(Graphics g)
{
	for(Uipanel panel:panels)
	{
		panel.render(g);
	}
	
}
public void addpanel(Uipanel panel)
{
	panels.add(panel);
}
}
