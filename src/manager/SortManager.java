package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilities.Sort;

public class SortManager
{
	private Shape[] shapes;
	private String fileName;
	private char compareType;
	private char sortType;

	public SortManager(String[] args) 
	{		
		parseArgs(args);
		loadShapes();
		sortShape();
		
	}
	
	private void sortShape() {
		
		long startTime = System.currentTimeMillis();
		
	    switch (sortType) {
	        case 'b': // Bubble Sort
	            if (compareType == 'h') {
	                Sort.bubbleSort(shapes);
	            } else if (compareType == 'v') {
	                Sort.bubbleSort(shapes, new Shape.VolumeComparator());
	            } else if (compareType == 'a') {
	                Sort.bubbleSort(shapes, new Shape.BaseAreaComparator());
	            }
	            break;

	        case 's': // Selection Sort
	            if (compareType == 'h') {
	                Sort.selectionSort(shapes);
	            } else if (compareType == 'v') {
	                Sort.selectionSort(shapes, new Shape.VolumeComparator());
	            } else if (compareType == 'a') {
	                Sort.selectionSort(shapes, new Shape.BaseAreaComparator());
	            }
	            break;

	        case 'i': // Insertion Sort
	            if (compareType == 'h') {
	                Sort.insertionSort(shapes);
	            } else if (compareType == 'v') {
	                Sort.insertionSort(shapes, new Shape.VolumeComparator());
	            } else if (compareType == 'a') {
	                Sort.insertionSort(shapes, new Shape.BaseAreaComparator());
	            }
	            break;

	        case 'm': // Merge Sort
	            if (compareType == 'h') {
	                Sort.mergeSort(shapes);
	            } else if (compareType == 'v') {
	                Sort.mergeSort(shapes, new Shape.VolumeComparator());
	            } else if (compareType == 'a') {
	                Sort.mergeSort(shapes, new Shape.BaseAreaComparator());
	            }
	            break;

	        case 'q': // Quick Sort
	            if (compareType == 'h') {
	                Sort.quickSort(shapes);
	            } else if (compareType == 'v') {
	                Sort.quickSort(shapes, new Shape.VolumeComparator());
	            } else if (compareType == 'a') {
	                Sort.quickSort(shapes, new Shape.BaseAreaComparator());
	            }
	            break;
	            
	        case 'z': // Heap Sort
	            if (compareType == 'h') {
	                Sort.heapSort(shapes);
	            } else if (compareType == 'v') {
	                Sort.heapSort(shapes, new Shape.VolumeComparator());
	            } else if (compareType == 'a') {
	                Sort.heapSort(shapes, new Shape.BaseAreaComparator());
	            }
	            break;	            
	    }
	    
	    String algName = "";
	    switch (sortType) {
	        case 'b': algName = "Bubble Sort"; break;
	        case 's': algName = "Selection Sort"; break;
	        case 'i': algName = "Insertion Sort"; break;
	        case 'm': algName = "Merge Sort"; break;
	        case 'q': algName = "Quick Sort"; break;
	        case 'z': algName = "Heap Sort"; break;
	    }
	    long endTime = System.currentTimeMillis();
	    displayResults();
	    System.out.println(algName + " run time was: " + (endTime - startTime) + "ms");
	}

	private void displayResults()
	{
		if (shapes == null || shapes.length == 0) 
			{
			System.err.println("Error: No data loaded. Please check your file path.");
			return;
			}

	    System.out.println("First element is: " + shapes[0]);

	    for (int i = 1000; i < shapes.length - 1; i += 1000) {
	        System.out.println(i + "-th element is: " + shapes[i]);
	    }

	    System.out.println("Last element is: " + shapes[shapes.length - 1]);
		
	}

	private void loadShapes()
	{
		File file = new File(fileName);
		Scanner sc;
		try
		{
			sc = new Scanner(file);
			int totalShapes = sc.nextInt();
			shapes = new Shape[totalShapes];
			int index = 0;
			while (sc.hasNext() && index < totalShapes) 
			{
				String type = sc.next();
				double height = sc.nextDouble();
				double secondValue = sc.nextDouble();
				
				switch (type)
				{
				case "Cylinder":
		            shapes[index] = new Cylinder(height, secondValue);
		            break;
		        case "Cone":
		            shapes[index] = new Cone(height, secondValue);
		            break;
		        case "Pyramid":
		            shapes[index] = new Pyramid(height, secondValue);
		            break;
		        case "SquarePrism":
		            shapes[index] = new SquarePrism(height, secondValue);
		            break;
		        case "TriangularPrism":
		            shapes[index] = new TriangularPrism(height, secondValue);
		            break;
		        case "PentagonalPrism":
		            shapes[index] = new PentagonalPrism(height, secondValue);
		            break;
		        case "OctagonalPrism":
		            shapes[index] = new OctagonalPrism(height, secondValue);
		            break;
				}
				index++;
			}
			sc.close();
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void parseArgs(String[] args)
	{
		for (String s : args)
		{
//			System.out.println(s);
			s = s.toLowerCase();
			if(s.startsWith("-f"))
			{
				fileName = s.substring(2).replace("\"", "");
			}
			else if(s.startsWith("-t"))
			{
				compareType = s.substring(2).charAt(0);
			}
			else if(s.startsWith("-s"))
			{
				sortType = s.substring(2).charAt(0);
			}
				
		}
		System.out.println(fileName);
		System.out.println(compareType);
		System.out.println(sortType);
	}
}