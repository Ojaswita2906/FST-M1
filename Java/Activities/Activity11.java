package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> colours =new HashMap<Integer, String>();
		
		colours.put(1, "Red");
		colours.put(2, "Blue");
		colours.put(3, "White");
		colours.put(4, "Yellow");
		colours.put(5, "Green");
		
		System.out.println(colours);
		
		System.out.println("Remove Yellow: "+ colours.remove(4));
		
		System.out.println("Check if green is present or not: " + colours.containsValue("Green"));
		
		System.out.println("Size of map: " + colours.size());
		


	}

}
