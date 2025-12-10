package activities;

public class Activity8 {
	public static void exceptionTest(String value) throws CustomException {
        if (value == null) {
            throw new CustomException("CustomException: Input string is null.");
        } else {
            System.out.println("Value: " + value);
        }
    }

	public static void main(String[] args) {

		 try {
				 Activity8.exceptionTest("Will print to console");
				 Activity8.exceptionTest(null); 
	        } catch (CustomException e) {
	            System.out.println("Caught Exception: " + e.getMessage());
	        }
	}
	
	
	

}
