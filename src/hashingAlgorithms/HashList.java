package hashingAlgorithms;

public class HashList {
	
	private int key;
	private int value;
	
	private HashList nextElement;
	
	public HashList(int key, int value) {
		
		this.key = key;
		this.value = value;
		
		this.nextElement = null;
	}
	
	public HashList getNextElement() {
		return nextElement;
	}

	public void setNextElement(HashList nextElement) {
		this.nextElement = nextElement;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
