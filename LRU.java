import java.util.LinkedList;

public class LRU extends ReplacementAlgorithm {

	public LinkedList<Integer> stack;

	public LRU(int pageFrameCount) {
		super(pageFrameCount);
		stack = new LinkedList<Integer>();
	}

	@Override
	public void insert(int pageNumber) {
		if (!stack.isEmpty()) {
			if (stack.size() != pageFrameCount) {
				if (stack.contains(pageNumber)) {
					stack.remove((Integer) pageNumber);
					stack.addFirst(pageNumber);
				} else {
					stack.addFirst(pageNumber);
					pageFaultCount++;
				}
			} else {
				if (!stack.contains(pageNumber)) {
					stack.removeLast();
					stack.addFirst(pageNumber);
					pageFaultCount++;
				} else {
					stack.remove((Integer) pageNumber);
					stack.addFirst(pageNumber);
				}
			}
		} else {
			stack.addFirst(pageNumber);
			pageFaultCount++;
		}
	}

}