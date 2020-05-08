package algorithmConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import algorithmConcepts.orderandsearch.OrderingMethods;
import algorithmConcepts.orderandsearch.SearchingMethods;

public class SearchingMethodsTest {

	public static void main(String[] args) {
		List<Integer> numbers = OrderingMethods.orderingByBubbleBetter(Arrays.asList(3, 1, 6, 4, 2, 10, 5));
		Optional<Integer> numberFound;
		int numberToSearch = 1;
		
		numberFound = SearchingMethods.searchingBySequencial(numbers, numberToSearch);
		System.out.println("\n(Por metodo secuencial)Existe el numero " + 6 +" en la lista: " + numbers + " ?"
				+ " Rpt:" + numberFound.isPresent());
		
		numberFound = SearchingMethods.searchingByBinary(numbers, numberToSearch);
		System.out.println("\n(Por metodo binario)Existe el numero " + 6 +" en la lista: " + numbers + " ?"
				+ " Rpt:" + numberFound.isPresent());
	}
}
