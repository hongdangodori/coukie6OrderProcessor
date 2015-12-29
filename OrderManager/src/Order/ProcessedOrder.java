package Order;

/**
 * Created by Coupang on 2015. 12. 28..
 */

	public class ProcessedOrder extends Order{
		private boolean deliveried;
		public ProcessedOrder(){
			super();
		}
		public ProcessedOrder(int orderId, int productId, String deliveried){
			super(orderId,productId);
			this.setDeliveried(true);
			if(deliveried.equals("F")){
				this.setDeliveried(false);
			}

		}
		public ProcessedOrder(int productId){
			super(productId);
			this.setDeliveried(false);
		}

		private boolean isDeliveried() {
			return deliveried;
		}

		private void setDeliveried(boolean deliveried) {
			this.deliveried = deliveried;
		}
		@Override
		public String getOrderInfo(){
			String tOrF = "F";
			if(this.isDeliveried()){
				tOrF="T";
			}

			return ""+super.getOrderInfo()+", 발송 정보 (T/F): "+tOrF;
		}

		@Override
		public String toString(){
			String tOrF = "F";
			if(this.isDeliveried()){
				tOrF="T";
			}

			return ""+super.toString()+"&"+tOrF;
		}
		public void processOrder(){
			this.setDeliveried(true);
		}
	}

