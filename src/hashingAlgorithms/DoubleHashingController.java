package hashingAlgorithms;

import java.util.Random;

public class DoubleHashingController {

	public static void main(String[] args) {

		DoubleHashing obj = new DoubleHashing();

//		int[] arr = {18,41,22,44,59,32,31,73, 273};
//		int[] arr = { 12, 26, 92, 23, 28, 94 };

		int noOfElements = 500;
		int arr[] = new int[noOfElements];

		for (int k = 0; k < noOfElements; k++) {
			Random rand = new Random();
			arr[k] = rand.nextInt(500);
//			arr[k] =k; Data for 1st scenario
		}

		System.out.println("======Setting elements=======");

		long startTime = System.nanoTime();
		for (int i = 0; i < noOfElements; i++) {
			try {
				obj.set(arr[i], i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Element cannot be inserted as the hash is full");
				break;
			}
		}

		long endTime = System.nanoTime();
		System.out.println("Time taken for setting elements = " + (endTime - startTime));
		System.out.println("======Elements set =======");

		double loadFactor = obj.getLoadFactor();

		loadFactor = Math.round(loadFactor * 100.0) / 100.0;

		System.out.println("Load Factor is " + loadFactor);

		System.out.println("=====Searching elements without deleting======");
		startTime = System.nanoTime();
		for (int i = 0; i < noOfElements; i++) {
			HashElement element = obj.search(arr[i]);
			if (element != null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + arr[i] + " Not found");
			}
		}
		endTime = System.nanoTime();
		System.out.println("Time taken for setting elements = " + (endTime - startTime));
		System.out.println("======Search ended=======");
		System.out.println("======Deleting elements=======");
		startTime = System.nanoTime();
		for (int i = 0; i < noOfElements; i += 11) {

			try {
				obj.delete(arr[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Element " + arr[i] + " Not found");
			}
		}
		endTime = System.nanoTime();
		System.out.println("Time taken for deleting elements = " + (endTime - startTime));
		System.out.println("======Elements deleted=======");

		System.out.println("=====Searching elements after deleting======");
		startTime = System.nanoTime();
		for (int i = 0; i < noOfElements; i++) {
			HashElement element = obj.search(arr[i]);
			if (element != null)
				System.out.println("Key - " + arr[i] + " Value " + element.getValue());
			else {
				System.out.println("Key - " + arr[i] + " Not found");
			}
		}
		endTime = System.nanoTime();
		System.out.println("Time taken for deleting elements = " + (endTime - startTime));
		System.out.println("======Search ended=======");

	}

}
