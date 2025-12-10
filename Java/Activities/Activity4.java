package activities;

public class Activity4 {

	public static void main(String[] args) {

		int[] numbers = {39, 20, 11, 77, 3, 12, 35, 6};
		
		System.out.println("Original Array:");
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
		
		
		insertionSort(numbers);
		
		
		System.out.println("Sorted Array:");
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
		
		
	}
	
	public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

}
