package hashingAlgorithms;

import java.util.*;

public class HashChaining {

	private int initialSize = 255;

	HashList hashList[];

	public HashChaining() {

		hashList = new HashList[initialSize];

		for (int i = 0; i < hashList.length; i++) {
			hashList[i] = null;
		}
	}

	public int hashFunction(int key) {

		return key % initialSize;
	}

	public void set(int key, int value) {

		int index = hashFunction(key);

		HashList newElement = new HashList(key, value);

		if (hashList[index] != null) {

			HashList hashElement = hashList[index];
			while (hashElement.getNextElement() != null && hashElement.getKey() != key) {
				hashElement = hashElement.getNextElement();
			}

			if (hashElement.getKey() == key) {
				hashElement.setValue(value);
			} else {
				hashElement.setNextElement(newElement);
			}
		} else {
			hashList[index] = newElement;
		}

	}

	public HashList search(int key) {

		int index = hashFunction(key);

		if (hashList[index] == null)
			return null;
		else {
			HashList hashElement = hashList[index];

			while (hashElement.getNextElement() != null && hashElement.getKey() != key) {
				hashElement = hashElement.getNextElement();
			}

			if (hashElement.getKey() == key)
				return hashElement;
		}

		return null;
	}

	public void delete(int key) throws Exception {

		int index = hashFunction(key);

		if (hashList[index] != null) {

			HashList previousElement = null;
			HashList currentElement = hashList[index];

			while (currentElement.getNextElement() != null && currentElement.getKey() != key) {
				previousElement = currentElement;
				currentElement = currentElement.getNextElement();
			}

			if (currentElement.getNextElement() == null && currentElement.getKey() != key)
				throw new Exception("Element does not exist");

			if (previousElement != null && currentElement.getKey() == key)
				previousElement.setNextElement(currentElement.getNextElement());

			if (previousElement == null && currentElement.getKey() == key)
				hashList[index] = null;

		} else {
			throw new Exception("Element does not exist");
		}
	}
}
