package app.workers;

import app.Result;
import app.allocators.ArrayAllocator;

public interface ArrayWorker {
	Result Run(int[] array, ArrayAllocator allocator);
}
