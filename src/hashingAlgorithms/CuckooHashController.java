package hashingAlgorithms;

public class CuckooHashController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CuckooHash obj = new CuckooHash();

		int[] arr = { 12, 26, 92, 23, 28, 94 };
		int noOfElements = arr.length;

		System.out.println("======Setting elements=======");
		for (int i = 0; i < noOfElements; i++) {
			try {
				obj.set(arr[i], i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("======Elements set =======");

		System.out.println("=====Searching elements without deleting======");

		for (int i = 0; i < noOfElements; i++) {
			HashElement element = obj.search(arr[i]);
			if (element != null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + arr[i] + " Not found");
			}
		}

		System.out.println("======Deleting elements=======");

		for (int i = 0; i < 2; i++) {

			try {
				obj.delete(arr[i]);
			} catch (Exception e) { // TODO Auto-generated catch
				e.printStackTrace();
			}
		}

		System.out.println("======Elements deleted=======");

		System.out.println("=====Searching elements after deleting======");

		for (int i = 0; i < noOfElements; i++) {
			HashElement element = obj.search(arr[i]);
			if (element != null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + arr[i] + " Not found");
			}
		}
	}

}
