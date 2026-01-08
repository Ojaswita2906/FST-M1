package activities;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Addable add1 = (a,b)-> (a+b);
		Addable add2 = (int a, int b) ->{
			return a+b;
		};
		
		System.out.println("add1(1,2)=  " + add1.add(1,2));
		System.out.println("add2(5,6)= " + add2.add(5, 6));
		
		
		

	}

}
