package mm.entity.level.tile;

import mm.entity.level.vector2i;

public class Node {
	public vector2i tile;
	public Node parent;
	public double  fcost, gcost, hcost;
	public Node(vector2i tile,Node parent,double gcost,double hcost)
	{
		this.tile=tile;
		this.parent=parent;
		this.gcost=gcost;
		this.hcost=gcost;
		this.fcost=this.gcost+this.hcost;
		
		
	}
}
