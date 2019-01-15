package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.allocator.DefaultAllocator;

public class DefaultAllocatorTest {

	@Test
	public void testRun() {
		DefaultAllocator allocator = new DefaultAllocator();
		int[] array = new int[] { 0, 2, 7, 0 };
		allocator.Run(array);
		
		assertArrayEquals(new int[] { 2, 4, 1, 2 }, array);
	}

}
