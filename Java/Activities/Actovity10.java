package activities;

import java.util.HashSet;

public class Actovity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs =new HashSet<String>();
		
		hs.add("Anmol");
		hs.add("Aman");
		hs.add("Tapan");
		hs.add("Amay");
		hs.add("Arav");
		hs.add("Nidhi");

		System.out.println("Size of Hashs: " + hs.size());
		
		System.out.println("Remove Arav: " +hs.remove("Arav"));
		
		System.out.println("Remove Amrit: "+ hs.remove("Amrit"));
		
		System.out.println("Check if Aman is present in the set or not: " + hs.contains("Aman"));
		
		System.out.println("Updated Set:");
		
		for (String name : hs) {
			System.out.println(name);
			
		}

	}

}
