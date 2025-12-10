package activities;

public class MountainBike extends Bicycle{
	
	public int seatHeight;

	public MountainBike(int gears, int speed, int seatHeight) {
		// TODO Auto-generated constructor stub
		super(gears, speed);
		this.seatHeight=seatHeight;
		
	}
	
	public void setHeight(int seatheight) {
	    seatHeight = seatheight;
	}
	
	@Override
	public String bicycleDesc() {
		// TODO Auto-generated method stub
		return (super.bicycleDesc()+"\nSeatHeight of bicycle is " + this.seatHeight);
	}
}
