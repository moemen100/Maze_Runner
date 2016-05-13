package mm.entity;

import mm.entity.effect.Type;
import mm.entity.level.level;
import mm.entity.particles.particles;

public class geteffect extends effect  {
private int life;
	public geteffect(level level,int x, int y,int life , int amount) {
		super(level,x, y, Type.Particles, amount);
		this.life=life;
		for(int i=0;i<amount;i++)
		{
		Level.add(new particles(level,x,y,life));	
		
			

		}
		// TODO Auto-generated constructor stub
	}

}
