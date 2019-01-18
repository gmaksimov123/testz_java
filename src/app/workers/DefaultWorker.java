package app.workers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import app.Result;
import app.allocators.ArrayAllocator;

public class DefaultWorker implements ArrayWorker {
	@Override
    public Result run(int[] array, ArrayAllocator allocator)
    {
		HashMap<String, Integer> results = new HashMap<String, Integer>();
        int[] defaultArray = cloneArray(array);
        int loops = 1;
        int equalsLoop = -1;
        String stringifiedArray = "";
        
        allocator.run(array);
        
        stringifiedArray = stringifyArray(array);
        while (equalsLoop == -1)
        {
            results.put(stringifiedArray, loops);
            allocator.run(array);
            
            stringifiedArray = stringifyArray(array);      
            equalsLoop = findEqualsIndex(results, stringifiedArray);
            
            loops++;
        }
        return new Result(defaultArray, array, loops, loops - equalsLoop);
    }

    protected int[] cloneArray(int[] array)
    {
        return array.clone();
    }
    
    protected int findEqualsIndex(HashMap<String, Integer> list, String stringigyArray)
    {
    	Integer index = list.get(stringigyArray);
        return  (index == null) ? -1 : index;
    }

    protected String stringifyArray(int[] array)
    {
        return Arrays.toString(array);
    }
}
