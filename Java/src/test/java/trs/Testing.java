package trs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import trs.controller.Controller;
import trs.data.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testing {
    @Autowired
    Controller controller;

    @Before
    public void init() {
        this.controller.getPollRepo().deleteAll();
        this.controller.getUserRepo().deleteAll();
    }
/*
    Test: createUser returns true if user is created
 */
    @Test
    public void createUser(){
        Assert.assertTrue(controller.getUserController().createUser("TestUser", "TestPw"));
    }
/*
    Test: User has to have a unique username, so if there is already a user with this particular username, createUser should return false
 */
    @Test
    public void createSameUserTwice(){
        controller.getUserController().createUser("TestUserTwice","TestPw");
        Assert.assertFalse(controller.getUserController().createUser("TestUserTwice", "TestPw"));
    }
/*
    Test: Creates a user and makes a login, the current user should have the same username like the created user
 */
    @Test
    public void getUserNameCurrentUser() {
        User user = new User("getUserName", "TestPw");
        controller.getUserController().createUser(user);
        controller.getUserController().login(user.getName(), user.getPassword());
        Assert.assertEquals("getUserName", controller.getCurrentUser().getName());
    }
/*
    Test: Creates a user and makes a login, the current user should have the same password like the created user
*/
    @Test
    public void getPasswordCurrentUser() {
        User user = new User("getUserPassword", "TestPw");
        controller.getUserController().createUser(user);
        controller.getUserController().login(user.getName(), user.getPassword());
        Assert.assertEquals("TestPw", controller.getCurrentUser().getPassword());
    }

/*
    Test: Creates a user and searches for this user. searchUser returns a User and the method getName returns the Username, searchUser(Username).
    the returned name should be the same like the username from the created user
 */
    @Test
    public void createUserAndSearchAssertSameName(){
        User user = new User("TestFindUserName", "TestPw");
        controller.getUserController().createUser(user);
        Assert.assertEquals("TestFindUserName", controller.getUserController().searchUser("TestFindUserName").getName());
    }

    /*
        Test: Creates a user and searches for this user. searchUser returns a User and the method getPassword returns the password, searchUser(Username).
        the returned password should be the same like the password from the created user
     */    @Test
    public void createUserAndSearchAssertSamePassword(){
        User user = new User("TestFindUserPassword", "TestPw");
        controller.getUserController().createUser(user);
        Assert.assertEquals("TestPw", controller.getUserController().searchUser("TestFindUserPassword").getPassword());
    }
/*
    Test: Creates a new user and makes a login, login checks if this username exists and compares the entered password with the existing user.
    If the username and password exist, a currentUser is going to be set.
 */
    @Test
    public void loginUser(){
        User testUser = new User("TestUser", "TestPw");
        controller.getUserController().createUser(testUser);
        controller.getUserController().login(testUser.getName(),testUser.getPassword());
        Assert.assertEquals(testUser.getName(), controller.getCurrentUser().getName());
    }

    /*
        Test: Creates a new user and makes a login, login checks if this username exists and compares the entered password with the existing user.
        If the password doesn't fit with the user, currentUser is going to be set as NULL.
     */
    @Test
    public void loginNotExistingUser(){
        controller.getUserController().login("Abc","TestPw");
        Assert.assertNull(controller.getCurrentUser());
    }
/*
    Test: creates a User and makes a login, logout sets the currentUser to null
 */
    @Test
    public void logoutUser(){
        User testUser = new User("LogoutUser", "TestPw");
        controller.getUserController().createUser(testUser);
        controller.getUserController().login(testUser.getName(),testUser.getPassword());
        controller.getUserController().logout();
        Assert.assertNull(controller.getCurrentUser());
    }


}