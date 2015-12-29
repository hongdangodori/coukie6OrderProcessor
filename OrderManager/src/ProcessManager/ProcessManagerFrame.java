package ProcessManager;

/**
 * Created by Coupang on 2015. 12. 29..
 */
public interface ProcessManagerFrame {
	abstract void printMenuList();
	abstract void runCommand(String command);
	abstract String chooseCommand();

}
