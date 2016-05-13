
package mm.entity;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mm.entity.events.Event;
import mm.entity.events.EventListener;
import mm.entity.graphics.screen;
import mm.entity.graphics.sprite;
import mm.entity.input.InputHandler;
import mm.entity.input.mouse;
import mm.entity.layers.Layer;
import mm.entity.level.level;
import mm.entity.level.randomlevel;
import mm.entity.mop.Player;
import mm.entity.mop.monster;

import mm.entity.mop.mop;

public class Game extends Canvas implements Runnable, EventListener {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 300;
	public static final double HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 3;
	public static final String NAME = "Game";
	public static final Dimension DIMENSIONS = new Dimension(WIDTH * SCALE, (int) HEIGHT * SCALE);
	public static Game game;
	private static uimanger uimanger;
	public JFrame frame;

	private Thread thread;

	public boolean running = false;
	public int tickCount = 0;

	private BufferedImage image = new BufferedImage(WIDTH, (int) HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private screen screen;
	public InputHandler input;
	public WindowHandler windowHandler;
	public level level;
	public Player player;
	private List<Layer> layerstack = new ArrayList<Layer>();
	public GameClient socketClient;
	public GameServer socketServer;

	public void init() {
		game = this;

		screen = new screen(WIDTH, (int) HEIGHT);
		input = new InputHandler(this);
		level = new randomlevel(30, 30);
		addlayer(level);
		uimanger = new uimanger();
		player = new PlayerMP(level, 1, 1, input, JOptionPane.showInputDialog(this, "Please enter a username"), null,
				-1);
		mouse mouse = new mouse(this);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		level.add(player);

		Packet00Login loginPacket = new Packet00Login(player.getUsername(), player.x, player.y);
		if (socketServer != null) {
			socketServer.addConnection((PlayerMP) player, loginPacket);
		}
		loginPacket.writeData(socketClient);

	}

	public synchronized void start() {
		running = true;

		thread = new Thread(this, NAME + "_main");
		thread.start();

		if (JOptionPane.showConfirmDialog(this, "Do you want to run the server") == 0) {
			socketServer = new GameServer(this);
			socketServer.start();
		}

		socketClient = new GameClient(this, "localhost");
		socketClient.start();

	}

	public synchronized void stop() {
		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				frame.setTitle("maze" + "  ||  " + ticks + "ups,  " + frames + "fps");
				frames = 0;
				ticks = 0;
			}
		}
	}

	public void tick() {
           
		tickCount++;
		uimanger.update();
		for (int i = 0; i < layerstack.size(); i++) {
			layerstack.get(i).update();
		}
	 if(level.getplayerat(0).health==0)
            {this.hide();
             GameEnd gameend = new GameEnd();
            gameend.show(true);
            }
            if(level.getplayerat(0).win)
            {this.hide();
             GameEnd gameend = new GameEnd();
            gameend.show(true);
          gameend.score  =level.getplayerat(0).score*level.getplayerat(0).health;
            }
        }

	public static uimanger getuimanger() {
		return uimanger;
	}

	public void addlayer(Layer Layer) {
		layerstack.add(Layer);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xOffset = player.x - (screen.width / 2);
		int yOffset = player.y - (screen.height / 2);

		player.render(screen);
		for (int i = 0; i < layerstack.size(); i++) {
			layerstack.get(i).render(screen);
		}

		level.setscroll(xOffset, yOffset);
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = screen.pixles[i];
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		uimanger.render(g);
		g.dispose();
		bs.show();
	}

	@Override
	public void onEvent(Event event) {

		for (int i = layerstack.size() - 1; i >= 0; i--) {
			layerstack.get(i).onEvent(event);
		}

	}

}
