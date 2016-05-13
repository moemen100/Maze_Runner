/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mm.entity;

import java.util.ArrayList;
import java.util.Random;
import mm.entity.level.level;

/**
 *
 * @author moemen
 */
public class StaticBombPool {
    private Random randomVar=new Random() ;
		private ArrayList<staticbomb> freeList;
		private ArrayList<staticbomb> usedList;
		private int size;
		private static StaticBombPool instance;
		private StaticBombPool() {
		freeList = new ArrayList<staticbomb>();
		usedList = new ArrayList<staticbomb>();
		}
		public static StaticBombPool getInstance() {
		if (instance == null)
		instance = new StaticBombPool();
		return instance;
		}
		public staticbomb acquire() {
		if (!freeList.isEmpty())
		{
			staticbomb object = freeList.remove(0);
		usedList.add(object);
		return object;
		}
		else
		return null;
		}
		public void release(staticbomb object) {
		if (usedList.remove(object))
		freeList.add(object);
		else
		System.err.println("Error, no such object in the pool");
		}
		public void setMaxPoolSize(int size, level Level, int x, int y) {
		this.size = size;
		for (int i = 0; i < size; i++){
			staticbomb s = new staticbomb(Level, randomVar.nextInt(Level.width-5)+3, randomVar.nextInt(Level.height-5)+3);
		freeList.add(new staticbomb(Level, randomVar.nextInt(Level.width-5)+3, randomVar.nextInt(Level.height-5)+3));
			
		}}
}
