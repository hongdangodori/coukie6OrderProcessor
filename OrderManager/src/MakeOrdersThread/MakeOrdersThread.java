package MakeOrdersThread;
import Order.*;
import OrderManager.OrderManager;

import java.util.Random;
/**
 * Created by Coupang on 2015. 12. 29..
 */
public class MakeOrdersThread extends Thread{

	Random rm;
	OrderManager om;

	private Random getRm() {
		return rm;
	}

	private void setRm(Random rm) {
		this.rm = rm;
	}

	private OrderManager getOm() {
		return this.om;
	}

	private void setOm(OrderManager om) {
		this.om = om;
	}

	public MakeOrdersThread(OrderManager om){
		this.rm = new Random();
		this.om = om;
	}
	@Override
	public void run(){
		while(true){
			try {
				om.insertOrder(new ProcessedOrder(this.rm.nextInt(3000)));
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
