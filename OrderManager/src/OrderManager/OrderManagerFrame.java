package OrderManager;
import Order.*;
/**
 * Created by Coupang on 2015. 12. 28..
 */
public interface OrderManagerFrame {

	abstract void insertOrder(Order o);
	abstract void printProcessedOrders();
	abstract void findOrder(int orderId);
	abstract void transportOrder(int orderId);
	abstract void processOrders();
}
