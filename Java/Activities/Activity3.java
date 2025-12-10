package activities;

public class Activity3 {

	public static void main(String[] args) {
		double age = 1000000000;
		findAge(age);
		
	}
	
	public static void findAge(double age) {
		
		double EarthSec = 31557600;
		double MercurySec = 0.2408467;
		double VenusSec = 0.61519726;
		double MarsSec = 1.8808158;
		double JupiterSec = 11.862615;
		double SaturnSec = 29.447498;
		double UranusSec = 84.016846;
		double NeptuneSec = 164.79132;
		
		double EarthAge = age/EarthSec;
		double MercuryAge = age/EarthSec/MercurySec;
		double VenusAge = age/EarthSec/VenusSec;
		double MarsAge = age/EarthSec/MarsSec;
		double JupiterAge = age/EarthSec/JupiterSec;
		double SaturnAge = age/EarthSec/SaturnSec;
		double UranusAge = age/EarthSec/UranusSec;
		double NeptuneAge = age/EarthSec/NeptuneSec;
		
		System.out.println("EarthAge: "+EarthAge);
		System.out.println("MercuryAge: "+MercuryAge);
		System.out.println("VenusAge: "+VenusAge);
		System.out.println("MarsAge: "+MarsAge);
		System.out.println("JupiterAge: "+JupiterAge);
		System.out.println("SaturnAge: "+SaturnAge);
		System.out.println("UranusAge: "+UranusAge);
		System.out.println("NeptuneAge: "+NeptuneAge);

	}

}
