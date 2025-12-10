package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> myList =new ArrayList<String>();
		
		myList.add("Anmol");
		myList.add("Aman");
		myList.add("Tapan");
		myList.add("Amay");
		myList.add("Arav");

		for (String name : myList) {
			System.out.println(name);
		}

		System.out.println("Third Name: "+myList.get(2));
		
		System.out.println("Is Amay present in the list: "+ myList.contains("Amay"));
		
		System.out.println("Number of elements in the list: " + myList.size());
		
		myList.remove("Amay");
		
		System.out.println("Size of the list after removing Amay: " + myList.size());
	}

}
