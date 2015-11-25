/**
 * Test harness for LRU page replacement algorithms
 *
 * Usage: java [-Debug] Test <reference string size> <number of page frames>
 */

public class Test {
	// public static int number=9;
	public static void main(String[] args) {
		// int number = 9;
		PageGenerator ref = new PageGenerator(new Integer(args[0]).intValue());
		// PageGenerator ref = new PageGenerator(new
		// Integer(number).intValue());

		int[] referenceString = ref.getReferenceString();

		
		// Print out the reference string
				System.out.print("Reference string = ");
				for (int i = 0; i < referenceString.length; i++) {
					System.out.print(referenceString[i]+" ");
				}
				System.out.println("\n");
		
		
		/** Use either the LRU algorithm */
		ReplacementAlgorithm lru = new LRU(new Integer(args[1]).intValue());
		// ReplacementAlgorithm lru = new LRU(new Integer(number).intValue());

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++) {
			System.out.println("inserting " + referenceString[i]);
			lru.insert(referenceString[i]);
		}

		// report the total number of page faults
		System.out.println("LRU faults = " + lru.getPageFaultCount());

	}
}
