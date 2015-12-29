package ResizingQueue;

/**
 * Created by Coupang on 2015. 12. 28..
 */
public interface ResizingQueueFrame {
	abstract void insertOrderInQueue(Object o);

	abstract Object pop();

	abstract void printQueue();
}
