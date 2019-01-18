package app;

import java.util.Scanner;

import app.allocators.DefaultAllocator;
import app.workers.DefaultWorker;

public class Main {

	public static void main(String[] args) {
		DefaultWorker worker = new DefaultWorker();
		DefaultAllocator allocator = new DefaultAllocator();

        Result result = worker.run(new int[] { 0, 2, 7, 0 }, allocator);
        showResult(result);

        result = worker.run(new int[] { 0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11 }, allocator);
        showResult(result);

        result = worker.run(new int[] { 2000000000, 0 }, allocator);
        showResult(result);
	}

	static void showResult(Result result)
	{
		System.out.println(result.toString());
	}
	static void onClose()
	{
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
}
