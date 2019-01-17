package app;

import java.util.Scanner;

import app.allocators.DefaultAllocator;
import app.workers.DefaultWorker;

public class Main {

	public static void main(String[] args) {
		
		DefaultWorker worker = new DefaultWorker();
		DefaultAllocator allocator = new DefaultAllocator();

        Result result = worker.Run(new int[] { 0, 2, 7, 0 }, allocator);
        ShowResult(result);

        result = worker.Run(new int[] { 0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11 }, allocator);
        ShowResult(result);

        result = worker.Run(new int[] { 2000000000, 0 }, allocator);
        ShowResult(result);
        
	}

	static void ShowResult(Result result)
	{
		System.out.println(result.toString());
	}
	static void OnClose()
	{
		Scanner in = new Scanner(System.in);
		in.nextLine();
		in.close();
	}
}
