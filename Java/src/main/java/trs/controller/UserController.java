package trs.controller;

import trs.data.User;

public class UserController {
	private Controller controller;

	public UserController(Controller controller) {
	    this.controller = controller;
    }

	public boolean login(String username, String password) {
		User logUser = this.controller.getUserRepo().findUserByName(username);
		if(logUser != null && logUser.getPassword().equals(password)) {
			controller.setCurrentUser(logUser);
			return true;
		}
		controller.setCurrentUser(null);
		return false;
	}

	public boolean createUser(String username, String password) {
		User user = new User(username, password);
		return this.createUser(user);
	}

	public boolean createUser(User user) {
	    if (this.controller.getUserRepo().findUserByName(user.getName()) == null) {
	        this.controller.getUserRepo().save(user);
            return true;
	    }
	    return false;
    }

	public User searchUser(String username) {
		return this.controller.getUserRepo().findUserByName(username);
	}

	public boolean logout() {
		return this.controller.setCurrentUser(null);
	}

}
