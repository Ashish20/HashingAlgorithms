package hashingAlgorithms;

public class LinearProbeController {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		HashChaining obj = new HashChaining();
		LinearProbe obj = new LinearProbe();
		
		int[] arr = {18,41,22,44,59,32,31,73};
		int noOfElements = arr.length;
		
		System.out.println("======Setting 500 elements=======");
		for(int i = 0; i<noOfElements; i++)
			obj.set(arr[i], i);
		
		System.out.println("======500 elements set =======");
		
		System.out.println("=====Searching elements without deleting======");

		for(int i =0; i<noOfElements; i++) {
			HashElement element = obj.search(arr[i]);
			if(element!=null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + i + " Not found");
			}
		}
		
		System.out.println("======Deleting elements=======");
		/*for(int i =1; i<noOfElements; i+=11) {

			try {
				obj.delete(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		System.out.println("======Elements deleted=======");
		
		System.out.println("=====Searching elements after deleting======");
		
	/*	for(int i =1; i<noOfElements; i+=11) {
			LinearHashElement element = obj.search(i);
			if(element.getKey()!=-1)
				System.out.println("Key - " + i + " Value " + element.getValue());
			else {
				System.out.println("Key - " + i + " Not found");
			}
		}
		System.out.println("======Search ended=======");*/
		
	}


}
