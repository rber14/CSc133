package com.mycompany.a1;

import java.util.Vector;

public class GameObjectCollection implements ICollection{
	private Vector<GameObject> WorldObjects = new Vector<GameObject>();
	
	public class GameObjectIterator implements IIterator {
		
		private int currentIndex = -1;
	
	
		public Object getNext() {
			this.currentIndex ++;
			return WorldObjects.get(this.currentIndex);
		}

	
		public boolean hasNext() {
			if (WorldObjects.size() <= 0) return false;
			if (this.currentIndex == WorldObjects.size() - 1) return false;
			return true;
		}
		
		
	}
	

	public void add(Object obj) {
		this.WorldObjects.add((GameObject)obj);
	}

	public IIterator getIterator() {
		return new GameObjectIterator();
		
	}
}
