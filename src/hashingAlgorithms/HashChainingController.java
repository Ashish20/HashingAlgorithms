package hashingAlgorithms;

import java.util.*;

public class HashChainingController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashChaining obj = new HashChaining();
		
		int noOfElements = 500;
		
		System.out.println("======Setting 500 elements=======");
		for(int i = 1; i<noOfElements; i++)
			obj.set(i, i*10);
		
		System.out.println("======500 elements set =======");
		
		System.out.println("=====Searching elements without deleting======");

		for(int i =1; i<noOfElements; i++) {
			HashList element = obj.search(i);
			if(element!=null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + i + " Not found");
			}
		}
		
		System.out.println("======Deleting elements=======");
		for(int i =1; i<noOfElements; i+=11) {

			try {
				obj.delete(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("======Elements deleted=======");
		
		System.out.println("=====Searching elements after deleting======");
		
		for(int i =1; i<noOfElements; i+=11) {
			HashList element = obj.search(i);
			if(element!=null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + i + " Not found");
			}
		}
		System.out.println("======Search ended=======");
		
	}

}
