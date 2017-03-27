import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;
// Vaibhavi Doiohode: Binary search has a complexity of O(log n)base2. This is to indicate that we 
// continually divide the list into half until we find x. Hence k =log2(n) represents the value of 
// number of times you divide n by 2 until you get to one. Must operate on sorted list.

public class BinarySearchNormal {

	//Why are these methods declared static?
	public static boolean binarySearchRecursive(int[] a, int x, int left, int right){
		if (left > right) {
			return false;
		}
		 
		int mid = (left + right)/ 2;
		// P: Above line could invite integer overflow
		// S: int mid = left + ((right - left) / 2);
		if (a[mid] == x) {
			System.out.println("Found " + x + " in array " + "at position " + mid);
			System.out.println("----------------------------------------------------------");
			return true;
		} else if (x < a[mid]) {
			binarySearchRecursive(a, x, 0, mid-1);
		} else {	
			binarySearchRecursive(a, x, mid+1, right);
		}
		
		return false;
	}
	
	public static boolean binarySearchIterative(int[] a, int x){
		int left = 0;
		int right = a.length - 1;
		int k = 0;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			k++;
			if (a[mid] == x) {
				System.out.println("Found " + x + " in array " + "at position " + (mid + 1));
				System.out.println("----------------------------------------------------------");
				return true;
			} else if (x < a[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}	
			System.out.println("Searching for " + x + " using Iterative method: Iteration " + k);
			

		}
		
		return false;
	}
	
	public static boolean binarySearchIterativeForString(String sentence, String word){
		ArrayList<String> wordArrayList = new ArrayList<String>();
		for(String temp : sentence.split(" ")) {
		    wordArrayList.add(temp);
		}
		
		int left = 0;
		int right = wordArrayList.size();
				
			for (String temp: wordArrayList) {
				if (temp.equals(word)) {
					System.out.println("Found!\nSearched word: " + word + "\n" + "Position: "+ (wordArrayList.indexOf(temp)+1));
					System.out.println("----------------------------------------------------------");
					return true;
				}
			}
		
		//System.out.println(wordArrayList);
		
		return false;
		
	}

	 
	public static boolean binarySearchRecursive(int[] array, int x) {
		return binarySearchRecursive(array, x, 0, array.length - 1);
		
	}
	
	public static void main(String[] args) {
		int[] temp = {1, 3, 4, 5, 13, 20, 25, 40, 42, 44, 53};
		String sentence = "I have always been interested in psychology and philosophy";
		String word = "and";
		System.out.println("Starting Method calls.. ");
		binarySearchRecursive(temp, 4);
		binarySearchIterative(temp, 53);
		binarySearchIterativeForString(sentence, word);

		
	}
}
