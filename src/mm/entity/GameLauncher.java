/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameLauncher {

	private static Game game = new Game();

	public GameLauncher() {
		start();
	}

	private void start() {
		game.setMinimumSize(Game.DIMENSIONS);
		game.setMaximumSize(Game.DIMENSIONS);
		game.setPreferredSize(Game.DIMENSIONS);

		game.frame = new JFrame("Game");

		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLayout(new BorderLayout());

		game.frame.add(game, BorderLayout.CENTER);
		game.frame.pack();

		game.frame.setResizable(false);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.windowHandler = new WindowHandler(game);
		game.start();
	}
}
