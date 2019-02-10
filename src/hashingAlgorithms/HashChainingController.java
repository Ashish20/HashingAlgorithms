package hashingAlgorithms;

import java.util.*;
import java.lang.Object;

public class HashChainingController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashChaining obj = new HashChaining();
		
		int noOfElements = 500;
		int arr[] = new int[noOfElements];

		for (int k = 0; k < noOfElements; k++) {
			Random rand = new Random();
			arr[k] = rand.nextInt(500);
//			arr[k] =k; Data for 1st scenario
		}
		
		System.out.println("======Setting 500 elements=======");
		
		long startTime = System.nanoTime(); 
		for(int i = 0; i<noOfElements; i++)
			obj.set(arr[i], i*10);
		
		long endTime = System.nanoTime();
		
		System.out.println("Time taken for setting elements = " + (endTime - startTime));
		
		System.out.println("======500 elements set =======");
		
		//load factor always 1;
		
		System.out.println("=====Searching elements without deleting======");

		startTime = System.nanoTime(); 
		for(int i =1; i<noOfElements; i++) {
			HashList element = obj.search(arr[i]);
			if(element!=null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + i + " Not found");
			}
		}
		
		endTime = System.nanoTime();
		
		System.out.println("Time taken for searching elements  = " + (endTime - startTime));
		
		System.out.println("=====Searching ended======");
		System.out.println("======Deleting elements=======");
		
		startTime = System.nanoTime();
		for(int i =0; i<noOfElements; i+=11) {

			try {
				obj.delete(arr[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Element " + i + " does not exist");
			}
		}
		
		endTime = System.nanoTime();
		
		System.out.println("Time taken for deleting elements = " + (endTime - startTime));
		System.out.println("======Elements deleted=======");
		
		System.out.println("=====Searching elements after deleting======");
		
		startTime = System.nanoTime();
		for(int i =1; i<noOfElements; i++) {
			HashList element = obj.search(arr[i]);
			if(element!=null)
				System.out.println("Key - " + element.getKey() + " Value " + element.getValue());
			else {
				System.out.println("Key - " + arr[i] + " Not found");
			}
		}
		endTime = System.nanoTime();
		System.out.println("Time taken for searching after deleting elements = " + (endTime - startTime));
		System.out.println("======Search ended=======");
		
	}

}
