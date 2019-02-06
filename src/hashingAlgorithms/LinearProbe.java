package hashingAlgorithms;

public class LinearProbe {

	private int hashSize = 13;

	HashElement[] hashElement;

	public LinearProbe() {

		hashElement = new HashElement[hashSize];
		for (int i = 0; i < hashSize; i++)
			hashElement[i] = null;
	}

	public int hashFunction(int key) {

		return key % hashSize;
	}

	public void set(int key, int value) {

		int index = hashFunction(key);

		HashElement newElement = new HashElement(key, value);

		int i =0;
		while (hashElement[index] != null && hashElement[index].getKey() != -1 && hashElement[index].getKey() != key) {
			++i;
			index = hashFunction(key + i);
//			System.out.println("Index - " + index);
		}

		hashElement[index] = newElement;
	}
	
	public HashElement search(int key) {

		int index = hashFunction(key);

		int i =0;
		while (hashElement[index] != null && hashElement[index].getKey() != -1 && hashElement[index].getKey() != key) {
//			key+=1;
			++i;
			index = hashFunction(key + i);
		}
//			index = hashFunction(key + 1);
		
		System.out.println("Key Found in index - " + index);
		
		return hashElement[index];
			
	}
	
	public void delete(int key) throws Exception {

		int index = hashFunction(key);

		int i =0;
		while (hashElement[index] != null && hashElement[index].getKey() != key) {
//			key+=1;
			++i;
			index = hashFunction(key+i);
		}
		
		if(hashElement[index]==null)
			throw new Exception("Element does not exist");
		
		hashElement[index] = new HashElement(-1, -1);
		
	}


}
