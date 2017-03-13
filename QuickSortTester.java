//Juan Man Army: James Smith
//APCS2 pd3
//Lab01 -- What does the data say?
//2017-03-09

/******************************
 * Testing Methodology 
    My algo runs 100000 tests per randomly generated array sizes of 1,10, 100, and 100000. 
	For each, the mean of the 100000 tests is calculated for an average execution time.
	Method averageTestTime runs runTest 100000 times, which first generates a randomly-populated
	array of a specified size and then starts timing the quick sort. Once the array is sorted, the
	total time is found by calculating the difference between the end and start time. Then the time
	for the 100000 tests is averaged.
******************************/

public class QuickSortTester{

    //TESTING METHODS ----------------------------------------------------------------------

    //Average Case vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    
    //generates an int array of length 'size' with random numbers within the range 0-maxNum
    public static int[] generateArray(int size, int maxNum){
	int[] retArr = new int[size];
	for (int i = 0; i< size;i++){
	    retArr[i] = (int)(Math.random()*maxNum);
	}
	return retArr;
    }

    //Return the execution time of the sorting algorithm in nano seconds
    public static long runTest(int size, int maxNum){
	int[] Arr = generateArray(size,maxNum);
	long startTime = System.nanoTime();
	qsort(Arr);
	long endTime   = System.nanoTime();
	return endTime - startTime;
    }

    //returns the average execution time of the sorting algorithm over numTests iterations
    public static double averageTestTime(int numTests, int size, int maxNum){
	long totalTime = 0;
	for(int i = 0; i < numTests; i++){
	    totalTime += runTest(size, maxNum);
	}
	return (totalTime/(long)numTests)*0.000000001;
    }

    //Average Case ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    //Worst Case vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    
    public static int[] generateArrayBad(int size){
	int[] retArr = new int[size];
	for (int i = 0; i<size;i++){
	    retArr[i] = 0;
	}
	return retArr;
    }

    public static long runTestBad(int size){
	int[] Arr = generateArrayBad(size);
	long startTime = System.nanoTime();
	qsort(Arr);
	long endTime   = System.nanoTime();
	return endTime - startTime;
    }

    public static double averageTestTimeBad(int numTests, int size){
	long totalTime = 0;
	for(int i = 0; i < numTests; i++){
	    totalTime += runTestBad(size);
	}
	return (totalTime/(long)numTests)*0.000000001;
    }

    //Worst Case ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    //TESTING METHODS ----------------------------------------------------------------------

    
    //QUICKSORT METHODS --------------------------------------------------------------------
    
    //swap values at indices x, y in array o
    public static void swap(int x, int y,  int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }
    public static int median3(int l, int m, int q, int[] arr) {
	if ((arr[q] - arr[l]) * (arr[q] - arr[m]) <= 0)
	    return q;
	if ((arr[m] - arr[l]) * (arr[m] - arr[q]) <= 0)
	    return m;
	return l;
	
    }
    public static int partitionArrayByPoint(int[] arr, int lowerBound, int upperBound, int partitionPoint){
	int partitionValue = arr[partitionPoint];//a point in which the array is divided in a sense. where numbers smaller than it are swapped with those greater than it. A reference point.
	swap(partitionPoint, upperBound, arr);//make the partitionvalue be the last in the array in order for it to be the last value to be swapped.
	int lessThanPartitionPoint = lowerBound; //lessThanPartitionPoint is the number of values smaller than the value at the partitionPoint
	for(int i = lowerBound; i<upperBound ;i++){ //iterate through the indexes of the array from the lower to the upperbound
	    if (arr[i] <= partitionValue){ //if the value at a given index is less than that of the partitionpoint
		swap(lessThanPartitionPoint, i, arr); //move the value to the leftmost that you haven't used to gather the lesser values.
		lessThanPartitionPoint++; //increase the leftmost value by 1 because you just used one up
	    }
	}
	swap(upperBound, lessThanPartitionPoint, arr);//swap the partition value to the place where all of the values left of it are smaller and the values to the right are greater
	return lessThanPartitionPoint;
    }
    
    public static void qsort(int[] d, int lower, int upper){
	int pos =  partitionArrayByPoint(d, lower, upper, median3(lower, upper, (lower + upper) / 2, d)); //index that partitions the list
	if(lower < pos){ //if the partition point isnt the smallest index, then recursively call the sorting on the smaller section of the list
	    qsort(d, lower, pos-1);
	}
	if(pos < upper){//if the partition point isnt the maximum index, then recursively call the sorting on the greater section of the list
	    qsort(d, pos+1, upper);
	}
    }
    
    //QUICKSORT HELPER METHODS --------------------------------------------------------------------

    
    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
	qsort(d, 0, d.length-1);
    }

    //MAIN METHOD FOR TESTING
    public static void main( String[] args ){
	int numTests = 100000;
	int maxNum = 100000;
	int size;
	
	System.out.println("Tests of a quick sort algorithm at different sizes. Execution time is in seconds.\n Number of tests performed: " + numTests + "\n Maximum Number: " + maxNum);

	//Average Case ----------------------------------------------------------------------------
	System.out.println("\nNow printing the average case:");
	//for n=1 ---------------------------------------
	size = 1;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=10 --------------------------------------
	size = 10;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=100 -------------------------------------
	size = 100;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=1000 ---------------------------------------
	size = 1000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=10000 -------------------------------------
	size = 10000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	//for n=100000 -------------------------------------
	size = 100000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTime(numTests, size, maxNum));
	
	//Worst Case ------------------------------------------------------------------------------
	System.out.println("\n Now printing the worst case:");
	//for n=1 ---------------------------------------
	size = 1;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTimeBad(numTests, size));
	//for n=10 --------------------------------------
	size = 10;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTimeBad(numTests, size));
	//for n=100 -------------------------------------
	size = 100;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTimeBad(numTests, size));
	//for n=1000 ---------------------------------------
	size = 1000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTimeBad(numTests, size));
	//for n=10000 -------------------------------------
	size = 10000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTimeBad(numTests, size));
	//for n=100000 -------------------------------------
	size = 100000;
	System.out.println("Now printing the average execution time for an array of size " + size);
	System.out.println(averageTestTimeBad(numTests, size));
	
    }//end main
}
