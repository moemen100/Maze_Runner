package mm.entity;

import java.util.ArrayList;
import java.util.List;

import mm.entity.level.level;
import mm.entity.particles.particles;

public class effect extends Entity {
public enum Type{
	Mob,Particles;
}
private Type type;
public effect(level Level,int x , int y, Type type,int amount)
{
    super(Level);
this.x=x;
this.y=y;
this.type=type;

	
}
}
