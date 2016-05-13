package mm.entity;

import java.util.ArrayList;
import java.util.Random;

import mm.entity.graphics.screen;
import mm.entity.level.level;

abstract public class Entity implements Subject{
	public int x,y;
	public int health;
        public level Level;
	private boolean removed=false;
	protected final Random random=new Random();
        ArrayList observers = new ArrayList();     //New line for observer
        public void register(Observer o) {     //New method added
		observers.add(o);
		}
		public void unregister(Observer o) {     //New method added
		int i = observers.indexOf(o);
		observers.remove(i);
		}
		public void notif() {     //New method added
			for (int i=0;i < observers.size();i++)
			{
			Observer ob = (Observer)observers.get(i);
			ob.update();
			}
			}
	public Entity(level Level)
        {
        intializ(Level);
        }
	public void update()
	{
		
	}
	public void render(screen screen)
	{
		
	}
	public void remove()
	{
		removed=true;}
	public boolean isRemoved()
	{
		return removed;
	}
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
	
	
public void intializ(level Level)
{
	this.Level=Level;
        
}

}
// packet00login loginPacket=new packet00login(JOptionPane.showInternalInputDialog(this, "pleaseenter user name"));
     //  loginPacket.writedata(socketClient);