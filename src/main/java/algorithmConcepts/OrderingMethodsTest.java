package algorithmConcepts;

import java.util.Arrays;
import java.util.List;

import algorithmConcepts.orderingMethods.OrderingMethods;

public class OrderingMethodsTest {

	public static void main(String[] args) {
		List<Integer> numbersToOrder = Arrays.asList(3,1,6,4,2,10,5);
		List<Integer> aux = Arrays.asList(3,1,6,4,2,10,5);
		
		System.out.println("\nArreglo inicial: " + numbersToOrder);
		
		System.out.println("\nPor seleccion: " + OrderingMethods.orderingBySelection(numbersToOrder));
		
		numbersToOrder = aux;
		
		System.out.println("\nPor inserccion: " + OrderingMethods.orderingByInsertion(numbersToOrder));
	}
}
