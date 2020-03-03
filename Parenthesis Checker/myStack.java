import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Student ID : 041701028
 * 
 * @author Cem Deliklitas
 * @since 20/11/2019
 *
 * @param <Item>
 */
public class myStack<Item> implements Iterable<Item> {
	private Item[] a; // array of items
	private int n; // number of elements on stack

	/**
	 * This allows us to access the constructor from main class, so that we can
	 * create the object.
	 */
	public myStack() {
		a = (Item[]) new Object[2];
		n = 0;
	}

	/**
	 * This method checks if the stack is empty or not empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * This method stores the size of the stack.
	 * 
	 * @return
	 */
	public int size() {
		return n;
	}

	/**
	 * This method provides to resize the stack.For example if stack is full this
	 * method automatically doubled the size of array and also It copies the array
	 * before the change to the new array.
	 * 
	 * @param capacity
	 */
	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	/**
	 * It allows us to add elements to Stack.
	 * 
	 * @param item
	 */
	public void push(Item item) {
		if (n == a.length) {
			resize(2 * a.length); // double size of array if necessary
			System.out.print("\n\n << stack doubled >> \n\n");
		}
		a[n++] = item; // add item

		// System.out.println(Arrays.toString(a));

	}

	/**
	 * This method allows us to remove elements from Stack.If the Stack's size falls
	 * below a certain value when removing the element, it resize Stack's size.
	 * 
	 * @return
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[n - 1];
		a[n - 1] = null; // to avoid loitering
		n--;
		// shrink size of array if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	/**
	 * It allows us to see the last element added to Stack.
	 * 
	 * @return
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return a[n - 1];
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i;

		public ReverseArrayIterator() {
			i = n - 1;
		}

		public boolean hasNext() {
			return i >= 0;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return a[i--];
		}

	}
}