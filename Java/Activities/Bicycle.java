package activities;

public class Bicycle implements BicycleParts, BicycleOperations{
	
	public int gears;
	public int speed;
	
	public Bicycle(int gears, int speed) {
		// TODO Auto-generated constructor stub
		this.gears=gears;
		this.speed=speed;	
	}
	
	@Override
	public void applyBrake(int decrement) {
		// TODO Auto-generated method stub
		this.speed=this.speed-decrement;
		
	}
	
	@Override
	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		this.speed=this.speed+increment;
		
	}
	
	public String bicycleDesc() {
	    return("No of gears are "+ this.gears + "\nSpeed of bicycle is " + this.speed);
	}

}
