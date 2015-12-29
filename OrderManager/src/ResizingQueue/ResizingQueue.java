package ResizingQueue;

/**
 * Created by Coupang on 2015. 12. 28..
 */
public class ResizingQueue implements ResizingQueueFrame{
	private Object[] queue;
	private int count;
	private int head;

	private void setQueue(Object[] queue) {
		this.queue = queue;
	}

	private void setCount(int count) {
		this.count = count;
	}

	private void setHead(int head) {
		this.head = head;
	}

	private Object[] getQueue() {

		return queue;
	}

	public int getCount() {
		return count;
	}

	private int getHead() {
		return head;
	}

	public ResizingQueue() {

		this.queue = new Object[10];
		this.count = 0;
		this.head = 0;
	}

	@Override
	public void insertOrderInQueue(Object order){
		this.resizingIfChangedQueue();
		this.getQueue()[(this.getHead()+this.getCount())%this.getQueue().length] = order;
		this.setCount(this.getCount()+1);
	}


	private void resizingIfChangedQueue(){
		int changedLength=0;
		if(this.ifQueueShouldBeIncr())
			changedLength = this.getQueue().length*2;
		if(this.ifQueueShouldBeReduced()){
			changedLength = this.getQueue().length/4;
		}
		if(changedLength > 0){
		//	System.out.println("test : "+changedLength + " count : "+this.getCount());
			resizingQueue(changedLength);
		}
	}

	private void resizingQueue(int changedLength){
		int prevOrderLength = this.getCount()+1;
		int headIndex = this.getHead();
		Object[] newQueue;
		if(changedLength < 10){
			changedLength = 10;
		}
		newQueue = new Object[ changedLength ];

		for(int i = 0 ; i < prevOrderLength ; i ++ ){
			newQueue[i] = this.getQueue()[(i+headIndex)%this.getQueue().length];
		}
		this.setQueue(newQueue);
		this.setHead(0);
		return;
	}


	private boolean ifQueueShouldBeReduced(){
		return (this.getQueue().length > 10) && (this.getCount() < this.getQueue().length / 4);
	}

	private boolean ifQueueShouldBeIncr(){
		return (this.getCount() == this.getQueue().length-1);
	}

	@Override
	public Object pop(){
		if(this.getCount() > 0){
			Object orderInfo=this.getQueue()[this.getHead()];
			this.setHead((this.getHead()+1) % this.getQueue().length);
			this.setCount(this.getCount()-1);
			this.resizingIfChangedQueue();
			return orderInfo;
		}

		return (new Object());
	}

	@Override
	public void printQueue() {
		for(int i = 0; i < this.getCount() ; ++i){
			System.out.println(this.getQueue()[(i+this.getHead())%this.getQueue().length]);
		}
	}

}
