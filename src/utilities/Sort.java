package utilities;

import java.util.Comparator;

public class Sort
{
	
	// 1. Bubble Sort

	//used for array of Comparable (sorting by height for this project)
	public static <T extends Comparable<? super T>> void bubbleSort(T[] arr)
	{
		int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) 
            {
            	if (arr[j].compareTo(arr[j + 1]) > 0) 
            	{
            		T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
            	}
            }
        }
	}
	
	//used for array of Comparable (sorting by volume or base area for this project)
	public static <T> void bubbleSort(T[] arr, Comparator<? super T> c)
	{
		int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (c.compare(arr[j], arr[j + 1]) > 0) 
                {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

	// 2. Selection Sort
	
	public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j].compareTo(arr[maxIdx]) < 0) {
					maxIdx = j;
				}
			}
			T temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}
	}

	public static <T> void selectionSort(T[] arr, Comparator<? super T> c) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (c.compare(arr[j], arr[maxIdx]) < 0) {
					maxIdx = j;
				}
			}
			T temp = arr[maxIdx];
			arr[maxIdx] = arr[i];
			arr[i] = temp;
		}
	}


	// 3. Insertion Sort

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(key) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {
		for (int i = 1; i < arr.length; i++) {
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && c.compare(arr[j], key) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}


	// 4. Merge Sort

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
		if (arr.length <= 1) return;
		int mid = arr.length / 2;
		T[] left = (T[]) new Comparable[mid];
		T[] right = (T[]) new Comparable[arr.length - mid];

		System.arraycopy(arr, 0, left, 0, mid);
		System.arraycopy(arr, mid, right, 0, arr.length - mid);

		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}

	private static <T extends Comparable<? super T>> void merge(T[] arr, T[] left, T[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i].compareTo(right[j]) <= 0) arr[k++] = left[i++];
			else arr[k++] = right[j++];
		}
		while (i < left.length) arr[k++] = left[i++];
		while (j < right.length) arr[k++] = right[j++];
	}

	public static <T> void mergeSort(T[] arr, Comparator<? super T> c) {
		if (arr.length <= 1) return;
		int mid = arr.length / 2;
		T[] left = (T[]) new Object[mid];
		T[] right = (T[]) new Object[arr.length - mid];

		System.arraycopy(arr, 0, left, 0, mid);
		System.arraycopy(arr, mid, right, 0, arr.length - mid);

		mergeSort(left, c);
		mergeSort(right, c);
		merge(arr, left, right, c);
	}

	private static <T> void merge(T[] arr, T[] left, T[] right, Comparator<? super T> c) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (c.compare(left[i], right[j]) <= 0) arr[k++] = left[i++];
			else arr[k++] = right[j++];
		}
		while (i < left.length) arr[k++] = left[i++];
		while (j < right.length) arr[k++] = right[j++];
	}


	// 5. Quick Sort

	public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] arr, int low, int high) {
		if (low < high) {
			int pivotIdx = partition(arr, low, high);
			quickSort(arr, low, pivotIdx - 1);
			quickSort(arr, pivotIdx + 1, high);
		}
	}

	private static <T extends Comparable<? super T>> int partition(T[] arr, int low, int high) {
		T pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j].compareTo(pivot) <= 0) {
				i++;
				T temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		T temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	public static <T> void quickSort(T[] arr, Comparator<? super T> c) {
		quickSort(arr, 0, arr.length - 1, c);
	}

	private static <T> void quickSort(T[] arr, int low, int high, Comparator<? super T> c) {
		if (low < high) {
			int pivotIdx = partition(arr, low, high, c);
			quickSort(arr, low, pivotIdx - 1, c);
			quickSort(arr, pivotIdx + 1, high, c);
		}
	}

	private static <T> int partition(T[] arr, int low, int high, Comparator<? super T> c) {
		T pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (c.compare(arr[j], pivot) <= 0) {
				i++;
				T temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		T temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	// 6. Your Choice: Heap Sort (堆積排序)

		public static <T extends Comparable<? super T>> void yourChoiceSort(T[] arr) {
			int n = arr.length;
			for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
			for (int i = n - 1; i > 0; i--) {
				T temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				heapify(arr, i, 0);
			}
		}

		private static <T extends Comparable<? super T>> void heapify(T[] arr, int n, int i) {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			if (l < n && arr[l].compareTo(arr[largest]) > 0) largest = l;
			if (r < n && arr[r].compareTo(arr[largest]) > 0) largest = r;
			if (largest != i) {
				T temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;
				heapify(arr, n, largest);
			}
		}

		public static <T> void yourChoiceSort(T[] arr, Comparator<? super T> c) {
			int n = arr.length;
			for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i, c);
			for (int i = n - 1; i > 0; i--) {
				T temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				heapify(arr, i, 0, c);
			}
		}

		private static <T> void heapify(T[] arr, int n, int i, Comparator<? super T> c) {
			int largest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			if (l < n && c.compare(arr[l], arr[largest]) > 0) largest = l;
			if (r < n && c.compare(arr[r], arr[largest]) > 0) largest = r;
			if (largest != i) {
				T temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;
				heapify(arr, n, largest, c);
			}
		}
	}
