package OrderManager;
import Order.*;
import OrderInfoManager.OrderInfoManager;
import ResizingQueue.ResizingQueue;
/**
 * Created by Coupang on 2015. 12. 28..
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ResizingQueue.ResizingQueue;
public class OrderManager implements OrderManagerFrame{

	private ResizingQueue orders;

	private OrderInfoManager getOrderInfoManager() {
		return orderInfoManager;
	}

	private void setOrderInfoManager(OrderInfoManager orderInfoManager) {
		this.orderInfoManager = orderInfoManager;
	}

	private OrderInfoManager orderInfoManager;

	private ResizingQueue getOrders() {
		return orders;
	}

	public void setOrders(ResizingQueue orders) {
		this.orders = orders;
	}

	public OrderManager() {
		this.orders = new ResizingQueue();
		this.orderInfoManager = new OrderInfoManager();
	}

	@Override
	public synchronized void insertOrder(Order o) {
		this.getOrders().insertOrderInQueue(o);
	}

	@Override
	public synchronized void printProcessedOrders(){
		ProcessedOrder[] po =this.getOrderInfoManager().getOrdersInfo();
		for(int i = 0;i<po.length ;i++){
			System.out.println(po[i].getOrderInfo());
		}
	}
	@Override
	public synchronized void transportOrder(int orderId){
		this.getOrderInfoManager().processOrder(orderId);

	}
	@Override
	public synchronized void findOrder(int orderId){
		ProcessedOrder po = this.getOrderInfoManager().findOrder(orderId);
		if(po.getOrderId() == -1){
			System.out.println("존재하지 않는 주문 정보입니다");
			return;
		}
		System.out.println(""+po.getOrderInfo());

	}


	@Override
	public synchronized void processOrders() {
		int count = this.getOrders().getCount();
		System.out.println("총 " + count +" 개의 주문이 처리되었습니다.");
		for(int i = 0;i <  count; i++)
			this.getOrderInfoManager().inputOrderInfo((Order) this.getOrders().pop());


	}

}
