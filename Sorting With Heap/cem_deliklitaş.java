import java.util.Arrays;

/**This program simply fills the arrays of a certain size
	 * with random numbers between 0 and 10,000,000, sorting
	 * them with 3 different sorting algorithms to see the
	 * speed difference between them.
	 * 
	 * @author Cem Deliklitaþ  ID:041701028
	 * @since 15/12/2019
	 * 
	 */
public class cem_deliklitaþ {
	
	
	public static void main(String[] args) {

		int test = 10;              //I keep this variable in the number of times we test it.
		
		// size of the arrays.
//		int size = 10000;
		int size = 40000;
//		int size = 80000;
//		int size = 200000;
		Integer[] list = new Integer[size];
		float sum = 0;								//The variable I use to find the average value.
		System.out.println("Arrays Size : " + size);

//		In the second for loop, I fill the array with random numbers,
//		and when the array is full, it is sorted according to the 
//		sorting algorithm I use and the average time is calculated.
		for (int i = 0; i < test; i++) {
			for (int j = 0; j < list.length; j++) {
				list[j] = (int) (Math.random() * 10000000);
			}
			long start = System.nanoTime();
			heapSort(list);
			long finish = System.nanoTime();
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0;
			System.out.printf("%2d: %9f msec\n", i + 1, elapsedTimeMilliSeconds);
			sum += elapsedTimeMilliSeconds;

		}
		System.out.printf("Average Sort Time for Heap Sort \t : %5f msec.", sum / test);
		System.out.println("\n");
		sum = 0; //I'm syncing this variable to zero because I'll use it again in the next loop.
		
		for (int i = 0; i < test; i++) {
			for (int j = 0; j < list.length; j++) {
				list[j] = (int) (Math.random() * 10000000);
			}
			long start = System.nanoTime();
			Arrays.sort(list);
			long finish = System.nanoTime();
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0;
			System.out.printf("%2d: %9f msec\n", i + 1, elapsedTimeMilliSeconds);
			sum += elapsedTimeMilliSeconds;

		}
		System.out.printf("Average Sort Time for Java Array Sort    : %f msec.", sum / test);
		System.out.println("\n");
		sum = 0; //I'm syncing this variable to zero because I'll use it again in the next loop.
		

		for (int i = 0; i < test; i++) {
			for (int j = 0; j < list.length; j++) {
				list[j] = (int) (Math.random() * 10000000);
			}
			long start = System.nanoTime();
			selectionHeapSort(list);
			long finish = System.nanoTime();
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0;
			System.out.printf("%2d: %9f msec\n", i + 1, elapsedTimeMilliSeconds);
			sum += elapsedTimeMilliSeconds;

		}
		System.out.printf("Average Sort Time fot Selection Sort     : %f msec ", sum / test);
		sum = 0;
		System.out.println("\n");
	}
	/**
	 *  In this method we will take integers and we start sorting with 
	 *  comparing their values. The algorithm sorting to take the first
	 *	value maximum value and starts comparing other values. Ýf the 
	 *  value is smaller than the compared one their index is changing.
	 * 
	 * @param list
	 */
	public static void selectionHeapSort(Integer[] list) {
		Integer temp;
		Heap<Integer> heap = new Heap<>();
		for (int i = 0; i < list.length - 1; i++) {
			int currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				temp = list[currentMinIndex];
				list[currentMinIndex] = list[i];
				list[i] = temp;
			}

		}

	}
	/**
	 * First we add the integer values with the add method and create
	 * a tree. We use the first remove method to sort the resulting 
	 * tree. The remove method removes root and equals the last empty 
	 * index of the integer array, and decreases the index each time 
	 * a new root is removed. When the index is equal to zero, the array 
	 * is sorted.
	 * 
	 * @param list
	 */
	public static void heapSort(Integer[] list) {
		Heap<Integer> heap = new Heap<>();
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		for (int i = list.length-1; i>=0 ; i--)
			list[i] = heap.remove();
	}

}
