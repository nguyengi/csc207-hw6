package queue;

import java.util.Arrays;
import java.util.Iterator;

public class QueueTest {
	public static void main(String[] args) throws Exception {
		Queue<String> q = new ArrayBasedQueue<>(6);
		q.put("a");
		q.put("b");
		q.put("c");
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(((ArrayBasedQueue<String>) q).size);
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		q.put("d");
		q.put("e");
		q.put("f");
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		q.put("g");
		q.put("h");
		q.put("i");
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		System.out.println("front = " + q.peek());
		Iterator<String> it = q.iterator();
		System.out.println(it.hasNext());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		Iterator<String> it2 = q.iterator();
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		System.out.println("Removes " + it2.next());
		it2.remove();
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		System.out.println("Removes " + it2.next());
		it2.remove();
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		System.out.println("Removes " + it2.next());
		it2.remove();
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
		it2.next();
		it2.next();
		System.out.println("Removes " + it2.next());
		it2.remove();
		System.out.println(Arrays
				.toString(((ArrayBasedQueue<String>) q).values));
	}
}
