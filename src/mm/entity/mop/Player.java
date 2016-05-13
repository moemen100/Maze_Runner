package mm.entity.mop;

import java.awt.event.MouseEvent;

import mm.entity.Game;
import mm.entity.Packet02Move;
import mm.entity.Uipanel;
import mm.entity.uimanger;
import mm.entity.uiprogresss;
import mm.entity.events.Event;
import mm.entity.events.EventDispatcher;
import mm.entity.events.EventHandler;
import mm.entity.events.EventListener;
import mm.entity.events.types.MousePressedEvent;
import mm.entity.events.types.MouseReleasedEvent;
import mm.entity.geteffect;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.input.InputHandler;
import mm.entity.input.mouse;
import mm.entity.level.level;
import mm.entity.level.vector2i;
import mm.entity.level.vector2i;
import mm.entity.level.vector2i;
import mm.entity.projectile.plasma_projectile;
import mm.entity.projectile.projectile;

public class Player extends mop implements EventListener {

    private uiprogresss uiheathbar;
    private uiprogresss uiplayerammo;
    private sprite Sprite;
    private InputHandler input;
    private int firerate;
    public int score;
    public int playerammoo = 50;
    private int xa, ya;
    private String username;
    private int animation;
    private uimanger ui;
    private Uipanel panel;
    private boolean checkexit = false;
   public boolean win = false;

    public Player(level Level, int x, int y, String username, InputHandler input) {
        super(Level, x, y, username, 1);
        this.x = x << 4;
        this.y = y << 4;
        this.input = input;
        this.username = username;
        health = 100;
        score = 0;
        firerate = plasma_projectile.rateofire;
        if (Level.getplayers().size() == 0) {
            ui = Game.getuimanger();
            panel = (Uipanel) new Uipanel(new vector2i(748, 0), new vector2i(10 * 16, 6 * 16)).setcolor(0x4f4f4f);
            ui.addpanel(panel);
            uiheathbar = new uiprogresss(new vector2i(754, 20), new vector2i(150, 20));
            uiplayerammo = new uiprogresss(new vector2i(754, 60), new vector2i(150, 20));
            uiplayerammo.setcolor(0x6a6a6a);
            uiplayerammo.setforgroundcolor(0x5476FF);
            uiheathbar.setcolor(0x6a6a6a);
            uiheathbar.setforgroundcolor(0xff6a6a);
            panel.addComponent(uiheathbar);
            panel.addComponent(uiplayerammo);
        }

    }

    @Override

    public void onEvent(Event event) {

        EventDispatcher dispatcher = new EventDispatcher(event);
        dispatcher.dispatch(Event.Type.MOUSE_PRESSED, new EventHandler() {

            @Override
            public boolean onEvent(Event event) {
                return onMousePressed((MousePressedEvent) event);
            }
        });
        dispatcher.dispatch(Event.Type.MOUSE_RELEASED, new EventHandler() {

            @Override
            public boolean onEvent(Event event) {
                return onMouserealeased((MouseReleasedEvent) event);
            }
        });
    }

    @Override
    public void update() {
        if (firerate > 0) {
            firerate--;
        }
        if (animation > 10000) {
            animation = 0;
        }
        animation++;
        xa = 0;
        ya = 0;
        if (input != null) {

            if (input.up.isPressed()) {
                ya--;
            }
            if (input.down.isPressed()) {
                ya++;
            }
            if (input.right.isPressed()) {
                xa++;
            }
            if (input.left.isPressed()) {
                xa--;
            }
        }

        isMoving = false;
        if (xa != 0 || ya != 0) {

            move(xa, ya);
            isMoving = true;
            Packet02Move packet = new Packet02Move(this.getUsername(), this.x, this.y, this.numSteps, this.isMoving, this.dir, this.shooting);
            packet.writeData(Game.game.socketClient);
        }

        clear();
        if (animation % 120 == 0&&health>0) {
            health--;
        }

        if (Level.getplayers().get(0) == this) {
            
             if(health>=0)
            uiheathbar.setprogress(health / 100.0);
            uiplayerammo.setprogress(playerammoo / 50.0);
        }

        updateshooting();
        if (score == 10 ) {
            Level.endGame();
            checkexit=true;
  
        }
        if(checkexit)
        {
           
        if(x/16==Level.getL1()&&y/16==Level.getL2())
      
       {
          win=true;
           Level.add(new geteffect(Level,(int)x,(int)y,90,20));
       
       }
            }
    }

    private void clear() {
        for (int i = 0; i < Level.getprojectiles().size(); i++) {
            projectile p = Level.getprojectiles().get(i);
            if (p.isRemoved()) {
                Level.getprojectiles().remove(i);
            }
        }
    }

    public boolean onMousePressed(MousePressedEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            shooting = true;
            Packet02Move packet = new Packet02Move(this.getUsername(), this.x, this.y, this.numSteps, this.isMoving, this.dir, this.shooting);
            packet.writeData(Game.game.socketClient);
            return true;
        }

        return false;
    }

    public boolean onMouserealeased(MouseReleasedEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            shooting = false;
            Packet02Move packet = new Packet02Move(this.getUsername(), this.x, this.y, this.numSteps, this.isMoving, this.dir, this.shooting);
            packet.writeData(Game.game.socketClient);
        }

        return true;
    }

    public void render(screen screen) {
//FF00AE;
// momken ya7sal error low direction msh equal 0,1,2,3
// error if enimation exceed the int limit 99999999
        if (dir == 0) {
            Sprite = Sprite.player_forw;
            if (isMoving) {

                if (animation % 20 > 10) {
                    Sprite = Sprite.player_forw1;

                } else {
                    Sprite = Sprite.player_forw2;
                }

            }

        }
        if (dir == 2) {
            Sprite = Sprite.player_back;
            if (isMoving) {

                if (animation % 20 > 10) {
                    Sprite = Sprite.player_back1;

                } else {
                    Sprite = Sprite.player_back2;

                }

            }
        }
        if (dir == 1) {
            Sprite = Sprite.player_left;
            if (isMoving) {

                if (animation % 20 > 10) {

                    Sprite = Sprite.player_left1;

                } else {

                    Sprite = Sprite.player_left2;

                }

            }
        }
        if (dir == 3) {
            Sprite = Sprite.player_right;
            if (isMoving) {

                if (animation % 20 > 10) {
                    Sprite = Sprite.player_right1;

                } else {
                    Sprite = Sprite.player_right2;
                }

            }

        }
        screen.renderplayer(x, y, Sprite);

    }

    public int getxa() {
        return xa;
    }

    public int getya() {
        return ya;
    }

    private void updateshooting() {
        if (!shooting || firerate > 0 || playerammoo <= 0) {
            return;
        }
        double dx = mouse.getMousex() - (Game.WIDTH * Game.SCALE) / 2;
        double dy = mouse.getMousey() - (Game.HEIGHT * Game.SCALE) / 2;
        double dirs = Math.atan2(dx, dy);

        shoot(dx, dy, dirs);

        playerammoo--;
        firerate = plasma_projectile.rateofire;
    }

    public String getUsername() {
        return this.username;
    }

    private void shoot(double dx, double dy, double dir) {
        projectile p = new plasma_projectile(Level, x, y, dir);
        Level.add(p);
        if (p.Iskilled()) {
            score++;
        }

    }
   
}
