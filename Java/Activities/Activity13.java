package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		Random indexGen = new Random();
		
		System.out.println("Enter integer:");
		
		while(scan.hasNextInt()) {
		    list.add(scan.nextInt());
		}
		
		Integer nums[] = list.toArray(new Integer[0]);
		
		int rand = indexGen.nextInt(nums.length);
		
		System.out.println("Random index: "+ rand + " & Value in array: "+ nums[rand]);
		
		
		scan.close();
	}

}
