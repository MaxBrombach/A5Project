package de.hfu;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	private Queue qu;
	
	@Before
	public void createQueue() {
		qu = new Queue(3);
	}
	
	@Test
	public void testEnqueue() {
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		int[] goal = {1,2,3};
		assertArrayEquals(goal, qu.queue);
	
	}
	
	@Test
	public void testOverwrite() {
		qu.enqueue(3);
		int[] goal = {3,2,3};
		assertArrayEquals(goal, qu.queue);
	}
}
