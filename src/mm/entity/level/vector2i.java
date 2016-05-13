package mm.entity.level;

public class vector2i {
private int x,y;
public vector2i()
{
	set(0,0);
}
public vector2i(int x,int y)
{
	set(x,y);
}
public void set(int x, int y) {
	// TODO Auto-generated method stub
	this.x=x;
	this.y=y;
}
public vector2i(vector2i vector)
{
	set(vector.x,vector.y);	
}
public vector2i add(vector2i vector)
{this.x+=vector.x;
this.y+=vector.y;
return this;
	
}
public vector2i subtract(vector2i vector)
{this.x-=vector.x;
this.y-=vector.y;
return this;
	
}
public int getx()
{
return x;
}
public int gety()
{
return y;
}
public vector2i setx(int x)
{
this.x=x;
return this;
}
public vector2i sety(int y)
{
this.y=y;
return this;
}
public boolean equals(Object object)
{if(!(object instanceof vector2i))
		return false;
vector2i vec=(vector2i)object;
if(vec.getx()==this.getx()&&vec.gety()==this.gety())
	return true;
		
return false	;
}



}
