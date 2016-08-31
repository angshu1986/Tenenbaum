package chapter3.exercise1;

public class Question2 {
	
	public static void main(String[] args) {
		System.out.println(new Question2().succ(12, 2));
	}

	private int succ(int a, int b) {
		if (b == 0) {
			return a;					
		} else {
			return succ(++a, --b);
		}
	}
}
