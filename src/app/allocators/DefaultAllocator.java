package app.allocators;

public class DefaultAllocator implements ArrayAllocator {

	@Override
    public void Run(int[] array)
    {
        int allocationIndex = this.FindMaxIndex(array);
        int allocationDiv = array[allocationIndex] / array.length;
        int allocationValue = array[allocationIndex] % array.length;
        array[allocationIndex] = 0;

        int index = allocationIndex + 1;
        int lastIndex = array.length - 1;
        
        
        while (allocationValue > 0)
        {
            if (index > lastIndex)
            {
                index = 0;
            }
            array[index]++;
            allocationValue--;
            index++;
        }
        
        if (allocationDiv > 0) {
            for (int i = 0; i <= lastIndex; i++)
            {
            	array[i] += allocationDiv;
            }
        }
    }

    protected int FindMaxIndex(int[] array)
    {
        int maxIndex = 0;
        int lastIndex = array.length - 1;
        for (int i = 0; i <= lastIndex; i++)
        {
            if (array[maxIndex] < array[i])
            {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
