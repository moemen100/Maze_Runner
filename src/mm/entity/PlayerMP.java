/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import java.net.InetAddress;
import mm.entity.input.InputHandler;
import mm.entity.level.level;
import mm.entity.mop.Player;

/**
 *
 * @author moemen
 */
public class PlayerMP extends Player {

    public InetAddress ipAddress;
    public int port;

    public PlayerMP(level level, int x, int y, InputHandler input, String username, InetAddress ipAddress, int port) {
        super(level, x, y,  username,input);
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public PlayerMP(level level, int x, int y, String username, InetAddress ipAddress, int port) {
        super(level, x, y, username, null);
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void update() {
        super.update();
    }
}
