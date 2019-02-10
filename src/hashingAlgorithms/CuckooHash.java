package hashingAlgorithms;

public class CuckooHash {

	public int hashSize = 199;
	private int a = 3;
	private int b = 42;
	private int p = 211;
	private int a1 = 4;
	private int b1 = 43;

	HashElement[] hashArrayZero;
	HashElement[] hashArrayOne;

	static int arrayToBeInserted;

	public CuckooHash() {

		hashArrayZero = new HashElement[hashSize];
		hashArrayOne = new HashElement[hashSize];

		for (int i = 0; i < hashSize; i++) {
			hashArrayZero[i] = null;
			hashArrayOne[i] = null;
		}
		arrayToBeInserted = 0;
	}

	public int hashFunction(int key, int arrayToBeSearched) {

		if (arrayToBeSearched == 0)
			return hashFunctionZero(key);

		return hashFunctionOne(key);

	}

	public int getSize() {

		int count = 0;
		for (int i = 0; i < hashSize; i++) {
			if (hashArrayZero[i] != null)
				++count;
			if (hashArrayOne[i] != null)
				++count;
		}

		return count;

	}

	public double getLoadFactor() {

		double result;

		int currSize = getSize();
		
		result = (double)currSize/(2*hashSize);

		return result;

	}

//	public int hashFunctionZero(int key) {
//
//		return key % hashSize;
//	}
	
	public int hashFunctionZero(int key) {

		return ((a*key + b) % p)%hashSize;
		
	}

//	public int hashFunctionOne(int key) {
//
//		key = key / hashSize;
//		return (key % hashSize);
//	}
	
	public int hashFunctionOne(int key) {

		return ((a1*key + b1) % p)%hashSize;
		
	}

	public boolean checkCount(int i) {

		if (i > 3)
			return false;

		return true;
	}

	public HashElement search(int key) {

		int arrayToBeSearched = 0;

		int i = 0;
		while (checkCount(i)) {

			int index = hashFunction(key, arrayToBeSearched);
			if (arrayToBeSearched == 0) {
				if (hashArrayZero[index] != null && hashArrayZero[index].getKey() != key) {
					arrayToBeSearched = 1 - arrayToBeSearched;
					++i;
				} else {
//					System.out.print("Array 0 Index - " + index);
					return hashArrayZero[index];
				}
			} else {
				if (hashArrayOne[index] != null && hashArrayOne[index].getKey() != key) {
					arrayToBeSearched = 1 - arrayToBeSearched;
					++i;
				} else {
//					System.out.print("Array 1 Index - " + index);
					return hashArrayOne[index];
				}

			}
		}

		return null;
	}

	public void delete(int key) throws Exception {

		int arrayToBeSearched = 0;
		int i = 0;
		while (checkCount(i)) {
			int index = hashFunction(key, arrayToBeSearched);
			if (arrayToBeSearched == 0) {
				if (hashArrayZero[index] != null && hashArrayZero[index].getKey() != key) {
					arrayToBeSearched = 1 - arrayToBeSearched;
					++i;
				} else {
					if (hashArrayZero[index].getKey() == key) {
						hashArrayZero[index] = null;
						return;
					}
				}
			} else {
				if (hashArrayOne[index] != null && hashArrayOne[index].getKey() != key) {
					arrayToBeSearched = 1 - arrayToBeSearched;
					++i;
				} else {
					if (hashArrayOne[index].getKey() == key) {
						hashArrayOne[index] = null;
						return;
					}
				}
			}
		}

		if (checkCount(i) == false) {
			throw new Exception("Element Not Found");
		}
	}

	public void set(int key, int value) throws Exception {

		try {
			utility(key, value, 0, key);
		} catch (Exception e) {
			throw e;
		}

	}

	public void utility(int key, int value, int i, int originalKey) throws Exception {

		HashElement element = new HashElement(key, value);

		if (key == originalKey)
			++i;

		int index = hashFunction(key, arrayToBeInserted);

//		int i = 0;
		while (checkCount(i)) {
			if (arrayToBeInserted == 0) {
				if (hashArrayZero[index] != null && hashArrayZero[index].getKey() != key) {

					HashElement temp = hashArrayZero[index];
					hashArrayZero[index] = element;

//				System.out.println("Element set at ArrayZero Index " + index + " Key - " + element.getKey() + "Value - "
//						+ element.getValue());

					arrayToBeInserted = 1 - arrayToBeInserted;
//				++i;
					utility(temp.getKey(), temp.getValue(), i, originalKey);
					return;
				} else {

//					System.out.println("Element set at ArrayZero Index " + index + " Key - " + element.getKey()
//							+ "Value - " + element.getValue());

					hashArrayZero[index] = element;
					return;
				}
			} else {
				if (hashArrayOne[index] != null && hashArrayOne[index].getKey() != key) {

					HashElement temp = hashArrayOne[index];
					hashArrayOne[index] = element;

//				System.out.println("Element set at ArrayOne Index " + index + " Key - " + element.getKey() + "Value - "
//						+ element.getValue());

					arrayToBeInserted = 1 - arrayToBeInserted;
//				++i;
					utility(temp.getKey(), temp.getValue(), i, originalKey);
					return;
				} else {

//					System.out.println("Element set at ArrayOne Index " + index + " Key - " + element.getKey()
//							+ "Value - " + element.getValue());

					hashArrayOne[index] = element;
					return;
				}
			}
		}

		throw new Exception("Element Cannot be inserted as hash is full");
	}
}
