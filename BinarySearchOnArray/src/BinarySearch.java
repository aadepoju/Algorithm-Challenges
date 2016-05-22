
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int binarySearch(int[] array, int target){
		if(array == null || array.length < 1){
			throw new IllegalArgumentException("Cannot perform search on empty or null array.");
		}
		return binarySearch(array, target, 0, array.length - 1);
		
	}
	public int binarySearch(int[] array, int target, int lowerBound, int upperBound){
		int range = upperBound - lowerBound;
		int center;
		if (range < 0){
			throw new IllegalArgumentException("Your upper and lower bound limits must be reversed.");
		} else if( range == 0 && array[lowerBound] != target ){
			throw new IllegalArgumentException("Your target element is not in this array.");
		}
		if( array[lowerBound] > array[upperBound] ){
			throw new IllegalArgumentException("Array not sorted");
		}
		center = ((range)/2) + lowerBound;
		if( target == array[center] ){
			return center; //base case
		} else if( target < array[center] ){
			return binarySearch( array, target, lowerBound, center - 1 ); //recurse on lower half
		} else {
			return binarySearch( array, target, center + 1, upperBound ); //recurse on upper half
		}
		
	}

}
