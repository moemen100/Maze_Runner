/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import mm.entity.level.level;

/**
 *
 * @author moemen
 */
public class gernadeFactory {
    public Entity getBombGift(String type, level Level, int x, int y) {
	if (type == null) {
	return null;
	}
	if (type.equalsIgnoreCase("gernade")) {
	return new gernade(Level, x, y);
	} else if (type.equalsIgnoreCase("dissappearingGift")) {
	return new dissappearingGift(Level, x, y);
	}
	return null;
	}
}
