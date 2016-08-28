package chapter2.exercise2;

import java.util.Scanner;

import com.home.ds.adt.IStack;
import com.home.ds.linear.Stack;

import chapter2.dto.Car;

public class Question8 {

	public Question8() {
		parking = new Stack<>();
	}

	private IStack<Car> parking;

	private static final int SIZE = 10;

	private void pickCar(Car c) {
		if (parking.size() == 0) {
			System.out.println("Parking lot empty");
			return;
		}
		pop(c);
	}

	private void pop(Car carToExit) {
		if (parking.size() == 0) {
			return;
		} else {
			Car c = parking.pop();
			if (c.equals(carToExit)) {
				System.out.printf("%s exiting, moved %d times\n", carToExit, c.getCount());
				return;
			} else {
				pop(carToExit);
				c.increment();
				parking.push(c);
			}
		}
	}

	private void addCar(Car c) {
		if (parking.size() == SIZE) {
			System.out.printf("Parking full. %s exiting\n", c);
			return;
		}
		parking.push(c);
		System.out.printf("%s parked\n", c);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Question8 q = new Question8();
		while (true) {
			System.out.print("Arrival(A)/Departure(D)");
			String type = s.next();
			if ("A".equalsIgnoreCase(type) || "Arrival".equalsIgnoreCase(type)) {
				System.out.print("Enter car licence plate number to add to parking");
				int licensePlate = s.nextInt();
				Car c = new Car(licensePlate);
				q.addCar(c);
			} else if ("D".equalsIgnoreCase(type) || "Departure".equalsIgnoreCase(type)) {
				System.out.print("Enter car licence plate number to exit parking");
				int licensePlate = s.nextInt();
				Car c = new Car(licensePlate);
				q.pickCar(c);
			} else {
				System.out.print("Invalid choice. Press enter(E) to continue or esc to exit ");
				int choice = s.nextInt();
				if (choice == 13 || 'e' == choice || 'E' == choice) {
					continue;
				} else if (choice == 27) {
					System.out.println("Program escapped. Exiting");
					break;
				} else {
					System.out.println("Incorrect choice. Exiting");
				}
			}
		}
		s.close();
	}
}
