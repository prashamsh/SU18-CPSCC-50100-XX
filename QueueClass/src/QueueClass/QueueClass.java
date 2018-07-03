package QueueClass;

import java.util.Scanner;

class QueueNode {
	String key;
	QueueNode next;

	public QueueNode(String key) {
		this.key = key;
		this.next = null;
	}
}

class Queue {
	QueueNode front, rear;

	public Queue() {
		this.front = this.rear = null;
	}

	void enqueue(String key) {

		QueueNode temp = new QueueNode(key);

		// If queue is empty, then new node is front and rear both
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}

		// Add the new node at the end of queue and change rear
		this.rear.next = temp;
		this.rear = temp;
	}

	// Method to remove an key from queue.
	QueueNode dequeue() {
		// If queue is empty, return NULL.
		if (this.front == null)
			return null;

		// Store previous front and move front one node ahead
		QueueNode temp = this.front;
		this.front = this.front.next;

		// If front becomes NULL, then change rear also as NULL
		if (this.front == null)
			this.rear = null;
		return temp;
	}
}

public class QueueClass {

	public static void main(String[] args) {
		Queue q = new Queue();

		Scanner scanFirst = new Scanner(System.in);

		System.out.print("Enter first Alphabet");

		String first = scanFirst.next();
		q.enqueue(first);

		int count = 0;
		while (count < 9) {

			Scanner scanNext = new Scanner(System.in);
			System.out.print("Enter next Alphabet. Enter 'N' if you are done entering the alphabets");

			String next = scanNext.next();
			if (next.equals("N")) {
				count = 9;
			} else {
				count++;
				q.enqueue(next);
				if (count == 9) {
					System.out.println("You can enter only 10 alphabets and you reached your limit");
				}
			}
		}
		String s = "Y";
		while (s == "Y") {
			Scanner deque = new Scanner(System.in);
			System.out.println(
					"Would you like to dequeue the next alphabet in the list. Enter 'Y' to dequeue and hit any key if you are done");
			String deq = deque.next();
			try {
				if (deq.equals("Y")) {
					System.out.println("Dequeued item is " + q.dequeue().key);

				}

				else {
					s = "N";
					System.out.println("Thank you");

				}
			} catch (NullPointerException e) {
				System.out.println("Queue underflow. No more alphabets present to dequeue");
				s = "N";
			}

		}

	}
}
