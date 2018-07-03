package QueueClass;

import Queue.QueueOne;
class Test
{
	public static void main(String[] args) 
	{
		QueueOne q=new QueueOne();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		System.out.println("Dequeued item is "+ q.dequeue().key);
	}
}
