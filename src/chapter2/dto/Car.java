package chapter2.dto;

public class Car {

	private int licensePlate;
	private int count;

	public Car(int licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(int licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void increment() {
		count++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + licensePlate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (licensePlate != other.licensePlate)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + "]";
	}
}
