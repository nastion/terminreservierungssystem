package trs.controller;

import trs.data.User;
import org.hibernate.Session;

public class Controller {
    private User currentUser;

    private Session session;

	private EventController eventController;

	private UserController userController;

	public User getCurrentUser() {
	    return this.currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public EventController getEventController() {
        return eventController;
    }

    public void setEventController(EventController eventController) {
        this.eventController = eventController;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
