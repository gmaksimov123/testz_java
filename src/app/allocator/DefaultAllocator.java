package app.allocator;

public class DefaultAllocator implements IAllocator {

	@Override
    public void Run(int[] array)
    {
        int allocationIndex = this.FindMaxIndex(array);
        int allocationValue = array[allocationIndex];
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
