import java.util.AbstractList;
import java.util.Collection;

/**
 * Implementation of a stack array list
 */
public class MyArrayStack<E> extends AbstractList<E> implements List<E> {
	
	/** Array used to store elements*/
	private E[] arr;

	/** Number of elements stored */
	private int n;

	/** Default size for no-arg constructor */
	private static int DEFAULT_SIZE = 10;

	@SuppressWarnings("unchecked")
	public MyArrayStack() {
		arr = (E[])(new Object[10]);
	}

	@SuppressWarnings("unchecked")
	public MyArrayStack(int initialCapacity) {
		if (initialCapacity < 0) throw new IllegalArgumentException(
				"Illegal Capacity: " + initialCapacity);
		arr = (E[])(new Object[initialCapacity]);
	}

	/** Resize internal array */
	void resize() {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[])(new Object[(Math.max(n*2,1))]);
		for (int i = 0; i < n; i++)
			newArr[i] = arr[i];
		arr = newArr;
	}

	void resize(int newSize) {
		@SuppressWarnings("unchecked")
		E[] newArr = (E[])(new Object[newSize]);
		for (int i = 0; i < n; i++) 
			newArr[i] = arr[i];
		arr = newArr;
	}


	/** List interface methods */
	
	public E get(int index) {
		if (index < 0 || index > n-1) throw new IndexOutOfBoundsException();
		return arr[index];
	}

	public E set(int index, E element) {
		if (index < 0 || index > n-1) throw new IndexOutOfBoundsException();
		E x = arr[index];
		arr[index] = element;
		return x;

	}

	public int size() {
		return n;
	}

	/** Place item onto stack */
	public boolean add(E item) {
		if (n + 1 > arr.length) resize();
		arr[n++] = item;
		return true;
	}

	/** Insert item at index position */
	public void add(int index, E item) {
		if (index < 0 || index > n) throw new IndexOutOfBoundsException();
		if (n + 1 > arr.length) resize();
		for (int i = n; i > index; i--)
			arr[i] = arr[i-1];
		arr[index] = item;
		n++;
	}

	/** Remove item at index position */
	public E remove(int index) {
		if (index < 0 || index > n-1) throw new IndexOutOfBoundsException();
		E x = arr[index];
		for (int i = index; i < n-1; i++)
			arr[i] = arr[i+1];
		if (arr.length >= 3*n) resize();
		return x;
	}

	public void clear() {
		n = 0;
		resize();
	}
}
