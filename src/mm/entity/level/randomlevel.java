package mm.entity.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import mm.entity.StaticBombPool;
import mm.entity.StaticGifts;
import mm.entity.dissappearingGift;
import mm.entity.gernadeFactory;
import static mm.entity.graphics.sprite.staticbomb;

import mm.entity.level.tile.Node;
import mm.entity.level.tile.Tile;
import mm.entity.monster1;
import mm.entity.mop.monster;
import mm.entity.staticbomb;
// error in mana power  ui if ui > 100;
public class randomlevel extends level {
	private static final Random random = new Random();
	private int l1;
	private int l2;

	public randomlevel(int width, int height) {
		super(width, height);
gernadeFactory factory = new gernadeFactory();     //New lined added for objectpool design pattern
		StaticBombPool pool = StaticBombPool.getInstance();     //New lined added for objectpool design pattern
		pool.setMaxPoolSize(20, this, 10, 10);     //New lined added for objectpool design pattern
		
                add(monster=new monster (this,20,20));
                
                  //add(new staticbomb (this,10,10));
		
                for(int i = 0; i < 20; i++)
                {
                	staticbomb s = pool.acquire();     //New lined added for objectpool design pattern
                    add(s);     //New lined added for objectpool design pattern
                }
                add(factory.getBombGift("gernade", this, 20, 10));     //New lined added for factory design pattern
                //add(new gernade (this,20,10));
                add(new StaticGifts (this,6,10));
                add(factory.getBombGift("dissappearingGift", this, 20, 10));     //New lined added for factory design pattern
                //add(new dissappearingGift (this,2,10));


	}

	private List<Node> path = null;

