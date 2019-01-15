package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Result;
import app.allocator.DefaultAllocator;
import app.workers.DefaultWorker;

public class DefaultWorkerTest {

	@Test
	public void testRun() {
		DefaultWorker worker = new DefaultWorker();
		DefaultAllocator allocator = new DefaultAllocator();

        Result result = worker.Run(new int[] { 0, 2, 7, 0 }, allocator);
        
        assertEquals(5, result.loops);
        assertEquals(4, result.equalsLoops);

        result = worker.Run(new int[] { 0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11 }, allocator);

        assertEquals(7864, result.loops);
        assertEquals(1695, result.equalsLoops);
        
	}

}
