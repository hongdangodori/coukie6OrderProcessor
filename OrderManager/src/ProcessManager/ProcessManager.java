package ProcessManager;
import MakeOrdersThread.MakeOrdersThread;
import OrderManager.OrderManager;
import Order.*;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Coupang on 2015. 12. 28..
 */
public class ProcessManager implements ProcessManagerFrame{
	private OrderManager om;
	private MakeOrdersThread thread;

	private MakeOrdersThread getThread() {
		return thread;
	}

	public void setThread(MakeOrdersThread thread) {
		this.thread = thread;
	}

	public OrderManager getOm() {
		return this.om;
	}

	private void setOm(OrderManager om) {
		this.om = om;
	}

	public ProcessManager(){
		this.setOm(new OrderManager());
		this.setThread(new MakeOrdersThread(this.getOm()));
	}
	public void runThread(){
		this.getThread().start();
	}
	@Override public void printMenuList() {
		System.out.println("주문이 생성되는 중입니다...");
		System.out.println("============= 메 뉴 바 =============");
		System.out.println(" 1. process order");
		System.out.println(" 2. find order");
		System.out.println(" 3. print processed orders list");
		System.out.println(" 4. delivery order");
		System.out.println(" 5. exit");
		System.out.println("==================================");
	}

	@Override
	public void runCommand(String command) {
		if(command.equals("1")){
			om.processOrders();
		}else if(command.equals("2")){
			System.out.print("정보를 확인 하고 싶은 주문의 아이디 번호를 입력해주세요. : ");
			String s = new Scanner(System.in).next();
			try {
				int orderId = Integer.parseInt(s);
				om.findOrder(orderId);
			}catch (NumberFormatException e){
				System.out.println("숫자를 넣으셔야 합니다.");
			}
		}else if(command.equals("3")){
			om.printProcessedOrders();
		}else if(command.equals("4")){
			System.out.print("배송하고 싶은 주문의 아이디 번호를 입력해주세요. :");
			String s = new Scanner(System.in).next();
			try {
				int orderId = Integer.parseInt(s);
				om.transportOrder(orderId);

			}catch (NumberFormatException e){
				System.out.println("숫자를 넣으셔야 합니다.");
			}

		}else if(command.equals("5")){
			System.exit(1);
		}else{
			System.out.println("없는 명령어입니다.");
		}
	}


	@Override
	public String chooseCommand() {
		Scanner scan = new Scanner(System.in);
		System.out.print("실행하고 싶은 명령어 번호를 입력하세요 : ");
		String command = scan.next();
		return command;
	}


}
