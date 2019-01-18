package app.workers;

import app.Result;
import app.allocators.ArrayAllocator;

public interface ArrayWorker {
	Result run(int[] array, ArrayAllocator allocator);
}
