
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArr = {5,7,6,4,3,3,1};
		printArr(insertionSort(myArr));
		printArr(insertionSort(new int[] {9,0,1,2}));
		printArr(insertionSort(new int[] {0}));
	}
	
	public static int[] insertionSort(int[] arr){
		if(arr.length < 0 || arr == null){
			throw new IllegalArgumentException("Cannot pass a null or empty array");
		}
		for(int counter1 = 1; counter1 < arr.length; counter1++){
			int val = arr[counter1];
			for(int counter2 = 0; counter2 < counter1; counter2++){
				if(arr[counter2] > arr[counter1]){
					System.arraycopy(arr, counter2, arr, counter2+1, counter1 - counter2);
					arr[counter2] = val;
					break;
				}
			}
		}
		return arr;
	}
	public static void printArr(int[] arr){
		if(arr == null){
			throw new NullPointerException("Cannot pass in a nonexisting object");
		}
		System.out.print("[");
		for(int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length-1] + "]");
	}
}
