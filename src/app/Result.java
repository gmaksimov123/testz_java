package app;

import java.util.Arrays;

public class Result {
    public int[] array;
    public int[] resultArray;
    public int loops;
    public int equalsLoops;
    
    public Result(int[] array, int[] resultArray, int loops, int equalsLoops) {
    	this.array = array;
    	this.resultArray = resultArray;
    	this.loops = loops;
    	this.equalsLoops = equalsLoops;
	}
    @Override
    public String toString() {
    	String output = String.format(
    			"��������� ������ - %1$s \n�������� ������ - %2$s \n��������� �������� - %3$s \n����������� �������� - %4$s \n",
    			Arrays.toString(array),	Arrays.toString(resultArray), loops, equalsLoops);
    	return output;
    }
}
