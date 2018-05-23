package data;

//import controller.Controller;

public interface User {
	 String name = null;
	 String password = null;
	//private Controller controller;
	 Notification notification = null;

	public abstract void notify_User();

}
