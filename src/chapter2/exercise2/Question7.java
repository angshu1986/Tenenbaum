package chapter2.exercise2;

public class Question7 {

	
	private static class DoubleStack {
		int a[];
		int pointer1;
		int pointer2;
		
		private static final int DEFAULT_SIZE = 10;
		
		private DoubleStack() {
			this(DEFAULT_SIZE);
		}
		private DoubleStack(int size) {
			a = new int[size];
			int mid = size%2 == 0 ? size/2 : (size/2)+1;
			pointer1 = mid - 1;
			pointer2 = mid;
		}
		
		private void push1(int val) {
			if (pointer1 == 0) {
				throw new RuntimeException("Stack overflow");
			}
			a[pointer1--] = val;
		}
		
		private void push2(int val) {
			if (pointer2 == a.length) {
				throw new RuntimeException("Stack overflow");
			}
			a[pointer2++] = val;
		}
		
		private int pop1() {
			int size = a.length;
			int mid = size%2 == 0 ? size/2 : (size/2)+1;
			if (pointer1 == mid - 1) {
				throw new RuntimeException("Stack underflow");
			}
			int val = a[pointer1];
			a[pointer1++] = 0;
			return val;
		}
		
		private int pop2() {
			int size = a.length;
			int mid = size%2 == 0 ? size/2 : (size/2)+1;
			if (pointer2 == mid) {
				throw new RuntimeException("Stack underflow");
			}
			int val = a[pointer2];
			a[pointer1--] = 0;
			return val;
		}
	}
}
