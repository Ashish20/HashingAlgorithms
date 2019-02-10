package hashingAlgorithms;

public class LinearProbe {

	private int hashSize = 199;
	private int a = 3;
	private int b = 42;
	private int p = 211;
	

	HashElement[] hashElement;

	public LinearProbe() {

		hashElement = new HashElement[hashSize];
		for (int i = 0; i < hashSize; i++)
			hashElement[i] = null;
	}

	//hash function used in scenario 1 and 2
//	public int hashFunction(int key) {
//
//		return key % hashSize;
//	}
	
	public int hashFunction(int key) {

		return ((a*key + b) % p)%hashSize;
		
	}

	
	public boolean checkSize() {
		
		for(int i =0; i<hashSize; i++) {
			if(hashElement[i] == null)
				return true;
		}
		
		return false;
		
	}

	public void set(int key, int value) throws Exception{
		
		if(checkSize()== false)
			throw new Exception("Element Cannot be inserted as the array is full");
		
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
		int start = index;
		while (hashElement[index] != null && hashElement[index].getKey() != -1 && hashElement[index].getKey() != key) {

			++i;
			index = hashFunction(key + i);
			if(index == start) {
				return null;
			}
		}
		
		return hashElement[index];
			
	}
	
	public void delete(int key) throws Exception {

		int index = hashFunction(key);

		int i =0;
		int start = index; boolean flag = false;
		while (hashElement[index] != null && hashElement[index].getKey() != key) {

			++i;
			index = hashFunction(key+i);
			if(index == start) {
				flag = true;
				break;
			}
		}
		
		if(flag == true || hashElement[index]==null)
			throw new Exception("Element does not exist");
		
		hashElement[index] = new HashElement(-1, -1);
		
	}


}
