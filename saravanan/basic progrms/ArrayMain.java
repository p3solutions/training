import java.util.Scanner;



public class ArrayMain {
	public static void main(String[] args) {
		int choice, value,position = 0;
		Array1 list = new Array1();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("******List of Menu*******");
			System.out.println("enter  1 to insert at end of the list ");
			System.out.println("enter 2 to display the list");
			System.out.println("enter 3 to insert the element at specified position");
			System.out.println("enter 4 to delete the element at the specified position");
			System.out.println("enter 5 to exit");
			choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("enter the data to insert at the end");
			value = scanner.nextInt();
			list.add(value);
			break;
		case 2:
			list.display();
			break;
		case 3:
			System.out.println("enter the position to add");
			position = scanner.nextInt();
			if (position < 0) {

				System.out.println("invalid position");
				break;
			}
			value = scanner.nextInt();
			System.out.println("enter the data to insert");
			list.Insert_At_Position(position, value);
			break;
		case 4:
			System.out.println("enter the position to delete");
			if (position < 0) {
				System.out.println("invalid position");
				break;
			}
			list.delete(position);
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("invalid choice unable to process");

		}
	}}
}public class Array1 {
	int arr[];
	int size;
	int capacity;
	int initial_capacity = 16;

	Array1() {// constructor to initialize the element;
		int arr[] = new int[initial_capacity];
		size = 0;
		capacity = 16;
	}

	public void add(int value) {
		if (size == capacity) {
			expand_Array();
		}
		arr[size] = value;
		size++;
	}

	private void expand_Array() {
		capacity = capacity * 2;
		arr = java.util.Arrays.copyOf(arr, capacity);
	}

	public void display() {
		for (int i = 0; i <= size; i++) {
			System.out.println(arr[i]);

		}

	}

	public void Insert_At_Position(int position, int value) {
		if (position == capacity)
			expand_Array();
		for (int i = size; i >= position; i--) {
			arr[i + 1] = arr[i];
			arr[size] = value;
			size++;
		}
	}

	public void delete(int position) {
		for (int i = position + 1; i <= size; i++) {
			arr[size - 1] = arr[i];
			size--;
			if (capacity > initial_capacity && capacity > 3 * size)
				shrinkArray();

		}

	}

	private void shrinkArray() {
		// TODO Auto-generated method stub
		capacity = capacity / 2;
		arr = java.util.Arrays.copyOf(arr, capacity);
	}
}