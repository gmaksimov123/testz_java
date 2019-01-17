package app.workers;

import app.Result;
import app.allocator.IAllocator;

public interface IWorker {
	Result Run(int[] array, IAllocator allocator);
}
