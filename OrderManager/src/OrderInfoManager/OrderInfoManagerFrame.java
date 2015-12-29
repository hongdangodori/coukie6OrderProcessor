package OrderInfoManager;
import Order.*;
/**
 * Created by Coupang on 2015. 12. 28..
 */

public interface OrderInfoManagerFrame {
	abstract void inputOrderInfo(Order o);
	abstract ProcessedOrder[] getOrdersInfo();
	abstract void processOrder(int orderId);
	abstract ProcessedOrder findOrder(int orderId);
}
