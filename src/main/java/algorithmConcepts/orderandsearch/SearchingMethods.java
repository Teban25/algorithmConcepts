package algorithmConcepts.orderandsearch;

import java.util.List;
import java.util.Optional;

public class SearchingMethods {
	
	/**
	 * Search in a vector element by element till it find 
	 * the element required.
	 * Magnitude order = O(n)
	 * @param numbers
	 * @param numberToSearch
	 * @return
	 */
	public static Optional<Integer> searchingBySequencial(List<Integer> numbers,
			Integer numberToSearch){
		Optional<Integer> foundData = Optional.empty();
		int i = 0;
		while ((i<numbers.size()) && (numbers.get(i) != numberToSearch)) {
			i++;
		}
		if(i < numbers.size()) {
			foundData = Optional.of(numbers.get(i));
		}
		return foundData;
	}
	
	/**
	 * To use this method the List has being ordered
	 * @param numbers
	 * @param numberToSearch
	 * @return
	 */
	public static Optional<Integer> searchingByBinary(List<Integer> numbers, Integer numberToSearch){
		Optional<Integer> foundData = Optional.empty();
		int first = 0;
		int last = numbers.size();
		int half;
		
		while(first <= last) {
			half = (first + last)/2;
			
			if(numbers.get(half) == numberToSearch) {
				foundData = Optional.of(numbers.get(half));
				return foundData;
			}
			
			if(numbers.get(half) > numberToSearch) {
				last = half - 1;
			}else {
				first = half + 1;
			}
		}
		
		return foundData;
	}
}
