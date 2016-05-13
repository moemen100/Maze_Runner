package mm.entity;

import java.util.Random;
import mm.entity.graphics.sprite;
import mm.entity.level.level;

import mm.entity.level.tile.Tile;

public class Bombs extends Entity {

    protected int damage;
    protected Random random = new Random();
    protected  sprite Sprite;

    protected int dir = 0;

    public Bombs(level Level) {
        super(Level);
    }

    void move(int xa, int ya) {

     
        if (!Level.tilecollision(x, y, xa, ya, 32)) {
            x += xa;
            y += ya;
        }

    }
}
