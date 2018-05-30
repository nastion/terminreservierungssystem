package controller;

import data.User;

public class UserController {
	private Controller controller;
	public User login(String username, String password) {
		return null;
	}

	public void createUser(String username, String password) {
		User user = new User(username, password);
		controller.getSession().persist(user);
	}

	public User searchUser(String username) {
		return null;
	}

	public boolean logout() {
		return false;
	}

}
