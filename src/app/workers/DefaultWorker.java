package app.workers;

import java.util.ArrayList;
import java.util.Arrays;

import app.Result;
import app.allocator.IAllocator;

public class DefaultWorker implements IWorker {

	@Override
    public Result Run(int[] array, IAllocator allocator)
    {
        int[] defaultArray = Clone(array);
        int loops = 1;
        int equalsLoop = -1;
        ArrayList<String> results = new ArrayList<String>();

        allocator.Run(array);
        
        while (equalsLoop == -1)
        {
            results.add(StringifyArray(array));
            allocator.Run(array);
            loops++;
            
            equalsLoop = FindEqualsIndex(results, StringifyArray(array));
        }
        return new Result(defaultArray, array, loops, loops - equalsLoop - 1);
    }

    protected int[] Clone(int[] array)
    {
        return array.clone();
    }

    protected int FindEqualsIndex(ArrayList<String> list, String stringigyArray)
    {
        return list.indexOf(stringigyArray);
    }

    protected String StringifyArray(int[] array)
    {
        return Arrays.toString(array);
    }
}
