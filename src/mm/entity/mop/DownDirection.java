/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity.mop;

/**
 *
 * @author moemen
 */
public class DownDirection implements State{
    public int doAction(mop player) {
		player.setState(this);
		return 0;
		}
}
