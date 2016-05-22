
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArr = {5,7,6,4,3,3,1};
		printArr(selectionSort(myArr));
		printArr(selectionSort(new int[] {9,0,1,2}));
		printArr(selectionSort(new int[] {0}));
	}
	public static int[] selectionSort(int[] arr){
		if(arr.length < 1 || arr == null){
			throw new NullPointerException("Cannot pass a null or empty array.");
		}
		int minIndex;
		for(int i = 0; i < arr.length; i++){
			minIndex = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
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
