// Michael Aldous
// Assignment 2
// Created 26/08/2017

package assignment2;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		//Creates dll lists 1 - 3
		DLL list1 = new DLL();
		DLL list2 = new DLL();
		DLL list3 = new DLL();

		//Addresses to text files
		String file1 = "file1.txt";
		String file2 = "file2.txt";
		String file3 = "file3.txt";

		//Reads data from files into dlls
		readData(list1, file1);
		readData(list2, file2);
		readData(list3, file3);

		//Display Data
		displayData(list1);
		displayData(list2);
		displayData(list3);

		//Display Intersecting Numbers
		dispIntersect(list1, list2, list3);
	}//End of method main
	
	//DLL display Intersecting method
	public static void dispIntersect(DLL list1, DLL list2, DLL list3){
		DLL intersectList = new DLL();
		intersectList = intersectList.intersection(list3,intersectList.intersection(list1, list2));
		if(intersectList.head!=null){
			System.out.print("Intersecting numbers: ");
			intersectList.printList();
		}else{
			System.out.println("No Intersecting Numbers Found");
		}
	}//End of display intersect
		
	//Reads in data from files
	public static void readData(DLL dll,String f){
		File path = new File(f);
		try {
			Scanner sc = new Scanner(path);
			while(sc.hasNextInt()){
				DLLNode p = new DLLNode(sc.nextInt());
				dll.addToTail(p);
			}
			sc.close();
		} catch(IOException e) {
			System.out.println("Can not find file: "+e.getMessage());
		}
		return;
	}//End of readData

	//Method used to display data
	public static void displayData(DLL dll){
		//Checks if list has object in it
		if(dll.head != null ){
			//Prints out size of list
			System.out.println("List Size: "+dll.listSize);

			//Finds middle number value, if even, displays both numbers
			DLLNode midTemp = dll.findMiddle();
			if(dll.listSize%2==0){
				System.out.println("First Middle Number: "+ midTemp.prev.num);
				System.out.println("Second Middle Number: "+ midTemp.num);
			}else{
				System.out.println("Middle Number: "+ midTemp.num);
			}
			//Displays prime numbers in list
			dll.displayPrimes();
			//Displays list of numbers from tail to head
			dll.printReverse();
		}else{
		System.out.println("List is empty");
		}
		System.out.print("\n");
	}//End of displayData

}//End of class main
