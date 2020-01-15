package nowcodercourse.zuocy.basic.class_03;

/**
 * 数组实现固定大小的队列和栈
 */
public class Code_01_Array_To_Stack_Queue {

	public static class ArrayStack {
		private Integer[] arr;
		private Integer size;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}

		/**
		 * 返回栈顶
		 * @return
		 */
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size - 1];
		}

		/**
		 * 入栈
		 * @param obj
		 */
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			arr[size++] = obj;
		}

		/**
		 * 出栈
		 * @return
		 */
		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			return arr[--size];
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = last == arr.length - 1 ? 0 : last + 1;
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = first == arr.length - 1 ? 0 : first + 1;
			return arr[tmp];
		}
	}

	public static void main(String[] args) {

	}

}
