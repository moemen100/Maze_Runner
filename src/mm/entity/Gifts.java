/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import java.util.Random;
import mm.entity.Entity;
import mm.entity.graphics.sprite;
import mm.entity.level.level;

/**
 *
 * @author moemen
 */
public class Gifts extends Entity {

   protected int damage;
    protected Random random = new Random();
   protected sprite Sprite;
    protected int dir = 0;

    public Gifts(level Level) {
        super(Level);
    }

    void move(int xa, int ya) {

     
        if (!Level.tilecollision(x, y, xa, ya, 32)) {
            x += xa;
            y += ya;
        }

    }
}