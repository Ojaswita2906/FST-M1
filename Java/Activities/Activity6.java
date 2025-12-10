package activities;

public class Activity6 {
    public static void main(String[] args) {
        Plane plane = new Plane(10);

        plane.onboard("Anmol");
        plane.onboard("Tapan");


        System.out.println("Plane took off: " + plane.takeOff());

        System.out.println("Passengers onboard: " + plane.getPassengers());

        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        plane.land();
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
    }
}
