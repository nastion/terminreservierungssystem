package controller;

import data.User;
import data.Event;
import org.hibernate.Session;

public class Controller {

	private User currentUser;

	private Session session;

	private Event event;

	private EventController eventController;

	private UserController userController;

	public User getCurrentUser() {
		return null;
	}

}
