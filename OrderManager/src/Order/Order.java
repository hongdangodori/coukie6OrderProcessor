package Order;

/**
 * Created by Coupang on 2015. 12. 28..
 */
public class Order implements OrderFrame{
	private int orderId;
	private int productId;
	private static int count = 0;
	public Order(){
		this.setOrderId(count++);
		this.setProductId(-1);
	}
	public Order(int productId){
		this.setOrderId(count++);
		this.setProductId(productId);
	}
	public Order(int orderId, int productId){
		this.setOrderId(orderId);
		this.setProductId(productId);
	}
	public int getOrderId() {
		return orderId;
	}

	private void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	private int getProductId() {
		return productId;
	}

	private void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String getOrderInfo(){
		return "주문 번호 : "+this.getOrderId()+", 상품 번호 : "+this.getProductId()+"";
	}
	@Override
	public String toString(){
		return ""+this.getOrderId()+"&"+this.getProductId()+"";
	}

}
