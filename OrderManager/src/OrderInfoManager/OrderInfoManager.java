package OrderInfoManager;


import Order.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coupang on 2015. 12. 28..
 */
public class OrderInfoManager implements OrderInfoManagerFrame{
	ProcessedOrder[] po;

	public OrderInfoManager(){
		File f = new File("./test.txt");
		f.delete();
	}
	public ProcessedOrder[] getPo() {
		return po;
	}

	public void setPo(ProcessedOrder[] po) {
		this.po = po;
	}

	@Override
	public void inputOrderInfo(Order o) {
		String txt = o.toString();
		//System.out.println(txt);
		String fileName = "./test.txt" ;
		BufferedWriter fw;
		try {
			fw = new BufferedWriter(new FileWriter(fileName, true));
			fw.write(txt+"\r\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProcessedOrder[] getOrdersInfo() {
		ArrayList<ProcessedOrder> l = new ArrayList<ProcessedOrder>();
		ProcessedOrder[] of = new ProcessedOrder[0];
		BufferedReader fr;
		String s;

		try{
			fr = new BufferedReader(new FileReader("./test.txt"));
			while((s=fr.readLine()) != null){
			//	System.out.println(s);
				String[] sl = s.split("&");
				ProcessedOrder po = new ProcessedOrder(Integer.parseInt(sl[0]),Integer.parseInt(sl[1]),sl[2]);
				l.add(po);
			}
		}catch(IOException e){

		}
		if(!l.isEmpty()) {
			of = new ProcessedOrder[l.toArray().length];
			for (int i = 0; i < l.toArray().length; i++) {
				of[i] = (ProcessedOrder)l.get(i);
			}
		}
		return of;
	}
	@Override
	public ProcessedOrder findOrder(int orderId){
		this.po = this.getOrdersInfo();

		for(int i = 0 ;i <po.length ;i++){
			if(po[i].getOrderId() == orderId) {
				//System.out.println(po[i].getOrderInfo());
				return po[i];
			}
		}
		return new ProcessedOrder(-1,-1,"f");
	}

	@Override
	public void processOrder(int orderId) {
		ProcessedOrder po = this.findOrder(orderId);
		if(po.getOrderId() == -1){
			System.out.println("존재하지 않는 주문 번호입니다.");
			return ;
		}
		po.processOrder();

		String fileName = "./test.txt" ;
		BufferedWriter fw;
		try {
			fw = new BufferedWriter(new FileWriter(fileName, false));
			for(int i=0;i<this.po.length ; i++){
				fw.write(this.po[i].toString()+"\r\n");
				fw.flush();
			}
			fw.close();
			System.out.println("배송 처리 되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
