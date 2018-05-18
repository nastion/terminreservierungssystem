package data;

//import controller.Controller;

public interface User {
	private String name;
	private String password;
	//private Controller controller;
	private Notification notification;

	public abstract void notify_User();

}
