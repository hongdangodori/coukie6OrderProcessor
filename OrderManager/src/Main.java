/**
 * Created by Coupang on 2015. 12. 29..
 */
import ProcessManager.*;
import MakeOrdersThread.*;
public class Main {
	public static void main(String[] args){
		ProcessManager pm = new ProcessManager();
		pm.runThread();

		while(true){
			pm.printMenuList();
			pm.runCommand(pm.chooseCommand());
		}

	}
}
