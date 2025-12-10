package activities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Plane {
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;
    
    public Plane(int maxPass)
    {
    	this.maxPassengers=maxPass;
    	this.passengers=new ArrayList<String>();
    }
    
    public void onboard(String PassName) {
    	if (passengers.size() < maxPassengers) {
            this.passengers.add(PassName);
        } else {
            System.out.println("Cannot onboard " + PassName + ". Plane is full.");
        }
    }
    public Date takeOff() {
        this.lastTimeTookOf = new Date();
        return this.lastTimeTookOf;
    }
    
    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }
    
    public List<String> getPassengers() {
        return new ArrayList<>(passengers); 
    }

}