	@Override
	protected void generatelevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width] = random.nextInt(1) + 1;

			}

		}
		vector2i start = new vector2i(0, 1);
		vector2i dest;
		int gtr;
		int gtr1;

		for (int i = 0; i < 5; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			grassroad(start, dest);
			start = dest;
		}
		int q = random.nextInt(2);
		if (q == 1) {
			while (getL1() < width * 3 / 4)
				l1 = random.nextInt(width);
			l2 = random.nextInt(height);
		} else if (q == 0) {
			while (getL2() < height * 4 / 5)
				l2 = random.nextInt(height);
			l1 = random.nextInt(width);
		}
		dest = new vector2i(getL1(), getL2());
		grassroad(start, dest);

		start = new vector2i(width / 2, 1);
		for (int i = 0; i < 5; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		start = new vector2i(width / 2, height);
		for (int i = 0; i < 5; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		start = new vector2i(0, height / 2);
		for (int i = 0; i < 5; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		start = new vector2i(width, height / 2);
		for (int i = 0; i < 5; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		start = new vector2i(width - 1, 0);
		for (int i = 0; i < 7; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		start = new vector2i(width - 1, height);
		for (int i = 0; i < 7; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		start = new vector2i(0, height - 1);
		for (int i = 0; i < 7; i++) {
			gtr = random.nextInt(width - 1);
			gtr1 = random.nextInt(height - 1);
			dest = new vector2i(gtr, gtr1);
			if (dest.getx() - start.getx() < 10 && dest.gety() - start.gety() < 10) {
				grassroad(start, dest);
				start = dest;
			} else
				i--;
		}

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (tiles[x + y * width] != 0)
					tiles[x + y * width] = 2;

			}

		}

		int x, y;
		for (int i = 0; i < 25; i++) {
			x = random.nextInt(width);
			y = random.nextInt(height);
			if (tiles[x + y * width] == 2)
				tiles[x + y * width] = 3;
			else
				i--;
		}

		for (y = 0; y < height - 2; y++) {
			for (x = 0; x < width - 2; x++) {
				if (tiles[x + y * width] == 0 && tiles[x + (y + 1) * width] == 0 && tiles[x + (y + 2) * width] == 0
						&& tiles[(x + 1) + y * width] == 0 && tiles[(x + 1) + (y + 1) * width] == 0
						&& tiles[(x + 1) + (y + 2) * width] == 0 && tiles[(x + 2) + y * width] == 0
						&& tiles[(x + 2) + (y + 1) * width] == 0 && tiles[(x + 2) + (y + 2) * width] == 0)
					tiles[(x + 1) + (y + 1) * width] = 2;

			}
		}

		for (y = 0; y < height - 2; y++) {
			for (x = 0; x < width - 2; x++) {
				if (tiles[x + y * width] == 0 && tiles[x + (y + 1) * width] == 0 && tiles[x + (y + 2) * width] == 0
						&& tiles[(x + 1) + y * width] == 0 && tiles[(x + 1) + (y + 1) * width] != 0
						&& tiles[(x + 1) + (y + 2) * width] == 0 && tiles[(x + 2) + y * width] == 0
						&& tiles[(x + 2) + (y + 1) * width] == 0 && tiles[(x + 2) + (y + 2) * width] == 0)
					tiles[(x + 2) + (y + 2) * width] = 2;

			}
		}

		for (y = 0; y < height - 2; y++) {
			for (x = 0; x < width - 2; x++) {

				if (tiles[x + y * width] == 0 && tiles[x + (y + 1) * width] == 0 && tiles[(x + 1) + y * width] == 0
						&& tiles[(x + 1) + (y + 1) * width] == 0 && tiles[(x + 2) + y * width] == 0
						&& tiles[(x + 2) + (y + 1) * width] == 0)
					tiles[(x + 1) + (y + 1) * width] = 2;

			}
		}

		for (y = 0; y < height - 2; y++) {
			for (x = 0; x < width - 2; x++) {

				if (tiles[x + y * width] == 0 && tiles[x + (y + 1) * width] == 0 && tiles[x + (y + 2) * width] == 0
						&& tiles[(x + 1) + y * width] == 0 && tiles[(x + 1) + (y + 1) * width] == 0
						&& tiles[(x + 1) + (y + 2) * width] == 0)
					tiles[(x + 1) + (y + 1) * width] = 2;

			}
		}
		tiles[getL1() + getL2() * width] = 2; //Di el destination abl ma tezhar
	}

	private void grassroad(vector2i x, vector2i y) {
		path = findpath2(x, y);
		if (path != null) {
			for (int i = 1; i <= path.size(); i++) {

				if (path != null) {
					if (path.size() > 0) {
						vector2i vec = path.get(path.size() - i).tile;

						tiles[vec.getx() + vec.gety() * width] = 0;
					}
				}

			}
		}
	
        
        }

	private List<Node> findpath2(vector2i start, vector2i goal) {

		int d1 = 0;
		int d3 = 0;
		int d5 = 0;
		int d7 = 0;

		List<Node> openList = new ArrayList<Node>();
		List<Node> closeList = new ArrayList<Node>();

		Node current = new Node(start, null, 0, getdistance(start, goal));
		openList.add(current);
		while (openList.size() > 0) {
			Collections.sort(openList, nodesorter);

			current = openList.get(0);
			if (current.tile.equals(goal)) {
				List<Node> path = new ArrayList<Node>();
				while (current.parent != null) {
					path.add(current);
					current = current.parent;
				}

				openList.clear();
				closeList.clear();
				return path;
			}

			openList.remove(current);
			closeList.add(current);
			for (int i = 0; i < 9; i++) {
				if (i == 0)
					continue;
				if (i == 1) {
					d1++;
					if (d1 % 4 == 0)
						continue;
				}
				if (i == 2)
					continue;
				if (i == 3) {
					d3++;
					if (d3 % 4 == 0)
						continue;
				}
				if (i == 4)
					continue;
				if (i == 5) {
					d5++;
					if (d5 % 4 == 0)
						continue;
				}
				if (i == 6)
					continue;
				if (i == 7) {
					d7++;
					if (d7 % 4 == 0)
						continue;
				}
				if (i == 8)
					continue;

				int x = current.tile.getx();
				int y = current.tile.gety();
				int xi = (i % 3) - 1;// x=-1or1 or y=-1or1
				int yi = (i / 3) - 1;

				Tile at = gettile(x + xi, y + yi);

				if (at == null)
					continue;
				if (at.solid())
					continue;

				vector2i a = new vector2i(x + xi, y + yi);// same as tile at in
															// vector form
				double gcost = current.gcost + getdistance(current.tile, a);
				double hcost = getdistance(a, goal);
				Node node = new Node(a, current, gcost, hcost);
				if (vecinlis(closeList, a) && gcost >= node.gcost)
					continue;
				if (!vecinlis(openList, a) || gcost < node.gcost)
					openList.add(node);

			}

		}

		closeList.clear();

		return null;
	}

        @Override
	public void endGame() {
		tiles[getL1() + getL2() * width] = 4; // E3ml object mn el class w call el method di lamma el score yb2a 10
									// randomlevel x = new randomlevel(0,1); ... x.endGame(); :D
	}

    /**
     * @return the l1
     */
        @Override
     
        
    public int getL1() {
        return l1;
    }

    /**
     * @return the l2
     */
    public int getL2() {
        return l2;
    }
}
