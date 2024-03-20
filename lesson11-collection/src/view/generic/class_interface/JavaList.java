package view.generic.class_interface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JavaList<E> implements IList<E> {

	private static final int DEFAULT_CAPACITY = 10;
	
	private E[] elements;
	private int size;

	public JavaList() {
		elements = createArray(DEFAULT_CAPACITY);
	}
	
	public JavaList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity at least = 0");
		}
		elements = createArray(capacity);
	}
	
	@Override
	public void add(E e) {
		if (size == elements.length) {
			elements = grow();
		}
		elements[size++] = e;
	}

	@Override
	public void add(int index, E e) {
		
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return elements[index];
	}

	@Override
	public void set(int index, E e) {
		checkIndex(index);
		elements[index] = e;
	}

	@Override
	public void remove(int index) {
		for (int i = index; i < size; i++)
			elements[i] = elements[i+1];
		size--;
	}
	// remove(1) ->
	// a, b, c, d	, null, null
	// a, c, d, null, null, null

	@Override
	public void remove(E e) {
		
	}

	@Override
	public void removeIf(Predicate<E> predicate) {
		for (int i = 0; i < size; i++)
			if (predicate.test(elements[i]))
				remove(i--);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return elements.length;
	}

	@Override
	public void forEach(Consumer<E> consumer) {
		for (int i = 0; i < size; i++)
			consumer.accept(elements[i]);
	}
	
	// ----------------------------------------
	
	private E[] grow() {
		int newLength = size * 3/2;
		return Arrays.copyOf(elements, newLength);
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("Index is out of range, size = " + size);
	}
	
	@SuppressWarnings("unchecked")
	private E[] createArray(int length) {
		return (E[])Array.newInstance(Object.class, length);
		//  ~  (E[])new Object[length]
	}

}
