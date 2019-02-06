package hashingAlgorithms;

public class DoubleHashing {

	int hashSize = 11;
	HashElement[] hashArray;

	public DoubleHashing() {

		hashArray = new HashElement[hashSize];

		for (int i = 0; i < hashSize; i++) {
			hashArray[i] = null;
		}

	}

	public int hashFunction(int key, int hashToBeUsed) {

		if (hashToBeUsed == 0)
			return hashFunctionOne(key);

		return hashFunctionTwo(key);

	}

	public int hashFunctionOne(int key) {

		return key % hashSize;
	}

	public int hashFunctionTwo(int key) {

		key = key / hashSize;
		return (key % hashSize);
	}

	public void set(int key, int value) throws Exception {

		HashElement element = new HashElement(key, value);

		int hashToBeUsed = 0;

		int index = hashFunction(key, hashToBeUsed);
		if (hashArray[index] != null && hashArray[index].getKey() != key) {

			for (int i = 1; i < hashSize; i++) {

				index = (hashFunction(key, hashToBeUsed) + i * hashFunction(key, 1 - hashToBeUsed)) % hashSize;
				System.out.println("New Index " + index);
				if (hashArray[index] == null || hashArray[index].getKey() == key) {

					System.out.println("Element set at ArrayZero Index " + index + " Key - " + element.getKey()
							+ "Value - " + element.getValue());

					hashArray[index] = element;
					return;
				}
			}

			throw new Exception("Element cannot be inserted as the hash is full");

		} else {

			System.out.println("Element set at ArrayZero Index " + index + " Key - " + element.getKey() + "Value - "
					+ element.getValue());
			hashArray[index] = element;
			return;
		}
	}

	public HashElement search(int key) {

		int hashToBeUsed = 0;
		int index = hashFunction(key, hashToBeUsed);

		if (hashArray[index] == null || hashArray[index].getKey() != key) {

			for (int i = 1; i < hashSize; i++) {

				index = (hashFunction(key, hashToBeUsed) + i * hashFunction(key, 1 - hashToBeUsed)) % hashSize;
				if (hashArray[index] != null && hashArray[index].getKey() == key) {

					System.out.print("Element found at index - " + index + " with ");
					return hashArray[index];

				}
			}
		} else {
			if (hashArray[index] != null && hashArray[index].getKey() == key) {
				System.out.print("Element found at index - " + index + " with ");
				return hashArray[index];
			}
		}

		return null;

	}

	public void delete(int key) throws Exception {

		int hashToBeUsed = 0;
		int index = hashFunction(key, hashToBeUsed);

		if (hashArray[index] != null && hashArray[index].getKey() != key) {

			for (int i = 1; i < hashSize; i++) {

				index = (hashFunction(key, hashToBeUsed) + i * hashFunction(key, 1 - hashToBeUsed)) % hashSize;
				if (hashArray[index] != null && hashArray[index].getKey() == key) {

					System.out.println("Element deleted at index - " + index+ " with key " + key);
					hashArray[index] = null;
					return;

				}
			}
		}

		if (hashArray[index].getKey() == key) {
			System.out.println("Element deleted at index - " + index + " with key " + key);
			hashArray[index] = null;
		}
		else
			throw new Exception("Element does not exist");

	}

}
