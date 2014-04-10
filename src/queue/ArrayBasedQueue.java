package queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Citation: Framework of this class as well as the whole text of Queue and
 * LinearStructure classes taken from lab on linear structure, some
 * code not from online version is taken from own lab
 * 
 * Queues implemented with arrays.
 * 
 * @author Samuel A. Rebelsky
 * @author Giang
 */
public class ArrayBasedQueue<T> implements Queue<T> {
	// +--------+----------------------------------------------------------
	// | Fields |
	// +--------+

	/**
	 * The values stored in the queue.
	 */
	T[] values;

	/**
	 * The index of the front of the queue.
	 */
	int front;

	/**
	 * The number of elements in the queue.
	 */
	int size;

	// +--------------+----------------------------------------------------
	// | Constructors |
	// +--------------+

	/**
	 * Create a new queue that holds up to capacity elements.
	 */
	@SuppressWarnings({ "unchecked" })
	// Handle array casting
	public ArrayBasedQueue(int capacity) throws Exception {
		if (capacity <= 0) {
			throw new Exception("Queues must have a positive capacity.");
		} // if (capacity <= 0)
			// Yay Java! It's not possible to say new T[capacity], so
			// we use this hack.
		this.values = (T[]) new Object[capacity];
		this.front = 0;
		this.size = 0;
	} // ArayBasedQueue(int capacity)

	// +---------------+---------------------------------------------------
	// | Queue Methods |
	// +---------------+

	@Override
	public boolean isEmpty() {
		return this.size <= 0;
	} // isEmpty()

	@Override
	public boolean isFull() {
		return this.size >= this.values.length;
	} // isFull()

	@Override
	public void put(T val) throws Exception {
		if (this.isFull()) {
			throw new Exception("no more room!");
		} // this.isFull()
		this.values[this.back()] = val;
		++this.size;
	} // put(T)

	@Override
	public T get() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("empty");
		} // if empty
			// Grab and clear the element at the front of the queue
		T result = this.values[this.front];
		this.values[this.front++] = null;
		if (this.front == this.values.length)
			this.front = 0;
		// We're removing an element, so decrement the size
		--this.size;
		// And we're done
		return result;
	} // get(T)

	@Override
	public T peek() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("empty");
		} // if empty
		return this.values[this.front];
	} // peek()

	@Override
	public T dequeue() throws Exception {
		return this.get();
	} // dequeue

	@Override
	public void enqueue(T val) throws Exception {
		this.put(val);
	} // enqueue

	@Override
	public Iterator<T> iterator() {
		return new ArrayBasedQueueIterator<T>(this);
	} // iterator()

	// +----------------+--------------------------------------------------
	// | Helper Methods |
	// +----------------+

	/**
	 * Get the index of the back of the queue. The back is where we add the next
	 * element. Note: instead of the invariant drawn in assignment, back() does
	 * not return index of last element but the index immediately after that,
	 * where the next element should go
	 */
	int back() {
		return (this.size + this.front) % this.values.length;
	} // back()

} // class ArrayBasedQueue<T>

class ArrayBasedQueueIterator<T> implements Iterator<T> {
	// +--------+----------------------------------------------------------
	// | Fields |
	// +--------+
	/**
	 * Keeps track of current element
	 */
	int index;

	/**
	 * Contains the queue
	 */
	ArrayBasedQueue<T> q;

	/**
	 * Keeps track of whether remove has been called since last call to next
	 */
	boolean calledRemove = true;
	
	/**
	 * Keeps track of whether next has been called
	 */
	boolean calledNext = false;
	// +--------------+----------------------------------------------------
	// | Constructors |
	// +--------------+

	/**
	 * Create a new iterator.
	 */
	public ArrayBasedQueueIterator(ArrayBasedQueue<T> q) {
		this.q = q;
		index = q.front;
	} // ArrayBasedQueueIterator

	// +---------+---------------------------------------------------------
	// | Methods |
	// +---------+

	@Override
	public T next() throws NoSuchElementException {
		if (!this.hasNext()) {
			throw new NoSuchElementException("no elements remain");
		} // if no elements
		calledRemove = false;
		calledNext = true;
		index = mod(index, q.values.length);
		T temp = q.values[index++];
		return temp;
	} // next()

	@Override
	public boolean hasNext() {
//		System.out.println("index = " + index + ", back = " + q.back());
		if (!calledNext && q.back() == q.front && q.front == index)
			return true;
		return !((index != 0 && index == q.back())
				|| (index == q.values.length && q.back() == 0));
	} // hasNext()

	@Override
	public void remove() throws IllegalStateException {
		if(calledRemove)
			throw new IllegalStateException();
		calledRemove = true;
		for (int z = 0; mod((z + index), q.values.length) != mod(q.back(), q.values.length); z++) {
			q.values[mod((index + z - 1), q.values.length)] = q.values[mod((index + z), q.values.length)];
		} // for
		q.values[mod((q.back() - 1), q.values.length)] = null;
		q.size--;
		index = mod(index - 1, q.values.length);
	} // remove()
	
	int mod(int a, int b){
		return (a % b + b) % b;
	} // mod (int, int)
} // ArrayBasedQueueIterator<T>
