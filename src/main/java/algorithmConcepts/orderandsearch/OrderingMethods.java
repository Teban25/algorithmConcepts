package algorithmConcepts.orderandsearch;

import java.util.List;

/**
 * Class with the differents
 * ordering methods
 * @author davidesteban.gomez
 *
 */
public class OrderingMethods {

	/**
	 * Basically, this method order by position, it means,
	 * search what is the smaller element in which position and interchange it with the index
	 * Magnitude order = 5n(n-1)/2 + 5n + 1 => O(n^2)
	 * @param numbersToOrder
	 * @return
	 */
	public static List<Integer> orderingBySelection(List<Integer> numbersToOrder){
		int k;
		for (int i = 0; i < numbersToOrder.size() - 1; i++) {
			k = i;
			for (int j = i + 1; j < numbersToOrder.size(); j++) {
				if(numbersToOrder.get(j) < numbersToOrder.get(k)) {
					k = j;
				}
			}
			changeValuesByPosition(i, k,numbersToOrder);
		}
		return numbersToOrder;
	}

	/**
	 * Magnitude order = 4n(n-1)/2 + 5n -2 => O(n^2)
	 * @param numbersToOrder
	 * @return
	 */
	public static List<Integer> orderingByInsertion(List<Integer> numbersToOrder){
		int d,j;
		for (int i = 1; i < numbersToOrder.size(); i++) {
			d = numbersToOrder.get(i);
			j = i - 1;
			while ((j>=0) && (d<numbersToOrder.get(j))) {
				numbersToOrder.set(j + 1, numbersToOrder.get(j));
				j = j - 1;
			}
			numbersToOrder.set(j + 1, d);
		}
		return numbersToOrder;
	}
	
	/**
	 * Magnitude order = 5n(n-1)/2 + 3n + 1 => O(n^2)
	 * @param numbersToOrder
	 * @return
	 */
	public static List<Integer> orderingByBubble(List<Integer> numbersToOrder){
		for (int i = 0; i < numbersToOrder.size() - 1; i++) {
			for (int j = 0; j < (numbersToOrder.size() - 1) - i; j++) {
				if (numbersToOrder.get(j) > numbersToOrder.get(j + 1)) {
					changeValuesByPosition(j, j + 1, numbersToOrder);
				}
			}
		}
		return numbersToOrder;
	}
	
	/**
	 * Magnitude order = 6n(n-1)/2 + 5n - 1=> O(n^2)
	 * @param numbersToOrder
	 * @return
	 */
	public static List<Integer> orderingByBubbleBetter(List<Integer> numbersToOrder){
		int changed;
		for (int i = 0; i < numbersToOrder.size() - 1; i++) {
			changed = 0;
			for (int j = 0; j < (numbersToOrder.size() - 1 ) - i; j++) {
				if (numbersToOrder.get(j) > numbersToOrder.get(j + 1)) {
					changeValuesByPosition(j, j + 1, numbersToOrder);
					changed = 1;
				}
			}
			if(changed == 0) {
				break;
			}
		}
		return numbersToOrder;
	}
	
	private static void changeValuesByPosition(int initPos, int finalP, List<Integer> numbersToOrder) {
		Integer aux = numbersToOrder.set(initPos, numbersToOrder.get(finalP));
		numbersToOrder.set(finalP, aux);
	}
}
