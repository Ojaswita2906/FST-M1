package activities;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainBike mb = new MountainBike(3, 0, 25);
	    System.out.println(mb.bicycleDesc());
	    mb.speedUp(20);
	    mb.applyBrake(5);
	    System.out.println("\nUpdatet Value:\n");
	    System.out.println(mb.bicycleDesc());

	}

}
