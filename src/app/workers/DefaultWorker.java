package app.workers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import app.Result;
import app.allocators.ArrayAllocator;

public class DefaultWorker implements ArrayWorker {
	protected HashMap<String, Integer> results = new HashMap<String, Integer>();
	
	@Override
    public Result Run(int[] array, ArrayAllocator allocator)
    {
        int[] defaultArray = Clone(array);
        int loops = 1;
        int equalsLoop = -1;
        String stringifiedArray = "";
        
        allocator.Run(array);
        
        stringifiedArray = StringifyArray(array);
        while (equalsLoop == -1)
        {
            results.put(stringifiedArray, loops);
            allocator.Run(array);
            
            stringifiedArray = StringifyArray(array);      
            equalsLoop = FindEqualsIndex(results, stringifiedArray);
            
            loops++;
        }
        return new Result(defaultArray, array, loops, loops - equalsLoop);
    }

    protected int[] Clone(int[] array)
    {
        return array.clone();
    }
    protected int FindEqualsIndex(ArrayList<String> list, String stringigyArray)
    {
        return list.indexOf(stringigyArray);
    }
    
    protected int FindEqualsIndex(HashMap<String, Integer> list, String stringigyArray)
    {
    	Integer index = list.get(stringigyArray);
        return  (index == null) ? -1 : index;
    }

    protected String StringifyArray(int[] array)
    {
        return Arrays.toString(array);
    }
}
