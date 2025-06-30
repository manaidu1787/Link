package base;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles extends BaseTest {


	public static String getChildWindow() {
		Set<String> totalWindow = driver.getWindowHandles();
		Iterator<String> itr = totalWindow.iterator();
		String parantWindow = itr.next();
		String childWindow = itr.next();

		return childWindow;

	}

	public static String getSecondChildWindow() {
		Set<String> totalWindow = driver.getWindowHandles();
		Iterator<String> itr = totalWindow.iterator();
		String parantWindow = itr.next();
		String childWindow = itr.next();
		String secondChildWindow = itr.next();

		return secondChildWindow;

	}

	public static String getParentWindow() {
		Set<String> totalWindow = driver.getWindowHandles();
		Iterator<String> itr = totalWindow.iterator();
		String parantWindow = itr.next();

		return parantWindow;
	}
}
