package mm.entity.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mm.entity.events.EventListener;
import mm.entity.events.types.MouseMovedEvent;
import mm.entity.events.types.MousePressedEvent;
import mm.entity.events.types.MouseReleasedEvent;

public class mouse implements MouseListener,MouseMotionListener
{
private static int mousex=-1;
private static int mousey=-1;
private static int mouseb=-1;
private EventListener eventlistner;

public mouse(EventListener listner)
{
	eventlistner =listner ;
}
public static int getMousey() {
	return mousey;
}



public static int getMousex() {
	return mousex;
}


	public static int getMouseb() {
	return mouseb;
}

	public void mouseMoved(MouseEvent e) {
mousex=e.getX();
mousey=e.getY();
MouseMovedEvent event=new MouseMovedEvent(e.getX(),e.getY(),false);
eventlistner.onEvent(event);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseb=e.getButton();
		MousePressedEvent event=new MousePressedEvent(e.getButton(),e.getX(),e.getY());
		eventlistner.onEvent(event);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseb=-1;
		MouseReleasedEvent event=new MouseReleasedEvent(e.getButton(),e.getX(),e.getY());
		eventlistner.onEvent(event);
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mousex=e.getX();
		mousey=e.getY();
		MouseMovedEvent event=new MouseMovedEvent(e.getX(),e.getY(),true);
		eventlistner.onEvent(event);
	}

	

}
